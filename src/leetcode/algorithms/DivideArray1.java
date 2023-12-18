package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 2966. Divide Array Into Arrays With Max Difference
 *
 * @author Baltan
 * @date 2023/12/17 13:25
 */
public class DivideArray1 {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(divideArray(new int[]{4, 2, 9, 8, 2, 12, 7, 12, 10, 5, 8, 5, 5, 7, 9, 2, 5, 11}, 14));
        OutputUtils.print2DIntegerArray(divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2));
        OutputUtils.print2DIntegerArray(divideArray(new int[]{1, 3, 3, 2, 7, 3}, 3));
    }

    public static int[][] divideArray(int[] nums, int k) {
        int[][] result = new int[nums.length / 3][3];
        Arrays.sort(nums);
        /**
         * 将数组nums中的元素排序后，每三个一组分割，校验每组中的三个元素的最大值和最小值之差是否不大于k，
         */
        for (int i = 0; i < nums.length / 3; i++) {
            if (nums[i * 3 + 2] - nums[i * 3] > k) {
                return new int[][]{};
            }
            result[i] = new int[]{nums[i * 3], nums[i * 3 + 1], nums[i * 3 + 2]};
        }
        return result;
    }
}
