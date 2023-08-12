package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 2811. Check if it is Possible to Split Array
 *
 * @author baltan
 * @date 2023/8/10 16:59
 */
public class CanSplitArray {
    public static void main(String[] args) {
        System.out.println(canSplitArray(Arrays.asList(1, 2, 1, 1), 4));
        System.out.println(canSplitArray(Arrays.asList(2, 2, 1), 4));
        System.out.println(canSplitArray(Arrays.asList(2, 1, 3), 5));
        System.out.println(canSplitArray(Arrays.asList(2, 3, 3, 2, 3), 6));
    }

    public static boolean canSplitArray(List<Integer> nums, int m) {
        int size = nums.size();
        /**
         * prefixSums[i]表示列表nums前i个值的和
         */
        int[] prefixSums = new int[size + 1];
        /**
         * dp[i][j]表示子数组nums.subList(i,j+1)是否能拆分数组
         */
        boolean[][] dp = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums.get(i);
            /**
             * 长度为1的子数组都能拆分数组
             */
            dp[i][i] = true;
            /**
             * 长度为2的子数组都能通过拆分成两个长度为1的子数组完成拆分
             */
            if (i + 1 < size) {
                dp[i][i + 1] = true;
            }
        }
        /**
         * 计算以nums[k]作为第一个元素的长度为i的子数组能否拆分成两个长度分别为j和i-j的子数组
         */
        for (int i = 3; i <= size; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = 0; k + i - 1 < size; k++) {
                    /**
                     * 子数组nums.subList(k,k+j-1)是否满足两个条件之一，只有子数组自身满足两个条件之一，才有可能进一步拆分该子数组
                     */
                    boolean divisible1 = j == 1 || prefixSums[k + j] - prefixSums[k] >= m;
                    /**
                     * 子数组nums.subList(k+j,k+i-1)是否满足两个条件之一，只有子数组自身满足两个条件之一，才有可能进一步拆分该子数组
                     */
                    boolean divisible2 = i - j == 1 || prefixSums[k + i] - prefixSums[k + j] >= m;
                    /**
                     * 如果两个子数组都满足两个条件之一且都可以进一步拆分成两个子数组，则子数组nums.subList(k,k+i-1)可以被拆分子数组
                     */
                    dp[k][k + i - 1] |= (divisible1 && divisible2 && dp[k][k + j - 1] && dp[k + j][k + i - 1]);
                }
            }
        }
        return dp[0][size - 1];
    }
}
