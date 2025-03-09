package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 3373. Maximize the Number of Target Nodes After Connecting Trees II
 *
 * @author baltan
 * @date 2025/3/3 15:31
 * @see MaxTargetNodes
 */
public class MaxTargetNodes1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(maxTargetNodes(new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}}, new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}}));
        OutputUtils.print1DIntegerArray(maxTargetNodes(new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}}, new int[][]{{0, 1}, {1, 2}, {2, 3}}));
    }

    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        /**
         * 第一棵无向树中的节点数
         */
        int nodeCount1 = getMaxNode(edges1) + 1;
        /**
         * depths1[i]表示将节点0作为第一棵无向树的根节点时，无向树中节点i到节点0的路径长度
         */
        int[] depths1 = new int[nodeCount1];
        /**
         * oddEvenDepthCount1[0]、oddEvenDepthCount1[1]分别表示将节点0作为第一棵无向树的根节点时，到达节点0的路径长度分别为偶数和奇数
         * 的节点个数
         */
        int[] oddEvenDepthCount1 = new int[2];
        help(edges1, nodeCount1, depths1, oddEvenDepthCount1);
        /**
         * 第二棵无向树中的节点数
         */
        int nodeCount2 = getMaxNode(edges2) + 1;
        /**
         * depths2[i]表示将节点0作为第二棵无向树的根节点时，无向树中节点i到节点0的路径长度
         */
        int[] depths2 = new int[nodeCount2];
        /**
         * oddEvenDepthCount2[0]、oddEvenDepthCount2[1]分别表示将节点0作为第二棵无向树的根节点时，到达节点0的路径长度分别为偶数和奇数
         * 的节点个数
         */
        int[] oddEvenDepthCount2 = new int[2];
        help(edges2, nodeCount2, depths2, oddEvenDepthCount2);
        int[] result = new int[nodeCount1];

        for (int i = 0; i < nodeCount1; i++) {
            /**
             * 第一棵无向树中节点i的目标节点个数为到达节点0的路径长度奇偶性与节点i相同的节点总数
             */
            int targetNodeCount1 = depths1[i] % 2 == 0 ? oddEvenDepthCount1[0] : oddEvenDepthCount1[1];
            int targetNodeCount2 = 0;
            /**
             * 如果第一棵无向树中存在到达节点i的路径长度为偶数的节点j，则连接节点j和第二棵无向树中的某个节点后，第二棵无向树中节点i的目标节
             * 点个数为oddEvenDepthCount2[1]
             */
            if (oddEvenDepthCount1[0] != 0) {
                targetNodeCount2 = Math.max(targetNodeCount2, oddEvenDepthCount2[1]);
            }
            /**
             * 如果第一棵无向树中存在到达节点i的路径长度为偶奇数的节点j，则连接节点j和第二棵无向树中的某个节点后，第二棵无向树中节点i的目标节
             * 点个数为oddEvenDepthCount2[0]
             */
            if (oddEvenDepthCount1[1] != 0) {
                targetNodeCount2 = Math.max(targetNodeCount2, oddEvenDepthCount2[0]);
            }
            result[i] = targetNodeCount1 + targetNodeCount2;
        }
        return result;
    }

    /**
     * 计算无向树中节点的最大值
     *
     * @param edge
     * @return
     */
    public static int getMaxNode(int[][] edge) {
        int max = Integer.MIN_VALUE;

        for (int[] path : edge) {
            max = Math.max(max, path[0]);
            max = Math.max(max, path[1]);
        }
        return max;
    }

    /**
     * 无向树构建图
     *
     * @param edge
     * @param nodeCount
     * @return
     */
    public static List<Integer>[] getGraph(int[][] edge, int nodeCount) {
        /**
         * graph[i]保存图中与节点i相邻的其他节点的值
         */
        List<Integer>[] graph = new List[nodeCount + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());

        for (int[] path : edge) {
            graph[path[0]].add(path[1]);
            graph[path[1]].add(path[0]);
        }
        return graph;
    }

    /**
     * 将节点0作为无向树的根节点时，计算节点currNode到节点0的路径长度
     *
     * @param graph
     * @param depths
     * @param currNode
     * @param parentNode
     * @param currDepth
     */
    public static void getDepths(List<Integer>[] graph, int[] depths, int currNode, int parentNode, int currDepth) {
        depths[currNode] = currDepth;

        for (int nextNode : graph[currNode]) {
            /**
             * 排除节点currNode的父节点parentNode
             */
            if (nextNode != parentNode) {
                getDepths(graph, depths, nextNode, currNode, currDepth + 1);
            }
        }
    }

    /**
     * 将节点0作为无向树的根节点时，计算各个节点到节点0的路径长度，并计算到达节点0的路径长度分别为偶数和奇数的节点个数
     *
     * @param edges
     * @param nodeCount
     * @param depths
     * @param oddEvenDepthCount
     */
    public static void help(int[][] edges, int nodeCount, int[] depths, int[] oddEvenDepthCount) {
        List<Integer>[] graph = getGraph(edges, nodeCount);
        getDepths(graph, depths, 0, -1, 0);

        for (int depth : depths) {
            oddEvenDepthCount[depth % 2]++;
        }
    }
}
