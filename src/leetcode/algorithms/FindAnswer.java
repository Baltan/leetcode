package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 3123. Find Edges in Shortest Paths
 *
 * @author Baltan
 * @date 2024/6/5 21:54
 */
public class FindAnswer {
    public static void main(String[] args) {
        int[][] edge1 = new int[][]{{0, 1, 4}, {0, 2, 1}, {1, 3, 2}, {1, 4, 3}, {1, 5, 1}, {2, 3, 1}, {3, 5, 3}, {4, 5, 2}};
        OutputUtils.print1DBooleanArray(findAnswer(6, edge1));

        int[][] edge2 = new int[][]{{2, 0, 1}, {0, 1, 1}, {0, 3, 4}, {3, 2, 2}};
        OutputUtils.print1DBooleanArray(findAnswer(4, edge2));
    }

    public static boolean[] findAnswer(int n, int[][] edges) {
        boolean[] result = new boolean[edges.length];
        /**
         * minDistances[i]表示节点i和节点0的最小距离
         */
        long[] minDistances = new long[n];
        /**
         * 无向带权图edges对应的邻接图
         */
        List<Edge>[] graph = new List[n];
        /**
         * 保存无向带权图edges中的所有节点，并且按照每个节点和节点0的最小距离升序排列
         */
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x.distanceSum));
        /**
         * 初始化出节点0以外的所有节点和节点0的最小距离为一个极大值
         */
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        minDistances[0] = 0;
        Arrays.setAll(graph, i -> new ArrayList<>());
        pq.offer(new Node(0, 0));
        /**
         * 构建无向带权图edges对应的邻接图
         */
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int distance = edges[i][2];
            graph[x].add(new Edge(y, distance, i));
            graph[y].add(new Edge(x, distance, i));
        }
        /**
         * 广度优先搜索计算无向带权图edges中每个节点和节点0的最小距离
         */
        while (!pq.isEmpty()) {
            /**
             * 一个从节点0到达节点nodeIndex的路线
             */
            Node node = pq.poll();
            int nodeIndex = node.nodeIndex;
            /**
             * 当前路线下，从节点0到达节点nodeIndex的总距离
             */
            long distanceSum = node.distanceSum;
            /**
             * 已经找到其他从节点0到节点nodeIndex的更短的路径，直接跳过当前路线
             */
            if (distanceSum > minDistances[nodeIndex]) {
                continue;
            }
            /**
             * 在当前路线的基础上，判断从节点nodeIndex出发，到达下一个相邻节点neighborNodeIndex后的总距离是否能够缩短从节点0到达节点
             * neighborNodeIndex的总距离
             */
            for (Edge edge : graph[nodeIndex]) {
                int neighborNodeIndex = edge.neighborNodeIndex;
                int distance = edge.distance;

                if (distanceSum + distance < minDistances[neighborNodeIndex]) {
                    minDistances[neighborNodeIndex] = distanceSum + distance;
                    pq.offer(new Node(neighborNodeIndex, minDistances[neighborNodeIndex]));
                }
            }
        }
        /**
         * 保存从节点n-1出发，所有能够到达节点0的最短路线上的节点
         */
        Queue<Node> queue = new LinkedList<>();
        /**
         * isVisited[i]表示节点i是否已被到达过
         */
        boolean[] isVisited = new boolean[n];
        queue.offer(new Node(n - 1, 0));
        isVisited[n - 1] = true;
        /**
         * 广度优先搜索查找从节点n-1出发，所有能够到达节点0的最短路线上的节点
         */
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nodeIndex = node.nodeIndex;
            /**
             * 当前路线下，从节点n-1到达节点nodeIndex的最小距离
             */
            long distanceSum = node.distanceSum;
            /**
             * 在当前路线的基础上，判断从节点nodeIndex出发的边edge是否在某一条从节点0到节点n-1的最短路线上
             */
            for (Edge edge : graph[nodeIndex]) {
                int neighborNodeIndex = edge.neighborNodeIndex;
                int distance = edge.distance;
                int edgeIndex = edge.edgeIndex;
                /**
                 * 已知节点0到节点neighborNodeIndex的最短距离为minDistances[neighborNodeIndex]，节点nodeIndex到节点n-1的最短距离
                 * 为distanceSum，如果边edge在某一条从节点0到节点n-1的最短路线上，则满足以下等式
                 */
                if (minDistances[neighborNodeIndex] + distance + distanceSum == minDistances[n - 1]) {
                    result[edgeIndex] = true;
                    /**
                     * 如果节点neighborNodeIndex还没被到达过，就从该节点出发继续判断下一条边
                     */
                    if (!isVisited[neighborNodeIndex]) {
                        queue.offer(new Node(neighborNodeIndex, distance + distanceSum));
                        isVisited[neighborNodeIndex] = true;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 与某个点直接相连的一条边
     */
    public static class Edge {
        /**
         * 相邻节点的索引值
         */
        private int neighborNodeIndex;
        /**
         * 某个点和相邻节点neighborNodeIndex的距离
         */
        private int distance;
        /**
         * 当前这条边在无向带权图edges中的索引值
         */
        private int edgeIndex;

        public Edge(int neighborNodeIndex, int distance, int edgeIndex) {
            this.neighborNodeIndex = neighborNodeIndex;
            this.distance = distance;
            this.edgeIndex = edgeIndex;
        }
    }

    /**
     * 无向带权图中的一个节点
     */
    public static class Node {
        /**
         * 节点的索引值
         */
        private int nodeIndex;
        /**
         * 当前节点和某个目标节点的总距离
         */
        private long distanceSum;

        public Node(int nodeIndex, long distanceSum) {
            this.nodeIndex = nodeIndex;
            this.distanceSum = distanceSum;
        }
    }
}
