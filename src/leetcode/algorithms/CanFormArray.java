package leetcode.algorithms;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description: 1640. Check Array Formation Through Concatenation
 *
 * @author Baltan
 * @date 2022/9/20 09:10
 */
public class CanFormArray {
    public static void main(String[] args) {
        int[] arr1 = {15, 88};
        int[][] pieces1 = {{88}, {15}};
        System.out.println(canFormArray(arr1, pieces1));

        int[] arr2 = {49, 18, 16};
        int[][] pieces2 = {{16, 18, 49}};
        System.out.println(canFormArray(arr2, pieces2));

        int[] arr3 = {91, 4, 64, 78};
        int[][] pieces3 = {{78}, {4, 64}, {91}};
        System.out.println(canFormArray(arr3, pieces3));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        /**
         * piece数组的第一个元素 -> piece数组
         */
        Map<Integer, int[]> map = Arrays.stream(pieces)
                .collect(Collectors.toMap(x -> x[0], Function.identity()));
        int length = arr.length;

        for (int i = 0; i < length; ) {
            int head = arr[i];
            int[] piece = map.get(head);

            if (piece == null) {
                return false;
            }

            if (!isEqual(arr, i, piece)) {
                return false;
            }
            i += piece.length;
        }
        return true;
    }

    /**
     * 比较arr的子数组arr.subarray(start,start+piece.length)是否和数组piece相等
     *
     * @param arr
     * @param start
     * @param piece
     * @return
     */
    public static boolean isEqual(int[] arr, int start, int[] piece) {
        int length = piece.length;

        for (int i = 0; i < length; i++) {
            if (piece[i] != arr[start + i]) {
                return false;
            }
        }
        return true;
    }
}
