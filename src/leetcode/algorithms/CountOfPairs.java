package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3015. Count the Number of Houses at a Certain Distance I
 *
 * @author baltan
 * @date 2024/1/22 10:07
 */
public class CountOfPairs {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(countOfPairs(3, 1, 3));
        OutputUtils.print1DIntegerArray(countOfPairs(5, 2, 4));
        OutputUtils.print1DIntegerArray(countOfPairs(4, 1, 1));
    }

    public static int[] countOfPairs(int n, int x, int y) {
        int[] result = new int[n];
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        /**
         * 遍历所有从房屋i到房屋j的情况
         */
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {

                if (j < min || i > max) {
                    /**
                     * 如果两个房屋都在min和max的左侧或者都在min和max的右侧，则从i直接到j，它们最少经过的街道条数为j-i
                     */
                    result[j - i - 1] += 2;
                } else {
                    /**
                     * 如果两个房屋分别在min的左右两侧，则可以从i直接到j，经过的街道条数为j-i；或从i先到min，再到max，再到j，经过的街道
                     * 条数为|i-min|+1+|j-max|。两种情况取较小值
                     */
                    result[Math.min(j - i, Math.abs(i - min) + 1 + Math.abs(j - max)) - 1] += 2;
                }
            }
        }
        return result;
    }
}
