package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 3741. Minimum Distance Between Three Equal Elements II
 *
 * @author baltan
 * @date 2026/1/20 15:43
 * @see MinimumDistance2
 */
public class MinimumDistance1 {
    public static void main(String[] args) {
        System.out.println(minimumDistance(new int[]{1, 2, 1, 1, 3}));
        System.out.println(minimumDistance(new int[]{1, 1, 2, 3, 2, 1, 2}));
        System.out.println(minimumDistance(new int[]{1}));
    }

    public static int minimumDistance(int[] nums) {
        int result = Integer.MAX_VALUE;
        int length = nums.length;
        /**
         * deques[i]升序保存数组nums中元素i的索引
         */
        Deque<Integer>[] deques = new Deque[length + 1];
        /**
         * 假设三元组为(i,j,k)且i<j<k则三元组的距离|i-j|+|j-k|+|k-i|=2(k-i)，计算2(k-i)的最小值即可
         */
        for (int i = 0; i < length; i++) {
            int num = nums[i];

            if (deques[num] == null) {
                /**
                 * 只需要关心元素num在数组nums中相邻出现三次的索引
                 */
                deques[num] = new ArrayDeque<>(3);
            }

            if (deques[num].size() == 3) {
                deques[num].pollFirst();
            }
            deques[num].offerLast(i);

            if (deques[num].size() == 3) {
                result = Math.min(result, (deques[num].peekLast() - deques[num].peekFirst()) * 2);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
