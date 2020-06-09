package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 1471. The k Strongest Values in an Array
 *
 * @author Baltan
 * @date 2020-06-09 19:29
 */
public class GetStrongest {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        OutputUtils.print1DIntegerArray(getStrongest(arr1, 2));

        int[] arr2 = {1, 1, 3, 5, 5};
        OutputUtils.print1DIntegerArray(getStrongest(arr2, 2));

        int[] arr3 = {6, 7, 11, 7, 6, 8};
        OutputUtils.print1DIntegerArray(getStrongest(arr3, 5));

        int[] arr4 = {6, -3, 7, 2, 11};
        OutputUtils.print1DIntegerArray(getStrongest(arr4, 3));

        int[] arr5 = {-7, 22, 17, 3};
        OutputUtils.print1DIntegerArray(getStrongest(arr5, 2));

        int[] arr6 = {8};
        OutputUtils.print1DIntegerArray(getStrongest(arr6, 1));
    }

    public static int[] getStrongest(int[] arr, int k) {
        int[] result = new int[k];
        Arrays.sort(arr);
        int index = 0;
        int lo = 0;
        int hi = arr.length - 1;
        /**
         * 中位数
         */
        int median = arr[hi / 2];
        /**
         * 显然越靠近两端的数字，即越远离中位数的数字越强，从两端向中心查找前k强的数字即可
         */
        while (index < k) {
            if (Math.abs(arr[hi] - median) >= Math.abs(median - arr[lo])) {
                result[index++] = arr[hi--];
            } else {
                result[index++] = arr[lo++];
            }
        }
        return result;
    }
}
