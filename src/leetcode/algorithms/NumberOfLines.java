package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 806. Number of Lines To Write String
 *
 * @author Baltan
 * @date 2018/7/30 16:44
 */
public class NumberOfLines {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(
                numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz"));

        OutputUtils.print1DIntegerArray(
                numberOfLines(
                        new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa"));
    }

    public static int[] numberOfLines(int[] widths, String S) {
        int lineNum = 1;
        int lineLength = 0;
        char letter;
        int letterLength;
        for (int i = 0; i < S.length(); i++) {
            letter = S.charAt(i);
            letterLength = widths[letter - 'a'];

            if (lineLength + letterLength > 100) {
                lineNum++;
                lineLength = letterLength;
            } else {
                lineLength += letterLength;
            }
        }
        return new int[]{lineNum, lineLength};
    }
}
