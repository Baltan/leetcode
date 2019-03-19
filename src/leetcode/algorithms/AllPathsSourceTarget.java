package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Description: All Paths From Source to Target
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


        for (int i = 0, m = graph[0].length; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(graph[0][i]);
            result.add(list);
        }

        for (int i = 1; i < terminal; i++) {
            ListIterator<List<Integer>> it = result.listIterator();
            while (it.hasNext()) {
                List<Integer> list = it.next();
                if (list.get(list.size() - 1) == i) {
                    for (int j = 0, n = graph[i].length; j < n; j++) {
                        List<Integer> list1 = new ArrayList<>();
                        for (int k = 0, p = list.size(); k < p; k++) {
                            list1.add(list.get(k));
                        }
                        list1.add(graph[i][j]);
                        it.add(list1);
                    }
                }
            }
        }

        Iterator<List<Integer>> it = result.iterator();
        while (it.hasNext()) {
            List<Integer> list = it.next();

            if (list.get(list.size() - 1) != terminal) {
                it.remove();
            }
        }
        return result;
    }
}
