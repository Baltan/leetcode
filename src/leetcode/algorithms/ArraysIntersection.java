package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1213. Intersection of Three Sorted Arrays
 *
 * @author Baltan
 * @date 2019-10-06 10:01
 */
public class ArraysIntersection {
    public static void main(String[] args) {
        int[] arr11 = {1, 2, 3, 4, 5};
        int[] arr12 = {1, 2, 5, 7, 9};
        int[] arr13 = {1, 3, 4, 5, 8};
        System.out.println(arraysIntersection(arr11, arr12, arr13));
    }

    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new LinkedList<>();
        /**
         * i1、i2、i3分别指向arr1、arr2、arr3三个数组当前的索引位置
         */
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int length1 = arr1.length;
        int length2 = arr2.length;
        int length3 = arr3.length;

        while (i1 < length1 && i2 < length2 && i3 < length3) {
            /**
             * 如果arr1、arr2、arr3三个数组当前位置的数字相等，则将该数字该数字加入结果集合；否则保持三个数组
             * 当前位置最大的数字的索引不动，较小的数字的索引加1，继续循环比较
             */
            if (arr1[i1] == arr2[i2] && arr2[i2] == arr3[i3]) {
                result.add(arr1[i1]);
                i1++;
                i2++;
                i3++;
            } else {
                int max = Math.max(Math.max(arr1[i1], arr2[i2]), arr3[i3]);

                if (arr1[i1] < max) {
                    i1++;
                }

                if (arr2[i2] < max) {
                    i2++;
                }

                if (arr3[i3] < max) {
                    i3++;
                }
            }
        }
        return result;
    }
}
