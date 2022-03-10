package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2192. All Ancestors of a Node in a Directed Acyclic Graph
 *
 * @author Baltan
 * @date 2022/3/9 20:03
 */
public class GetAncestors {
    public static void main(String[] args) {
        int[][] edges1 = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        System.out.println(getAncestors(8, edges1));

        int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};
        System.out.println(getAncestors(5, edges2));
    }

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>(n);
        /**
         * 节点i -> 能直接到达节点i的所有的节点列表
         */
        Map<Integer, List<Integer>> toMap = new HashMap<>((int) (n / 0.75) + 1);
        /**
         * isVisited[i][j]表示是否已判断过从i到j这条路径
         */
        boolean[][] isVisited = new boolean[n][n];

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            List<Integer> fromList = toMap.computeIfAbsent(to, i -> new LinkedList<>());
            fromList.add(from);
        }
        /**
         * 依次查找节点i的所有祖先节点
         */
        for (int i = 0; i < n; i++) {
            List<Integer> ancestorList = new LinkedList<>();
            result.add(ancestorList);
            dfs(ancestorList, toMap, isVisited, i, i);
        }
        /**
         * 将每个节点的祖先节点都按照升序排列
         */
        for (List<Integer> ancestorList : result) {
            Collections.sort(ancestorList);
        }
        return result;
    }

    /**
     * 递归查找节点end的所有祖先节点
     *
     * @param ancestorList
     * @param toMap
     * @param isVisited
     * @param to
     * @param end
     */
    public static void dfs(List<Integer> ancestorList, Map<Integer, List<Integer>> toMap,
                           boolean[][] isVisited, int to, int end) {
        List<Integer> fromList = toMap.get(to);

        if (Objects.nonNull(fromList)) {
            for (int from : fromList) {
                /**
                 * 已经判断过的路径不重复判断，避免重复加入祖先节点
                 */
                if (!isVisited[from][end]) {
                    ancestorList.add(from);
                    isVisited[from][end] = true;
                    /**
                     * 继续向上查找from节点的父节点，也是end的祖先节点
                     */
                    dfs(ancestorList, toMap, isVisited, from, end);
                }
            }
        }
    }
}
