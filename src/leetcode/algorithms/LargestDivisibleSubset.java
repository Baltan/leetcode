package leetcode.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description: 368. Largest Divisible Subset
 *
 * @author Baltan
 * @date 2019-06-28 09:25
 */
public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        System.out.println(largestDivisibleSubset(nums1));

        int[] nums2 = {1, 2, 4, 7, 8, 9, 16, 18};
        System.out.println(largestDivisibleSubset(nums2));

        int[] nums3 = {1};
        System.out.println(largestDivisibleSubset(nums3));

        int[] nums4 = {};
        System.out.println(largestDivisibleSubset(nums4));

        int[] nums5 = {2, 3, 5, 7, 11, 13, 17, 19};
        System.out.println(largestDivisibleSubset(nums5));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        int length = nums.length;
        Integer[][] subsets = new Integer[length][];
        Arrays.sort(nums);
        subsets[0] = new Integer[]{nums[0]};
        /**
         * 最长subset的长度
         */
        int maxLength = 1;
        /**
         * 最长subset所在的位置
         */
        int maxLengthIndex = 0;

        for (int i = 1; i < length; i++) {
            int prevMaxLength = 0;
            int index = -1;
            /**
             * 查找已有subsets中，加入nums[i]后仍然符合要求的长度最大的subset
             */
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && subsets[j].length > prevMaxLength) {
                    prevMaxLength = subsets[j].length;
                    index = j;
                }
            }
            Integer[] subset = new Integer[prevMaxLength + 1];

            if (prevMaxLength + 1 > maxLength) {
                maxLengthIndex = i;
                maxLength = prevMaxLength + 1;
            }

            if (index != -1) {
                System.arraycopy(subsets[index], 0, subset, 0, prevMaxLength);
            }
            subset[prevMaxLength] = nums[i];
            subsets[i] = subset;
        }
        return Arrays.asList(subsets[maxLengthIndex]);
    }
}
