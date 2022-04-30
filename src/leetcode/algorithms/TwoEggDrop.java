package leetcode.algorithms;

/**
 * Description: 1884. Egg Drop With 2 Eggs and N Floors
 *
 * @author Baltan
 * @date 2022/4/29 18:01
 */
public class TwoEggDrop {
    public static void main(String[] args) {
        System.out.println(twoEggDrop(2));
        System.out.println(twoEggDrop(100));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/egg-drop-with-2-eggs-and-n-floors/solution/dong-tai-gui-hua-shu-xue-tui-dao-by-tang-1zz1/"></a>
     * 第二种数学推导方法直接见以上地址
     *
     * @param n
     * @return
     */
    public static int twoEggDrop(int n) {
        /**
         * dp[i][j]表示有i+1个蛋，建筑为n层时的最小操作次数
         */
        int[][] dp = new int[2][n + 1];
        /**
         * 当只有一个蛋，建筑共i层时，只能从第一层开始逐层向上尝试，直到找到鸡蛋摔碎的楼层f，最坏情况是要到第i层鸡蛋才摔碎，一共
         * 尝试i次，所以至少dp[0][i]次尝试后，一定可以找到楼层f
         */
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        /**
         * 当只有一个蛋，建筑共i层时
         */
        for (int i = 1; i <= n; i++) {
            dp[1][i] = Integer.MAX_VALUE;
            /**
             * 第一个蛋尝试从第j层向下扔，如果蛋碎了，问题变成"当只有一个蛋，建筑共j-1层时，找到鸡蛋摔碎的楼层f"，此时还需尝试
             * dp[0][j-1]次，加上第一个蛋的尝试，共dp[0][j-1]+1次；如果蛋没碎，问题变成"当有两个蛋，建筑共i-j层时，找到鸡蛋
             * 摔碎的楼层f"，此时还需尝试dp[1][i-j]次，加上第一个蛋的尝试，共dp[1][i-j]+1次，两种情况取尝试次数较少的即可
             */
            for (int j = 1; j <= i; j++) {
                dp[1][i] = Math.min(dp[1][i], Math.max(dp[0][j - 1] + 1, dp[1][i - j] + 1));
            }
        }
        return dp[1][n];
    }
}
