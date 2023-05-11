package leetcode.algorithms;

/**
 * Description: 1444. Number of Ways of Cutting a Pizza
 *
 * @author Baltan
 * @date 2023/4/1 14:12
 */
public class Ways {
    public static void main(String[] args) {
        System.out.println(ways(new String[]{"A..", "AAA", "..."}, 3));
        System.out.println(ways(new String[]{"A..", "AA.", "..."}, 3));
        System.out.println(ways(new String[]{"A..", "A..", "..."}, 1));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/number-of-ways-of-cutting-a-pizza/solutions/657061/java-dong-tai-gui-hua-by-lippon-5shq/"></a>
     *
     * @param pizza
     * @param k
     * @return
     */
    public static int ways(String[] pizza, int k) {
        int mod = 1000000007;
        int rows = pizza.length;
        int cols = pizza[0].length();
        /**
         * dp[i][j][l]表示以pizza[i][j]为左上角，pizza[rows-1][cols-1]为右下角的披萨分配给l个人的方案数
         */
        long[][][] dp = new long[rows + 1][cols + 1][k + 1];
        /**
         * prefixSums[i][j]表示以pizza[i][j]为左上角，pizza[rows-1][cols-1]为右下角的披萨中包含的苹果数
         */
        int[][] prefixSums = new int[rows + 1][cols + 1];
        /**
         * 计算以pizza[i][j]为左上角，pizza[rows-1][cols-1]为右下角的披萨中包含的苹果数
         */
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                prefixSums[i][j] = prefixSums[i + 1][j] + prefixSums[i][j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0) - prefixSums[i + 1][j + 1];
            }
        }
        /**
         * 从右下角向左上角方向计算
         */
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                /**
                 * 如果以pizza[i][j]为左上角，pizza[rows-1][cols-1]为右下角的披萨中包含苹果，则这部分可以分配给1个人，且分配方案唯一
                 */
                if (prefixSums[i][j] > 0) {
                    dp[i][j][1] = 1;
                }
                /**
                 * 计算以pizza[i][j]为左上角，pizza[rows-1][cols-1]为右下角的披萨分配给[2,k]个人的方案数
                 */
                for (int l = 2; l <= k; l++) {
                    /**
                     * 如果分给第l个人的披萨是横着切得到的，则第l个人可能得到行数为[1,maxRows]
                     */
                    int maxRows = rows - 1 - i;
                    /**
                     * 如果分给第l个人的披萨是竖着切得到的，则第l个人可能得到列数为[1,maxCols]
                     */
                    int maxCols = cols - 1 - j;
                    /**
                     * 考虑第l个人的披萨是横着切得到的情况
                     */
                    for (int m = 1; m <= maxRows; m++) {
                        /**
                         * 如果横着切得到的这部分披萨包含苹果，则可以分给第l个人，下方其余部分的披萨分给l-1个人
                         */
                        if (prefixSums[i][j] > prefixSums[i + m][j]) {
                            dp[i][j][l] = (dp[i][j][l] + dp[i + m][j][l - 1]) % mod;
                        }
                    }
                    /**
                     * 考虑第l个人的披萨是竖着切得到的情况
                     */
                    for (int m = 1; m <= maxCols; m++) {
                        /**
                         * 如果竖着切得到的这部分披萨包含苹果，则可以分给第l个人，右侧其余部分的披萨分给l-1个人
                         */
                        if (prefixSums[i][j] > prefixSums[i][j + m]) {
                            dp[i][j][l] = (dp[i][j][l] + dp[i][j + m][l - 1]) % mod;
                        }
                    }
                }
            }
        }
        return (int) dp[0][0][k];
    }
}
