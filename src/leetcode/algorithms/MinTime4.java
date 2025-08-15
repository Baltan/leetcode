package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3608. Minimum Time for K Connected Components
 *
 * @author baltan
 * @date 2025/8/15 09:22
 */
public class MinTime4 {
    public static void main(String[] args) {
        System.out.println(minTime(1, new int[][]{}, 1));
        System.out.println(minTime(2, new int[][]{{0, 1, 3}}, 2));
        System.out.println(minTime(3, new int[][]{{0, 1, 2}, {1, 2, 4}}, 3));
        System.out.println(minTime(3, new int[][]{{0, 2, 5}}, 2));
    }

    public static int minTime(int n, int[][] edges, int k) {
        /**
         * 连通分量的个数，当所有边都不存在时，n个节点即为n个连通分量
         */
        int count = n;
        /**
         * parent[i]是节点i的父节点，初始化假设n个节点都是独立的连通分量，即每个节点的父节点都是自身
         */
        int[] parent = new int[n];
        /**
         * 将所有边按照被删除的时间倒序排列
         */
        Arrays.sort(edges, (x, y) -> y[2] - x[2]);
        Arrays.setAll(parent, x -> x);
        /**
         * 当无向图中不存在任何边时，不需要删除任何边，返回最小时间为0；否则在edges[0][2]时刻将无向图中所有边都删除后，连通分量的个数为n，
         * 一定不小于k个（根据题意，k<=n）
         */
        int result = edges.length == 0 ? 0 : edges[0][2];
        /**
         * 按照时间倒序逐一将每条边恢复，判断连接这条边后，图中连通分量的个数是否仍不小于k个
         */
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            /**
             * 如果节点edge[0]和edge[1]可以合并，说明它们本身在两个不同的连通分量中，连接这两个节点后，两个连通分量合成了一个，所以图中连
             * 通分量的个数会少一个
             */
            if (union(parent, edge[0], edge[1])) {
                count--;
            }
            /**
             * 当连接边edge后，图中连通分量的个数仍不小于k个，则说明在更早时刻edges[i+1][2]删除上一条边后，仍能保证图中连通分量的个数不少
             * 于k个。如果不存在更早时刻被删除的边，则说明不需要删除图中的任何边，图中连通分量的个数就不少于k个
             */
            if (count >= k) {
                result = i == edges.length - 1 ? 0 : edges[i + 1][2];
            }
        }
        return result;
    }

    /**
     * 查找节点value的根节点
     *
     * @param parent
     * @param value
     * @return
     */
    public static int getRoot(int[] parent, int value) {
        /**
         * 只要节点value的父节点不是其自身，就继续向上查找父节点，直到查找到根节点为止
         */
        while (parent[value] != value) {
            value = parent[value];
        }
        return value;
    }

    /**
     * 能否将x所在的连通分量和y所在的连通分量合并，如果不能合并，说明x和y本来就在就在同一个连通分量中
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
            parent[yRoot] = xRoot;
            return true;
        }
        return false;
    }
}
