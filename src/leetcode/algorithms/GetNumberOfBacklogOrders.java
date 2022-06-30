package leetcode.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1801. Number of Orders in the Backlog
 *
 * @author Baltan
 * @date 2022/6/29 10:10
 */
public class GetNumberOfBacklogOrders {
    public static void main(String[] args) {
        int[][] orders1 = {{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}};
        System.out.println(getNumberOfBacklogOrders(orders1));

        int[][] orders2 = {{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}};
        System.out.println(getNumberOfBacklogOrders(orders2));
    }

    public static int getNumberOfBacklogOrders(int[][] orders) {
        int mod = 1000000007;
        /**
         * 积压的订单总笔数
         */
        long backlogOrderAmount = 0L;
        /**
         * 保存积压的销售订单，并按照订单价格升序排列
         */
        Queue<int[]> sellBacklogOrders = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        /**
         * 保存积压的采购订单，并按照订单价格降序排列
         */
        Queue<int[]> buyBacklogOrders = new PriorityQueue<>((x, y) -> y[0] - x[0]);

        for (int[] order : orders) {
            if (order[2] == 0) {
                /**
                 * 采购订单价格
                 */
                int buyPrice = order[0];
                /**
                 * 采购订单包含笔数
                 */
                int buyAmount = order[1];
                /**
                 * 从订单价格不高于buyPrice的最低价格的积压销售订单开始尝试匹配执行这两笔订单
                 */
                while (buyAmount > 0 && !sellBacklogOrders.isEmpty() &&
                        sellBacklogOrders.peek()[0] <= buyPrice) {
                    /**
                     * 销售订单包含笔数
                     */
                    int sellAmount = sellBacklogOrders.peek()[1];

                    if (sellAmount > buyAmount) {
                        /**
                         * 匹配执行采购订单中的所有笔数，销售订单匹配执行buyAmount笔，销售订单还剩
                         * sellBacklogOrders.peek()[1]-buyAmount笔
                         */
                        sellBacklogOrders.peek()[1] -= buyAmount;
                        backlogOrderAmount -= buyAmount;
                        buyAmount = 0;
                    } else {
                        /**
                         * 匹配执行销售订单中的所有笔数，采购订单匹配执行sellAmount笔，采购订单还剩buyAmount-sellAmount笔
                         */
                        sellBacklogOrders.poll();
                        buyAmount -= sellAmount;
                        backlogOrderAmount -= sellAmount;
                    }
                }
                /**
                 * 如果当前采购订单还有多余笔数，加入积压的采购订单队列
                 */
                if (buyAmount > 0) {
                    /**
                     * 采购订单剩余笔数
                     */
                    order[1] = buyAmount;
                    buyBacklogOrders.offer(order);
                    backlogOrderAmount += buyAmount;
                }
            } else {
                /**
                 * 销售订单价格
                 */
                int sellPrice = order[0];
                /**
                 * 销售订单包含笔数
                 */
                int sellAmount = order[1];
                /**
                 * 从订单价格不低于sellPrice的最高价格的积压采购订单开始尝试匹配执行这两笔订单
                 */
                while (sellAmount > 0 && !buyBacklogOrders.isEmpty() &&
                        buyBacklogOrders.peek()[0] >= sellPrice) {
                    /**
                     * 采购订单包含笔数
                     */
                    int buyAmount = buyBacklogOrders.peek()[1];

                    if (buyAmount > sellAmount) {
                        /**
                         * 匹配执行销售订单中的所有笔数，采购订单匹配执行sellAmount笔，采购订单还剩
                         * buyBacklogOrders.peek()[1]-sellAmount笔
                         */
                        buyBacklogOrders.peek()[1] -= sellAmount;
                        backlogOrderAmount -= sellAmount;
                        sellAmount = 0;
                    } else {
                        /**
                         * 匹配执行采购订单中的所有笔数，销售订单匹配执行buyAmount笔，销售订单还剩sellAmount-buyAmount笔
                         */
                        buyBacklogOrders.poll();
                        sellAmount -= buyAmount;
                        backlogOrderAmount -= buyAmount;
                    }
                }
                /**
                 * 如果当前销售订单还有多余笔数，加入积压的销售订单队列
                 */
                if (sellAmount > 0) {
                    /**
                     * 销售订单剩余笔数
                     */
                    order[1] = sellAmount;
                    sellBacklogOrders.offer(order);
                    backlogOrderAmount += sellAmount;
                }
            }
        }
        return (int) (backlogOrderAmount % mod);
    }
}
