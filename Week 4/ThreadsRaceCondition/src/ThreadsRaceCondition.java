import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadsRaceCondition {
    final int THREAD_NUMBER = 4;
    final int RANGE = 2500;
    final List<Integer> oddNumbers;
    final List<Integer> evenNumbers;
    CountDownLatch latch;

    public ThreadsRaceCondition() {
        oddNumbers = new ArrayList<>();
        evenNumbers = new ArrayList<>();
        latch = new CountDownLatch(THREAD_NUMBER);
    }

    public void run() throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(THREAD_NUMBER);

        for (int i = 1; i <= THREAD_NUMBER; i++) {
            Task task = new Task(RANGE * (i - 1) + 1, RANGE * i);
            executor.execute(task);
        }

        latch.await();
        executor.shutdown();

        for (Integer s : evenNumbers) {
            System.out.println(s);
        }
    }

    class Task implements Runnable {
        int lowerRange;
        int upperRange;

        public Task(int lowerRange, int upperRange) {
            this.lowerRange = lowerRange;
            this.upperRange = upperRange;
        }

        @Override
        public void run() {
            for (int i = lowerRange; i <= upperRange; i++) {
                if (i % 2 == 0) {
                    synchronized (evenNumbers) {
                        evenNumbers.add(i);
                    }
                } else {
                    synchronized (oddNumbers) {
                        oddNumbers.add(i);
                    }
                }
            }

            latch.countDown();
        }
    }
}
