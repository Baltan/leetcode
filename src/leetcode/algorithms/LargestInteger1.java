package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3471. Find the Largest Almost Missing Integer
 *
 * @author Baltan
 * @date 2025/3/10 23:26
 */
public class LargestInteger1 {
    public static void main(String[] args) {
        System.out.println(largestInteger(new int[]{3, 1, 7, 10, 0}, 1));
        System.out.println(largestInteger(new int[]{0, 0}, 2));
        System.out.println(largestInteger(new int[]{3, 9, 2, 1, 7}, 3));
        System.out.println(largestInteger(new int[]{3, 9, 7, 2, 1, 7}, 4));
        System.out.println(largestInteger(new int[]{0, 0}, 1));
    }

    public static int largestInteger(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        /**
         * counts[i]表示数组nums中，数字i在不同的长度为k的子数组中出现的次数
         */
        int[] counts = new int[max + 1];

        for (int i = 0; i <= nums.length - k; i++) {
            /**
             * isVisited[i]表示数字i在子数组nums[i……i+k-1]中是否出现过
             */
            boolean[] isVisited = new boolean[max + 1];

            for (int j = 0; j < k; j++) {
                isVisited[nums[i + j]] = true;
            }

            for (int j = 0; j <= max; j++) {
                if (isVisited[j]) {
                    counts[j]++;
                }
            }
        }
        /**
         * 查找数组nums中，在不同的长度为k的子数组中只出现过一次的最大数字
         */
        for (int i = max; i >= 0; i--) {
            if (counts[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
