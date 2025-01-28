package leetcode.algorithms;

/**
 * Description: 3427. Sum of Variable Length Subarrays
 *
 * @author Baltan
 * @date 2025/1/28 20:33
 */
public class SubarraySum1 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{2, 3, 1}));
        System.out.println(subarraySum(new int[]{3, 1, 1, 2}));
    }

    public static int subarraySum(int[] nums) {
        int result = 0;
        int length = nums.length;
        /**
         * 数组nums的前缀和数组
         */
        int[] prefixSums = new int[length + 1];

        for (int i = 0; i < length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        for (int i = 0; i < length; i++) {
            int start = Math.max(0, i - nums[i]);
            /**
             * 累加子数组nums[start……i]中所有元素之和
             */
            result += prefixSums[i + 1] - prefixSums[start];
        }
        return result;
    }
}
