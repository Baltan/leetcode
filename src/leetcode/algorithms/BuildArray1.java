package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1920. Build Array from Permutation
 *
 * @author Baltan
 * @date 2022/3/3 09:51
 */
public class BuildArray1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(buildArray(new int[]{0, 2, 1, 5, 3, 4}));
        OutputUtils.print1DIntegerArray(buildArray(new int[]{5, 0, 1, 2, 3, 4}));
    }

    public static int[] buildArray(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }
}
