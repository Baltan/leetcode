package leetcode.algorithms;

/**
 * Description: 312. Burst Balloons
 *
 * @author Baltan
 * @date 2020-07-19 10:03
 */
public class MaxCoins {
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/burst-balloons/solution/dong-tai-gui-hua-by-acw_wangdh15-9/"></a>
     *
     * @param nums
     * @return
     */
    public static int maxCoins(int[] nums) {
        int length = nums.length;
        /**
         * 将nums头尾各加入一个1，其他元素顺序不变构成一个新数组
         */
        int[] help = new int[length + 2];
        /**
         * dp[i][j]表示从元素help[i]到元素help[j]构成的子数组（包含这两个元素），可以获得硬币的最大数量
         */
        int[][] dp = new int[length + 2][length + 2];
        help[0] = 1;
        help[length + 1] = 1;

        for (int i = 1; i <= length; i++) {
            help[i] = nums[i - 1];
        }
        /**
         * len表示子数组的长度
         */
        for (int len = 1; len <= length; len++) {
            /**
             * start表示从help中截取长度为len的子数组起始索引的范围
             */
            for (int start = 1; start <= length + 1 - len; start++) {
                /**
                 * end表示长度为len的子数组的结束索引
                 */
                int end = start + len - 1;
                /**
                 * 在mid表示在help[start]到help[end]这些气球中最后戳破的气球的索引，该气球将这段子数组分割为了
                 * 两段
                 */
                for (int mid = start; mid <= end; mid++) {
                    dp[start][end] = Math.max(dp[start][end], dp[start][mid - 1] + dp[mid + 1][end] +
                            help[start - 1] * help[mid] * help[end + 1]);
                }
            }
        }
        return dp[1][length];
    }
}
