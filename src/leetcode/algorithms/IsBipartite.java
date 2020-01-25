package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 785. Is Graph Bipartite?
 *
 * @author Baltan
 * @date 2020-01-25 10:51
 */
public class IsBipartite {
    public static void main(String[] args) {
        int[][] graph1 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite(graph1));

        int[][] graph2 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(isBipartite(graph2));

        int[][] graph3 =
                {{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9},
                        {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}};
        System.out.println(isBipartite(graph3));
    }

    public static boolean isBipartite(int[][] graph) {
        int length = graph.length;
        /**
         * 将节点染色，两个集合的节点分别将被染上两种颜色1和-1，colors[0]为0表示第i个节点还没有被染色
         */
        int[] colors = new int[length];

        for (int i = 0; i < length; i++) {
            /**
             * 如果第i个节点还没有被染色，就从这个节点出发，将其可以到达的节点交替染色
             */
            if (colors[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                colors[i] = 1;

                while (!queue.isEmpty()) {
                    int start = queue.poll();

                    for (int end : graph[start]) {
                        /**
                         * 如果一条边的两个节点已经被染上了一样的颜色，这两个点无法被放到两个不同的集
                         * 合中去，所以原图不是二分图，返回false；如果另一个节点还没被染色，就将节点
                         * 染上不同的颜色，并加入队列中继续为其他边的节点染色
                         */
                        if (colors[end] == colors[start]) {
                            return false;
                        } else if (colors[end] == 0) {
                            queue.offer(end);
                            colors[end] = -colors[start];
                        }
                    }
                }
            }
        }
        return true;
    }
}
