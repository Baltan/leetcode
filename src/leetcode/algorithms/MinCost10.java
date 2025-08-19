package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 3613. Minimize Maximum Component Cost
 *
 * @author Baltan
 * @date 2025/8/17 17:16
 */
public class MinCost10 {
    public static void main(String[] args) {
        System.out.println(minCost(6, new int[][]{{0, 1, 27}, {0, 2, 37}, {0, 3, 34}, {2, 4, 97}, {4, 5, 70}, {1, 4, 86}, {1, 2, 27}, {0, 5, 50}, {1, 5, 74}, {1, 3, 55}, {3, 4, 19}, {2, 5, 72}, {2, 3, 30}}, 1));
        System.out.println(minCost(4, new int[][]{{0, 1, 5}, {1, 2, 5}, {2, 3, 5}}, 4));
        System.out.println(minCost(5, new int[][]{{0, 1, 4}, {1, 2, 3}, {1, 3, 2}, {3, 4, 6}}, 2));
        System.out.println(minCost(4, new int[][]{{0, 1, 5}, {1, 2, 5}, {2, 3, 5}}, 1));
    }

    public static int minCost(int n, int[][] edges, int k) {
        /**
         * 图中没有任何边时，连通分量的个数不大于k个
         */
        if (n <= k) {
            return 0;
        }
        /**
         * parent[i]是节点i的父节点，初始化假设n个节点都是独立的连通分量，即每个节点的父节点都是自身
         */
        int[] parent = new int[n];
        /**
         * height[i]是以节点i为根节点的多叉树的高度
         */
        int[] height = new int[n];
        /**
         * 将图中所有边按照边权升序排列
         */
        Arrays.sort(edges, Comparator.comparingInt(x -> x[2]));

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            height[i] = 1;
        }
        /**
         * 初始时，假设图中没有任何边，只有n个独立的节点构成了n个连通分量。按照边权从小到大向图中增加边，直到图中连通分量的个数不超过k个。此
         * 时，最后增加的边的边权即为所有连通分量中的最大成本的最小可能值
         */
        for (int[] edge : edges) {
            /**
             * 每当两个节点edge[0]和edge[1]成功合并，则图中连通分量的个数减1
             */
            if (union(parent, height, edge[0], edge[1])) {
                n--;
            }

            if (n <= k) {
                return edge[2];
            }
        }
        return 0;
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
     * @param height
     * @param x
     * @param y
     * @return
     */
    public static boolean union(int[] parent, int[] height, int x, int y) {
        int xRoot = getRoot(parent, x);
        int yRoot = getRoot(parent, y);

        if (xRoot != yRoot) {
            if (height[xRoot] < height[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (height[yRoot] < height[xRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[xRoot] = yRoot;
                height[yRoot]++;
            }
            return true;
        }
        return false;
    }
}
