package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: Beautiful Arrangement II
 *
 * @author Baltan
 * @date 2018/8/20 16:43
 */
public class ConstructArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(constructArray(3, 1));
        OutputUtils.print1DIntegerArray(constructArray(3, 2));
        OutputUtils.print1DIntegerArray(constructArray(5, 4));
        OutputUtils.print1DIntegerArray(constructArray(5, 3));
        OutputUtils.print1DIntegerArray(constructArray(5, 2));
        OutputUtils.print1DIntegerArray(constructArray(5, 1));
    }

    public static int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && i < k) {
                res[i] = n - i / 2;
            } else if (i % 2 != 0 && i < k) {
                res[i] = (i + 1) / 2;
            } else {
                if (k % 2 != 0) {
                    res[i] = n - k / 2 - (i - k + 1);
                } else {
                    res[i] = k / 2 + (i - k + 1);
                }
            }
        }
        return res;
    }
}
