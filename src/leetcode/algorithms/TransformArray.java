package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1243. Array Transformation
 *
 * @author Baltan
 * @date 2019-11-03 17:36
 */
public class TransformArray {
    public static void main(String[] args) {
        System.out.println(transformArray(new int[]{6, 2, 3, 4}));
        System.out.println(transformArray(new int[]{1, 6, 3, 4, 3, 5}));
        System.out.println(transformArray(new int[]{1}));
        System.out.println(transformArray(new int[]{1, 6}));
        System.out.println(transformArray(
                new int[]{1, 6, 4, 7, 9, 2, 4, 8, 4, 3, 1, 5, 2, 5, 8, 5, 24, 7, 3, 57, 13, 67, 67, 3, 2
                        , 5, 67, 98, 1, 8, 3, 32, 6, 6, 8}));
    }

    public static List<Integer> transformArray(int[] arr) {
        List<Integer> result = new LinkedList<>();
        int length = arr.length;
        int[] temp;
        /**
         * 记录某一天当中数组中是否有数字发生变化
         */
        boolean flag = true;

        while (flag) {
            flag = false;
            temp = arr.clone();

            for (int i = 1; i < length - 1; i++) {
                if (temp[i] < temp[i - 1] && temp[i] < temp[i + 1]) {
                    arr[i]++;
                    flag = true;
                } else if (temp[i] > temp[i - 1] && temp[i] > temp[i + 1]) {
                    arr[i]--;
                    flag = true;
                }
            }
        }

        for (int num : arr) {
            result.add(num);
        }
        return result;
    }
}
