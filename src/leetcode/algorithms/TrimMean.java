package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1619. Mean of Array After Removing Some Elements
 *
 * @author Baltan
 * @date 2022/10/4 00:06
 */
public class TrimMean {
    public static void main(String[] args) {
        System.out.println(trimMean(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
        System.out.println(trimMean(new int[]{6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0}));
        System.out.println(trimMean(
                new int[]{6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5,
                        10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4}));
    }

    public static double trimMean(int[] arr) {
        int sum = 0;
        int length = arr.length;
        /**
         * 数组arr中5%元素的个数
         */
        int count = length / 20;
        Arrays.sort(arr);
        /**
         * 除去首尾5%的元素，计算数组arr中剩余元素的和
         */
        for (int i = length - 1 - count; i >= count; i--) {
            sum += arr[i];
        }
        return 1.0 * sum / (length - 2 * count);
    }
}
