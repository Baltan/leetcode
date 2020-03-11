package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1338. Reduce Array Size to The Half
 *
 * @author Baltan
 * @date 2020-03-11 16:03
 */
public class MinSetSize {
    public static void main(String[] args) {
        System.out.println(minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
        System.out.println(minSetSize(new int[]{7, 7, 7, 7, 7, 7}));
        System.out.println(minSetSize(new int[]{1, 9}));
        System.out.println(minSetSize(new int[]{1000, 1000, 3, 7}));
        System.out.println(minSetSize(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    public static int minSetSize(int[] arr) {
        int result = 0;
        int halfLength = arr.length / 2;
        int count = 0;
        /**
         * count[i]表示数组arr中元素i出现的次数
         */
        int[] counts = new int[100001];

        for (int value : arr) {
            counts[value]++;
        }
        /**
         * 将arr中元素按照出现次数递增排序
         */
        Arrays.sort(counts);
        /**
         * 从出现次数最多的元素开始逐一将这些元素加入整数集合，直到这些元素累计数量达到数组元素总数的一半
         */
        for (int i = counts.length - 1; i >= 0; i--) {
            count += counts[i];
            result++;

            if (count >= halfLength) {
                return result;
            }
        }
        return arr.length;
    }
}
