package leetcode.algorithms;

/**
 * Description: 1049. Last Stone Weight II
 *
 * @author Baltan
 * @date 2020-03-04 16:30
 */
public class LastStoneWeightII {
    public static void main(String[] args) {
        System.out.println(lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/last-stone-weight-ii/solution/dong-tai-gui-hua-bei-bao-wen-ti-xiang-jie-by-jiach/"></a>
     *
     * @param stones
     * @return
     */
    public static int lastStoneWeightII(int[] stones) {
        /**
         * 所有石头的总重量
         */
        int totalWeight = 0;

        for (int stone : stones) {
            totalWeight += stone;
        }
        /**
         * 石头的总重量的一半。所求结果就是把所有石头分成两堆，这两堆石头的总重量差尽可能接近。
         * 即两堆石头总重量都尽可能接近halfWeight
         */
        int halfWeight = totalWeight / 2;
        /**
         * dp[i]表示当一堆石头的最大容量为i时，可以放下的石头的最大总重量
         */
        int[] dp = new int[halfWeight + 1];

        for (int stone : stones) {
            for (int i = halfWeight; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }
        return totalWeight - 2 * dp[halfWeight];
    }
}
