package leetcode.algorithms;

/**
 * Description: 837. New 21 Game
 *
 * @author Baltan
 * @date 2019-10-29 08:45
 */
public class New21Game {
    public static void main(String[] args) {
        System.out.println(new21Game(10, 1, 10));
        System.out.println(new21Game(6, 1, 10));
        System.out.println(new21Game(21, 17, 10));
        System.out.println(new21Game(0, 0, 1));
        System.out.println(new21Game(421, 400, 47));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/new-21-game/solution/di-tui-gong-shi-yi-ji-xiang-xi-jie-ti-si-lu-by-wan/"></a>
     */
    public static double new21Game(int N, int K, int W) {
        /**
         * 如果K为0，则没有抽牌机会，不论N为多少，最后得到不超过N的概率都是100%
         */
        if (K == 0) {
            return 1.0;
        }
        /**
         * 理论上最后可能得到最大的数字为K-1+W，但是题目要求计算最后得到不超过N的概率，初始化数组的最大索引为N即可
         */
        double[] dp = new double[N + 1];
        /**
         * sumOfP[i]=dp[0]+dp[1]+dp[2]+dp[3]+……+dp[i]
         */
        double[] sumOfP = new double[N + 1];
        dp[0] = 1.0;
        sumOfP[0] = 1.0;
        /**
         * 每次抽取抽到每个数字的概率
         */
        double p = 1.0 / W;

        for (int i = 1; i <= N; i++) {
            /**
             * 累计和为i的前一轮抽取的累积和最小可能是Math.max(0,i-W)，最大可能是Math.min(i-1,K-1)
             */
            int prevMin = Math.max(0, i - W);
            int prevMax = Math.min(i - 1, K - 1);
            /**
             * 得到i的概率只与前一轮抽取后累积和得到[prevMin,prevMax]中的某个数的概率有关，即：
             * dp[i]=(dp[prevMin]+dp[prevMin+1]+dp[prevMin+2]+……+dp[prevMax])*(1/W)
             */
            dp[i] += (sumOfP[prevMax] - sumOfP[prevMin] + dp[prevMin]) * p;
            sumOfP[i] = sumOfP[i - 1] + dp[i];
        }
        /**
         * 最后得到不超过N的概率为dp[K]+dp[K+1]+dp[K+2]+……+dp[N]
         */
        return sumOfP[N] - sumOfP[K] + dp[K];
    }
}
