package leetcode.algorithms;

/**
 * Description: 1749. Maximum Absolute Sum of Any Subarray
 *
 * @author Baltan
 * @date 2022/7/26 08:49
 */
public class MaxAbsoluteSum {
    public static void main(String[] args) {
        System.out.println(maxAbsoluteSum(new int[]{1, -3, 2, 3, -4}));
        System.out.println(maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2}));
        System.out.println(maxAbsoluteSum(new int[]{1, 2, 3, 4, 5}));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/solution/1749-ren-yi-zi-shu-zu-he-de-jue-dui-zhi-0gqqh/"></a>
     *
     * @param nums
     * @return
     */
    public static int maxAbsoluteSum(int[] nums) {
        int result = 0;
        /**
         * 遍历到某个元素时的前缀和
         */
        int prefixSum = 0;
        /**
         * 遍历到某个元素时，之前元素前缀和的最小值
         */
        int minPrefixSum = 0;
        /**
         * 遍历到某个元素时，之前元素前缀和的最大值
         */
        int maxPrefixSum = 0;

        for (int num : nums) {
            prefixSum += num;
            /**
             * 包含元素num的子数组和的绝对值的最大值一定在以下两种情况中出现
             */
            result = Math.max(result, Math.abs(prefixSum - minPrefixSum));
            result = Math.max(result, Math.abs(prefixSum - maxPrefixSum));
            /**
             * 更新前缀和的最大值和最小值
             */
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
            maxPrefixSum = Math.max(maxPrefixSum, prefixSum);
        }
        return result;
    }
}
