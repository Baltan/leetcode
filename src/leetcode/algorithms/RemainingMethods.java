package leetcode.algorithms;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Description: 3310. Remove Methods From Project
 *
 * @author baltan
 * @date 2024/10/9 08:50
 */
public class RemainingMethods {
    public static void main(String[] args) {
        System.out.println(remainingMethods(4, 1, new int[][]{{1, 2}, {0, 1}, {3, 2}}));
        System.out.println(remainingMethods(5, 0, new int[][]{{1, 2}, {0, 2}, {0, 1}, {3, 4}}));
        System.out.println(remainingMethods(3, 2, new int[][]{{1, 2}, {0, 1}, {2, 0}}));
    }

    public static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        /**
         * 保存所有可以方法
         */
        Queue<Integer> queue = new LinkedList<>();
        /**
         * isVisited[i]表示方法i是否已被标记为可以方法
         */
        boolean[] isVisited = new boolean[n];
        /**
         * graph[i]保存方法i直接调用的所有其他方法
         */
        List<Integer>[] graph = new List[n];
        queue.offer(k);
        isVisited[k] = true;
        Arrays.setAll(graph, i -> new ArrayList<>());
        /**
         * 构建图
         */
        for (int[] invocation : invocations) {
            graph[invocation[0]].add(invocation[1]);
        }
        /**
         * 广度优先搜索查找所有可疑方法
         */
        while (!queue.isEmpty()) {
            int method = queue.poll();

            for (int invokedMethod : graph[method]) {
                if (!isVisited[invokedMethod]) {
                    queue.offer(invokedMethod);
                    isVisited[invokedMethod] = true;
                }
            }
        }

        for (int[] invocation : invocations) {
            /**
             * 如果一个可疑方法被一个非可疑方法调用，则该可疑方法无法被移除，直接返回所有方法
             */
            if (!isVisited[invocation[0]] && isVisited[invocation[1]]) {
                return IntStream.range(0, n).boxed().toList();
            }
        }
        /**
         * 过滤出所有未被标记为可疑的方法
         */
        return IntStream.range(0, n).filter(x -> !isVisited[x]).boxed().toList();
    }
}
