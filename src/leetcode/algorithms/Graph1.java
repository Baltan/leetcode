package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2642. Design Graph With Shortest Path Calculator
 *
 * @author Baltan
 * @date 2023/12/21 22:21
 * @see Graph
 */
public class Graph1 {
    /**
     * 防止计算路径总代价时溢出
     */
    private static final Integer MAX = Integer.MAX_VALUE / 2;
    /**
     * 节点个数
     */
    private int n;
    /**
     * toTimeMatrix[i][j]表示从节点i到达节点j的用时情况
     */
    private int[][] toTimeMatrix;
    /**
     * 堆优化Dijkstra，minTimes[i]表示从某一个指定节点到节点i的最小花费时间
     *
     * @see CountRestrictedPaths
     */
    private int[] minTimes;
    /**
     * isVisited[i]表示从某一个指定节点到节点i的最小花费时间是否已计算过
     */
    private boolean[] isVisited;

    public Graph1(int n, int[][] edges) {
        this.n = n;
        minTimes = new int[n + 1];
        isVisited = new boolean[n + 1];
        toTimeMatrix = new int[n][n];
        Arrays.setAll(toTimeMatrix, x -> new int[n]);

        for (int[] toTimes : toTimeMatrix) {
            Arrays.fill(toTimes, MAX);
        }

        for (int[] edge : edges) {
            toTimeMatrix[edge[0]][edge[1]] = edge[2];
        }
    }

    public void addEdge(int[] edge) {
        toTimeMatrix[edge[0]][edge[1]] = edge[2];
    }

