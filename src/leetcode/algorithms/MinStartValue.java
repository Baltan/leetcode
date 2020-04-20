package leetcode.algorithms;

/**
 * Description: 1413. Minimum Value to Get Positive Step by Step Sum
 *
 * @author Baltan
 * @date 2020-04-21 07:34
 */
public class MinStartValue {
    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{-3, 2, -3, 4, 2}));
        System.out.println(minStartValue(new int[]{1, 2}));
        System.out.println(minStartValue(new int[]{1, -2, -3}));
    }

    public static int minStartValue(int[] nums) {
        /**
         * 数组nums中所有前缀和的最小值
         */
        int minPrefixSum = nums[0];
        /**
         * 数组nums的前缀和
         */
        int prefixSum = nums[0];
        int length = nums.length;
        /**
         * 计算数组nums中所有前缀和的最小值
         */
        for (int i = 1; i < length; i++) {
            prefixSum += nums[i];
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
        }
        /**
         * 因为startValue为正数，所以至少为1
         */
        return Math.max(1, 1 - minPrefixSum);
    }
}
