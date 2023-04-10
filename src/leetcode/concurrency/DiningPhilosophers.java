package leetcode.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: 1226. The Dining Philosophers
 *
 * @author Baltan
 * @date 2023/4/10 10:37
 * 参考：<a href="https://leetcode.cn/problems/the-dining-philosophers/solutions/36049/1ge-semaphore-1ge-reentrantlockshu-zu-by-gfu/"></a>
 */
public class DiningPhilosophers {
    private Lock lock;

    public DiningPhilosophers() {
        lock = new ReentrantLock();
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) {
        lock.lock();

        try {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        } finally {
            lock.unlock();
        }
    }
}
