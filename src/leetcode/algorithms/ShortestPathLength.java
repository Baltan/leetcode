package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 847. Shortest Path Visiting All Nodes
 *
 * @author Baltan
 * @date 2023/3/26 17:59
 */
public class ShortestPathLength {
    public static void main(String[] args) {
        System.out.println(shortestPathLength(new int[][]{{1, 2, 3}, {0}, {0}, {0}}));
        System.out.println(shortestPathLength(new int[][]{{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}}));
        System.out.println(shortestPathLength(new int[][]{{2, 3, 5, 7}, {2, 3, 7}, {0, 1}, {0, 1}, {7}, {0}, {10}, {9, 10, 0, 1, 4}, {9}, {7, 8}, {7, 6}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/shortest-path-visiting-all-nodes/solutions/918634/gtalgorithm-tu-jie-fa-ba-hardbian-cheng-v5knb/"></a>
     *
     * @param graph
     * @return
     */
    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        /**
         * endStatus为最终需要达到的状态。endStatus二进制值从低到高第i位为1表示节点i已访问过，为0表示节点i未访问过。因为最终需要每个节点都访
         * 问到，所以最终状态为0b111……111，从低到高n位都为1，即(1<<n)-1
         */
        int endStatus = (1 << n) - 1;
        Queue<Node> queue = new LinkedList<>();
        /**
         * isVisited[i][j]表示是否已出现过访问节点i时，已访问节点状态为j的情况
         */
        boolean[][] isVisited = new boolean[n][1 << n];
        /**
         * 将出发节点加入队列，可能从[0,n-1]中的任意一个节点出发
         */
        for (int i = 0; i < n; i++) {
            /**
             * 表示节点i已访问过
             */
            int status = 1 << i;
            Node node = new Node(i, status, 0);
            queue.offer(node);
            isVisited[i][status] = true;
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            /**
             * 已经将所有节点都访问过了，直接返回已经过的距离
             */
            if (node.status == endStatus) {
                return node.distance;
            }
            /**
             * 从当前节点node可以直接到达的下一个节点
             */
            for (int nextValue : graph[node.value]) {
                /**
                 * 如果接下去访问节点nextValue，则已访问节点状态会变成node.status|(1<<nextValue)
                 */
                int nextStatus = node.status | (1 << nextValue);
                /**
                 * 不经历重复状态，因为重复状态的距离一定不小于之前的状态
                 */
                if (!isVisited[nextValue][nextStatus]) {
                    queue.offer(new Node(nextValue, nextStatus, node.distance + 1));
                    isVisited[nextValue][nextStatus] = true;
                }
            }
        }
        return -1;
    }

    private static class Node {
        /**
         * 当前节点的值
         */
        int value;
        /**
         * 到当前节点为止，已访问节点的状态
         */
        int status;
        /**
         * 从起点出发到当前节点为止已经过的距离
         */
        int distance;

        public Node(int value, int status, int distance) {
            this.value = value;
            this.status = status;
            this.distance = distance;
        }
    }
}
