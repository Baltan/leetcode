package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1304. Find N Unique Integers Sum up to Zero
 *
 * @author Baltan
 * @date 2019-12-31 10:42
 */
public class SumZero {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(sumZero(1));
        OutputUtils.print1DIntegerArray(sumZero(2));
        OutputUtils.print1DIntegerArray(sumZero(3));
        OutputUtils.print1DIntegerArray(sumZero(7));
        OutputUtils.print1DIntegerArray(sumZero(8));
        OutputUtils.print1DIntegerArray(sumZero(10));
    }

    public static int[] sumZero(int n) {
        int[] result = new int[n];
        /**
         * 用一对相反数填充相邻的两个元素，即[1,-1,2,-2,3,-3,4,-4……]
         */
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                result[i] = i / 2 + 1;
            } else {
                result[i] = -result[i - 1];
            }
        }
        /**
         * 如果n为奇数，数组中最后一对相反数只有第一个数，将这个数更改为0
         */
        if ((n & 1) == 1) {
            result[n - 1] = 0;
        }
        return result;
    }
}
