package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 167. Two Sum II - Input array is sorted
 *
 * @author Baltan
 * @date 2017/11/7 16:29
 */
public class TwoSum1 {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        OutputUtils.print1DIntegerArray(twoSum(numbers, 9));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        /**
         * 双指针
         */
        while (numbers[index1] + numbers[index2] != target) {
            if (numbers[index1] + numbers[index2] < target) {
                index1++;
            } else {
                index2--;
            }
        }
        /**
         * 按照题意，index1和index2的下标是从1开始的
         */
        int[] result = {index1 + 1, index2 + 1};
        return result;
    }
}
