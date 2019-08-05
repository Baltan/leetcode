package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 930. Binary Subarrays With Sum
 *
 * @author Baltan
 * @date 2019-08-05 09:33
 */
public class NumSubarraysWithSum {
    public static void main(String[] args) {
        int[] A1 = {1, 0, 1, 0, 1};
        System.out.println(numSubarraysWithSum(A1, 2));

        int[] A2 =
                {0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0,
                        0, 1,
                        0, 1, 0, 1, 1, 0, 1};
        System.out.println(numSubarraysWithSum(A2, 4));

        int[] A3 = {0, 0, 0, 0, 0};
        System.out.println(numSubarraysWithSum(A3, 0));

        int[] A4 = {0, 0, 1, 0, 0};
        System.out.println(numSubarraysWithSum(A4, 0));
    }

    public static int numSubarraysWithSum(int[] A, int S) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int result = 0;
        int length = A.length;
        List<Integer> list = new ArrayList<>();

        list.add(-1);
        /**
         * list存储每个1的索引位置，在list首尾分别添加一个假设存在的索引-1和length，方便后续计算
         */
        for (int i = 0; i < length; i++) {
            if (A[i] == 1) {
                list.add(i);
            }
        }
        list.add(length);

        int size = list.size();

        if (S == 0) {
            /**
             * 如果目标和S为0，则获得每两个1之间0的个数，可以求得这个区间符合条件的数组个数
             */
            for (int i = 1; i < size; i++) {
                int zeros = list.get(i) - list.get(i - 1) - 1;
                result += zeros * (zeros + 1) / 2;
            }
        } else {
            /**
             * 如果目标和S大于0，但是1的个数（不含首尾两个假设存在的索引）小于S，直接返回0
             */
            if (size - 2 < S) {
                return 0;
            }
            /**
             * 确定两个指针，分别指向两个1的索引，并且这两个指针之间1的个数（含这两个指针指向的1）为S，
             * 分别获得lo指针左边的连续的0的个数和hi指针右边的连续的0的个数，
             * 从左右各选择任意数量的0两两组合，构成的数组都符合条件。
             * 然后将两个指针都向右移动一位，进行下一轮计算
             */
            int lo = 1;
            int hi = lo + S - 1;

            while (hi < size - 1) {
                int leftZeros = list.get(lo) - list.get(lo - 1);
                int rightZeros = list.get(hi + 1) - list.get(hi);
                result += leftZeros * rightZeros;
                lo++;
                hi++;
            }
        }
        return result;
    }
}
