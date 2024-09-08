package leetcode.algorithms;

/**
 * Description: 1872. Stone Game VIII
 *
 * @author Baltan
 * @date 2024/9/8 15:13
 */
public class StoneGameVIII {
    public static void main(String[] args) {
        System.out.println(stoneGameVIII(new int[]{-1, 2, -3, 4, -5}));
        System.out.println(stoneGameVIII(new int[]{7, -6, 5, 10, 5, -2, -6}));
        System.out.println(stoneGameVIII(new int[]{-10, -12}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/stone-game-viii/solutions/791413/shi-zi-you-xi-viii-by-leetcode-solution-e8dx/"></a>
     *
     * @param stones
     * @return
     */
    public static int stoneGameVIII(int[] stones) {
        int length = stones.length;
        /**
         * 由于Alice希望Alice的得分-Bob的得分之差尽可能大，Bob希望Alice的得分-Bob的得分之差尽可能小，所以目标其实都是自己的得分-对手的得
         * 分尽可能大。dp[i]表示Alice可以选择石头的范围为[stones[i],stones[length-1]]时，她的得分和Bob的得分之差的最大值
         */
        int[] dp = new int[length];
        /**
         * 数组stones的前缀和数组。由于拿走最左边n个石头后，会把这n个石头的总得分相同的一块石头重新放回最左边，所以石头的前缀和数组其实是不
         * 变的。例如：原来的石头分数为[s0,s1,s2,s3,s4]，则前缀和数组为[s0,s0+s1,s0+s1+s2,s0+s1+s2+s3,s0+s1+s2+s3+s4]。当拿走前三
         * 块石头后，剩余石头变为[s0+s1+s2,s3,s4]，则前缀和数组为[s0+s1+s2,s0+s1+s2+s3,s0+s1+s2+s3+s4]。所以题目可以转化为两人在前
         * 缀和数组prefixSums中从左到右取数，使得自己的数字之和-对手的数字之和的差最大
         */
        int[] prefixSums = new int[length + 1];

        for (int i = 0; i < length; i++) {
            prefixSums[i + 1] = prefixSums[i] + stones[i];
        }
        /**
         * 当Alice直接把所有石头都取走，则轮到Bob时只剩下一块石头，不能再取走任何石头，两人得分之差即为所有石头值之和
         */
        dp[length - 1] = prefixSums[length];
        /**
         * 当Alice没有选择prefixSums[i]时，她需要在范围[prefixSums[i+1],prefixSums[length]]内取数，则dp[i]=dp[i+1]。如果Alice选
         * 择了prefixSums[i]，则轮到Bob时，他需要在范围[prefixSums[i+1],prefixSums[length]]内取数，此时对于Alice来说，dp[i]=
         * prefixSums[i+1]-dp[i+1]。又因为每次至少要取两块石头，所以i至少为1
         */
        for (int i = length - 2; i > 0; i--) {
            dp[i] = Math.max(dp[i + 1], prefixSums[i + 1] - dp[i + 1]);
        }
        return dp[1];
    }
}
