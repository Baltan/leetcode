package leetcode.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Description: 1116. Print Zero Even Odd
 *
 * @author Baltan
 * @date 2019-07-14 09:32
 */
public class ZeroEvenOdd {
    private int n;
    private int evenNum;
    private int oddNum;
    private int zeroCount;
    private Semaphore semaphoreZero;
    private Semaphore semaphoreOdd;
    private Semaphore semaphoreEven;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.evenNum = 2;
        this.oddNum = 1;
        this.zeroCount = 0;
        this.semaphoreZero = new Semaphore(1);
        this.semaphoreOdd = new Semaphore(0);
        this.semaphoreEven = new Semaphore(0);
    }

    /**
     * printNumber.accept(x) outputs "x", where x is an integer.
     */
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphoreZero.acquire();
            printNumber.accept(0);
            zeroCount++;

            if ((zeroCount & 1) == 1) {
                semaphoreOdd.release();
            } else {
                semaphoreEven.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (evenNum <= n) {
            semaphoreEven.acquire();
            printNumber.accept(evenNum);
            evenNum += 2;
            semaphoreZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (oddNum <= n) {
            semaphoreOdd.acquire();
            printNumber.accept(oddNum);
            oddNum += 2;
            semaphoreZero.release();
        }
    }

    private static class Thread1 extends Thread {
        private ZeroEvenOdd zeroEvenOdd;

        public Thread1(ZeroEvenOdd zeroEvenOdd) {
            this.zeroEvenOdd = zeroEvenOdd;
        }

        @Override
        public void run() {
            try {
                zeroEvenOdd.zero(x -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Thread2 extends Thread {
        private ZeroEvenOdd zeroEvenOdd;

        public Thread2(ZeroEvenOdd zeroEvenOdd) {
            this.zeroEvenOdd = zeroEvenOdd;
        }

        @Override
        public void run() {
            try {
                zeroEvenOdd.even(x -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Thread3 extends Thread {
        private ZeroEvenOdd zeroEvenOdd;

        public Thread3(ZeroEvenOdd zeroEvenOdd) {
            this.zeroEvenOdd = zeroEvenOdd;
        }

        @Override
        public void run() {
            try {
                zeroEvenOdd.odd(x -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd1 = new ZeroEvenOdd(2);
        Thread1 thread1A = new Thread1(zeroEvenOdd1);
        Thread2 thread1B = new Thread2(zeroEvenOdd1);
        Thread3 thread1C = new Thread3(zeroEvenOdd1);
        thread1A.start();
        thread1B.start();
        thread1C.start();

        ZeroEvenOdd zeroEvenOdd2 = new ZeroEvenOdd(5);
        Thread1 thread2A = new Thread1(zeroEvenOdd2);
        Thread2 thread2B = new Thread2(zeroEvenOdd2);
        Thread3 thread2C = new Thread3(zeroEvenOdd2);
        thread2A.start();
        thread2B.start();
        thread2C.start();
    }
}
