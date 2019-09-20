package leetcode.algorithms;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Description: 1195. Fizz Buzz Multithreaded
 *
 * @author Baltan
 * @date 2019-09-19 09:58
 */
public class FizzBuzz1 {
    private int n;
    private int currentValue;
    private Semaphore semaphore1;
    private Semaphore semaphore2;
    private Semaphore semaphore3;
    private Semaphore semaphore4;
    private int fizzLast = 0;
    private int buzzLast = 0;
    private int fizzbuzzLast = 0;
    private int numberLast = 0;

    public FizzBuzz1(int n) {
        this.n = n;
        /**
         * 记录当前值，相应的线程会执行输出
         */
        this.currentValue = 1;
        semaphore1 = new Semaphore(0);
        semaphore2 = new Semaphore(0);
        semaphore3 = new Semaphore(0);
        semaphore4 = new Semaphore(1);
        /**
         * 计算每个线程最后一次执行输出时的值
         */
        for (int i = n; i > n - 15; i--) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzzLast = Math.max(fizzbuzzLast, i);
            } else if (i % 3 == 0) {
                fizzLast = Math.max(fizzLast, i);
            } else if (i % 5 == 0) {
                buzzLast = Math.max(buzzLast, i);
            } else {
                numberLast = Math.max(numberLast, i);
            }
        }
    }

    /**
     * printFizz.run() outputs "fizz".
     */
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (currentValue <= n) {
            semaphore1.acquire();
            printFizz.run();
            currentValue++;
            semaphoreDeal(currentValue);

            if (currentValue > fizzLast) {
                break;
            }
        }
    }

    /**
     * printBuzz.run() outputs "buzz".
     */
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (currentValue <= n) {
            semaphore2.acquire();
            printBuzz.run();
            currentValue++;
            semaphoreDeal(currentValue);

            if (currentValue > buzzLast) {
                break;
            }
        }
    }

    /**
     * printFizzBuzz.run() outputs "fizzbuzz".
     */
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (currentValue <= n) {
            semaphore3.acquire();
            printFizzBuzz.run();
            currentValue++;
            semaphoreDeal(currentValue);

            if (currentValue > fizzbuzzLast) {
                break;
            }
        }
    }

    /**
     * printNumber.accept(x) outputs "x", where x is an integer.
     */
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (currentValue <= n) {
            semaphore4.acquire();
            printNumber.accept(currentValue);
            currentValue++;
            semaphoreDeal(currentValue);

            if (currentValue > numberLast) {
                break;
            }
        }
    }

    /**
     * 处理信号量
     */
    private void semaphoreDeal(int currentValue) {
        if (currentValue > n) {
            return;
        }

        if (currentValue % 3 == 0 && currentValue % 5 == 0) {
            semaphore3.release();
        } else if (currentValue % 3 == 0) {
            semaphore1.release();
        } else if (currentValue % 5 == 0) {
            semaphore2.release();
        } else {
            semaphore4.release();
        }
    }

    private static class Thread1 extends Thread {
        private FizzBuzz1 fizzBuzz;

        public Thread1(FizzBuzz1 fizzBuzz) {
            this.fizzBuzz = fizzBuzz;
        }

        @Override
        public void run() {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Thread2 extends Thread {
        private FizzBuzz1 fizzBuzz;

        public Thread2(FizzBuzz1 fizzBuzz) {
            this.fizzBuzz = fizzBuzz;
        }

        @Override
        public void run() {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Thread3 extends Thread {
        private FizzBuzz1 fizzBuzz;

        public Thread3(FizzBuzz1 fizzBuzz) {
            this.fizzBuzz = fizzBuzz;
        }

        @Override
        public void run() {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Thread4 extends Thread {
        private FizzBuzz1 fizzBuzz;

        public Thread4(FizzBuzz1 fizzBuzz) {
            this.fizzBuzz = fizzBuzz;
        }

        @Override
        public void run() {
            try {
                fizzBuzz.number(x -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        FizzBuzz1 fizzBuzz = new FizzBuzz1(10000);
        Thread1 thread1 = new Thread1(fizzBuzz);
        Thread2 thread2 = new Thread2(fizzBuzz);
        Thread3 thread3 = new Thread3(fizzBuzz);
        Thread4 thread4 = new Thread4(fizzBuzz);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
