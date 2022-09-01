package leetcode.algorithms;

/**
 * Description: 1690. Stone Game VII
 *
 * @author Baltan
 * @date 2022/8/28 13:05
 * @see PredictTheWinner
 * @see PredictTheWinner1
 * @see StoneGame
 * @see StoneGameII
 * @see StoneGameIII
 * @see StoneGameIX
 * @see StoneGameVI
 */
public class StoneGameVII {
    public static void main(String[] args) {
        System.out.println(stoneGameVII(new int[]{5, 3, 1, 4, 2}));
        System.out.println(stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2}));
        System.out.println(stoneGameVII(new int[]{2, 3}));
        System.out.println(stoneGameVII(new int[]{1}));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/stone-game-vii/solution/qu-jian-dp-by-sobrilliantgun-zu9t/"></a>
     *
     * @param stones
     * @return
     */
    public static int stoneGameVII(int[] stones) {
        int length = stones.length;
        /**
         * dp[i][j]表示如果在stones的子数组[stones[i],stones[i+1],……,stones[j]]中进行游戏，先手可以获得的最大得分差值，
         * 题目所求即为dp[0][length-1]。对于dp[0][0]、dp[1][1]、……、dp[length-1][length-1]，因为先手总是只能移除唯一的
         * 一块石头得到0分，使得最终最大得分差值为0分，所以初始状态就是所有的dp[i][i]为0
         */
        int[][] dp = new int[length][length];
        /**
         * prefixSum[i]表示stones[0]+stones[1]+……+stones[i-1]的和
         */
        int[] prefixSum = new int[length + 1];
        /**
         * 计算数组stones的前缀和
         */
        for (int i = 0; i < length; i++) {
            prefixSum[i + 1] = prefixSum[i] + stones[i];
        }
        /**
         * span表示子数组的跨度，即子数组中元素的个数
         */
        for (int span = 2; span <= length; span++) {
            /**
             * 遍历子数组中第一个元素的坐标位置，则最后一个元素的坐标位置为start+span-1
             */
            for (int start = 0; start + span - 1 < length; start++) {
                int end = start + span - 1;
                int sum = prefixSum[end + 1] - prefixSum[start];
                /**
                 * 如果先手拿子数组中最左边的石头，则可以获得sum-stones[start]分。对于剩下的石头而言，此时的后手就变成了先手，
                 * 当他拿的时候，也会想要获得最大得分差值，而他能获得的最大得分差值为dp[start+1][end]分，于是先手最终能获得的
                 * 最大得分差值为sum-stones[start]-dp[start+1][end]分
                 */
                int chooseLeft = sum - stones[start] - dp[start + 1][end];
                /**
                 * 如果先手拿子数组中最右边的石头，则可以获得sum-stones[end]分。对于剩下的石头而言，此时的后手就变成了先手，
                 * 当他拿的时候，也会想要获得最大得分差值，而他能获得的最大得分差值为dp[start][end-1]分，于是先手最终能获得的
                 * 最大得分差值为sum-stones[end]-dp[start][end-1]分
                 */
                int chooseRight = sum - stones[end] - dp[start][end - 1];
                /**
                 * 先手会在以上两种情况中选择得分较多的一种
                 */
                dp[start][start + span - 1] = Math.max(chooseLeft, chooseRight);
            }
        }
        return dp[0][length - 1];
    }
}
