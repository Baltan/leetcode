package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3379. Transformed Array
 *
 * @author Baltan
 * @date 2024/12/12 23:45
 */
public class ConstructTransformedArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(constructTransformedArray(new int[]{}));
        OutputUtils.print1DIntegerArray(constructTransformedArray(new int[]{}));
        OutputUtils.print1DIntegerArray(constructTransformedArray(new int[]{}));
    }

    public static int[] constructTransformedArray(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                /**
                 * 当向右移动步数nums[i]大于等于length时，等同于向右移动了nums[i]%length步
                 */
                result[i] = nums[(i + nums[i]) % length];
            } else if (nums[i] < 0) {
                /**
                 * 当向左移动步数-nums[i]大于等于length时，等同于向左移动了(-nums[i])%length步
                 */
                result[i] = nums[(i + length - (-nums[i]) % length) % length];
            } else {
                result[i] = nums[i];
            }
        }
        return result;
    }
}
