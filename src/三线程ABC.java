public class 三线程ABC {
    private static volatile int flag = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        while (flag != 1) {
                            lock.wait();
                        }
                        System.out.println("A");
                        Thread.sleep(500);
                        flag = 2;
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        while (flag != 2) {
                            lock.wait();
                        }
                        System.out.println("B");
                        Thread.sleep(500);
                        flag = 3;
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        while (flag != 3) {
                            lock.wait();
                        }
                        System.out.println("C");
                        Thread.sleep(500);
                        flag = 1;
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
