package leetcode.algorithms;

/**
 * Description: 2656. Maximum Sum With Exactly K Elements
 *
 * @author Baltan
 * @date 2023/4/30 16:40
 */
public class MaximizeSum {
    public static void main(String[] args) {
        System.out.println(maximizeSum(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(maximizeSum(new int[]{5, 5, 5}, 2));
    }

    public static int maximizeSum(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        /**
         * 计算数组nums中的最大值
         */
        for (int num : nums) {
            max = Math.max(max, num);
        }
        /**
         * 每一次操作总是选择当前数组中的最大值，所以k次操作的得分依次为max、max+1、max+2、……、max+k-1
         */
        return (max + k - 1 + max) * k / 2;
    }
}
