package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 66. Plus One
 *
 * @author Baltan
 * @date 2017/11/8 17:11
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits1 = {5, 6, 9, 2, 8, 9, 9};
        int[] digits2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] digits3 =
                {7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0,
                        1, 1, 1, 7, 4, 0, 0,
                        6};
        OutputUtils.print1DIntegerArray(plusOne(digits1));
        OutputUtils.print1DIntegerArray(plusOne(digits2));
        OutputUtils.print1DIntegerArray(plusOne(digits3));
    }

    public static int[] plusOne(int[] digits) {
        boolean flag = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (flag) {
                digits[i] = digits[i] + 1;
                if (digits[i] == 10) {
                    digits[i] = 0;
                } else {
                    flag = false;
                }
            }
        }
        if (digits[0] == 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        } else {
            return digits;
        }
    }
}
