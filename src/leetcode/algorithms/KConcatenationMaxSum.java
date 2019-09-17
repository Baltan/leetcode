package leetcode.algorithms;

/**
 * Description: 1191. K-Concatenation Maximum Sum
 *
 * @author Baltan
 * @date 2019-09-17 08:45
 */
public class KConcatenationMaxSum {
    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        System.out.println(kConcatenationMaxSum(arr1, 3));

        int[] arr2 = {1, -2, 1};
        System.out.println(kConcatenationMaxSum(arr2, 5));

        int[] arr3 = {-1, -2};
        System.out.println(kConcatenationMaxSum(arr3, 7));
    }


    public static int kConcatenationMaxSum(int[] arr, int k) {
        /**
         * 前缀和
         */
        long prefixSum = arr[0];
        /**
         * 最大子数组和，因为子数组长度可以为0，所以初始化值为0和数组第一个元素的较大值
         */
        long result = Math.max(0, prefixSum);
        /**
         * 当前最小的前缀和
         */
        long minPrefixSum = arr[0];
        /**
         * 当前最大和子数组开始索引
         */
        int maxSumSubArrayStart = 0;
        /**
         * 当前最大和子数组结束索引
         */
        int maxSumSubArrayEnd = 0;
        /**
         * 当前最小的前缀和子数组结束索引
         */
        int minPrefixSumArrayEnd = 0;
        int length = arr.length;
        /**
         * 只需讨论两个数组拼接的情况即可，例如：a,b,c,d,e,f,a,b,c,d,e,f……
         * 找到两个数组中的最大和子数组，并记录下最大和子数组开始索引和结束索引
         * @see MaxSubarraySumCircular
         * 到当前元素位置的最大和子数组的和即为"当前前缀和"和"当前前缀和和当前位置之前所有前缀和的最小值之差"
         * 两者取较大值
         */
        for (int i = 1; i < length; i++) {
            prefixSum += arr[i];
            /**
             * "当前前缀和"
             */
            if (prefixSum >= result) {
                maxSumSubArrayEnd = i;
                result = prefixSum;
            }
            /**
             * "当前前缀和"和"当前位置之前所有前缀和的最小值"之差
             */
            if (prefixSum - minPrefixSum >= result) {
                maxSumSubArrayEnd = i;
                maxSumSubArrayStart = minPrefixSumArrayEnd + 1;
                result = prefixSum - minPrefixSum;
            }
            /**
             * 更新"当前位置的所有前缀和的最小值"和"当前最小的前缀和子数组结束索引"
             */
            if (prefixSum <= minPrefixSum) {
                minPrefixSumArrayEnd = i;
                minPrefixSum = prefixSum;
            }
        }
        /**
         * 单个数组所有元素的总和
         */
        long sum = prefixSum;

        for (int i = 0; i < length; i++) {
            prefixSum += arr[i];
            /**
             * "当前前缀和"
             */
            if (prefixSum >= result) {
                /**
                 * 遍历第二个数组的时候，保存当前最大和子数组结束索引时需要将当前索引i+数组长度length
                 */
                maxSumSubArrayEnd = i + length;
                result = prefixSum;
            }
            /**
             * "当前前缀和"和"当前位置之前所有前缀和的最小值"之差
             */
            if (prefixSum - minPrefixSum >= result) {
                /**
                 * 遍历第二个数组的时候，保存当前最大和子数组结束索引时需要将当前索引i+数组长度length
                 */
                maxSumSubArrayEnd = i + length;
                maxSumSubArrayStart = minPrefixSumArrayEnd + 1;
                result = prefixSum - minPrefixSum;
            }
            /**
             * 更新"当前位置的所有前缀和的最小值"和"当前最小的前缀和子数组结束索引"
             */
            if (prefixSum <= minPrefixSum) {
                /**
                 * 遍历第二个数组的时候，保存当前最大和子数组结束索引时需要将当前索引i+数组长度length
                 */
                minPrefixSumArrayEnd = i + length;
                minPrefixSum = prefixSum;
            }
        }
        /**
         * 1、如果单个数组所有元素的总和sum大于0，如果最大和子数组是数组尾+数组头，例如：f,a或者d,e,f,a等形式，连
         * 续k个数组中的最大和子数组的和应当加上(k-2)*sum；否则连续k个数组中的最大和子数组的和应当加上(k-1)*sum；
         * 2、如果单个数组所有元素的总和sum不大于0，连续k个数组中的最大和子数组的和就是连续2个数组中的最大和子数组
         * 的和
         */
        if (sum > 0) {
            if (maxSumSubArrayStart <= length - 1 && maxSumSubArrayEnd >= length) {
                return (int) ((result + (k - 2) * sum) % 1000000007);
            } else {
                return (int) ((result + (k - 1) * sum) % 1000000007);
            }
        } else {
            return (int) (result % 1000000007);
        }
    }
}
