package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1331. Rank Transform of an Array
 *
 * @author Baltan
 * @date 2020-01-26 12:50
 */
public class ArrayRankTransform {
    public static void main(String[] args) {
        int[] arr1 = {40, 10, 20, 30};
        OutputUtils.print1DIntegerArray(arrayRankTransform(arr1));

        int[] arr2 = {100, 100, 100};
        OutputUtils.print1DIntegerArray(arrayRankTransform(arr2));

        int[] arr3 = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        OutputUtils.print1DIntegerArray(arrayRankTransform(arr3));

        int[] arr4 = {};
        OutputUtils.print1DIntegerArray(arrayRankTransform(arr4));
    }

    public static int[] arrayRankTransform(int[] arr) {
        int length = arr.length;
        /**
         * 保存数组中每个值以及它在排序后的数组中的序号
         */
        Map<Integer, Integer> map = new HashMap<>((int) Math.ceil(length / 0.75));
        int rank = 1;
        int[] copy = arr.clone();
        Arrays.sort(copy);

        for (int i = 0; i < length; i++) {
            /**
             * 如果某个值还没有序号，就将这个值和它的序号加入map中
             */
            if (!map.containsKey(copy[i])) {
                map.put(copy[i], rank);
                rank++;
            }
        }
        /**
         * 将数组中的元素转换为它们排序后的序号
         */
        for (int i = 0; i < length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
