package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 834. Sum of Distances in Tree
 *
 * @author Baltan
 * @date 2023/9/15 22:34
 */
public class SumOfDistancesInTree {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}}));
        OutputUtils.print1DIntegerArray(sumOfDistancesInTree(1, new int[][]{}));
        OutputUtils.print1DIntegerArray(sumOfDistancesInTree(2, new int[][]{{1, 0}}));
    }

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] result = new int[n];
        /**
         * descendantNodeCounts[i]表示节点i的下级节点的数量
         */
        int[] descendantNodeCounts = new int[n];
        /**
         * descendantDistances[i]表示节点i到所有下级节点的距离之和
         */
        int[] descendantDistances = new int[n];
        /**
         * otherDistances[i]表示节点i必须经过其父节点才能到达其余节点的距离之和
         */
        int[] otherDistances = new int[n];
        /**
         * isVisited[i]表示节点i的otherDistances[i]值是否已被计算过
         */
        boolean[] isVisited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        /**
         * graph[i]表示与节点i相邻的所有节点
         */
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, x -> new ArrayList<>());
        queue.offer(0);

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        /**
         * 将节点0当做树的根节点开始计算
         */
        countDescendantNodes(graph, descendantNodeCounts, -1, 0);
        getDescendantDistances(graph, descendantNodeCounts, descendantDistances, -1, 0);
        isVisited[0] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            graph[curr].forEach(x -> {
                if (isVisited[x]) {
                    return;
                }
                /**
                 * 节点x必须经过其父节点curr才能到达其余节点的距离之和为：
                 * SUM(
                 *      节点curr到所有下级节点的距离之和（=descendantDistances[curr]）-
                 *      节点x到所有下级节点的距离之和（=descendantDistances[x]）-
                 *      节点curr到节点x和节点x的所有下级节点descendantNodeCounts[x]+1次经过节点x的距离和
                 *      （=descendantNodeCounts[x]+1）+
                 *      节点x必须经过父节点curr才能到达其余节点n-descendantNodeCounts[x]-1次经过节点x的距离和
                 *      （n-descendantNodeCounts[x]-1）+
                 *      父节点curr必须经过其父节点才能到达其余节点的距离之和（=otherDistances[curr]）
                 * )
                 */
                otherDistances[x] = descendantDistances[curr] - descendantDistances[x] - (descendantNodeCounts[x] + 1) +
                        (n - descendantNodeCounts[x] - 1) + otherDistances[curr];
                isVisited[x] = true;
                queue.offer(x);
            });
        }

        for (int i = 0; i < n; i++) {
            /**
             * 节点i到达其余节点的距离之和为：
             * SUM(
             *      节点i到所有下级节点的距离之和（=descendantDistances[i]）+
             *      节点i必须经过其父节点才能到达其余节点的距离之和（=otherDistances[i]）
             * )
             */
            result[i] = descendantDistances[i] + otherDistances[i];
        }
        return result;
    }

    /**
     * 计算每个节点到所有下级节点的距离之和
     *
     * @param graph
     * @param descendantNodeCounts
     * @param descendantDistances
     * @param prev
     * @param curr
     */
    public static void getDescendantDistances(List<Integer>[] graph, int[] descendantNodeCounts, int[] descendantDistances, int prev, int curr) {
        /**
         * 和节点curr相连的节点只有其父节点prev，说明节点curr没有子节点
         */
        if (graph[curr].size() == 1 && graph[curr].get(0) == prev) {
            return;
        }
        graph[curr].stream()
                /**
                 * 过滤出节点curr的所有子节点
                 */
                .filter(x -> x != prev)
                .forEach(x -> {
                    getDescendantDistances(graph, descendantNodeCounts, descendantDistances, curr, x);
                    /**
                     * 节点curr到所有下级节点的距离之和为：
                     * SUM(
                     *      节点curr到子节点x的距离（=1）+
                     *      节点x到所有下级节点的距离之和（=descendantDistances[x]）+
                     *      节点curr到达节点x的所有下级节点descendantNodeCounts[x]次经过节点x的距离和（=descendantNodeCounts[x]）
                     * )
                     */
                    descendantDistances[curr] += (1 + descendantDistances[x] + descendantNodeCounts[x]);
                });
    }

    /**
     * 计算每个节点的下级节点的数量
     *
     * @param graph
     * @param nodeCounts
     * @param prev
     * @param curr
     */
    public static void countDescendantNodes(List<Integer>[] graph, int[] nodeCounts, int prev, int curr) {
        /**
         * 和节点curr相连的节点只有其父节点prev，说明节点curr没有子节点
         */
        if (graph[curr].size() == 1 && graph[curr].get(0) == prev) {
            return;
        }
        graph[curr].stream()
                /**
                 * 过滤出节点curr的所有子节点
                 */
                .filter(x -> x != prev)
                .forEach(x -> {
                    countDescendantNodes(graph, nodeCounts, curr, x);
                    /**
                     * 节点curr的下级节点的数量为：
                     * SUM(
                     *      节点curr的子节点x（=1）+
                     *      节点x的所有下级节点的数量（=nodeCounts[x]）
                     * )
                     */
                    nodeCounts[curr] += (1 + nodeCounts[x]);
                });
    }
}
