package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 215. Kth Largest Element in an Array
 *
 * @author Baltan
 * @date 2019-06-08 12:41
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums1, 2));

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums2, 4));

        int[] nums3 = {-1, 2, 0};
        System.out.println(findKthLargest(nums3, 1));
    }

    public static int findKthLargest(int[] nums, int k) {
        /**
         * 降序保存nums中的所有元素
         */
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);

        for (int num : nums) {
            queue.offer(num);
        }
        /**
         * 将queue中的前k-1个最大的元素出队
         */
        while (k-- > 1) {
            queue.poll();
        }
        /**
         * 当前对首的元素就是nums中第k个最大元素
         */
        return queue.poll();
    }
}
