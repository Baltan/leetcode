package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1838. Frequency of the Most Frequent Element
 *
 * @author Baltan
 * @date 2022/6/9 09:32
 */
public class MaxFrequency {
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1, 2, 4}, 5));
        System.out.println(maxFrequency(new int[]{1, 4, 8, 13}, 5));
        System.out.println(maxFrequency(new int[]{3, 9, 6}, 2));
    }

    public static int maxFrequency(int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        /**
         * 窗口开始索引
         */
        int start = 0;
        /**
         * 窗口结束索引
         */
        int end = 0;
        /**
         * 当前窗口中所有数字变成窗口中最大数字需要的操作总次数
         */
        int operations = 0;
        Arrays.sort(nums);

        while (start <= end && end < length) {
            /**
             * 窗口中所有数字操作总次数不超过k次时，向后延长窗口1个长度；否则从前面缩小窗口1个长度
             */
            if (operations <= k) {
                result = Math.max(result, end - start + 1);
                end++;

                if (end < length) {
                    /**
                     * 扩大后的窗口中，除了最大的数字，其余的数字都需要从倒数第二大的数字nums[end-1]变成最大的数字nums[end]，
                     * 这一步共需要(end-start)*(nums[end]-nums[end-1])次操作
                     */
                    operations += (end - start) * (nums[end] - nums[end - 1]);
                }
            } else {
                /**
                 * 缩小窗口后，原窗口中的第一个数字不需要变成窗口中最大的数字，这一步可以省去nums[end]-nums[start]次操作
                 */
                operations -= (nums[end] - nums[start]);
                start++;
            }
        }
        return result;
    }
}
