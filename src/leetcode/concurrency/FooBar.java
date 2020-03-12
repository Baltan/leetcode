package leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: 1115. Print FooBar Alternately
 *
 * @author Baltan
 * @date 2019-07-13 10:48
 */
public class FooBar {
    private int n;
    private boolean fooFlag;
    private boolean barFlag;
    private Lock lock;
    private Condition fooCondition;
    private Condition barCondition;

    public FooBar(int n) {
        this.n = n;
        this.fooFlag = false;
        this.barFlag = true;
        this.lock = new ReentrantLock();
        this.fooCondition = lock.newCondition();
        this.barCondition = lock.newCondition();
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();

            try {
                while (fooFlag) {
                    fooCondition.await();
                }

                /**
                 * printFoo.run() outputs "foo". Do not change or remove this line.
                 */
                printFoo.run();
                fooFlag = true;
                barFlag = false;
                barCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();

            try {
                while (barFlag) {
                    barCondition.await();
                }

                /**
                 * printBar.run() outputs "bar". Do not change or remove this line.
                 */
                printBar.run();
                barFlag = true;
                fooFlag = false;
                fooCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    private static class Thread1 extends Thread {
        private FooBar fooBar;

        public Thread1(FooBar fooBar) {
            this.fooBar = fooBar;
        }

        @Override
        public void run() {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Thread2 extends Thread {
        private FooBar fooBar;

        public Thread2(FooBar fooBar) {
            this.fooBar = fooBar;
        }

        @Override
        public void run() {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FooBar fooBar1 = new FooBar(1);
        Thread1 thread1A = new Thread1(fooBar1);
        Thread2 thread1B = new Thread2(fooBar1);
        thread1A.start();
        thread1B.start();

        FooBar fooBar2 = new FooBar(2);
        Thread1 thread2A = new Thread1(fooBar2);
        Thread2 thread2B = new Thread2(fooBar2);
        thread2A.start();
        thread2B.start();
    }
}
