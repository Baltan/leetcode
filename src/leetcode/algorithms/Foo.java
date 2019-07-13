package leetcode.algorithms;

import java.util.concurrent.CountDownLatch;

/**
 * Description: 1114. Print in Order
 *
 * @author Baltan
 * @date 2019-07-13 10:16
 */
public class Foo {
    private CountDownLatch latch1;
    private CountDownLatch latch2;

    public Foo() {
        latch1 = new CountDownLatch(1);
        latch2 = new CountDownLatch(2);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        /**
         * printFirst.run() outputs "first". Do not change or remove this line.
         */
        printFirst.run();
        latch1.countDown();
        latch2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        /**
         * printSecond.run() outputs "second". Do not change or remove this line.
         */
        latch1.await();
        printSecond.run();
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        /**
         * printThird.run() outputs "third". Do not change or remove this line.
         */
        latch2.await();
        printThird.run();
    }

    private static class Thread1 extends Thread {
        private Foo foo;

        public Thread1(Foo foo) {
            this.foo = foo;
        }

        @Override
        public void run() {
            try {
                foo.first(() -> {
                    System.out.println("first");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Thread2 extends Thread {
        private Foo foo;

        public Thread2(Foo foo) {
            this.foo = foo;
        }

        @Override
        public void run() {
            try {
                foo.second(() -> {
                    System.out.println("second");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Thread3 extends Thread {
        private Foo foo;

        public Thread3(Foo foo) {
            this.foo = foo;
        }

        @Override
        public void run() {
            try {
                foo.third(() -> {
                    System.out.println("third");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Foo foo1 = new Foo();
        Thread1 thread1A = new Thread1(foo1);
        Thread2 thread1B = new Thread2(foo1);
        Thread3 thread1C = new Thread3(foo1);
        thread1A.start();
        thread1B.start();
        thread1C.start();

        Foo foo2 = new Foo();
        Thread1 thread2A = new Thread1(foo2);
        Thread3 thread2B = new Thread3(foo2);
        Thread2 thread2C = new Thread2(foo2);
        thread2A.start();
        thread2B.start();
        thread2C.start();
    }
}
