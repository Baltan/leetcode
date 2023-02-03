package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2294. Partition Array Such That Maximum Difference Is K
 *
 * @author Baltan
 * @date 2023/1/21 13:11
 */
public class PartitionArray {
    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{3, 6, 1, 2, 5}, 2));
        System.out.println(partitionArray(new int[]{1, 2, 3}, 1));
        System.out.println(partitionArray(new int[]{2, 2, 4, 5}, 0));
    }

    public static int partitionArray(int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        int lo = 0;
        Arrays.sort(nums);
        /**
         * 将排序后的数组nums从较小到大分成多个子数组，保证每个子数组中的最大值和最小值之差不大于k，且最大值尽可能大
         */
        while (lo < length) {
            /**
             * 当前子数组中的最大值上限
             */
            int ceiling = nums[lo] + k;
            /**
             * 说明数组nums剩余所有数字都可以放在一个子数组中，结束循环
             */
            if (nums[length - 1] <= ceiling) {
                result++;
                break;
            }
            int hi = length - 1;
            /**
             * 二分查找当前子数组的最大值在数组nums中的索引
             */
            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;

                if (nums[mid] > ceiling) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }
            result++;
            lo = hi + 1;
        }
        return result;
    }
}
