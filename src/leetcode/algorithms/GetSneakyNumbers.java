package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3289. The Two Sneaky Numbers of Digitville
 *
 * @author Baltan
 * @date 2024/9/18 23:24
 */
public class GetSneakyNumbers {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(getSneakyNumbers(new int[]{0, 1, 1, 0}));
        OutputUtils.print1DIntegerArray(getSneakyNumbers(new int[]{0, 3, 2, 1, 3, 2}));
        OutputUtils.print1DIntegerArray(getSneakyNumbers(new int[]{7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2}));
    }

    public static int[] getSneakyNumbers(int[] nums) {
        int[] result = {0, 0};
        int index = 0;
        /**
         * isVisited[i]表示数组nums中数字i是否已出现过，根据题意，i∈[0,nums.length-3]
         */
        boolean[] isVisited = new boolean[nums.length - 2];

        for (int num : nums) {
            if (isVisited[num]) {
                result[index++] = num;
                isVisited[num] = false;
            } else {
                isVisited[num] = true;
            }
        }
        return result;
    }
}
