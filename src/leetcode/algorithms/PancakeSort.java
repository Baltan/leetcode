package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 969. Pancake Sorting
 *
 * @author Baltan
 * @date 2019-03-22 20:30
 */
public class PancakeSort {
    public static void main(String[] args) {
        System.out.println(pancakeSort(new int[]{3, 2, 4, 1}));
        System.out.println(pancakeSort(new int[]{1, 2, 3}));
        System.out.println(pancakeSort(new int[]{1, 4, 5, 2, 7, 2, 7, 3, 2, 6, 2, 3}));
    }

    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<>();
        int length = A.length;
        int[] B = Arrays.copyOf(A, length);
        Arrays.sort(B);

        while (!Arrays.equals(A, B)) {
            int maxIndex = 0;
            int max = A[0];

            for (int i = 1; i < length; i++) {
                if (A[i] > max) {
                    max = A[i];
                    maxIndex = i;
                }
            }

            if (maxIndex != 0) {
                list.add(maxIndex + 1);

                for (int i = 0; i < (maxIndex + 1) / 2; i++) {
                    int temp = A[i];
                    A[i] = A[maxIndex - i];
                    A[maxIndex - i] = temp;
                }
            }

            list.add(length);

            for (int i = 0; i < (length + 1) / 2; i++) {
                int temp = A[i];
                A[i] = A[length - 1 - i];
                A[length - 1 - i] = temp;
            }

            length--;
        }
        return list;
    }
}
