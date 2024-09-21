package leetcode.algorithms;

/**
 * Description: 3290. Maximum Multiplication Score
 *
 * @author baltan
 * @date 2024/9/18 09:51
 */
public class MaxScore7 {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{3, 2, 5, 6}, new int[]{2, -6, 4, -5, -3, 2, -7}));
        System.out.println(maxScore(new int[]{-1, 4, 5, -2}, new int[]{-5, -1, -3, -2, -4}));
    }

    public static long maxScore(int[] a, int[] b) {
        /**
         * dp[i][j]表示前缀子数组a[0……i]和b[0……j]的最大乘法得分
         */
        long[][] dp = new long[a.length][b.length];
        /**
         * 初始化所有情况的最大乘法得分都为一个极小值
         */
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                dp[i][j] = Long.MIN_VALUE;
            }
        }
        /**
         * 前缀子数组[a[0]]和[b[0]]的乘法得分只可能为a[0]*b[0]
         */
        dp[0][0] = (long) a[0] * b[0];
        /**
         * 对于前缀子数组[a[0]]和b[0……i]的最大乘法得分，如果a[0]需要和b[i]相乘，则得分为a[0]*b[i]，否则和[a[0]]和b[0……i-1]的最大乘法
         * 得分相同
         */
        for (int i = 1; i <= b.length - a.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], (long) a[0] * b[i]);
        }
        /**
         * 计算前缀子数组a[0……i]和b[0……j]的最大乘法得分，如果a[i]需要和b[j]相乘，则最大乘法得分为a[0……i-1]和b[0……j-1]的最大乘法得分加
         * 上a[i]*b[j]，否则和a[0……i]和b[0……j-1]的最大乘法得分相同
         */
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j <= b.length - a.length + i; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1] + (long) a[i] * b[j]);
            }
        }
        return dp[a.length - 1][b.length - 1];
    }
}
