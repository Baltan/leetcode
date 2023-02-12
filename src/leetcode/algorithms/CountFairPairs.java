package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2563. Count the Number of Fair Pairs
 *
 * @author Baltan
 * @date 2023/2/12 12:29
 */
public class CountFairPairs {
    public static void main(String[] args) {
        System.out.println(countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));
        System.out.println(countFairPairs(new int[]{1, 7, 9, 2, 5}, 11, 11));
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        long result = 0L;
        /**
         * 前一个遍历的数字可以构成的公平数对数量，当当前数字和前一个数字相同时，避免重复计算
         */
        int count = 0;
        int length = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            /**
             * nums[i]可以构成的公平数对数量和nums[i-1]相同
             */
            if (i > 0 && nums[i] == nums[i - 1]) {
                result += count;
                continue;
            }
            /**
             * 公平数对中的另一个数nums[j]必须大于等于lowerLimit
             */
            int lowerLimit = lower - nums[i];
            /**
             * 公平数对中的另一个数nums[j]必须小于等于upperLimit
             */
            int upperLimit = upper - nums[i];
            int lowerIndex = getLowerIndex(nums, lowerLimit);
            /**
             * 公平数对中的另一个数nums[j]不存在
             */
            if (lowerIndex == -1) {
                count = 0;
                continue;
            }
            int upperIndex = getUpperIndex(nums, upperLimit);
            /**
             * 公平数对中的另一个数nums[j]不存在
             */
            if (upperIndex == -1) {
                count = 0;
                continue;
            }
            count = upperIndex - lowerIndex + 1;
            /**
             * 如果公平数对中的另一个数nums[j]的值也可以为nums[i]，则计算过程中也包括了(i,i)这样不符合题意的公平数对，需要排除
             */
            if (lowerLimit <= nums[i] && upperLimit >= nums[i]) {
                count--;
            }
            result += count;
        }
        return result / 2;
    }

    /**
     * 在数组nums中二分查找大于等于lowerLimit的第一个数的索引
     *
     * @param nums
     * @param lowerLimit
     * @return
     */
    public static int getLowerIndex(int[] nums, int lowerLimit) {
        /**
         * 数组nums中所有数字都小于lowerLimit，不存在要找的数
         */
        if (nums[nums.length - 1] < lowerLimit) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] < lowerLimit) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 在数组nums中二分查找小于等于upperLimit的最后一个数的索引
     *
     * @param nums
     * @param upperLimit
     * @return
     */
    public static int getUpperIndex(int[] nums, int upperLimit) {
        /**
         * 数组nums中所有数字都大于upperLimit，不存在要找的数
         */
        if (nums[0] > upperLimit) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (nums[mid] > upperLimit) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
