package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 3372. Maximize the Number of Target Nodes After Connecting Trees I
 *
 * @author Baltan
 * @date 2024/12/3 23:12
 * @see MaxTargetNodes1
 */
public class MaxTargetNodes {
    public static void main(String[] args) {
        int[][] edges11 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        int[][] edges12 = {{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}};
        OutputUtils.print1DIntegerArray(maxTargetNodes(edges11, edges12, 2));

        int[][] edges21 = {{0, 1}, {0, 2}, {0, 3}, {0, 4}};
        int[][] edges22 = {{0, 1}, {1, 2}, {2, 3}};
        OutputUtils.print1DIntegerArray(maxTargetNodes(edges21, edges22, 1));
    }

    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int[] result = new int[edges1.length + 1];
        int[] nodeCounts1 = getDistances(edges1, k);
        int[] nodeCounts2 = getDistances(edges2, k - 1);
        /**
         * 无向树edges2中的所有节点在距离小于等于k-1的范围内的目标节点数的最大值
         */
        int maxNodeCount = Arrays.stream(nodeCounts2).max().getAsInt();

        for (int i = 0; i <= edges1.length; i++) {
            /**
             * 对于无向树edges1中的节点i，在距离小于等于k的范围内有nodeCounts1[i]个目标节点，另外通过连接节点i和无向树edges2中的某个节
             * 点后，无向树edges2中在距离小于等于k的范围内最多有maxNodeCount个目标节点
             */
            result[i] = nodeCounts1[i] + maxNodeCount;
        }
        return result;
    }

    /**
     * 计算无向树中的每个节点的在距离小于等于maxDistance的范围内的目标节点数
     *
     * @param edges
     * @param maxDistance
     * @return
     */
    public static int[] getDistances(int[][] edges, int maxDistance) {
        int length = edges.length + 1;
        /**
         * nodeCounts[i]表示节点i在距离小于等于maxDistance的范围内的目标节点数
         */
        int[] nodeCounts = new int[length];
        /**
         * graph[i]表示与节点i相邻的所有节点
         */
        List<Integer>[] graph = new List[length];
        Arrays.setAll(graph, i -> new ArrayList<>());
        /**
         * 构建图
         */
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        /**
         * 广度优先搜索计算每个节点在距离小于等于maxDistance的范围内的目标节点数
         */
        for (int i = 0; i < length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] isVisited = new boolean[length];
            /**
             * 当前节点和节点i的距离
             */
            int distance = 0;
            queue.offer(i);
            isVisited[i] = true;

            while (!queue.isEmpty()) {
                /**
                 * 如果此时剩余节点距离节点i的距离，已经大于maxDistance，则它们必然不是节点i的目标节点，不用继续计算
                 */
                if (distance > maxDistance) {
                    break;
                }
                int size = queue.size();
                nodeCounts[i] += size;

                for (int j = 0; j < size; j++) {
                    int node = queue.poll();

                    for (int neighbor : graph[node]) {
                        if (!isVisited[neighbor]) {
                            queue.offer(neighbor);
                            isVisited[neighbor] = true;
                        }
                    }
                }
                distance++;
            }
        }
        return nodeCounts;
    }
}
