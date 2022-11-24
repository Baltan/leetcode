package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 2467. Most Profitable Path in a Tree
 *
 * @author Baltan
 * @date 2022/11/22 11:48
 */
public class MostProfitablePath {
    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int bob1 = 3;
        int[] amount1 = {-2, 4, 2, -4, 6};
        System.out.println(mostProfitablePath(edges1, bob1, amount1));

        int[][] edges2 = {{0, 1}};
        int bob2 = 1;
        int[] amount2 = {-7280, 2350};
        System.out.println(mostProfitablePath(edges2, bob2, amount2));
    }

    private static int result;

    /**
     * 参考：<a href="https://leetcode.cn/problems/most-profitable-path-in-a-tree/solutions/1964916/liang-bian-dfs-by-endlesscheng-da7j/"></a>
     *
     * @param edges
     * @param bob
     * @param amount
     * @return
     */
    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        result = Integer.MIN_VALUE;
        int length = edges.length;
        /**
         * graph[i]表示与节点i相连的所有其他的节点列表
         */
        List<Integer>[] graph = new List[length + 1];
        /**
         * bobTimes[i]表示Bob到节点i的时间
         */
        int[] bobTimes = new int[length + 1];
        Arrays.fill(bobTimes, -1);

        for (int i = 0; i <= length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        /**
         * 计算Bob从节点bob到节点0的过程中到达每个节点的时间
         */
        dfsBobTimes(graph, bob, -1, bobTimes, 0);
        dfsAlice(graph, 0, -1, 0, 0, amount, bobTimes);
        return result;
    }

    /**
     * 计算Alice从节点0到达每个叶节点的得分
     *
     * @param graph
     * @param to
     * @param from
     * @param income
     * @param time
     * @param amount
     * @param bobTimes
     */
    public static void dfsAlice(List<Integer>[] graph, int to, int from, int income, int time, int[] amount, int[] bobTimes) {
        /**
         * 到达to节点时给以获得的得分
         */
        int currentIncome;
        /**
         * 如果Bob没有到过to节点或者Bob到达to节点的时间大于time，Alice可以获得to节点的所有得分；如果Bob和Alice同时到达to节点，Alice可以获
         * 得to节点的一半得分；如果Bob到达to节点的时间小于time，Alice到达to节点不能得分
         */
        if (bobTimes[to] == -1 || bobTimes[to] > time) {
            currentIncome = amount[to];
        } else if (bobTimes[to] == time) {
            currentIncome = amount[to] / 2;
        } else {
            currentIncome = 0;
        }
        income += currentIncome;
        /**
         * to节点是非0节点的叶节点
         */
        if (graph[to].size() == 1 && to != 0) {
            result = Math.max(result, income);
            return;
        }

        for (int next : graph[to]) {
            if (next == from) {
                continue;
            }
            /**
             * 向下一节点next节点递归
             */
            dfsAlice(graph, next, to, income, time + 1, amount, bobTimes);
        }
    }

    /**
     * 计算Bob从节点bob到节点0的过程中到达每个节点的时间
     *
     * @param graph
     * @param to
     * @param from
     * @param bobTimes
     * @param time
     * @return Bob是否可以到达to节点
     */
    public static boolean dfsBobTimes(List<Integer>[] graph, int to, int from, int[] bobTimes, int time) {
        if (to == 0) {
            bobTimes[to] = time;
            return true;
        }

        for (int next : graph[to]) {
            if (next != from && dfsBobTimes(graph, next, to, bobTimes, time + 1)) {
                bobTimes[to] = time;
                return true;
            }
        }
        return false;
    }
}
