package leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 2685. Count the Number of Complete Components
 *
 * @author Baltan
 * @date 2023/5/14 21:55
 */
public class CountCompleteComponents {
    public static void main(String[] args) {
        System.out.println(countCompleteComponents(6, new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}}));
        System.out.println(countCompleteComponents(6, new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}}));
    }

    public static int countCompleteComponents(int n, int[][] edges) {
        int result = 0;
        /**
         * graph[i]表示与节点i相邻的所有节点
         */
        List<Integer>[] graph = new List[n];
        /**
         * isVisited[i]表示节点i是否已被计算过
         */
        boolean[] isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 0; i < n; i++) {
            /**
             * 已经计算过的节点不再重复计算
             */
            if (isVisited[i]) {
                continue;
            }
            /**
             * 当前子图中从每个节点出发的边数总和
             */
            int edgeCount = 0;
            /**
             * 当前子图中的节点数
             */
            int nodeCount = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            isVisited[i] = true;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                /**
                 * 从节点node出发可以相连graph[node]中的节点，共有graph[node]条边
                 */
                edgeCount += graph[node].size();
                /**
                 * 对节点node计数
                 */
                nodeCount++;

                for (int neighbor : graph[node]) {
                    if (!isVisited[neighbor]) {
                        queue.offer(neighbor);
                        isVisited[neighbor] = true;
                    }
                }
            }
            /**
             * 完全连通的子图中，任意两个节点之间都有一条边，即从每个节点出发都有nodeCount-1条边，共nodeCount*(nodeCount-1)条边（每条边
             * 都被重复计数了一次）
             */
            if (nodeCount * (nodeCount - 1) == edgeCount) {
                result++;
            }
        }
        return result;
    }
}
