package leetcode.interview;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 面试题 16.16. 部分排序
 *
 * @author Baltan
 * @date 2020-04-01 11:53
 */
public class SubSort {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(subSort(new int[]{}));
        OutputUtils.print1DIntegerArray(subSort(new int[]{1}));
        OutputUtils.print1DIntegerArray(subSort(new int[]{1, 2}));
        OutputUtils.print1DIntegerArray(subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19}));
    }

    public static int[] subSort(int[] array) {
        int[] result = {-1, -1};

        if (array.length == 0) {
            return result;
        }

        int[] copiedArray = array.clone();
        int length = array.length;
        /**
         * 将copiedArray按照升序排列
         */
        Arrays.sort(copiedArray);
        /**
         * 从前向后逐一比较array和copiedArray对应位置上的值，直到找到第一个不一样的位置，则array
         * 从这个位置开始的子列表需要被排序
         */
        for (int i = 0; i < length; i++) {
            if (array[i] != copiedArray[i]) {
                result[0] = i;
                break;
            }
        }
        /**
         * 从后向前逐一比较array和copiedArray对应位置上的值，直到找到第一个不一样的位置，则array
         * 需要被排序的子列表在这个位置结束
         */
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] != copiedArray[i]) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
