package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 949. Largest Time for Given Digits
 *
 * @author Baltan
 * @date 2019-03-17 10:02
 */
public class LargestTimeFromDigits {
    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{1, 2, 3, 4}));
        System.out.println(largestTimeFromDigits(new int[]{5, 5, 5, 5}));
        System.out.println(largestTimeFromDigits(new int[]{3, 2, 1, 0}));
        System.out.println(largestTimeFromDigits(new int[]{1, 2, 1, 7}));
        System.out.println(largestTimeFromDigits(new int[]{1, 2, 1, 3}));
        System.out.println(largestTimeFromDigits(new int[]{3, 2, 1, 3}));
        System.out.println(largestTimeFromDigits(new int[]{2, 2, 1, 4}));
        System.out.println(largestTimeFromDigits(new int[]{3, 2, 6, 6}));
        System.out.println(largestTimeFromDigits(new int[]{2, 0, 6, 6}));
    }

    public static String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        if (A[0] >= 3) {
            return "";
        }

        StringBuilder builder = new StringBuilder(5);

        hour:
        for (int i = 23; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (k != j && A[j] * 10 + A[k] == i) {
                        builder.append(A[j]).append(A[k]).append(":");
                        int temp1 = A[j];
                        int temp2 = A[k];
                        A[j] = -1;
                        A[k] = -1;
                        for (int l = 59; l >= 0; l--) {
                            for (int m = 0; m < 4; m++) {
                                for (int n = 0; n < 4; n++) {
                                    if (m != n && A[m] != -1 && A[n] != -1 && A[m] * 10 + A[n] == l) {
                                        builder.append(A[m]).append(A[n]);
                                        return builder.toString();
                                    }
                                }
                            }
                        }
                        A[j] = temp1;
                        A[k] = temp2;
                        builder.delete(0, 5);
                        continue hour;
                    }
                }
            }
        }
        return "";
    }
}
