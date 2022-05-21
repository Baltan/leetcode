package leetcode.algorithms;

/**
 * Description: 2270. Number of Ways to Split Array
 *
 * @author Baltan
 * @date 2022/5/19 09:27
 */
public class WaysToSplitArray {
    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[]{10, 4, -8, 7}));
        System.out.println(waysToSplitArray(new int[]{2, 3, 1, 0}));
    }

    public static int waysToSplitArray(int[] nums) {
        int result = 0;
        /**
         * 数组nums中所有元素的和
         */
        long sum = 0L;
        int limit = nums.length - 1;
        /**
         * 假设左半部分初始时没有元素，和为0
         */
        long leftSum = 0L;

        for (int num : nums) {
            sum += num;
        }
        /**
         * 将右半部分的元素逐一移到左半部分中
         */
        for (int i = 0; i < limit; i++) {
            leftSum += nums[i];
            sum -= nums[i];
            /**
             * 判断左半部分的元素和是否不小于右半部分的元素和
             */
            if (leftSum >= sum) {
                result++;
            }
        }
        return result;
    }
}
