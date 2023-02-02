package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 698. Partition to K Equal Sum Subsets
 *
 * @author Baltan
 * @date 2023/1/31 13:34
 */
public class CanPartitionKSubsets {
    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{2, 9, 4, 7, 3, 2, 10, 5, 3, 6, 6, 2, 7, 5, 2, 4}, 7));
        System.out.println(canPartitionKSubsets(new int[]{3, 3, 10, 2, 6, 5, 10, 6, 8, 3, 2, 1, 6, 10, 7, 2}, 6));
        System.out.println(canPartitionKSubsets(new int[]{4, 4, 4, 6, 1, 2, 2, 9, 4, 6}, 3));
        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println(canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/solutions/1833777/hua-fen-wei-kge-xiang-deng-de-zi-ji-by-l-v66o/"></a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        /**
         * 数组nums中所有数字的和
         */
        int sum = Arrays.stream(nums).sum();
        /**
         * 如果sum不是k的整数倍，则数组nums不能被分成k个非空子集，使得每个非空子集的数字之和相等
         */
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        int length = nums.length;
        /**
         * 每个非空子集的数字之和
         */
        int average = sum / k;
        int max = nums[length - 1];
        /**
         * 如果数组nums中的最大值max大于average，则总有一个非空子集的数字之和要超过average
         */
        if (max > average) {
            return false;
        }
        /**
         * status二进制值从低位到高位的第i位为0表示数字nums[i]可用，为1表示数字nums[i]已被使用，status的最大可能值为(1<<length)-1
         */
        int status = (1 << length) - 1;
        /**
         * dp[i]表示status值为i时，这种状态下是否可能按照题意划分数组nums，题目所求就是dp[status]
         */
        boolean[] dp = new boolean[status + 1];
        /**
         * sums[i]表示status值为i时，当前正在查找的子集中数字的和
         */
        int[] sums = new int[status + 1];
        dp[0] = true;

        for (int i = 0; i <= status; i++) {
            /**
             * status值为i时不能划分数组，加上其他数字也不可能可以划分数组
             */
            if (!dp[i]) {
                continue;
            }
            /**
             * 在status值为i的基础上多增加一个数字nums[j]，判断是否可以划分数组
             */
            for (int j = 0; j < length; j++) {
                /**
                 * 说明在状态status值为i时，数字dp[j]已被使用，跳过
                 */
                if (((i >> j) & 1) == 1) {
                    continue;
                }
                /**
                 * 当前子集数字之和大于average，不能划分数组，后面的nums[j]值更大，不用继续计算
                 */
                if (sums[i] + nums[j] > average) {
                    break;
                }
                /**
                 * 标记数字dp[j]已被使用
                 */
                int next = i | (1 << j);

                if (!dp[next]) {
                    /**
                     * 当前子集中数字的和已经为average了，将当前子集中数字的和设为0，表示要查找一个新的子集
                     */
                    sums[next] = sums[i] + nums[j] == average ? 0 : sums[i] + nums[j];
                    dp[next] = true;
                }
            }
        }
        return dp[status];
    }
}
