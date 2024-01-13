package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 1931. Painting a Grid With Three Different Colors
 *
 * @author Baltan
 * @date 2024/1/13 22:22
 */
public class ColorTheGrid {
    public static void main(String[] args) {
        System.out.println(colorTheGrid(1, 1));
        System.out.println(colorTheGrid(1, 2));
        System.out.println(colorTheGrid(5, 5));
    }

    public static int colorTheGrid(int m, int n) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * 用三进制数字表示某一行的涂色状态时的最大可能值，即三进制下的22……22（共m个2），其中三进制值中的每一位可能为0、1、2依次代表了每个
         * 单元格可能被涂上的三种颜色
         */
        int max = 0;
        int weight = 1;
        /**
         * 计算三进制下的22……22（共m个2）对应的十进制值
         */
        for (int i = 0; i < m; i++) {
            max += 2 * weight;
            weight *= 3;
        }
        /**
         * 就单行而言，plans保存这一行所有可行的涂色状态
         */
        List<Integer> plans = new ArrayList<>(max);

        for (int i = 0; i <= max; i++) {
            if (checkRow(i, m)) {
                plans.add(i);
            }
        }
        /**
         * isConnectable[i][j]表示相邻的两行涂色状态能否分别为plans[i]和plans[j]
         */
        boolean[][] isConnectable = new boolean[plans.size()][plans.size()];
        /**
         * dp[i][j]表示第i行的涂色状态为plans[j]时，前i+1行的涂色方法总数。dp[n-1]中所有元素之和即为涂完所有单元格的方法总数
         */
        long[][] dp = new long[n][plans.size()];
        /**
         * 对于首行而言，plans中的所有方案都有且仅有1中涂色方法
         */
        Arrays.fill(dp[0], 1L);

        for (int i = 0; i < plans.size(); i++) {
            for (int j = i + 1; j < plans.size(); j++) {
                if (checkConnectedRows(plans.get(i), plans.get(j), m)) {
                    isConnectable[i][j] = true;
                    isConnectable[j][i] = true;
                }
            }
        }
        /**
         * 计算第i行的涂色状态依次为plans[j]时，前i+1行的涂色方法总数
         */
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < plans.size(); j++) {
                for (int k = 0; k < plans.size(); k++) {
                    /**
                     * 判断第i行的涂色状态为plans[j]，第i-1行的涂色状态为plans[k]是否可行
                     */
                    if (isConnectable[j][k]) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                    }
                }
            }
        }

        for (long count : dp[n - 1]) {
            result += count;
        }
        return (int) (result % mod);
    }

    /**
     * 判断涂色状态为mask的方案是否可行
     *
     * @param mask
     * @param m
     * @return
     */
    public static boolean checkRow(int mask, int m) {
        /**
         * mask对应的三进制值更低一位的值，用于比较相邻两个数位的数字是否相同
         */
        int lowerBit = -1;
        /**
         * mask对应的三进制值的位数（忽略前导0）
         */
        int bitCount = 0;

        while (mask != 0) {
            int bit = mask % 3;
            /**
             * 相邻两个数位的数字相等，说明相邻的两个单元格被涂上了相同的颜色，涂色状态为mask的方案不可行
             */
            if (bit == lowerBit) {
                return false;
            }
            mask /= 3;
            lowerBit = bit;
            bitCount++;
        }
        /**
         * 如果mask对应的三进制不足m-1位，说明其高位至少有相邻的两位为0，说明这两个单元格被涂上了相同的颜色，涂色状态为mask的方案不可行；反
         * 之得到一个可行的涂色方案
         */
        return m - bitCount <= 1;
    }

    /**
     * 判断相邻的两行涂色状态分别为mask1和mask2的方案是否可行
     *
     * @param mask1
     * @param mask2
     * @param m
     * @return
     */
    public static boolean checkConnectedRows(int mask1, int mask2, int m) {
        /**
         * mask1和mask2对应的三进制值的位数（忽略前导0）的较大值
         */
        int bitCount = 0;

        while (mask1 != 0 || mask2 != 0) {
            int bit1 = mask1 % 3;
            int bit2 = mask2 % 3;
            /**
             * mask1和mask2对应的三进制值同一数位上的数字相等，说明相邻的两个单元格被涂上了相同的颜色，涂色状态为mask1和mask2的方案不可行
             */
            if (bit1 == bit2) {
                return false;
            }
            mask1 /= 3;
            mask2 /= 3;
            bitCount++;
        }
        /**
         * 如果mask1和mask2对应的三进制值都不足m位，说明它们同时存在某一个高位为0的情况，说明这两个单元格被涂上了相同的颜色，涂色状态为mask
         * 的方案不可行；反之相邻两行涂色得到一个可行的涂色方案
         */
        return bitCount == m;
    }
}
