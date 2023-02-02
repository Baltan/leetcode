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

    private static boolean result;

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
        result = false;
        /**
         * counts[i]表示数组nums中数字i的剩余个数
         */
        int[] counts = new int[max + 1];

        for (int num : nums) {
            counts[num]++;
        }
        dfs(nums, counts, average, 0, length - 1, length);
        return result;
    }

    public static void dfs(int[] nums, int[] counts, int average, int sum, int currIndex, int leftCount) {
        /**
         * 如果数组nums中所有数字都被用光了，说明已将数组nums分成了多个非空子集，每个非空子集的数字之和都为average
         */
        if (result || leftCount == 0) {
            result = true;
            return;
        }

        for (int i = currIndex; i >= 0; i--) {
            int num = nums[i];

            if (counts[num] == 0 || sum + num > average) {
                continue;
            }
            counts[num]--;

            if (sum + num == average) {
                /**
                 * 当前非空子集的所有数字之和已经为average，继续查找下一个非空子集
                 */
                dfs(nums, counts, average, 0, nums.length - 1, leftCount - 1);
            } else {
                /**
                 * 继续查找当前非空子集的剩余数字
                 */
                dfs(nums, counts, average, sum + num, i - 1, leftCount - 1);
            }
            counts[num]++;
        }
    }
}
