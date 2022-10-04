package leetcode.algorithms;

/**
 * Description: 1621. Number of Sets of K Non-Overlapping Line Segments
 *
 * @author Baltan
 * @date 2022/10/2 15:31
 * @see NumberOfSets1
 * @see NumberOfSets2
 */
public class NumberOfSets {
    public static void main(String[] args) {
        System.out.println(numberOfSets(4, 2));
        System.out.println(numberOfSets(3, 1));
        System.out.println(numberOfSets(30, 7));
        System.out.println(numberOfSets(33, 20));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/number-of-sets-of-k-non-overlapping-line-segments/solution/da-xiao-wei-k-de-bu-zhong-die-xian-duan-de-shu-mu-/"></a>
     *
     * @param n
     * @param k
     * @return
     */
    public static int numberOfSets(int n, int k) {
        int mod = 1000000007;
        /**
         * dp[i][j][0]表示用0、1、……、i这些点构造了j条线段的方法数，其中第j条线段的右端点不是第i个点，
         * dp[i][j][1]表示用0、1、……、i这些点构造了j条线段的方法数，其中第j条线段的右端点是第i个点
         * 所求即为dp[n-1][k][0]+dp[n-1][k][1]
         */
        long[][][] dp = new long[n][k + 1][2];
        dp[0][0][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                /**
                 * 如果用0、1、……、i这些点构造了j条线段，其中第j条线段的右端点不是第i个点，相当于以下两种情况：
                 * ① 用0、1、……、i-1这些点构造了j条线段，其中第j条线段的右端点不是第i-1个点
                 * ② 用0、1、……、i-1这些点构造了j条线段，其中第j条线段的右端点是第i-1个点
                 */
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % mod;
                /**
                 * 如果用0、1、……、i这些点构造了j条线段，其中第j条线段的右端点是第i个点，相当于以下情况：
                 * ① 用0、1、……、i-1这些点构造了j条线段，其中第j条线段的右端点是第i-1个点，我们只是对第j条线段进行了延长，仍
                 * 看做是一条线段
                 * ② 用0、1、……、i-1这些点构造了j-1条线段，其中第j条线段的右端点不是第i-1个点
                 * ③ 用0、1、……、i-1这些点构造了j-1条线段，其中第j条线段的右端点是第i-1个点，虽然和情况①相同我们对第i-1个
                 * 点向右进行了延长，但是看做是两条线段，只是共用第i-1个点
                 *
                 * 其中第②和③种情况要考虑j的范围
                 */
                if (j == 0) {
                    dp[i][j][1] = dp[i - 1][j][1];
                } else {
                    dp[i][j][1] = (dp[i - 1][j][1] + dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1]) % mod;
                }
            }
        }
        return (int) (dp[n - 1][k][0] + dp[n - 1][k][1]) % mod;
    }
}
