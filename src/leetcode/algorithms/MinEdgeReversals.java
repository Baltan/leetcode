package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 2858. Minimum Edge Reversals So Every Node Is Reachable
 *
 * @author Baltan
 * @date 2023/12/30 00:00
 */
public class MinEdgeReversals {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(minEdgeReversals(5, new int[][]{{3, 0}, {0, 4}, {1, 3}, {2, 3}}));
        OutputUtils.print1DIntegerArray(minEdgeReversals(4, new int[][]{{2, 0}, {2, 1}, {1, 3}}));
        OutputUtils.print1DIntegerArray(minEdgeReversals(3, new int[][]{{1, 2}, {2, 0}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-edge-reversals-so-every-node-is-reachable/solutions/2445681/mo-ban-huan-gen-dppythonjavacgojs-by-end-8qiu/"></a>
     *
     * @param n
     * @param edges
     * @return
     */
    public static int[] minEdgeReversals(int n, int[][] edges) {
        int[] result = new int[n];
        /**
         * nodeCounts[i]表示以节点0作为根节点的树中，节点i为根节点的子树的节点数量
         */
        int[] nodeCounts = new int[n];
        /**
         * distances[i]表示以节点0作为根节点的树中，节点0到节点i需要经过的边数
         */
        int[] distances = new int[n];
        /**
         * reversedEdgeCounts[i]表示以节点0作为根节点的树中，节点0到节点i需要反转的边数
         */
        int[] reversedEdgeCounts = new int[n];
        /**
         * 以节点0作为根节点的树中，节点0到达所有节点需要反转的总边数
         */
        int reversedEdgeCount = 0;
        /**
         * isVisited[i]表示以节点0作为根节点的树中，从节点0出发，是否已到达过节点i
         */
        boolean[] isVisited = new boolean[n];
        /**
         * 节点i -> 节点i的所有相邻节点
         */
        Map<Integer, List<Neighbor>> edgeMap = new HashMap<>((int) (n / 0.75 + 1));
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        isVisited[0] = true;
        /**
         * 每个节点作为根节点的子树中，都先把自身计入到子树的节点数量中
         */
        Arrays.fill(nodeCounts, 1);

        for (int[] edge : edges) {
            /**
             * 从edge[0]到edge[1]不需要反转边，反之，从edge[1]到edge[0]要反转边
             */
            edgeMap.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new Neighbor(edge[1], true));
            edgeMap.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new Neighbor(edge[0], false));
        }
        /**
         * 广度优先搜索计算以节点0作为根节点的树中，节点0到每个节点各自需要反转的边数以及到达所有节点需要反转的总边数
         */
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Neighbor neighbor : edgeMap.get(node)) {
                /**
                 * 说明节点neighbor.node是节点node的父节点，不能重复访问
                 */
                if (isVisited[neighbor.node]) {
                    continue;
                }
                isVisited[neighbor.node] = true;
                /**
                 * 计算节点0到节点neighbor.node需要经过的边数
                 */
                distances[neighbor.node] = distances[node] + 1;
                /**
                 * 节点node到节点neighbor.node需要反转边
                 */
                reversedEdgeCount += neighbor.reachable ? 0 : 1;
                /**
                 * 计算节点0到节点neighbor.node需要反转的边数
                 */
                reversedEdgeCounts[neighbor.node] = neighbor.reachable ? reversedEdgeCounts[node] : reversedEdgeCounts[node] + 1;
                queue.offer(neighbor.node);
            }
        }
        Arrays.fill(isVisited, false);
        /**
         * isVisited[i]表示以节点0作为根节点的树中，从节点0出发，是否已到达过节点i
         */
        isVisited[0] = true;
        getNodeCounts(0, nodeCounts, edgeMap, isVisited);
        result[0] = reversedEdgeCount;
        /**
         * 换根：对于节点i来说，如果将以节点0作为根节点的树转换为以节点i作为根节点的树，则只有从节点0到节点i这段路径上的边会发生变化，原来反
         * 转的reversedEdgeCounts[i]条边现在不需要反转，原来不反转的distances[i]-reversedEdgeCounts[i]条边现在需要翻转
         */
        for (int i = 1; i < n; i++) {
            result[i] = result[0] - reversedEdgeCounts[i] + (distances[i] - reversedEdgeCounts[i]);
        }
        return result;
    }

    /**
     * 在以节点0作为根节点的树中，以节点node作为根节点的子树中节点的总数
     *
     * @param node
     * @param nodeCounts
     * @param edgeMap
     * @param isVisited
     */
    public static void getNodeCounts(int node, int[] nodeCounts, Map<Integer, List<Neighbor>> edgeMap, boolean[] isVisited) {
        for (Neighbor neighbor : edgeMap.get(node)) {
            /**
             * 说明节点neighbor.node是节点node的父节点，不能重复访问
             */
            if (isVisited[neighbor.node]) {
                continue;
            }
            isVisited[neighbor.node] = true;
            /**
             * 在以节点0作为根节点的树中，递归计算以节点neighbor.node作为根节点的子树中节点的总数
             */
            getNodeCounts(neighbor.node, nodeCounts, edgeMap, isVisited);
            nodeCounts[node] += nodeCounts[neighbor.node];
        }
    }

    public static class Neighbor {
        public Neighbor(int node, boolean reachable) {
            this.node = node;
            this.reachable = reachable;
        }

        /**
         * 相邻接点编号
         */
        private int node;
        /**
         * 是否可达，不可达说明需要反转边
         */
        private boolean reachable;
    }
}
