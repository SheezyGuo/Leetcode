import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 生产者消费者 {
    private final static int MAX_SIZE = 20;

    private static class Producer implements Runnable {
        Lock lock;
        Condition full;
        Condition empty;
        LinkedList<Integer> task;

        public Producer(Lock lock, Condition full, Condition empty, LinkedList<Integer> task) {
            this.lock = lock;
            this.full = full;
            this.empty = empty;
            this.task = task;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (task.size() >= MAX_SIZE) {
                        // full;
                        System.out.printf("%s 正在等待\n", Thread.currentThread().getName());
                        full.await();
                    }
                    int t = (int) (Math.random() * 20);
                    task.add(t);
//                    System.out.printf("%s Producing %d\n", Thread.currentThread().getName(), t);
                    Thread.sleep((int) (Math.random() * 500) + 1000);
                    System.out.printf("%s Produced %d\n", Thread.currentThread().getName(), t);
                    // not empty;
                    empty.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class Customer implements Runnable {
        Lock lock;
        Condition full;
        Condition empty;
        LinkedList<Integer> task;

        public Customer(Lock lock, Condition full, Condition empty, LinkedList<Integer> task) {
            this.lock = lock;
            this.full = full;
            this.empty = empty;
            this.task = task;
        }


        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (task.size() <= 0) {
                        // empty;
                        System.out.printf("%s 正在等待\n", Thread.currentThread().getName());
                        empty.await();
                    }
                    int t = task.remove();
//                    System.out.printf("%s Consuming %d\n", Thread.currentThread().getName(), t);
                    Thread.sleep((int) (Math.random() * 500) + 1000);
                    System.out.printf("%s Consumed %d\n", Thread.currentThread().getName(), t);
                    // not full;
                    full.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition full = lock.newCondition();
        Condition empty = lock.newCondition();
        LinkedList<Integer> task = new LinkedList<>();
        Producer producer = new Producer(lock, full, empty, task);
        Customer customer = new Customer(lock, full, empty, task);
        int n1 = 5, n2 = 10;
        Thread[] producers = new Thread[n1];
        Thread[] customers = new Thread[n2];
        for (int i = 0; i < n1; i++) {
            producers[i] = new Thread(producer, String.format("生产者%d", i + 1));
            producers[i].start();
        }
        for (int i = 0; i < n2; i++) {
            customers[i] = new Thread(customer, String.format("消费者%d", i + 1));
            customers[i].start();
        }
        for (int i = 0; i < n1; i++) {
            producers[i].join();
        }
        for (int i = 0; i < n2; i++) {
            customers[i].join();
        }
    }


//    static class Buffer {
//        private final Lock lock;
//        private final Condition notFull;
//        private final Condition notEmpty;
//        private int maxSize;
//        private List<Date> storage;
//
//        Buffer(int size) {
//            //使用锁lock，并且创建两个condition，相当于两个阻塞队列
//            lock = new ReentrantLock();
//            notFull = lock.newCondition();
//            notEmpty = lock.newCondition();
//            maxSize = size;
//            storage = new LinkedList<>();
//        }
//
//        public void put() {
//            lock.lock();
//            try {
//                while (storage.size() == maxSize) {//如果队列满了
//                    System.out.print(Thread.currentThread().getName() + ": wait \n");
//                    ;
//                    notFull.await();//阻塞生产线程
//                }
//                storage.add(new Date());
//                System.out.print(Thread.currentThread().getName() + ": put:" + storage.size() + "\n");
//                Thread.sleep(1000);
//                notEmpty.signalAll();//唤醒消费线程
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        }
//
//        public void take() {
//            lock.lock();
//            try {
//                while (storage.size() == 0) {//如果队列满了
//                    System.out.print(Thread.currentThread().getName() + ": wait \n");
//                    ;
//                    notEmpty.await();//阻塞消费线程
//                }
//                Date d = ((LinkedList<Date>) storage).poll();
//                System.out.print(Thread.currentThread().getName() + ": take:" + storage.size() + "\n");
//                Thread.sleep(1000);
//                notFull.signalAll();//唤醒生产线程
//
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        }
//    }
//
//    static class Producer implements Runnable {
//        private Buffer buffer;
//
//        Producer(Buffer b) {
//            buffer = b;
//        }
//
//        @Override
//        public void run() {
//            while (true) {
//                buffer.put();
//            }
//        }
//    }
//
//    static class Consumer implements Runnable {
//        private Buffer buffer;
//
//        Consumer(Buffer b) {
//            buffer = b;
//        }
//
//        @Override
//        public void run() {
//            while (true) {
//                buffer.take();
//            }
//        }
//    }
//
//    public static void main(String[] arg) {
//        Buffer buffer = new Buffer(10);
//        Producer producer = new Producer(buffer);
//        Consumer consumer = new Consumer(buffer);
//        for (int i = 0; i < 3; i++) {
//            new Thread(producer, "producer-" + i).start();
//        }
//        for (int i = 0; i < 3; i++) {
//            new Thread(consumer, "consumer-" + i).start();
//        }
//    }
}
