package leetcode.algorithms;

/**
 * Description: 1223. Dice Roll Simulation
 *
 * @author Baltan
 * @date 2019-10-16 09:07
 */
public class DieSimulator {
    public static void main(String[] args) {
        int[] rollMax1 = {1, 1, 2, 2, 2, 3};
        System.out.println(dieSimulator(2, rollMax1));

        int[] rollMax2 = {1, 1, 1, 1, 1, 1};
        System.out.println(dieSimulator(2, rollMax2));

        int[] rollMax3 = {1, 1, 1, 2, 2, 3};
        System.out.println(dieSimulator(3, rollMax3));

        int[] rollMax4 = {3, 4, 5, 6, 7, 8};
        System.out.println(dieSimulator(5000, rollMax4));
    }

    public static int dieSimulator(int n, int[] rollMax) {
        long result = 0;
        int mod = 1000000007;
        int max = 0;
        /**
         * 同一数字连续出现的最大次数
         */
        for (int num : rollMax) {
            max = Math.max(max, num);
        }
        /**
         * dp[i][j][k]表示当连续掷i次骰子时，最后k个数字都为j且最后至多只有连续k个j的点数序列的数量
         */
        long[][][] dp = new long[n + 1][7][max + 1];
        /**
         * 投掷1次骰子，最后1个数字为1、2、3、4、5、6的结果种类数都为1
         */
        for (int i = 1; i < 7; i++) {
            dp[1][i][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < 7; j++) {
                for (int k = 1; k < 7; k++) {
                    if (k != j) {
                        /**
                         * 对于连续出现k的次数，至多只有rollMax[k-1]个
                         */
                        for (int l = 1; l <= rollMax[k - 1]; l++) {
                            /**
                             * 连续投掷i次骰子，最后1个数字为j且最后至多只有连续1个j的点数序列的数量，为连续投掷i-1次
                             * 骰子，最后一个数字不为j的所有点数序列的数量的和。例如：
                             * dp[i][6][1]=
                             * (dp[i-1][1][1]+dp[i-1][1][2]+……+dp[i-1][1][rollMax[0]])+
                             * (dp[i-1][2][1]+dp[i-1][2][2]+……+dp[i-1][2][rollMax[1]])+
                             * (dp[i-1][3][1]+dp[i-1][3][2]+……+dp[i-1][3][rollMax[2]])+
                             * (dp[i-1][4][1]+dp[i-1][4][2]+……+dp[i-1][4][rollMax[3]])+
                             * (dp[i-1][5][1]+dp[i-1][5][2]+……+dp[i-1][5][rollMax[4]])
                             *
                             * dp[i][1][1]=
                             * (dp[i-1][2][1]+dp[i-1][2][2]+……+dp[i-1][2][rollMax[1]])+
                             * (dp[i-1][3][1]+dp[i-1][3][2]+……+dp[i-1][3][rollMax[2]])+
                             * (dp[i-1][4][1]+dp[i-1][4][2]+……+dp[i-1][4][rollMax[3]])+
                             * (dp[i-1][5][1]+dp[i-1][5][2]+……+dp[i-1][5][rollMax[4]])+
                             * (dp[i-1][6][1]+dp[i-1][6][2]+……+dp[i-1][6][rollMax[5]])
                             */
                            dp[i][j][1] += dp[i - 1][k][l] % mod;
                        }
                        dp[i][j][1] = dp[i][j][1] % mod;
                    }
                }
                /**
                 * 对于连续出现j的次数，至多只有rollMax[j-1]个
                 */
                for (int k = 2; k <= rollMax[j - 1]; k++) {
                    /**
                     * 连续投掷i次骰子，最后k(k>=2且k<=rollMax[j-1])个数字为j且最后至多只有连续k个j的点数序列的数量，
                     * 为连续投掷i-1次骰子，最后k-1个数字为j且最后至多只有连续k-1个j的点数序列的数量。例如：
                     * dp[100][6][50]=dp[99][6][49]
                     */
                    dp[i][j][k] = dp[i - 1][j][k - 1];
                }
            }
        }
        /**
         * 连续投掷n次骰子的点数序列的数量为最后j(j>=1且j<=rollMax[i-1])个数字为i且最后至多只有连续j个i的点数序列的数量
         * 的和。即：
         * (dp[n][1][1]+dp[n][1][2]+……+dp[n][1][rollMax[0]])+
         * (dp[n][2][1]+dp[n][2][2]+……+dp[n][2][rollMax[1]])+
         * (dp[n][3][1]+dp[n][3][2]+……+dp[n][3][rollMax[2]])+
         * (dp[n][4][1]+dp[n][4][2]+……+dp[n][4][rollMax[3]])+
         * (dp[n][5][1]+dp[n][5][2]+……+dp[n][5][rollMax[4]])+
         * (dp[n][6][1]+dp[n][6][2]+……+dp[n][6][rollMax[5]])
         */
        for (int i = 1; i < 7; i++) {
            /**
             * 对于连续出现i的次数，至多只有rollMax[i-1]个
             */
            for (int j = 1; j <= rollMax[i - 1]; j++) {
                result += dp[n][i][j] % mod;
            }
        }
        return (int) (result % mod);
    }
}
