package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2341. Maximum Number of Pairs in Array
 *
 * @author Baltan
 * @date 2023/2/15 10:14
 */
public class NumberOfPairs {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2}));
        OutputUtils.print1DIntegerArray(numberOfPairs(new int[]{1, 1}));
        OutputUtils.print1DIntegerArray(numberOfPairs(new int[]{0}));
    }

    public static int[] numberOfPairs(int[] nums) {
        int[] result = new int[2];
        /**
         * 根据题意，nums[i]∈[0,100]
         */
        int max = 100;
        /**
         * counts[i]表示数组nums中数字i的个数
         */
        int[] counts = new int[max + 1];

        for (int num : nums) {
            counts[num]++;
        }

        for (int count : counts) {
            result[0] += count / 2;
            result[1] += count % 2;
        }
        return result;
    }
}
