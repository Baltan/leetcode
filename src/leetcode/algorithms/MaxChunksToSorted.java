package leetcode.algorithms;

/**
 * Description: 769. Max Chunks To Make Sorted
 *
 * @author Baltan
 * @date 2019-08-21 11:09
 */
public class MaxChunksToSorted {
    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 1, 0};
        System.out.println(maxChunksToSorted(arr1));

        int[] arr2 = {1, 0, 2, 3, 4};
        System.out.println(maxChunksToSorted(arr2));

        int[] arr3 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(maxChunksToSorted(arr3));

        int[] arr4 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(maxChunksToSorted(arr4));

        int[] arr5 = {1, 2, 0, 3};
        System.out.println(maxChunksToSorted(arr5));
    }

    public static int maxChunksToSorted(int[] arr) {
        int result = 0;
        int max = -1;
        int length = arr.length;
        /**
         * 遍历原数组，对于每一个遍历到的数字，获取当前所有遍历过的数字的最大值，
         * 如果最大值和当前索引相等，那么当前值及其左边的所有数字都小于当前最大值，这些数可以分为一组，将result加1，
         * 如果最大值大于当前索引，那么还有小于当前最大值的数字在当前数字的右边，需要将这些数分在同一组内
         */
        for (int i = 0; i < length; i++) {
            max = Math.max(max, arr[i]);

            if (max == i) {
                result++;
            }
        }
        return result;
    }
}
