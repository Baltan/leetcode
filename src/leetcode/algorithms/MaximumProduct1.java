package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2233. Maximum Product After K Increments
 *
 * @author Baltan
 * @date 2022/4/14 22:49
 */
public class MaximumProduct1 {
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{0, 4}, 5));
        System.out.println(maximumProduct(new int[]{6, 3, 3, 2}, 2));
    }

    public static int maximumProduct(int[] nums, int k) {
        /**
         * 如果只有一个元素，则直接返回
         */
        if (nums.length == 1) {
            return nums[0] + k;
        }

        long result = 1L;
        int mod = 1000000007;
        Queue<Integer> pq = new PriorityQueue<>(nums.length);

        for (int num : nums) {
            pq.offer(num);
        }
        /**
         * 当所有元素的总和一致，所有元素尽可能接近时，乘积最大，所以每次操作始终令最小的元素向第二大的元素靠拢
         */
        while (k > 0) {
            int first = pq.poll();
            int second = pq.peek();
            /**
             * 如果k足够大，使队列中最小的元素尽可能超过第二大的元素
             */
            int add = Math.min(k, second - first + 1);
            first += add;
            k -= add;
            pq.offer(first);
        }
        /**
         * 计算所有元素的乘积对mod取模的结果
         */
        for (int num : pq) {
            result = (result * num) % mod;
        }
        return (int) result;
    }
}
