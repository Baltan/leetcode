package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Description: 1697. Checking Existence of Edge Length Limited Paths
 *
 * @author Baltan
 * @date 2023/8/29 22:46
 */
public class DistanceLimitedPathsExist {
    public static void main(String[] args) {
        int[][] edgeList1 = {{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}};
        int[][] queries1 = {{0, 1, 2}, {0, 2, 5}};
        OutputUtils.print1DBooleanArray(distanceLimitedPathsExist(3, edgeList1, queries1));

        int[][] edgeList2 = {{0, 1, 10}, {1, 2, 5}, {2, 3, 9}, {3, 4, 13}};
        int[][] queries2 = {{0, 4, 14}, {1, 4, 13}};
        OutputUtils.print1DBooleanArray(distanceLimitedPathsExist(5, edgeList2, queries2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/checking-existence-of-edge-length-limited-paths/solutions/2018397/jian-cha-bian-chang-du-xian-zhi-de-lu-ji-cdr5/"></a>
     *
     * @param n
     * @param edgeList
     * @param queries
     * @return
     */
    public static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        /**
         * parent[i]是节点i的父节点
         */
        int[] parent = new int[n];
        /**
         * height[i]是以i作为根节点的多叉树的高度
         */
        int[] height = new int[n];
        int edgeIndex = 0;
        Integer[] queryIndexes = IntStream.range(0, queries.length).boxed().toArray(Integer[]::new);
        /**
         * 将所有边按照距离正序排列
         */
        Arrays.sort(edgeList, Comparator.comparingInt(x -> x[2]));
        /**
         * 将所有查询在数组queries中的索引值按照对应的limit升序排列
         */
        Arrays.sort(queryIndexes, Comparator.comparingInt(x -> queries[x][2]));

        for (int i = 1; i < n; i++) {
            /**
             * 初始化每个节点的父节点都是自己
             */
            parent[i] = i;
            /**
             * 初始化每个节点都构成一个单节点的多叉树，树高为1
             */
            height[i] = 1;
        }

        for (int queryIndex : queryIndexes) {
            /**
             * 将所有长度小于queries[queryIndex][2]的边都加入并查集中
             */
            while (edgeIndex < edgeList.length && edgeList[edgeIndex][2] < queries[queryIndex][2]) {
                int nodeX = edgeList[edgeIndex][0];
                int nodeY = edgeList[edgeIndex][1];
                union(parent, height, nodeX, nodeY);
                edgeIndex++;
            }
            /**
             * 如果节点queries[queryIndex][0]和queries[queryIndex][1]的根节点相同，说明它们在同一个连通图中，即两个节点可以互通
             */
            result[queryIndex] = getRoot(parent, queries[queryIndex][0]) == getRoot(parent, queries[queryIndex][1]);
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
     * 能否将x所在的集合和y所在的集合合并，如果不能合并，说明x和y本来就在就在同一个集合中，此时连
     * 接x和y就构成了一个环
     *
     * @param parent
     * @param x
     * @param y
     * @return
     */
    public static boolean union(int[] parent, int[] height, int x, int y) {
        int xRoot = getRoot(parent, x);
        int yRoot = getRoot(parent, y);
        /**
         * 如果需要将两棵多叉树合并到一起构成一棵大的多叉树，总是将矮多叉树的根节点作为高多叉树的根节点的子节点
         */
        if (xRoot != yRoot) {
            if (height[xRoot] >= height[yRoot]) {
                parent[yRoot] = xRoot;
                height[xRoot] = Math.max(height[xRoot], 1 + height[yRoot]);
            } else {
                parent[xRoot] = yRoot;
                height[yRoot] = Math.max(height[yRoot], 1 + height[xRoot]);
            }
            return true;
        }
        return false;
    }
}
