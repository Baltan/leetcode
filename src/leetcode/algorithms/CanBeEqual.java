package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1460. Make Two Arrays Equal by Reversing Subarrays
 *
 * @author Baltan
 * @date 2023/2/17 14:41
 */
public class CanBeEqual {
    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
        System.out.println(canBeEqual(new int[]{7}, new int[]{7}));
        System.out.println(canBeEqual(new int[]{3, 7, 9}, new int[]{3, 7, 11}));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        /**
         * 根据题意，target∈[1,1000]，arr∈[1,1000]
         */
        int max = 1000;
        /**
         * targetCounts[i]表示数组target中数字i的个数
         */
        int[] targetCounts = new int[max + 1];
        /**
         * arrCounts[i]表示数组arr中数字i的个数
         */
        int[] arrCounts = new int[max + 1];

        for (int num : target) {
            targetCounts[num]++;
        }

        for (int num : arr) {
            arrCounts[num]++;
        }
        /**
         * 如果target和arr中数字能一一对应上，arr相邻两数两两交换若干次一定能得到target（类似冒泡排序）
         */
        return Arrays.equals(targetCounts, arrCounts);
    }
}
