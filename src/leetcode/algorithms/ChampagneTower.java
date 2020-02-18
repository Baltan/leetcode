package leetcode.algorithms;

/**
 * Description: 799. Champagne Tower
 *
 * @author Baltan
 * @date 2020-02-18 11:29
 */
public class ChampagneTower {
    public static void main(String[] args) {
        System.out.println(champagneTower(1, 1, 1));
        System.out.println(champagneTower(2, 1, 1));
        System.out.println(champagneTower(1000000000, 99, 99));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        /**
         * dp[i][j]表示第i行第j列一共被倒入过的多少香槟
         */
        double[][] dp = new double[query_row + 1][query_row + 1];
        /**
         * 所有酒都是从香槟塔顶的dp[0][0]酒杯倒入的，所以初始化dp[0][0]=poured
         */
        dp[0][0] = poured;
        /**
         * 对于dp[i][j]杯子而言，这个杯子里的香槟只能从dp[i-1][j-1]和dp[i-1][j]两个杯子流入，
         * 从塔顶开始逐层计算每个杯子中一共被倒入过的多少香槟
         */
        for (int i = 1; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                /**
                 * 如果dp[i-1][j-1]杯子存在并且这个杯子一共被倒入的香槟大于一杯，则多余的香槟
                 * 一半会流入dp[i][j]
                 */
                if (j - 1 >= 0 && dp[i - 1][j - 1] > 1) {
                    dp[i][j] += (dp[i - 1][j - 1] - 1) / 2;
                }
                /**
                 * 如果dp[i-1][j]这个杯子一共被倒入的香槟大于一杯，则多余的香槟一半会流入
                 * dp[i][j]
                 */
                if (dp[i - 1][j] > 1) {
                    dp[i][j] += (dp[i - 1][j] - 1) / 2;
                }
            }
        }
        /**
         * 如果dp[query_row][query_glass]这个杯子一共被倒入的香槟大于一杯，则杯中最后只会剩余
         * 一杯香杯
         */
        return dp[query_row][query_glass] >= 1 ? 1 : dp[query_row][query_glass];
    }
}
