package leetcode.algorithms;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3781. Maximum Score After Binary Swaps
 *
 * @author baltan
 * @date 2026/2/9 15:08
 */
public class MaximumScore3 {
    public static void main(String[] args) {
        System.out.println(maximumScore(new int[]{2, 1, 5, 2, 3}, "01010"));
        System.out.println(maximumScore(new int[]{4, 7, 2, 9}, "0000"));
    }

    public static long maximumScore(int[] nums, String s) {
        long result = 0L;
        /**
         * 大顶堆保存数组nums中的所有数字
         */
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        /**
         * 因为每次操作可以将"01"变为"10"，相当于可以将字符串s中的所有"1"向左移动，所以可以将s中的"1"都向左移动到nums[i]较大的索引i处
         */
        for (int i = 0; i < s.length(); i++) {
            pq.offer(nums[i]);

            if (s.charAt(i) == '1') {
                result += pq.poll();
            }
        }
        return result;
    }
}
