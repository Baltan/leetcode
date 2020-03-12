package leetcode.interview;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 面试题59 - II. 队列的最大值
 * <p>
 * 参考：
 * <a href="https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-ii-dui-lie-de-zui-da-zhi-by-leetcod/"></a>
 *
 * @author Baltan
 * @date 2020-03-07 00:21
 */
public class MaxQueue {
    /**
     * 保存所有加入MaxQueue的元素
     */
    private Queue<Integer> queue;
    /**
     * 当某个元素value加入deque时，将deque尾部所有小于value的值都出队后，再加入value，
     * 保证deque中的元素始终是单调递减的，即deque头部的元素始终是队列queue中的最大值。
     * <p>
     * 对于后加入queue的更大的元素，队列前面的比它小的元素永远不可能成为队列中最大的元素，
     * 所以可以从deque中将前面的这些较小的元素出队
     */
    private Deque<Integer> deque;

    public MaxQueue() {
        this.queue = new LinkedList<>();
        this.deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        /**
         * 将deque尾部所有小于value的值都出队
         */
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) {
            return -1;
        } else {
            int value = queue.poll();
            /**
             * 如果queue和deque的头部元素相同，说明当前队列中的最大元素已经出队了，要将
             * 最大元素也从deque中出队
             */
            if (deque.peekFirst() == value) {
                deque.pollFirst();
            }
            return value;
        }
    }

    public static void main(String[] args) {
        MaxQueue maxQueue1 = new MaxQueue();
        maxQueue1.push_back(1);
        maxQueue1.push_back(2);
        System.out.println(maxQueue1.max_value());
        System.out.println(maxQueue1.pop_front());
        System.out.println(maxQueue1.max_value());

        System.out.println("---------------------");

        MaxQueue maxQueue2 = new MaxQueue();
        System.out.println(maxQueue2.pop_front());
        System.out.println(maxQueue2.max_value());
    }
}
