package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2477. Minimum Fuel Cost to Report to the Capital
 *
 * @author Baltan
 * @date 2022/11/21 11:38
 */
public class MinimumFuelCost {
    public static void main(String[] args) {
        int[][] roads1 = {{0, 1}, {0, 2}, {0, 3}};
        int seats1 = 5;
        System.out.println(minimumFuelCost(roads1, seats1));

        int[][] roads2 = {{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}};
        int seats2 = 2;
        System.out.println(minimumFuelCost(roads2, seats2));

        int[][] roads3 = {};
        int seats3 = 1;
        System.out.println(minimumFuelCost(roads3, seats3));

        int[][] roads4 = {{1, 0}, {0, 2}, {3, 1}, {1, 4}, {5, 0}};
        int seats4 = 1;
        System.out.println(minimumFuelCost(roads4, seats4));
    }

    private static long result;

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-fuel-cost-to-report-to-the-capital/solutions/1981361/kao-lu-mei-tiao-bian-shang-zhi-shao-xu-y-uamv/"></a>
     *
     * @param roads
     * @param seats
     * @return
     */
    public static long minimumFuelCost(int[][] roads, int seats) {
        result = 0L;
        int length = roads.length;
        /**
         * graph[i]表示与城市i相连的所有其他的城市列表
         */
        List<Integer>[] graph = new List[length + 1];

        for (int i = 0; i <= length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        for (int from : graph[0]) {
            dfs(graph, 0, from, seats);
        }
        return result;
    }

    /**
     * 计算从城市from到达城市to的总人数，并且累加这条路径上的总油耗
     *
     * @param graph
     * @param to
     * @param from
     * @param seats
     * @return
     */
    private static int dfs(List<Integer>[] graph, int to, int from, int seats) {
        /**
         * 城市from是一条路径的端点，即除了城市to没有其他城市与城市from相连
         */
        if (graph[from].size() == 1 && graph[from].get(0) == to) {
            /**
             * 城市from的代表到城市to一个人需要一辆车
             */
            result++;
            return 1;
        }
        /**
         * 从城市from到达城市to的总人数，包括从城市other到达城市from的人数加上从城市from到达城市to的一个代表。初始化为1代表从城市from到达城
         * 市to的一个代表
         */
        int count = 1;

        for (int other : graph[from]) {
            if (other == to) {
                continue;
            }
            /**
             * 从城市other到达城市from的人数
             */
            count += dfs(graph, from, other, seats);
        }
        result += Math.ceil(count * 1.0 / seats);
        return count;
    }
}
