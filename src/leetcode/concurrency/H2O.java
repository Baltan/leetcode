package leetcode.concurrency;

import java.util.concurrent.Semaphore;

/**
 * Description: 1117. Building H2O
 *
 * @author Baltan
 * @date 2019-07-14 12:41
 */
public class H2O {
    private Semaphore semaphoreH;
    private Semaphore semaphoreO;

    public H2O() {
        this.semaphoreH = new Semaphore(2);
        this.semaphoreO = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreH.acquire();
        /**
         * releaseHydrogen.run() outputs "H". Do not change or remove this line.
         */
        releaseHydrogen.run();
        semaphoreO.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreO.acquire(2);
        /**
         * releaseOxygen.run() outputs "H". Do not change or remove this line.
         */
        releaseOxygen.run();
        semaphoreH.release(2);
    }

    private static class Hydrogen extends Thread {
        private H2O h2o;

        public Hydrogen(H2O h2o) {
            this.h2o = h2o;
        }

        @Override
        public void run() {
            try {
                h2o.hydrogen(() -> System.out.println("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Oxygen extends Thread {
        private H2O h2o;

        public Oxygen(H2O h2o) {
            this.h2o = h2o;
        }

        @Override
        public void run() {
            try {
                h2o.oxygen(() -> System.out.println("O"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}