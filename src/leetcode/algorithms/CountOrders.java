package leetcode.algorithms;

/**
 * Description: 1359. Count All Valid Pickup and Delivery Options
 *
 * @author Baltan
 * @date 2020-03-28 11:53
 */
public class CountOrders {
    public static void main(String[] args) {
        System.out.println(countOrders(1));
        System.out.println(countOrders(2));
        System.out.println(countOrders(3));
        System.out.println(countOrders(4));
        System.out.println(countOrders(5));
        System.out.println(countOrders(500));
    }

    public static int countOrders(int n) {
        int mod = 1000000007;
        /**
         * dp[i]表示i笔订单的快递序列数目
         */
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            /**
             * 对于第n笔订单的服务可以在第n-1笔订单的快递序列基础上安排。例如已经安排了2笔订单的服务：
             *      ○     ○     ○     ○
             * 共有5个插槽可以安排第n笔订单的收件服务
             *      ○     ○     ○     ○
             *   ↑     ↑     ↑     ↑     ↑
             * 当安排好第n笔订单的收件服务后，第n笔订单的配送服务可以安排的位置也确定了，例如：
             *      ○     ○     ○     ○
             *   ↑
             *    ↑    ↑     ↑     ↑     ↑
             *
             *      ○     ○     ○     ○
             *        ↑
             *         ↑     ↑     ↑     ↑
             *
             *      ○     ○     ○     ○
             *               ↑
             *                ↑    ↑     ↑
             *
             *       ○     ○     ○     ○
             *                      ↑
             *                       ↑   ↑
             *
             *       ○     ○     ○     ○
             *                           ↑
             *                            ↑
             * 第n笔订单的收件配送服务共有5+4+3+2+1=(1+slotCount)*slotCount/2种安排
             */
            int slotCount = (i - 1) * 2 + 1;
            long count = (1 + slotCount) * slotCount / 2;
            dp[i] = (int) (dp[i - 1] * count % mod);
        }
        return dp[n];
    }
}
