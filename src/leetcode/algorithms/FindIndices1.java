package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2903. Find Indices With Index and Value Difference I
 *
 * @author Baltan
 * @date 2023/10/20 20:31
 */
public class FindIndices1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(findIndices(new int[]{5, 1, 4, 1}, 2, 4));
        OutputUtils.print1DIntegerArray(findIndices(new int[]{2, 1}, 0, 0));
        OutputUtils.print1DIntegerArray(findIndices(new int[]{1, 2, 3}, 2, 4));
    }

    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int length = nums.length;
        /**
         * 遍历所有可能的组合
         */
        for (int i = 0; i < length; i++) {
            for (int j = i + indexDifference; j < length; j++) {
                if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
