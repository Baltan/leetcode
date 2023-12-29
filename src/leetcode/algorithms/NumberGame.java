package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 2974. Minimum Number Game
 *
 * @author baltan
 * @date 2023/12/29 09:40
 */
public class NumberGame {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(numberGame(new int[]{5, 4, 2, 3}));
        OutputUtils.print1DIntegerArray(numberGame(new int[]{2, 5}));
    }

    public static int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        /**
         * 将排序后的数组nums中每相邻两个元素作为一组，交换两个元素
         */
        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }
}
