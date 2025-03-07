package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3467. Transform Array by Parity
 *
 * @author Baltan
 * @date 2025/3/7 23:11
 */
public class TransformArray1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(transformArray(new int[]{4, 3, 2, 1}));
        OutputUtils.print1DIntegerArray(transformArray(new int[]{1, 5, 1, 4, 2}));
    }

    public static int[] transformArray(int[] nums) {
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        /**
         * 数组nums中有多少个奇数，就将数组result的最后这么多个元素置为1即可
         */
        for (int num : nums) {
            if (num % 2 == 1) {
                result[index--] = 1;
            }
        }
        return result;
    }
}
