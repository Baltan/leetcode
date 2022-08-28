package leetcode.algorithms;

/**
 * Description: 1695. Maximum Erasure Value
 *
 * @author Baltan
 * @date 2022/8/27 15:13
 */
public class MaximumUniqueSubarray {
    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
        System.out.println(maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        /**
         * 初始状态时，子数组中只包括元素nums[0]
         */
        int result = nums[0];
        /**
         * 子数组中所有元素的和
         */
        int sum = nums[0];
        /**
         * 子数组的第一个元素的索引位置
         */
        int start = 0;
        /**
         * 子数组的最后一个元素的索引位置
         */
        int end = 0;
        int length = nums.length;
        /**
         * flag[i]表示数字i在子数组中是否存在，根据题意，数组nums中的数字∈[1,10000]
         */
        boolean[] flag = new boolean[10001];
        flag[nums[0]] = true;
        /**
         * 因为数组nums中的元素都是正数，所以子数组中数字不重复的情况下，尽可能的右移end的位置，使子数组中的数字尽可能多肯定能使
         * 得子数组各元素之和更大
         */
        while (end + 1 < length) {
            /**
             * 如果下一个数nums[end+1]在子数组中还不存在，就右移end的位置，把下一个数包括进子数组中
             */
            if (!flag[nums[end + 1]]) {
                end++;
                sum += nums[end];
                flag[nums[end]] = true;
                result = Math.max(result, sum);
            } else {
                /**
                 * 如果下一个数nums[end+1]在子数组中已存在，为了把这个数包括进子数组中，就要先右移start的位置，直到把子数组中
                 * 等于nums[end+1]的这个数字x排除掉。先把子数组中x之前的数字都排除掉
                 */
                while (nums[start] != nums[end + 1]) {
                    sum -= nums[start];
                    flag[nums[start]] = false;
                    start++;

                }
                /**
                 * 再次右移start的位置把数字x排除掉，再右移end的位置，把nums[end+1]包括进子数组中。此时新的子数组中各元素之
                 * 和一定不大于之前的子数组，所以没必要和result比较
                 */
                start++;
                end++;
            }
        }
        return result;
    }
}
