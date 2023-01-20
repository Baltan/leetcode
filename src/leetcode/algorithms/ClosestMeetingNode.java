package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2359. Find Closest Node to Given Two Nodes
 *
 * @author Baltan
 * @date 2023/1/13 11:31
 */
public class ClosestMeetingNode {
    public static void main(String[] args) {
        System.out.println(closestMeetingNode(new int[]{2, 0, 0}, 2, 0));
        System.out.println(closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1));
        System.out.println(closestMeetingNode(new int[]{1, 2, -1}, 0, 2));
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int result = -1;
        int maxDistance = Integer.MAX_VALUE;
        int length = edges.length;
        /**
         * distances1[i]表示节点node1到节点i的距离
         */
        int[] distances1 = new int[length];
        /**
         * distances2[i]表示节点node2到节点i的距离
         */
        int[] distances2 = new int[length];
        getDistance(edges, node1, distances1);
        getDistance(edges, node2, distances2);

        for (int i = 0; i < length; i++) {
            /**
             * 节点node1和节点node2不能都到达节点i
             */
            if (distances1[i] == -1 || distances2[i] == -1) {
                continue;
            }
            /**
             * 节点node1和节点node2到节点i的距离的较大值
             */
            int distance = Math.max(distances1[i], distances2[i]);

            if (distance < maxDistance) {
                result = i;
                maxDistance = distance;
            }
        }
        return result;
    }

    /**
     * 计算从节点start到各个节点的距离，如果不能到达节点i，则distances[i]为-1
     *
     * @param edges
     * @param node
     * @param distances
     */
    public static void getDistance(int[] edges, int node, int[] distances) {
        /**
         * isVisited[i]表示节点i已访问过
         */
        boolean[] isVisited = new boolean[edges.length];
        int distance = 1;
        /**
         * 假设节点node不能到达除自身外的所有其他节点
         */
        Arrays.fill(distances, -1);
        distances[node] = 0;
        isVisited[node] = true;
        node = edges[node];
        /**
         * 从node节点不能到达任何其他节点
         */
        if (node == -1) {
            return;
        }
        /**
         * 如果没有其他节点可到达或者又回到已访问过的节点，就结束计算
         */
        while (node != -1 && !isVisited[node]) {
            isVisited[node] = true;
            distances[node] = distance++;
            node = edges[node];
        }
    }
}
