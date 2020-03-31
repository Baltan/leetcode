package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 1365. How Many Numbers Are Smaller Than the Current Number
 *
 * @author Baltan
 * @date 2020-03-31 17:55
 */
public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        int[] nums1 = {8, 1, 2, 2, 3};
        OutputUtils.print1DIntegerArray(smallerNumbersThanCurrent(nums1));

        int[] nums2 = {6, 5, 4, 8};
        OutputUtils.print1DIntegerArray(smallerNumbersThanCurrent(nums2));

        int[] nums3 = {7, 7, 7, 7};
        OutputUtils.print1DIntegerArray(smallerNumbersThanCurrent(nums3));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        /**
         * count[i]表示nums中小于i的数字的个数，根据题意，nums中的数字∈[0,100]，count长度为101即可
         */
        int[] count = new int[101];
        int[] copiedNums = nums.clone();
        /**
         * 将nums中的数字按照升序排列
         */
        Arrays.sort(copiedNums);

        for (int i = 1; i < length; i++) {
            /**
             * 如果copiedNums[i]比copiedNums[i-1]大，说明前面的i个数字都小于copiedNums[i]
             */
            if (copiedNums[i] != copiedNums[i - 1]) {
                count[copiedNums[i]] = i;
            }
        }

        for (int i = 0; i < length; i++) {
            result[i] = count[nums[i]];
        }
        return result;
    }
}
