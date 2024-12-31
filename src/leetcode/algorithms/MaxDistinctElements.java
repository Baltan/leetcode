package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3397. Maximum Number of Distinct Elements After Operations
 *
 * @author Baltan
 * @date 2024/12/29 16:48
 */
public class MaxDistinctElements {
    public static void main(String[] args) {
        System.out.println(maxDistinctElements(new int[]{9, 8, 8, 10, 10}, 0));
        System.out.println(maxDistinctElements(new int[]{1, 2, 2, 3, 3, 4}, 2));
        System.out.println(maxDistinctElements(new int[]{4, 4, 4, 4}, 1));
    }

    public static int maxDistinctElements(int[] nums, int k) {
        int result = 1;
        Arrays.sort(nums);
        /**
         * 将nums[0]变成操作后数组nums中可能得到的最小值
         */
        nums[0] -= k;
        /**
         * 依次尝试将数组nums中的每个数字变得和前一个数字不同，但是操作后的数字尽可能小
         */
        for (int i = 1; i < nums.length; i++) {
            /**
             * 操作后nums[i]可以变为[min,max]中的任意一个数字，为了尽可能地使得操作后的nums[i]和nums[i-1]不同，nums[i]至少要变为
             * nums[i-1]+1，但是又不可能小于min或大于max
             */
            int min = nums[i] - k;
            int max = nums[i] + k;
            nums[i] = Math.min(max, Math.max(nums[i - 1] + 1, min));
        }
        /**
         * 计算操作后数组nums中不同数字的个数
         */
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                result++;
            }
        }
        return result;
    }
}
