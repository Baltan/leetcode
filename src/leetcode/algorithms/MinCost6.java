package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3424. Minimum Cost to Make Arrays Identical
 *
 * @author Baltan
 * @date 2025/1/23 23:15
 */
public class MinCost6 {
    public static void main(String[] args) {
        System.out.println(minCost(new int[]{-7, 4}, new int[]{9, -6}, 17));
        System.out.println(minCost(new int[]{-7, 9, 5}, new int[]{7, -2, -5}, 2));
        System.out.println(minCost(new int[]{2, 1}, new int[]{2, 1}, 0));
    }

    public static long minCost(int[] arr, int[] brr, long k) {
        /**
         * 方案A：不对数组进行第一类操作，直接将数组arr和brr相同索引上的数字变为一样
         */
        long planA = 0L;

        for (int i = 0; i < arr.length; i++) {
            planA += Math.abs(arr[i] - brr[i]);
        }
        /**
         * 如果执行一次第一类操作的成本k本身就不小于planA，则需要进行至少一次第一类操作的其他方案总成本一定不小于planA，直接返回planA
         */
        if (k >= planA) {
            return planA;
        }
        /**
         * 方案B：先对数组进行第一类操作，如果数组brr中元素brr[i]是数组中第m小的数字，则重新排列后的数组arr中元素arr[i]也是数组中第m小的
         * 数字。然后将重新排列后的数组arr和brr相同索引上的数字变为一样
         */
        long planB = k;
        Arrays.sort(arr);
        Arrays.sort(brr);

        for (int i = 0; i < arr.length; i++) {
            planB += Math.abs(arr[i] - brr[i]);
        }
        return Math.min(planA, planB);
    }
}
