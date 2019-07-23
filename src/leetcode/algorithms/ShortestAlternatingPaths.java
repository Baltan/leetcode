package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 1129. Shortest Path with Alternating Colors
 *
 * @author Baltan
 * @date 2019-07-23 09:12
 */
public class ShortestAlternatingPaths {
    public static void main(String[] args) {
        int[][] red_edges1 = {{0, 1}, {1, 2}};
        int[][] blue_edges1 = {};
        OutputUtils.print1DIntegerArray(shortestAlternatingPaths(3, red_edges1, blue_edges1));

        int[][] red_edges2 = {{0, 1}};
        int[][] blue_edges2 = {{2, 1}};
        OutputUtils.print1DIntegerArray(shortestAlternatingPaths(3, red_edges2, blue_edges2));

        int[][] red_edges3 = {{1, 0}};
        int[][] blue_edges3 = {{2, 1}};
        OutputUtils.print1DIntegerArray(shortestAlternatingPaths(3, red_edges3, blue_edges3));

        int[][] red_edges4 = {{0, 1}};
        int[][] blue_edges4 = {{1, 2}};
        OutputUtils.print1DIntegerArray(shortestAlternatingPaths(3, red_edges4, blue_edges4));

        int[][] red_edges5 = {{0, 1}, {0, 2}};
        int[][] blue_edges5 = {{1, 0}};
        OutputUtils.print1DIntegerArray(shortestAlternatingPaths(3, red_edges5, blue_edges5));

        int[][] red_edges6 = {{0, 2}, {1, 2}};
        int[][] blue_edges6 = {{2, 1}, {0, 1}};
        OutputUtils.print1DIntegerArray(shortestAlternatingPaths(3, red_edges6, blue_edges6));

        int[][] red_edges7 = {{3, 2}, {4, 1}, {1, 4}, {2, 4}};
        int[][] blue_edges7 = {{2, 3}, {0, 4}, {4, 3}, {4, 4}, {4, 0}, {1, 0}};
        OutputUtils.print1DIntegerArray(shortestAlternatingPaths(5, red_edges7, blue_edges7));

        int[][] red_edges8 = {{2, 0}, {4, 3}, {4, 4}, {3, 0}, {1, 4}};
        int[][] blue_edges8 = {{2, 1}, {4, 3}, {3, 1}, {3, 0}, {1, 1}, {2, 0}, {0, 3}, {3, 3}, {2, 3}};
        OutputUtils.print1DIntegerArray(shortestAlternatingPaths(5, red_edges8, blue_edges8));
    }

    public static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] result = new int[n];
        Map<Integer, Set<Integer>> redEdges;
        Map<Integer, Set<Integer>> blueEdges;

        for (int i = 1; i < n; i++) {
            result[i] = Integer.MAX_VALUE;
            Queue<Integer> queue = new LinkedList<>();
            /**
             * 将起始点0号点加入队列
             */
            queue.offer(0);
            /**
             * flag为true时，查找红边，为false时查找蓝边
             * 先走红边
             */
            boolean flag = true;
            int length = 0;
            int queueLength;
            redEdges = new HashMap<>();
            blueEdges = new HashMap<>();
            /**
             * redEdges的key值为某一个点的编号，value值为从key值指代的点出发经过一条红边可能到达的所有点所构成的Set
             */
            for (int[] red_edge : red_edges) {
                if (redEdges.containsKey(red_edge[0])) {
                    redEdges.get(red_edge[0]).add(red_edge[1]);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(red_edge[1]);
                    redEdges.put(red_edge[0], set);
                }
            }
            /**
             * blue_edges的key值为某一个点的编号，value值为从key值指代的点出发经过一条蓝边可能到达的所有点所构成的Set
             */
            for (int[] blue_edge : blue_edges) {
                if (blueEdges.containsKey(blue_edge[0])) {
                    blueEdges.get(blue_edge[0]).add(blue_edge[1]);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(blue_edge[1]);
                    blueEdges.put(blue_edge[0], set);
                }
            }

            outer:
            while (!queue.isEmpty()) {
                length++;
                queueLength = queue.size();
                /**
                 * 将当前队列中的点通过指定颜色的边可能到达的下一个点加入队列中
                 */
                for (int j = 0; j < queueLength; j++) {
                    int start = queue.poll();
                    Set<Integer> set = flag ? redEdges.get(start) : blueEdges.get(start);

                    if (set != null) {
                        for (int end : set) {
                            queue.offer(end);
                            /**
                             * 如果到达了目标点就可以不用考虑其他情况了，将当前步数保存下来
                             */
                            if (end == i) {
                                result[i] = length;
                                break outer;
                            }
                        }
                        /**
                         * 将可能到达的下一个点加入队列中后，需要清空set，防止闭环造成的死循环
                         */
                        set.clear();
                    }
                }
                /**
                 * 如果当前一步走红边，下一步则走蓝边；如果当前一步走蓝边，下一步则走红边
                 */
                flag = !flag;
            }

            /**
             * 将队列清空后考虑先走蓝边的情况
             */
            queue.clear();
            /**
             * 将起始点0号点加入队列
             */
            queue.offer(0);
            /**
             * flag为true时，查找红边，为false时查找蓝边
             * 先走蓝边
             */
            flag = false;
            length = 0;
            redEdges = new HashMap<>();
            blueEdges = new HashMap<>();
            /**
             * redEdges的key值为某一个点的编号，value值为从key值指代的点出发经过一条红边可能到达的所有点所构成的Set
             */
            for (int[] red_edge : red_edges) {
                if (redEdges.containsKey(red_edge[0])) {
                    redEdges.get(red_edge[0]).add(red_edge[1]);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(red_edge[1]);
                    redEdges.put(red_edge[0], set);
                }
            }
            /**
             * blue_edges的key值为某一个点的编号，value值为从key值指代的点出发经过一条蓝边可能到达的所有点所构成的Set
             */
            for (int[] blue_edge : blue_edges) {
                if (blueEdges.containsKey(blue_edge[0])) {
                    blueEdges.get(blue_edge[0]).add(blue_edge[1]);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(blue_edge[1]);
                    blueEdges.put(blue_edge[0], set);
                }
            }

            outer:
            while (!queue.isEmpty()) {
                length++;
                queueLength = queue.size();
                /**
                 * 如果当前走的步数已经大于等于前面先走红边的情况了，就不用再往下计算了
                 */
                if (length >= result[i]) {
                    break outer;
                }
                /**
                 * 将当前队列中的点通过指定颜色的边可能到达的下一个点加入队列中
                 */
                for (int j = 0; j < queueLength; j++) {
                    int start = queue.poll();
                    Set<Integer> set = flag ? redEdges.get(start) : blueEdges.get(start);

                    if (set != null) {
                        for (int end : set) {
                            queue.offer(end);
                            /**
                             * 如果到达了目标点就可以不用考虑其他情况了，将当前步数保存下来，
                             * 前面判定过当前步数一定小于先走红边到达目标点的步数
                             */
                            if (end == i) {
                                result[i] = length;
                                break outer;
                            }
                        }
                        /**
                         * 将可能到达的下一个点加入队列中后，需要清空set，防止闭环造成的死循环
                         */
                        set.clear();
                    }
                }
                /**
                 * 如果当前一步走红边，下一步则走蓝边；如果当前一步走蓝边，下一步则走红边
                 */
                flag = !flag;
            }
        }

        /**
         * 0号点一定是0步，其他点的步数如果还是Integer.MAX_VALUE的话，说明不论先走红边还是蓝边都无法到达，记为-1
         */
        for (int i = 1; i < n; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }
}
