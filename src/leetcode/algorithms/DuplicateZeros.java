package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1089. Duplicate Zeros
 *
 * @author Baltan
 * @date 2019-06-17 09:09
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr1);
        OutputUtils.print1DIntegerArray(arr1);

        int[] arr2 = {1, 2, 3};
        duplicateZeros(arr2);
        OutputUtils.print1DIntegerArray(arr2);

        int[] arr3 = {0, 0, 0, 1};
        duplicateZeros(arr3);
        OutputUtils.print1DIntegerArray(arr3);

        int[] arr4 = {1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0};
        duplicateZeros(arr4);
        OutputUtils.print1DIntegerArray(arr4);
    }

    public static void duplicateZeros(int[] arr) {
        if (arr != null) {
            int length = arr.length;
            int[] zeroCount = new int[length];
            boolean[] book = new boolean[length];
            zeroCount[0] = arr[0] == 0 ? 1 : 0;

            for (int i = 1; i < length; i++) {
                zeroCount[i] = zeroCount[i - 1];
                zeroCount[i] = arr[i] == 0 ? zeroCount[i] + 1 : zeroCount[i];
            }

            for (int i = length - 1; i >= 0; i--) {
                int index = i + zeroCount[i];

                if (index < length) {
                    arr[index] = arr[i];
                    book[index] = true;
                }
            }

            for (int i = 0; i < length; i++) {
                if (!book[i]) {
                    arr[i] = 0;
                }
            }
        }
    }
}
