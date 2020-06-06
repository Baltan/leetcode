package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1466. Reorder Routes to Make All Paths Lead to the City Zero
 *
 * @author Baltan
 * @date 2020-06-06 22:01
 */
public class MinReorder {
    public static void main(String[] args) {
        int[][] connections1 = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(minReorder(6, connections1));

        int[][] connections2 = {{1, 0}, {1, 2}, {3, 2}, {3, 4}};
        System.out.println(minReorder(5, connections2));

        int[][] connections3 = {{1, 0}, {2, 0}};
        System.out.println(minReorder(3, connections3));
    }

    public static int minReorder(int n, int[][] connections) {
        int result = 0;
        /**
         * 城市i -> 和城市i直接相连的路线的集合
         */
        Map<Integer, List<int[]>> map = new HashMap<>();
        /**
         * isVisited[i]标记城市i是否被访问过
         */
        boolean[] isVisited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        /**
         * 终点为城市0，从城市0开始逆推
         */
        queue.offer(0);

        for (int[] connection : connections) {
            map.putIfAbsent(connection[0], new LinkedList<>());
            map.putIfAbsent(connection[1], new LinkedList<>());
            map.get(connection[0]).add(connection);
            map.get(connection[1]).add(connection);
        }
        /**
         * 广度优先搜索
         */
        while (!queue.isEmpty()) {
            int to = queue.poll();
            isVisited[to] = true;

            for (int[] path : map.get(to)) {
                /**
                 * 如果当前路线就是从终点to通往其他城市，并且另一端的城市还没访问过，则需要将这条路线翻转，使得
                 * 对面的城市可以到达城市to；如果当前路线就是从其他城市通往城市to的，则不需要翻转这条路线
                 */
                if (path[0] == to && !isVisited[path[1]]) {
                    result++;
                    queue.offer(path[1]);
                } else if (!isVisited[path[0]]) {
                    queue.offer(path[0]);
                }
            }
        }
        return result;
    }
}
