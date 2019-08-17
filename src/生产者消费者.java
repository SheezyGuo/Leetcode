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

}
