package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1299. Replace Elements with Greatest Element on Right Side
 *
 * @author Baltan
 * @date 2019-12-29 10:55
 */
public class ReplaceElements {
    public static void main(String[] args) {
        int[] arr1 = {17, 18, 5, 4, 6, 1};
        OutputUtils.print1DIntegerArray(replaceElements(arr1));

        int[] arr2 = {1};
        OutputUtils.print1DIntegerArray(replaceElements(arr2));

        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        OutputUtils.print1DIntegerArray(replaceElements(arr3));

        int[] arr4 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        OutputUtils.print1DIntegerArray(replaceElements(arr4));
    }

    public static int[] replaceElements(int[] arr) {
        /**
         * 当前元素右边所有元素的最大值，因为最后一个元素要求更改为-1，所以初始化为-1
         */
        int max = -1;
        int length = arr.length;
        /**
         * 从后向前遍历
         */
        for (int i = length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            /**
             * 当前元素及其后面所有元素的最大值
             */
            max = Math.max(max, temp);
        }
        return arr;
    }
}
