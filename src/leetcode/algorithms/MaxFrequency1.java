package leetcode.algorithms;

/**
 * Description: 3346. Maximum Frequency of an Element After Performing Operations I
 *
 * @author Baltan
 * @date 2024/11/10 15:19
 * @see MaxFrequency2
 */
public class MaxFrequency1 {
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1, 4, 5}, 1, 2));
        System.out.println(maxFrequency(new int[]{5, 11, 20, 20}, 5, 1));
    }

    public static int maxFrequency(int[] nums, int k, int numOperations) {
        int result = 0;
        /**
         * 数组nums中的最小值
         */
        int min = Integer.MAX_VALUE;
        /**
         * 数组nums中的最大值
         */
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        /**
         * counts[i]表示数组nums中数字i出现的次数
         */
        int[] counts = new int[max + 1];
        /**
         * 数组counts的前缀和
         */
        int[] prefixSums = new int[max + 2];

        for (int num : nums) {
            counts[num]++;
            /**
             * 先记录数组nums中出现次数最多的数字出现的总次数
             */
            result = Math.max(result, counts[num]);
        }
        /**
         * 如果k为0，则不能修改数组nums中的任何数字，直接返回数组nums中出现次数最多的数字出现的总次数
         */
        if (k == 0) {
            return result;
        }

        for (int i = min; i <= max; i++) {
            prefixSums[i + 1] = prefixSums[i] + counts[i];
        }
        /**
         * 假设操作完成后，最终数组nums中出现次数最多的数字为i，显然i的范围为[min,max]
         */
        for (int i = min; i <= max; i++) {
            /**
             * 如果被操作的数字最终变成i，则该数字至少为i-k，同时不小于min
             */
            int lo = Math.max(i - k, min);
            /**
             * 如果被操作的数字最终变成i，则该数字至多为i+k，同时不大于max
             */
            int hi = Math.min(i + k, max);
            /**
             * 除了数组nums中本身已有的counts[i]个数字i以外，还能将其余范围[lo,i-1]和[i+1,hi]内的数字尽可能变为i，但是可变成i的数字不
             * 超过numOperations个
             */
            result = Math.max(result, counts[i] + Math.min(numOperations, (prefixSums[i] - prefixSums[lo]) + (prefixSums[hi + 1] - prefixSums[i + 1])));
        }
        return result;
    }
}
