package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3203. Find Minimum Diameter After Merging Two Trees
 *
 * @author Baltan
 * @date 2024/7/10 20:48
 */
public class MinimumDiameterAfterMerge {
    public static void main(String[] args) {
        int[][] edge11 = {{0, 1}, {0, 2}, {0, 3}};
        int[][] edge21 = {{0, 1}};
        System.out.println(minimumDiameterAfterMerge(edge11, edge21));

        int[][] edge12 = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {2, 5}, {3, 6}, {2, 7}};
        int[][] edge22 = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {2, 5}, {3, 6}, {2, 7}};
        System.out.println(minimumDiameterAfterMerge(edge12, edge22));

        int[][] edge13 = {{3, 0}, {2, 1}, {2, 3}};
        int[][] edge23 = {{0, 1}, {0, 4}, {3, 5}, {6, 3}, {7, 6}, {2, 7}, {0, 2}, {8, 0}, {8, 9}};
        System.out.println(minimumDiameterAfterMerge(edge13, edge23));

        int[][] edge14 = {{0, 1}, {2, 0}, {3, 2}, {3, 6}, {8, 7}, {4, 8}, {5, 4}, {3, 5}, {3, 9}};
        int[][] edge24 = {{0, 1}, {0, 2}, {0, 3}};
        System.out.println(minimumDiameterAfterMerge(edge14, edge24));
    }

    public static int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        /**
         * 假设通过连接多叉树edges1中的节点node1和多叉树edges2中的节点node2，可以得到一棵直径最小的多叉树，则合并后多叉树的直径为多叉树
         * edges1中距离node1最远的点到node1的距离，加上多叉树edges2中距离node2最远的点到node2的距离，再加上连接node1和node2的距离1。
         * 即多叉树edges1的半径，加上多叉树edges2的半径，再加上1
         */
        int diameter1 = getDiameter(edges1);
        int diameter2 = getDiameter(edges2);
        return Math.max((diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1, Math.max(diameter1, diameter2));
    }

    /**
     * 计算多叉树edges的直径
     *
     * @param edges
     * @return
     * @see TreeDiameter
     */
    public static int getDiameter(int[][] edges) {
        /**
         * 多叉树edges的邻接图，graph[i]表示与节点i相邻的所有节点
         */
        List<Integer>[] graph = new List[edges.length + 1];
        Queue<int[]> queue = new LinkedList<>();
        /**
         * 正在遍历多叉树edges的由外向内的第level层节点
         */
        int level = 0;
        Arrays.setAll(graph, i -> new ArrayList<>());
        /**
         * 多叉树edges的邻接图
         */
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        /**
         * 只和其他一个节点相邻的节点就是多叉树edges中最外层的节点
         */
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].size() == 1) {
                queue.offer(new int[]{-1, i});
            }
        }
        /**
         * 广度优先搜索，逐层遍历邻接图graph中的节点，直到得到距离最远的节点
         */
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] currNode = queue.poll();

                for (int node : graph[currNode[1]]) {
                    if (node != currNode[0]) {
                        queue.offer(new int[]{currNode[1], node});
                    }
                }
            }

            if (queue.isEmpty()) {
                return level;
            }
            level++;
        }
        return 0;
    }
}
