package leetcode.algorithms;

/**
 * Description: 2348. Number of Zero-Filled Subarrays
 *
 * @author Baltan
 * @date 2023/1/16 15:37
 */
public class ZeroFilledSubarray {
    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
        System.out.println(zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0}));
        System.out.println(zeroFilledSubarray(new int[]{2, 10, 2019}));
    }

    public static long zeroFilledSubarray(int[] nums) {
        long result = 0;
        /**
         * 当前子数组中连续的0的个数
         */
        int zeroCount = 0;

        for (int num : nums) {
            if (num != 0) {
                zeroCount = 0;
            } else {
                zeroCount++;
                /**
                 * 以num作为结尾，当前子数组中的每个0作为起始的子数组都符合题意，共zeroCount个子数组
                 */
                result += zeroCount;
            }
        }
        return result;
    }
}
