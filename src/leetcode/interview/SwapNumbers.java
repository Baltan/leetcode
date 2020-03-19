package leetcode.interview;

import leetcode.util.OutputUtils;

/**
 * Description: 面试题 16.01. 交换数字
 *
 * @author Baltan
 * @date 2020-03-19 16:03
 */
public class SwapNumbers {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(swapNumbers(new int[]{1, 2}));
    }

    public static int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}
