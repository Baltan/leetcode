package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1122. Relative Sort Array
 *
 * @author Baltan
 * @date 2019-07-15 09:32
 */
public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        OutputUtils.print1DIntegerArray(relativeSortArray(arr1, arr2));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int max = 1000;
        /**
         * arr[i]表示arr1中数字i出现的次数
         */
        int[] arr = new int[max + 1];
        int index = 0;

        for (int num : arr1) {
            arr[num]++;
        }
        /**
         * 先把在arr2中出现过的数字按顺序填到arr1中
         */
        for (int num : arr2) {
            int count = arr[num];

            for (int i = 0; i < count; i++) {
                result[index++] = num;
            }
            arr[num] = 0;
        }
        /**
         * 再把未在arr2中出现过的数字按升序填到arr1中
         */
        for (int i = 0; i <= max; i++) {
            int count = arr[i];

            for (int j = 0; j < count; j++) {
                result[index++] = i;
            }
        }
        return result;
    }
}
