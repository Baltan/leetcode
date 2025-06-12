package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3558. Number of Ways to Assign Edge Weights I
 *
 * @author baltan
 * @date 2025/6/11 16:12
 */
public class AssignEdgeWeights {
    public static void main(String[] args) {
        System.out.println(assignEdgeWeights(new int[][]{{2, 3}, {1, 2}, {5, 6}, {2, 4}, {6, 7}, {3, 5}}));
        System.out.println(assignEdgeWeights(new int[][]{{1, 4}, {1, 2}, {1, 3}, {3, 5}}));
        System.out.println(assignEdgeWeights(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(assignEdgeWeights(new int[][]{{1, 2}}));
        System.out.println(assignEdgeWeights(new int[][]{{1, 2}, {1, 3}, {3, 4}, {3, 5}}));
    }

    public static int assignEdgeWeights(int[][] edges) {
        long result = 1L;
        int mod = 1000000007;
        /**
         * 节点个数
         */
        int n = edges.length + 1;
        /**
         * 节点1到深度最大节点的路径上的边数
         */
        int depth = -1;
        Queue<Integer> queue = new LinkedList<>();
        /**
         * isVisited[i]表示节点i是否访问过
         */
        boolean[] isVisited = new boolean[n + 1];
        /**
         * graph[i]表示与节点i相连的所有其他的节点列表
         */
        List<Integer>[] graph = new List[n + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());
        queue.offer(1);
        isVisited[1] = true;
        /**
         * 构建图
         */
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        /**
         * 广度优先搜索计算节点1到深度最大节点的路径上的边数
         */
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                for (int next : graph[queue.poll()]) {
                    if (!isVisited[next]) {
                        queue.offer(next);
                        isVisited[next] = true;
                    }
                }
            }
        }
        /**
         * 从depth条边中任意选择奇数条边的情况数为C(depth,1)+C(depth,3)+C(depth,5)+……C(depth,2k+1)=2^(depth-1)，其中2k+1<=depth
         */
        for (int i = 1; i < depth; i++) {
            result = result * 2 % mod;
        }
        return (int) result;
    }
}
