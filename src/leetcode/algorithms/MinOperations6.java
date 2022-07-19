package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1769. Minimum Number of Operations to Move All Balls to Each Box
 *
 * @author Baltan
 * @date 2022/7/17 13:27
 */
public class MinOperations6 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(minOperations("110"));
        OutputUtils.print1DIntegerArray(minOperations("001011"));
    }

    public static int[] minOperations(String boxes) {
        int length = boxes.length();
        int[] result = new int[length];
        char[] charArray = boxes.toCharArray();

        for (int i = 0; i < length; i++) {
            /**
             * 如果boxes[j]中有球，就将boxes[j]中的球移动到boxes[i]中
             */
            for (int j = 0; j < length; j++) {
                if (i != j && charArray[j] == '1') {
                    result[i] += Math.abs(i - j);
                }
            }
        }
        return result;
    }
}
