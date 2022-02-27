package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1929. Concatenation of Array
 *
 * @author Baltan
 * @date 2022/2/26 14:35
 */
public class GetConcatenation {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(getConcatenation(new int[]{1, 2, 1}));
        OutputUtils.print1DIntegerArray(getConcatenation(new int[]{1, 3, 2, 1}));
    }

    public static int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] result = new int[length << 1];

        for (int i = 0; i < length; i++) {
            result[i] = nums[i];
            result[length + i] = nums[i];
        }
        return result;
    }
}
