package leetcode.algorithms;

/**
 * Description: 446. Arithmetic Slices II - Subsequence
 *
 * @author Baltan
 * @date 2024/7/27 16:10
 */
public class NumberOfArithmeticSlices1 {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{0, 2000000000, -294967296}));
        System.out.println(numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
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
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        /**
         * 因为等差子序列的长度至少为3，所以所有等差子序列的步长不大于maxStep
         */
        int maxStep = (max - min) / 2;
        /**
         * 数组nums中所有递增等差子序列的数量
         */
        result += countIncrementSequence(nums, max, maxStep);
        /**
         * 在数组nums中所有常数等差子序列的数量
         */
        result += countConstantSequence(nums, max);
        /**
         * 将数组nums翻转后，计算新数组中所有递增等差子序列的数量，相当于在原数组nums中计算所有递减等差子序列的数量
         */
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        /**
         * 数组nums中所有递减等差子序列的数量
         */
        result += countIncrementSequence(nums, max, maxStep);
        return result;
    }

    /**
     * 在数组nums中计算所有递增等差子序列的数量
     *
     * @param nums
     * @param max
     * @param maxStep
     * @return
     */
    public static int countIncrementSequence(int[] nums, int max, int maxStep) {
        int result = 0;
        /**
         * dp[i][j][k]表示最后一个数字为i，步长为j，长度为k的递增等差子序列的个数
         */
        int[][][] dp = new int[max + 1][maxStep + 1][nums.length + 1];

        for (int num : nums) {
            for (int step = 1; step <= maxStep; step++) {
                /**
                 * 数字num可以作为步长为step的递增等差子序列的第一个数字
                 */
                dp[num][step][1]++;
                /**
                 * 数字num不可能和之前的某个数字构成递增等差子序列
                 */
                if (num - step < 0) {
                    continue;
                }

                for (int i = 2; i < dp[num - step][step].length; i++) {
                    /**
                     * 在最后一个数字为num-step，步长为step的递增等差子序列后追加数字num
                     */
                    dp[num][step][i] += dp[num - step][step][i - 1];
                }
            }
        }
        /**
         * 筛选出所有长度至少为3的递增等差子序列
         */
        for (int i = 1; i <= max; i++) {
            for (int j = 0; j <= maxStep; j++) {
                for (int k = 3; k < dp[i][j].length; k++) {
                    result += dp[i][j][k];
                }
            }
        }
        return result;
    }

    /**
     * 在数组nums中计算所有常数等差子序列的数量
     *
     * @param nums
     * @param max
     * @return
     */
    public static int countConstantSequence(int[] nums, int max) {
        int result = 0;
        /**
         * counts[i]表示数组nums中数字i出现的次数
         */
        int[] counts = new int[max + 1];

        for (int num : nums) {
            counts[num]++;
        }

        for (int count : counts) {
            if (count >= 3) {
                /**
                 * count个数字i可以构成的常数等差子序列的数量为：
                 * C(count,3)+C(count,4)+……+C(count,count)
                 * =2^count-C(count,0)-C(count,1)-C(count,2)
                 * =2^count-1-count-count*(count-1)/2
                 */
                result += (1 << count) - 1 - count - count * (count - 1) / 2;
            }
        }
        return result;
    }
}
