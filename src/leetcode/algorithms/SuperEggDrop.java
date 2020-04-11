package leetcode.algorithms;

/**
 * Description: 887. Super Egg Drop
 *
 * @author Baltan
 * @date 2020-04-11 11:54
 */
public class SuperEggDrop {
    public static void main(String[] args) {
        System.out.println(superEggDrop(1, 2));
        System.out.println(superEggDrop(2, 6));
        System.out.println(superEggDrop(3, 14));
        System.out.println(superEggDrop(1, 1));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/super-egg-drop/solution/ji-dan-diao-luo-by-leetcode-solution/"></a>
     *
     * @param K
     * @param N
     * @return
     */
    public static int superEggDrop(int K, int N) {
        /**
         * 如果只有一层楼，则操作一次就可以确定安全楼层
         */
        if (N == 1) {
            return 1;
        }
        /**
         * 如果只有一个鸡蛋，则需要从一楼开始逐层向上尝试，最坏情况下操作N次才确定安全楼层
         */
        if (K == 1) {
            return N;
        }

        int result = 0;
        /**
         * dp[i][j]表示有j个鸡蛋，最多可以操作i次可以确定最高的楼层数
         */
        int[][] dp = new int[N + 1][K + 1];
        /**
         * 如果只能操作一次，则只能确定第一层楼是否安全，即最多只能确定一层楼的高度
         */
        for (int i = 1; i <= K; ++i) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; ++i) {
            for (int j = 1; j <= K; ++j) {
                /**
                 * 扔出一个鸡蛋，如果鸡蛋碎了，则还剩j-1个鸡蛋，还能操作i-1次，在该层楼下方还可以判断最多
                 * dp[i-1][j-1]层楼；如果鸡蛋没碎，则还剩j个鸡蛋，还能操作i-1次，在该层楼上方还可以判断
                 * 最多dp[i-1][j]层楼。所以j个鸡蛋操作i次最多可以判断1+dp[i-1][j-1]+dp[i-1][j]层楼
                 */
                dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i - 1][j];
            }
            /**
             * 当K个鸡蛋操作i次可以确定的楼层数不小于N时，就找到了最小操作次数
             */
            if (dp[i][K] >= N) {
                result = i;
                break;
            }
        }
        return result;
    }
}
