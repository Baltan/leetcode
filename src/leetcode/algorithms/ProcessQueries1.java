package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Description: 3607. Power Grid Maintenance
 *
 * @author Baltan
 * @date 2025/8/11 22:49
 */
public class ProcessQueries1 {
    public static void main(String[] args) {
        int[][] connections1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] queries1 = {{1, 3}, {2, 1}, {1, 1}, {2, 2}, {1, 2}};
        OutputUtils.print1DIntegerArray(processQueries(5, connections1, queries1));

        int[][] connections2 = {};
        int[][] queries2 = {{1, 1}, {2, 1}, {1, 1}};
        OutputUtils.print1DIntegerArray(processQueries(3, connections2, queries2));
    }

    public static int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        /**
         * graph[i]表示与电站i相邻的所有电站
         */
        List<Integer>[] graph = new List[c + 1];
        /**
         * isVisited[i]表示计算电网的过程中电站是否已被访问过
         */
        boolean[] isVisited = new boolean[c + 1];
        /**
         * unions[i]表示包含电站i的电网中所有电站的集合
         */
        TreeSet<Integer>[] unions = new TreeSet[c + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());
        Arrays.setAll(unions, i -> new TreeSet<>());
        /**
         * 构建图
         */
        for (int[] connection : connections) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }
        /**
         * 依次递归计算电站i所属电网
         */
        for (int i = 1; i <= c; i++) {
            TreeSet<Integer> union = new TreeSet<>();
            dfs(union, unions, graph, isVisited, i);
        }

        for (int[] query : queries) {
            int station = query[1];

            if (query[0] == 1) {
                TreeSet<Integer> union = unions[station];
                result.add(union.isEmpty() ? -1 : (union.contains(station) ? station : union.getFirst()));
            } else {
                /**
                 * 电站station从电网union中下线
                 */
                unions[station].remove(station);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 递归计算电网
     *
     * @param union
     * @param unions
     * @param graph
     * @param isVisited
     * @param curr
     */
    public static void dfs(TreeSet<Integer> union, TreeSet<Integer>[] unions, List<Integer>[] graph, boolean[] isVisited, int curr) {
        if (isVisited[curr]) {
            return;
        }
        /**
         * 将电站curr纳入电网union中，并标记电站curr已被访问
         */
        union.add(curr);
        isVisited[curr] = true;
        unions[curr] = union;

        for (int next : graph[curr]) {
            dfs(union, unions, graph, isVisited, next);
        }
    }
}
