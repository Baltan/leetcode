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
        if (connections.length < n - 1) {
            return -1;
        }

        int groupNum = 0;
        boolean[] isVisited = new boolean[n];
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
            if (!isVisited[i]) {
                groupNum++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int computer = queue.poll();
                    isVisited[computer] = true;

                    for (int connectedComputer : directConnections[computer]) {
                        if (!isVisited[connectedComputer]) {
                            queue.offer(connectedComputer);
                        }
                    }
                }
            }
        }
        return groupNum - 1;
    }
}
