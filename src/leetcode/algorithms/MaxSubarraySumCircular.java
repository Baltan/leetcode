package leetcode.algorithms;

/**
 * Description: 918. Maximum Sum Circular Subarray
 *
 * @author Baltan
 * @date 2019-08-30 18:19
 */
public class MaxSubarraySumCircular {
    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
        System.out.println(maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
        System.out.println(maxSubarraySumCircular(new int[]{-2, -3, -1}));
        System.out.println(maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
        System.out.println(maxSubarraySumCircular(new int[]{-1, -2, -3, -4}));
        System.out.println(maxSubarraySumCircular(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxSubarraySumCircular(new int[]{1, -6, -3, 2, -8, -9, 2, 6, -4, -5, 7, -5}));
        System.out.println(maxSubarraySumCircular(new int[]{-9}));
        System.out.println(maxSubarraySumCircular(new int[]{8}));
        System.out.println(maxSubarraySumCircular(new int[]{6, 9, -3}));
        System.out.println(maxSubarraySumCircular(new int[]{-2, 4, -5, 4, -5, 9, 4}));
    }

    public static int maxSubarraySumCircular(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        /**
         * 数组所有元素之和
         */
        int sum = A[0];
        /**
         * 子数组的最大值
         */
        int max = A[0];
        /**
         * 数组的前缀和
         */
        int prefixSum = A[0];
        /**
         * 数组当前位置之前所有前缀和的最小值
         */
        int minPrefixSum = A[0];
        int length = A.length;
        /**
         * 不同时包含首尾的情况
         */
        for (int i = 1; i < length; i++) {
            sum += A[i];
            /**
             * 当前前缀和
             */
            prefixSum += A[i];
            max = Math.max(max, prefixSum);
            /**
             * 当前前缀和和当前位置之前所有前缀和的最小值之差，求得当前位置之前子数组之和的最大值
             */
            max = Math.max(max, prefixSum - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
        }

        /**
         * 子数组的最小值
         */
        int min = A[1];
        /**
         * 数组当前位置之前所有前缀和的最大值
         */
        int maxPrefixSum = A[1];
        /**
         * 数组的前缀和
         */
        prefixSum = A[1];
        /**
         * 求不包含首尾时，子数组之和的最小值，数组所有元素之和减去该值，求得同时包含首尾时子数组的最大值
         */
        for (int i = 2; i < length - 1; i++) {
            /**
             * 当前前缀和
             */
            prefixSum += A[i];
            min = Math.min(min, prefixSum);
            /**
             * 当前前缀和和当前位置之前所有前缀和的最大值之差，求得当前位置之前子数组之和的最小值
             */
            min = Math.min(min, prefixSum - maxPrefixSum);
            maxPrefixSum = Math.max(maxPrefixSum, prefixSum);
        }
        /**
         * 不同时包含首尾时子数组之和、同时包含首尾时子数组之和，两者取较大值
         */
        return Math.max(max, sum - min);
    }
}
