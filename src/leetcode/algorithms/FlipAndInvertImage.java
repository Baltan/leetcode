package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: Flipping an Image
 *
 * @author Baltan
 * @date 2018/7/30 10:39
 */
public class FlipAndInvertImage {
    public static void main(String[] args) {
        int[][] A1 = {new int[]{1, 1, 0}, new int[]{1, 0, 1}, new int[]{0, 0, 0}};
        OutputUtils.print2DIntegerArray(flipAndInvertImage(A1));

        System.out.println();

        int[][] A2 =
                {new int[]{1, 1, 0, 0}, new int[]{1, 0, 0, 1}, new int[]{0, 1, 1, 1}, new int[]{1, 0, 1, 0}};
        OutputUtils.print2DIntegerArray(flipAndInvertImage(A2));

        System.out.println();

        int[][] A3 = {new int[]{1}, new int[]{0}, new int[]{1}};
        OutputUtils.print2DIntegerArray(flipAndInvertImage(A3));
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int[] element;
        int elementLen;
        for (int i = 0; i < A.length; i++) {
            element = A[i];
            elementLen = element.length;
            for (int j = 0; j <= (elementLen - 1) / 2; j++) {
                if (element[j] == element[elementLen - 1 - j]) {
                    if (j != elementLen - 1 - j) {
                        element[j] = 1 - element[j];
                        element[elementLen - 1 - j] = 1 - element[elementLen - 1 - j];
                    } else {
                        element[j] = 1 - element[j];
                    }
                }
            }
        }
        return A;
    }
}
