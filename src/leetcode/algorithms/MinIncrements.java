package leetcode.algorithms;

/**
 * Description: 2673. Make Costs of Paths Equal in a Binary Tree
 *
 * @author Baltan
 * @date 2023/5/7 14:32
 */
public class MinIncrements {
    public static void main(String[] args) {
        System.out.println(minIncrements(7, new int[]{1, 5, 2, 2, 3, 3, 1}));
        System.out.println(minIncrements(3, new int[]{5, 3, 3}));
    }

    public static int minIncrements(int n, int[] cost) {
        int result = 0;
        /**
         * 二叉树的层数
         */
        int levels = Integer.bitCount(n);
        /**
         * 二叉树最底层最左边叶子节点的值
         */
        int leftmost = 1 << (levels - 1);
        /**
         * 二叉树最底层最右边叶子节点的值
         */
        int rightmost = (1 << levels) - 1;
        /**
         * 对于二叉树最底层的所有叶子节点来说，最终互为兄弟节点的两个节点的代价一定是相等的
         */
        for (int i = leftmost; i <= rightmost; i += 2) {
            /**
             * 互为兄弟节点的两个节点代价的较大值
             */
            int max = Math.max(cost[i - 1], cost[i]);
            /**
             * 两个兄弟节点的代价最终都变为max
             */
            result += max - cost[i - 1];
            result += max - cost[i];
            cost[i - 1] = max;
            cost[i] = max;
        }
        /**
         * 对于二叉树的所有非叶子节点来说，最终互为兄弟节点的两个节点各自到达叶子节点的总代价一定是相等的，从倒数第二层依次向上计算直到第二层为止
         */
        for (int i = levels - 2; i > 0; i--) {
            /**
             * 二叉树当前层最左边叶子节点的值
             */
            leftmost = 1 << i;
            /**
             * 二叉树当前层最右边叶子节点的值
             */
            rightmost = (1 << (i + 1)) - 1;

            for (int j = leftmost; j <= rightmost; j += 2) {
                /**
                 * 左子节点到达叶子节点的总代价
                 */
                int leftCost = cost[j - 1] + cost[(j << 1) - 1];
                /**
                 * 右子节点到达叶子节点的总代价
                 */
                int rightCost = cost[j] + cost[((j + 1) << 1) - 1];
                int max = Math.max(leftCost, rightCost);
                /**
                 * 两个兄弟节点到达叶子节点的总代价最终都为max
                 */
                result += max - leftCost;
                result += max - rightCost;
                /**
                 * cost[x]记录最终从值为x+1的节点到达叶子节点的总代价
                 */
                cost[j - 1] = max;
                cost[j] = max;
            }
        }
        return result;
    }
}