    public int shortestPath(int node1, int node2) {
        /**
         * 队列保存的所有节点，并且按照节点node1到该节点的最小花费时间升序排列
         */
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(x -> minTimes[x]));
        Arrays.fill(isVisited, false);
        Arrays.fill(minTimes, MAX);
        queue.offer(node1);
        /**
         * 出发时就在节点node1，不需要花费任何时间
         */
        minTimes[node1] = 0;
        /**
         * 广度优先搜索计算节点node1到每个节点的最小花费时间
         */
        while (!queue.isEmpty()) {
            int i = queue.poll();

            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;

            for (int j = 0; j < n; j++) {
                if (toTimeMatrix[i][j] == MAX) {
                    continue;
                }
                /**
                 * 从节点node1经过节点i再到达节点j可能比不经过节点i到达节点j的路径用时更少
                 */
                if (minTimes[i] + toTimeMatrix[i][j] < minTimes[j]) {
                    minTimes[j] = minTimes[i] + toTimeMatrix[i][j];
                    toTimeMatrix[node1][j] = minTimes[j];
                }
                queue.offer(j);
            }
        }
        return minTimes[node2] == MAX ? -1 : minTimes[node2];
    }

    public static void main(String[] args) {
        Graph1 graph1 = new Graph1(4, new int[][]{{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}});
        System.out.println(graph1.shortestPath(3, 2));
        System.out.println(graph1.shortestPath(0, 3));
        graph1.addEdge(new int[]{1, 3, 4});
        System.out.println(graph1.shortestPath(3, 2));

        System.out.println("----------------------------------------");

        Graph1 graph2 = new Graph1(13, new int[][]{{7, 2, 131570}, {9, 4, 622890}, {9, 1, 812365}, {1, 3, 399349}, {10, 2, 407736}, {6, 7, 880509}, {1, 4, 289656}, {8, 0, 802664}, {6, 4, 826732}, {10, 3, 567982}, {5, 6, 434340}, {4, 7, 833968}, {12, 1, 578047}, {8, 5, 739814}, {10, 9, 648073}, {1, 6, 679167}, {3, 6, 933017}, {0, 10, 399226}, {1, 11, 915959}, {0, 12, 393037}, {11, 5, 811057}, {6, 2, 100832}, {5, 1, 731872}, {3, 8, 741455}, {2, 9, 835397}, {7, 0, 516610}, {11, 8, 680504}, {3, 11, 455056}, {1, 0, 252721}});
        System.out.println(graph2.shortestPath(9, 3));
        graph2.addEdge(new int[]{11, 1, 873094});
        System.out.println(graph2.shortestPath(3, 10));
        graph2.addEdge(new int[]{0, 9, 601498});
        graph2.addEdge(new int[]{12, 0, 824080});
        graph2.addEdge(new int[]{12, 4, 459292});
        graph2.addEdge(new int[]{6, 9, 7876});
        graph2.addEdge(new int[]{11, 7, 5479});
        graph2.addEdge(new int[]{11, 12, 802});
        System.out.println(graph2.shortestPath(2, 9));
        System.out.println(graph2.shortestPath(2, 6));
        graph2.addEdge(new int[]{0, 11, 441770});
        System.out.println(graph2.shortestPath(3, 7));
        graph2.addEdge(new int[]{11, 0, 393443});
        System.out.println(graph2.shortestPath(4, 2));
        graph2.addEdge(new int[]{10, 5, 338});
        graph2.addEdge(new int[]{6, 1, 305});
        graph2.addEdge(new int[]{5, 0, 154});

        System.out.println("----------------------------------------");

        Graph1 graph3 = new Graph1(13, new int[][]{{6, 12, 315086}, {4, 6, 434499}, {8, 4, 753794}, {4, 8, 25425}, {12, 7, 790970}, {1, 12, 617809}, {12, 3, 162762}, {6, 10, 831419}, {1, 3, 161356}, {2, 9, 78885}, {9, 6, 377317}, {9, 2, 21891}, {0, 4, 8226}, {7, 12, 182349}, {5, 10, 113773}, {4, 10, 538290}, {1, 0, 733504}, {11, 2, 105677}, {8, 11, 716157}, {0, 8, 598757}, {12, 6, 390446}, {6, 7, 231085}, {0, 11, 306911}, {1, 11, 201790}, {9, 8, 632445}, {4, 2, 11198}, {10, 4, 480988}, {12, 0, 855344}, {11, 1, 951787}, {1, 9, 847441}, {12, 5, 265162}, {3, 4, 836015}, {3, 6, 10355}, {6, 4, 986910}, {7, 1, 789806}, {4, 11, 601682}, {11, 12, 373853}, {7, 9, 975447}, {2, 11, 408606}, {6, 1, 177887}, {11, 5, 245495}, {10, 0, 107270}});
        graph3.addEdge(new int[]{6, 5, 962787});
        graph3.addEdge(new int[]{3, 10, 6961});
        System.out.println(graph3.shortestPath(12, 6));
        System.out.println(graph3.shortestPath(8, 8));
        System.out.println(graph3.shortestPath(12, 1));
        graph3.addEdge(new int[]{8, 9, 763398});
        graph3.addEdge(new int[]{5, 9, 787580});
        graph3.addEdge(new int[]{5, 6, 5710});
        graph3.addEdge(new int[]{3, 8, 2990});
        graph3.addEdge(new int[]{2, 12, 580988});
        graph3.addEdge(new int[]{1, 5, 749003});
        System.out.println(graph3.shortestPath(3, 10));
        graph3.addEdge(new int[]{8, 5, 1999});
        System.out.println(graph3.shortestPath(7, 2));
        graph3.addEdge(new int[]{8, 7, 711});
        System.out.println(graph3.shortestPath(0, 2));
        System.out.println(graph3.shortestPath(10, 8));
        System.out.println(graph3.shortestPath(5, 6));
        graph3.addEdge(new int[]{9, 4, 490870});
        System.out.println(graph3.shortestPath(2, 5));
        graph3.addEdge(new int[]{2, 0, 663});
        graph3.addEdge(new int[]{7, 5, 518});
        graph3.addEdge(new int[]{8, 10, 91});
        System.out.println(graph3.shortestPath(10, 2));
        graph3.addEdge(new int[]{7, 3, 687804});
        graph3.addEdge(new int[]{0, 12, 216563});
        System.out.println(graph3.shortestPath(12, 1));
        graph3.addEdge(new int[]{1, 8, 91});
        System.out.println(graph3.shortestPath(3, 5));
        graph3.addEdge(new int[]{5, 3, 382061});
        System.out.println(graph3.shortestPath(11, 1));
        graph3.addEdge(new int[]{0, 3, 53});
        System.out.println(graph3.shortestPath(8, 12));
        graph3.addEdge(new int[]{8, 0, 10});
        graph3.addEdge(new int[]{12, 2, 3});
        graph3.addEdge(new int[]{4, 12, 901278});
        System.out.println(graph3.shortestPath(3, 7));
        graph3.addEdge(new int[]{3, 7, 2});
        graph3.addEdge(new int[]{10, 2, 165121});
        graph3.addEdge(new int[]{3, 1, 606436});
        System.out.println(graph3.shortestPath(2, 8));
        graph3.addEdge(new int[]{10, 11, 937623});
        System.out.println(graph3.shortestPath(12, 5));
        graph3.addEdge(new int[]{2, 5, 25648});
        System.out.println(graph3.shortestPath(0, 8));
        graph3.addEdge(new int[]{11, 8, 1});
        graph3.addEdge(new int[]{4, 7, 1});
        graph3.addEdge(new int[]{10, 9, 1});
        graph3.addEdge(new int[]{5, 12, 613478});
        System.out.println(graph3.shortestPath(11, 4));
        System.out.println(graph3.shortestPath(7, 7));
        graph3.addEdge(new int[]{11, 6, 1});
        System.out.println(graph3.shortestPath(9, 4));
        graph3.addEdge(new int[]{2, 1, 1});
        graph3.addEdge(new int[]{5, 2, 1});
        System.out.println(graph3.shortestPath(11, 7));
        graph3.addEdge(new int[]{12, 11, 1});
        graph3.addEdge(new int[]{6, 8, 709797});
        System.out.println(graph3.shortestPath(10, 4));
        System.out.println(graph3.shortestPath(5, 6));
        graph3.addEdge(new int[]{7, 6, 1});
        System.out.println(graph3.shortestPath(0, 1));
        System.out.println(graph3.shortestPath(5, 12));
        System.out.println(graph3.shortestPath(5, 1));
        System.out.println(graph3.shortestPath(0, 5));
        graph3.addEdge(new int[]{10, 8, 1});
    }
}
