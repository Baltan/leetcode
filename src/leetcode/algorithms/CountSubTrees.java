package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 1519. Number of Nodes in the Sub-Tree With the Same Label
 *
 * @author Baltan
 * @date 2020-07-19 22:20
 */
public class CountSubTrees {
    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        OutputUtils.print1DIntegerArray(countSubTrees(7, edges1, "abaedcd"));

        int[][] edges2 = {{0, 1}, {1, 2}, {0, 3}};
        OutputUtils.print1DIntegerArray(countSubTrees(4, edges2, "bbbb"));

        int[][] edges3 = {{0, 1}, {0, 2}, {1, 3}, {0, 4}};
        OutputUtils.print1DIntegerArray(countSubTrees(5, edges3, "aabab"));

        int[][] edges4 = {{0, 1}, {0, 2}, {1, 3}, {3, 4}, {4, 5}};
        OutputUtils.print1DIntegerArray(countSubTrees(6, edges4, "cbabaa"));

        int[][] edges5 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}};
        OutputUtils.print1DIntegerArray(countSubTrees(7, edges5, "aaabaaa"));

        int[][] edges6 = {{0, 2}, {0, 3}, {1, 2}};
        OutputUtils.print1DIntegerArray(countSubTrees(4, edges6, "aeed"));
    }

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] result = new int[n];
        char[] charArray = labels.toCharArray();
        /**
         * 某个节点的编号 -> 与该节点直接相连的节点的编号集合
         */
        Map<Integer, Set<Integer>> pathMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        for (int i = 0; i < n; i++) {
            pathMap.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            pathMap.get(edge[0]).add(edge[1]);
            pathMap.get(edge[1]).add(edge[0]);
        }
        /**
         * 对于每个节点，将其父节点的值从与该节点直接相连的节点的编号集合中移除
         */
        while (!queue.isEmpty()) {
            int value = queue.poll();
            Set<Integer> children = pathMap.get(value);

            if (Objects.nonNull(children)) {
                for (int child : children) {
                    pathMap.get(child).remove(value);
                    queue.offer(child);
                }
            }
        }
        /**
         * counts[i]记录了值为i的节点的所有后代节点（包括它自己）中标签为a-z的节点各有多少个
         */
        int[][] counts = new int[n][26];
        /**
         * 记录值为i的节点是否已被计算过
         */
        boolean[] isVisited = new boolean[n];
        dfs(charArray, pathMap, 0, counts, isVisited);

        for (int i = 0; i < n; i++) {
            /**
             * 获取值为i的节点的所有后代节点（包括它自己）中标签和它相同的节点的个数
             */
            result[i] = counts[i][charArray[i] - 'a'];
        }
        return result;
    }

    /**
     * 深度优先搜索计算每个节点的所有后代节点（包括它自己）中标签为a-z的节点各有多少个
     *
     * @param charArray
     * @param pathMap
     * @param value
     * @param counts
     * @param isVisited
     */
    public static void dfs(char[] charArray, Map<Integer, Set<Integer>> pathMap, int value, int[][] counts,
                           boolean[] isVisited) {
        /**
         * 对于叶子节点只需对它自身的标签计数即可
         */
        if (pathMap.get(value).isEmpty()) {
            counts[value][charArray[value] - 'a'] = 1;
            isVisited[value] = true;
        } else {
            /**
             * 非叶子结点，先将节点自身的标签计数
             */
            counts[value][charArray[value] - 'a']++;
            /**
             * 将所有子节点的标签进行计数
             */
            for (int childValue : pathMap.get(value)) {
                if (!isVisited[childValue]) {
                    /**
                     * 对子节点进行递归计算
                     */
                    dfs(charArray, pathMap, childValue, counts, isVisited);
                    isVisited[childValue] = true;
                }

                for (int i = 0; i < 26; i++) {
                    counts[value][i] += counts[childValue][i];
                }
            }
        }
    }
}
