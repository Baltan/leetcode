package leetcode.algorithms;

/**
 * Description: 3251. Find the Count of Monotonic Pairs II
 *
 * @author baltan
 * @date 2024/8/15 14:28
 * @see CountOfPairs1
 */
public class CountOfPairs2 {
    public static void main(String[] args) {
        System.out.println(countOfPairs(new int[]{40, 91, 187, 256, 334, 337, 694, 749, 782, 833}));
        System.out.println(countOfPairs(new int[]{40, 40, 40, 40, 40, 40, 41, 41, 41, 42, 42, 43, 43, 43, 44, 44, 44, 45, 45, 45, 45, 45, 46, 46, 46, 46, 46, 46, 46, 47, 47, 47, 47, 48, 48, 49, 49, 49, 49, 49, 49, 50, 50, 50, 50}));
        System.out.println(countOfPairs(new int[]{2, 3, 2}));
        System.out.println(countOfPairs(new int[]{5, 5, 5, 5}));
    }

    public static int countOfPairs(int[] nums) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * 根据题意，nums[i]∈[1,1000]
         */
        int upperLimit = 1000;
        /**
         * counts[i]表示遍历到nums[x]时，arr1[x]为i，arr2[x]为nums[x]-i的单调数组对的数目
         */
        long[] counts = new long[upperLimit + 1];
        /**
         * 对于第一个数字nums[0]，arr1[0]可以为[0,nums[0]]，相对应地，arr2[0]就为nums[0]-arr1[0]
         */
        for (int i = 0; i <= nums[0]; i++) {
            counts[i] = 1;
        }
        /**
         * 遍历计算前缀子数组[nums[0],……,nums[i]]的单调数组对数目
         */
        for (int i = 1; i < nums.length; i++) {
            /**
             * 假设有一个数组help，其中help[w]表示arr1[i]为w，arr2[i]为nums[i]-w的单调数组对是数目。数组diffs为数组help的差分数组
             */
            long[] diffs = new long[upperLimit + 2];
            /**
             * 对于前缀子数组[nums[0],……,nums[i-1]]而言，arr1[i-1]可能为[0,nums[i-1]]
             */
            for (int j = 0; j <= nums[i - 1]; j++) {
                /**
                 * 当arr1[i-1]为j时，arr2[i-1]为nums[i-1]-j
                 */
                int k = nums[i - 1] - j;
                /**
                 * 因为arr1[i]不能小于j，并且nums[i]-arr1[i]不能大于k，所以arr1[i]大于等于j，且大于等于nums[i]-k
                 */
                int min = Math.max(j, nums[i] - k);
                /**
                 * arr1[i]最大可能为nums[i]
                 */
                int max = nums[i];

                if (min <= max) {
                    /**
                     * 当arr1[i-1]为j时，arr1[i]可以为[min,max]，所以arr1[i]为[min,max]的每种情况都能有counts[j]种可能
                     */
                    diffs[min] = (diffs[min] + counts[j]) % mod;
                    diffs[max + 1] = (diffs[max + 1] + mod - counts[j]) % mod;
                }
            }
            /**
             * 由差分数组diffs重新推得数组count
             */
            counts[0] = diffs[0];

            for (int j = 1; j <= upperLimit; j++) {
                counts[j] = (counts[j - 1] + diffs[j]) % mod;
            }
        }
        /**
         * 将数组nums的所有单调数组对中arr1的最后一个元素可能的情况数累加即可
         */
        for (long count : counts) {
            result = (result + count) % mod;
        }
        return (int) result;
    }
}
