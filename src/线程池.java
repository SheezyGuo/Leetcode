import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class 线程池 {

    class ThreadPool {
        private final LinkedBlockingDeque<Runnable> taskQueue;
        private final LinkedList<Worker> coreWorkers;
        private final LinkedList<Worker> extraWorkers;
        private final AtomicInteger workerNum;
        private final int coreSize;
        private final int maxSize;
        private final long lifeTime;

        public ThreadPool(int coreSize, int maxSize, long lifeTime) {
            this.taskQueue = new LinkedBlockingDeque<>(coreSize);
            this.workerNum = new AtomicInteger();
            this.coreWorkers = new LinkedList<>();
            this.extraWorkers = new LinkedList<>();
            this.coreSize = coreSize;
            this.maxSize = maxSize;
            this.lifeTime = lifeTime;
        }

        public void execute(Runnable task) throws Exception {
            if (workerNum.get() < coreSize) {
                Worker coreWorker = new Worker(taskQueue, 0, workerNum, task);
                synchronized (coreWorkers) {
                    coreWorkers.add(coreWorker);
                }
                coreWorker.start();
            } else if (taskQueue.size() < coreSize) {
                taskQueue.add(task);
            } else if (workerNum.get() < maxSize) {
                Worker extraWorker = new Worker(taskQueue, lifeTime, workerNum, task);
                synchronized (extraWorkers) {
                    extraWorkers.add(extraWorker);
                }
                extraWorker.start();
            } else {
                throw new Exception("info");
            }
        }
    }

    class Worker extends Thread {
        private final LinkedBlockingDeque<Runnable> taskQueue;
        private final long lifeTime;
        private final AtomicInteger workerNum;
        private final Runnable task;

        public Worker(LinkedBlockingDeque<Runnable> taskQueue, long lifeTime, AtomicInteger workerNum, Runnable task) {
            this.taskQueue = taskQueue;
            this.lifeTime = lifeTime;
            this.workerNum = workerNum;
            this.task = task;
        }

        @Override
        public void run() {
            workerNum.incrementAndGet();
            task.run();
            while (true) {
                try {
                    Runnable task = null;
                    if (lifeTime != 0) {
                        task = taskQueue.pollFirst(lifeTime, TimeUnit.SECONDS);
                    } else {
                        task = taskQueue.pollFirst();
                    }
                    if (task != null) {
                        System.out.printf("%s done\n", Thread.currentThread().getName());
                    } else {
                        System.out.println("out");
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            workerNum.decrementAndGet();
        }
    }
}

