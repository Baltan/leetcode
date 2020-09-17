package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 684. Redundant Connection
 *
 * @author Baltan
 * @date 2020-02-13 11:48
 * @see FindRedundantDirectedConnection
 */
public class FindRedundantConnection1 {
    public static void main(String[] args) {
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        OutputUtils.print1DIntegerArray(findRedundantConnection(edges1));

        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        OutputUtils.print1DIntegerArray(findRedundantConnection(edges2));

        int[][] edges3 = {{2, 7}, {7, 8}, {3, 6}, {2, 5}, {6, 8}, {4, 8}, {2, 8}, {1, 8}, {7, 10}, {3, 9}};
        OutputUtils.print1DIntegerArray(findRedundantConnection(edges3));
    }

    /**
     * 并查集
     * 参考：<a href="https://www.bilibili.com/video/av38498175?p=2"></a>
     *
     * @param edges
     * @return
     */
    public static int[] findRedundantConnection(int[][] edges) {
        /**
         * 无向图中节点的个数
         */
        int count = 0;

        for (int[] edge : edges) {
            count = Math.max(count, edge[0]);
            count = Math.max(count, edge[1]);
        }
        /**
         * parent[i]是节点i的父节点
         */
        int[] parent = new int[count + 1];
        /**
         * 依次判断edge这条边是否在环上
         */
        for (int[] edge : edges) {
            if (!union(parent, edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }

    /**
     * 查找节点value的根节点
     *
     * @param parent
     * @param value
     * @return
     */
    public static int getRoot(int[] parent, int value) {
        int root = value;

        while (parent[root] != 0) {
            root = parent[root];
        }
        return root;
    }

    /**
     * 能否将x所在的集合和y所在的集合合并，如果不能合并，说明x和y本来就在就在同一个集合中，此时连
     * 接x和y就构成了一个环
     *
     * @param parent
     * @param x
     * @param y
     * @return
     */
    public static boolean union(int[] parent, int x, int y) {
        int xRoot = getRoot(parent, x);
        int yRoot = getRoot(parent, y);

        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
            return true;
        }
        return false;
    }
}
