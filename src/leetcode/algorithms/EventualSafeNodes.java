package leetcode.algorithms;


import java.util.*;

/**
 * Description: 802. Find Eventual Safe States
 *
 * @author Baltan
 * @date 2019-11-02 18:46
 */
public class EventualSafeNodes {
    public static void main(String[] args) {
        int[][] graph1 = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(graph1));

        int[][] graph2 = {{0}, {2, 3, 4}, {3, 4}, {0, 4}, {}};
        System.out.println(eventualSafeNodes(graph2));

        int[][] graph3 = {{2, 3}, {2, 3, 4}, {3, 4}, {}, {1}};
        System.out.println(eventualSafeNodes(graph3));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/find-eventual-safe-states/solution/zhao-dao-zui-zhong-de-an-quan-zhuang-tai-by-leetco/"></a>
     *
     * @param graph
     * @return
     */
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new LinkedList<>();
        int length = graph.length;
        /**
         * 标记每个节点是否是安全的，因为题目要求按序输出安全节点，最后一步需要遍历该数组按序判断是否为安全节点
         */
        boolean[] isSafe = new boolean[length];
        /**
         * 保存安全节点的队列
         */
        Queue<Integer> safeQueue = new LinkedList();
        /**
         * 原始的正向图
         */
        Set<Integer>[] originalGraph = new Set[length];
        /**
         * 将原始有向图的每条边的起点作为终点，终点作为起点之后转化得到的反向图
         */
        Set<Integer>[] reversedGraph = new Set[length];

        for (int i = 0; i < length; i++) {
            originalGraph[i] = new HashSet();
            reversedGraph[i] = new HashSet();
        }

        for (int i = 0; i < length; i++) {
            /**
             * 对于原始的正向图，如果某个节点没有出边，该节点显然是一个安全节点
             */
            if (graph[i].length == 0) {
                safeQueue.offer(i);
            } else {
                for (int j : graph[i]) {
                    originalGraph[i].add(j);
                    reversedGraph[j].add(i);
                }
            }
        }
        /**
         * 对于每一个节点而言，如果该节点直接连通的所有节点都是安全节点，则该节点也是一个安全节点
         */
        while (!safeQueue.isEmpty()) {
            int safePoint = safeQueue.poll();
            isSafe[safePoint] = true;
            /**
             * 对于直接连通到当前安全节点的所有节点i，在原始的正向图中将节点i连通到的该安全节点移除
             */
            for (int i : reversedGraph[safePoint]) {
                originalGraph[i].remove(safePoint);
                /**
                 * 如果节点i没有连通到其他节点了，说明节点i直接连通的所有节点都是安全节点，则节点i也是一个安全节点
                 */
                if (originalGraph[i].isEmpty()) {
                    safeQueue.offer(i);
                }
            }
        }
        /**
         * 将安全节点有序加入结果集合
         */
        for (int i = 0; i < length; i++) {
            if (isSafe[i]) {
                result.add(i);
            }
        }
        return result;
    }
}