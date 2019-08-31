import java.util.concurrent.atomic.AtomicInteger;

public class 多个线程加法 {
    private static final AtomicInteger i = new AtomicInteger(1);
    private static final AtomicInteger sum = new AtomicInteger(0);

    public static void main(String[] args) {
        int k = 1000;
        Runnable runnable = () -> {
            int n;
            while ((n = i.getAndIncrement()) <= k) {
                sum.getAndAdd(n * (n + 1));
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runnable, String.format("Thread-%d", i + 1));
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
        int s = 0;
        for (int j = 1; j <= k; j++) {
            s += j * (j + 1);
        }
        System.out.println(s);
    }
}
