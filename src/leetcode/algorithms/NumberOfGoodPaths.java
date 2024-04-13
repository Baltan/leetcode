package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description: 2421. Number of Good Paths
 *
 * @author Baltan
 * @date 2024/4/10 17:09
 */
public class NumberOfGoodPaths {
    public static void main(String[] args) {
        System.out.println(numberOfGoodPaths(new int[]{2, 2, 5, 5}, new int[][]{{1, 0}, {0, 2}, {3, 2}}));
        System.out.println(numberOfGoodPaths(new int[]{1, 3, 2, 1, 3}, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}}));
        System.out.println(numberOfGoodPaths(new int[]{1, 1, 2, 2, 3}, new int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 4}}));
        System.out.println(numberOfGoodPaths(new int[]{1}, new int[][]{}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/number-of-good-paths/solutions/1847967/bing-cha-ji-by-endlesscheng-tbz8/"></a>
     *
     * @param vals
     * @param edges
     * @return
     */
    public static int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        int result = n;
        /**
         * graph[i]表示与节点i相邻的所有节点的集合
         */
        List<Integer>[] graph = new List[n];
        /**
         * indexes[i]为节点i的编号
         */
        Integer[] indexes = new Integer[n];
        /**
         * parent[i]表示节点i的父节点
         */
        int[] parent = new int[n];
        /**
         * counts[i]为节点i所在的连通块中，节点值为vals[i]的节点的个数
         */
        int[] counts = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            indexes[i] = i;
            /**
             * 初始化每个节点的父节点为它本身
             */
            parent[i] = i;
            /**
             * 初始化每个节点自身构成一个独立的连通块
             */
            counts[i] = 1;
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        /**
         * 将所有节点的编号按照对应的节点值升序排列
         */
        Arrays.sort(indexes, Comparator.comparingInt(x -> vals[x]));

        for (int x : indexes) {
            int rootX = getRoot(parent, x);
            /**
             * 判断能否将节点y所在连通块中的节点和节点x构成好路径
             */
            for (int y : graph[x]) {
                int rootY = getRoot(parent, y);

                if (rootX != rootY) {
                    if (vals[rootY] == vals[x]) {
                        /**
                         * 节点x所在连通块中的counts[rootX]个值为vals[x]的节点可以和节点y所在连通块中的counts[rootY]个值为vals[x]
                         * 的节点两两组合构成好路径
                         */
                        result += counts[rootX] * counts[rootY];
                        /**
                         * 两个连通块合并后，连通块中值为vals[x]的节点个数
                         */
                        counts[rootX] += counts[rootY];
                    }
                    /**
                     * 节点y所在连通块合并到节点x所在连通块中
                     */
                    if (vals[rootY] <= vals[x]) {
                        parent[rootY] = rootX;
                    }
                }
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
}
