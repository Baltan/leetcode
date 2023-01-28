package leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 2039. The Time When the Network Becomes Idle
 *
 * @author Baltan
 * @date 2023/1/26 10:28
 */
public class NetworkBecomesIdle {
    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {1, 2}};
        int[] patience1 = {0, 2, 1};
        System.out.println(networkBecomesIdle(edges1, patience1));

        int[][] edges2 = {{0, 1}, {0, 2}, {1, 2}};
        int[] patience2 = {0, 10, 10};
        System.out.println(networkBecomesIdle(edges2, patience2));
    }

    public static int networkBecomesIdle(int[][] edges, int[] patience) {
        int result = 0;
        int n = patience.length;
        /**
         * graph[i]保存与服务器i相邻的服务器的列表
         */
        List<Integer>[] graph = new List[n];
        /**
         * distances[i]表示服务器i与服务器0（主服务器）的距离
         */
        int[] distances = new int[n];
        /**
         * isVisited[i]表示服务器i是否已被访问过
         */
        boolean[] isVisited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int distance = 0;
        queue.offer(0);
        isVisited[0] = true;

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        /**
         * 获得每个服务器的相邻服务器的列表
         */
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        /**
         * 计算每个服务器到服务器0（主服务器）的距离
         */
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currServer = queue.poll();
                distances[currServer] = distance;

                for (int nextServer : graph[currServer]) {
                    if (!isVisited[nextServer]) {
                        queue.offer(nextServer);
                        isVisited[nextServer] = true;
                    }
                }
            }
            distance++;
        }

        for (int i = 1; i < n; i++) {
            /**
             * 服务器i发出的第一条信息经过服务器0（主服务器）返回服务器i的间隔时间
             */
            int time = distances[i] * 2;
            /**
             * 服务器i发送的信息总条数
             */
            int sendCount = (int) Math.ceil(1.0 * time / patience[i]);
            /**
             * 服务器i发出的最后一条信息经过服务器0（主服务器）返回服务器i的间隔时间
             */
            time = (sendCount - 1) * patience[i] + time;
            /**
             * 所有信息都返回服务器i的下一秒，线路上没有服务器i发出的信息
             */
            result = Math.max(result, time + 1);
        }
        return result;
    }
}
