package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Description: 797. All Paths From Source to Target
 *
 * @author Baltan
 * @date 2019-03-19 14:25
 */
public class AllPathsSourceTarget {
    public static void main(String[] args) {
        int[][] graph1 = {{1, 2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget(graph1));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        int terminal = graph.length - 1;
        /**
         * 将从0可到达的点加入result
         */
        for (int i = 0, m = graph[0].length; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(graph[0][i]);
            result.add(list);
        }
        /**
         * 对于每一个点，逐一判断之前是否存在路径可以走到该点
         */
        for (int i = 1; i < terminal; i++) {
            ListIterator<List<Integer>> it = result.listIterator();

            while (it.hasNext()) {
                List<Integer> list = it.next();
                /**
                 * 如果已有的路径中存在走到该点的路径，并且还能继续往下走，就将新路径加入到result
                 */
                if (list.get(list.size() - 1) == i) {
                    for (int j = 0, n = graph[i].length; j < n; j++) {
                        List<Integer> list1 = new ArrayList<>(list);
                        list1.add(graph[i][j]);
                        it.add(list1);
                    }
                }
            }
        }

        Iterator<List<Integer>> it = result.iterator();
        /**
         * 将终点不是n-1的路径从result中删除
         */
        while (it.hasNext()) {
            List<Integer> list = it.next();

            if (list.get(list.size() - 1) != terminal) {
                it.remove();
            }
        }
        return result;
    }
}
