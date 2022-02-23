package leetcode.interview;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 面试题 17.20. 连续中值
 *
 * @author Baltan
 * @date 2022/2/23 17:34
 * @see leetcode.algorithms.MedianFinder
 */
public class MedianFinder {
    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        /**
         * 大顶堆，保存小于当前中间位置数字（非中位数）的所有数字，例如：6、5、4、3
         */
        minHeap = new PriorityQueue<>();
        /**
         * 小顶堆，保存大于当前中间位置数字（非中位数）的所有数字，例如：7、8、9
         */
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        /**
         * num大于等于当前小顶堆堆顶数字（如果有的话），即大于中间位置数字（非中位数）时，加入小顶堆，其余情况都加入大顶堆
         */
        if (!minHeap.isEmpty() && num >= minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        /**
         * 调整大顶堆和小顶堆的大小，保持两者的数字个数之差始终不大于1
         */
        while (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
        /**
         * 调整大顶堆和小顶堆的大小，保持两者的数字个数之差始终不大于1
         */
        while (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            /**
             * 两个堆的堆顶数字即为所有数字的中间位置的数字
             */
            return 1.0 * (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            /**
             * 哪个堆中数字多，那个堆的堆顶数字即为中位数
             */
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder finder1 = new MedianFinder();
        finder1.addNum(1);
        finder1.addNum(2);
        System.out.println(finder1.findMedian());
        finder1.addNum(3);
        System.out.println(finder1.findMedian());
        finder1.addNum(4);
        System.out.println(finder1.findMedian());
        finder1.addNum(2);
        System.out.println(finder1.findMedian());
        finder1.addNum(5);
        System.out.println(finder1.findMedian());
        finder1.addNum(5);
        System.out.println(finder1.findMedian());
        finder1.addNum(1);
        System.out.println(finder1.findMedian());

        System.out.println("------------------");

        MedianFinder finder2 = new MedianFinder();
        finder2.addNum(-1);
        System.out.println(finder2.findMedian());
        finder2.addNum(-2);
        System.out.println(finder2.findMedian());
        finder2.addNum(-3);
        System.out.println(finder2.findMedian());
        finder2.addNum(-4);
        System.out.println(finder2.findMedian());
        finder2.addNum(-5);
        System.out.println(finder2.findMedian());
    }
}
