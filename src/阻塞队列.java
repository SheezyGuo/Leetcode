import javax.sound.midi.Soundbank;
import java.util.LinkedList;

public class 阻塞队列 {

    class BlockQueue {
        private LinkedList<Integer> list;
        private int size;

        public BlockQueue(int size) {
            this.list = new LinkedList<>();
            this.size = size;
        }

        private synchronized void put(int n) {
            try {
                while (list.size() >= size) {
                    wait();
                }
                Thread.sleep((int) (Math.random() * 1000));
                System.out.printf("%s Put %d\n", Thread.currentThread().getName(), n);
                list.add(n);
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private synchronized void get() {
            try {
                while (list.size() == 0) {
                    wait();
                }
                Thread.sleep((int) (Math.random() * 1000));
                System.out.printf("%s Get %d\n", Thread.currentThread().getName(), list.remove());
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class Put implements Runnable {
        private BlockQueue queue;

        Put(BlockQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                queue.put((int) (Math.random() * 50));
            }
        }
    }

    private class Get implements Runnable {
        private BlockQueue queue;

        Get(BlockQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                queue.get();
            }
        }
    }

    public static void main(String[] args) {
        int pn = 2, cn = 2;
        Thread[] ps = new Thread[pn];
        Thread[] cs = new Thread[cn];
        阻塞队列 zusai = new 阻塞队列();
        BlockQueue queue = zusai.new BlockQueue(20);
        for (int i = 0; i < pn; i++) {
            ps[i] = new Thread(zusai.new Put(queue), String.format("Producer %d", i));
            ps[i].start();
        }
        for (int i = 0; i < cn; i++) {
            cs[i] = new Thread(zusai.new Get(queue), String.format("Consumer %d", i));
            cs[i].start();
        }
    }

}
