package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 1319. Number of Operations to Make Network Connected
 *
 * @author Baltan
 * @date 2020-01-27 13:20
 */
public class MakeConnected {
    public static void main(String[] args) {
        int[][] connections1 = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(makeConnected(4, connections1));

        int[][] connections2 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println(makeConnected(6, connections2));

        int[][] connections3 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}};
        System.out.println(makeConnected(6, connections3));

        int[][] connections4 = {{0, 1}, {0, 2}, {3, 4}, {2, 3}};
        System.out.println(makeConnected(5, connections4));
    }

    public static int makeConnected(int n, int[][] connections) {
        /**
         * 如果有n台计算机，至少需要n-1条线缆才可以将所有计算机连接成一个网络
         */
        if (connections.length < n - 1) {
            return -1;
        }
        /**
         * 初始化连接下，计算机网络的个数，如果有k个计算机网络，那么就需要k-1条线缆，将这些独立的计
         * 算机网络连成一个新的计算机网络，所以最后返回groupNum-1
         */
        int groupNum = 0;
        boolean[] isVisited = new boolean[n];
        /**
         * directConnections[i]表示编号为i的计算机直接连接的所有其他计算机
         */
        List<Integer>[] directConnections = new List[n];

        for (int i = 0; i < n; i++) {
            directConnections[i] = new LinkedList<>();
        }

        for (int[] connection : connections) {
            int computer1 = connection[0];
            int computer2 = connection[1];
            directConnections[computer1].add(computer2);
            directConnections[computer2].add(computer1);
        }

        for (int i = 0; i < n; i++) {
            /**
             * 如果编号为i的计算机不在当前已经确定的某个计算机网络中，就从这台计算机开始查找它所在
             * 的计算机网络中的所有计算机编号
             */
            if (!isVisited[i]) {
                /**
                 * 计算机网络的个数加1
                 */
                groupNum++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                isVisited[i] = true;
                /**
                 * 广度优先搜索
                 */
                while (!queue.isEmpty()) {
                    int computer = queue.poll();

                    for (int connectedComputer : directConnections[computer]) {
                        if (!isVisited[connectedComputer]) {
                            queue.offer(connectedComputer);
                            isVisited[connectedComputer] = true;
                        }
                    }
                }
            }
        }
        return groupNum - 1;
    }
}
