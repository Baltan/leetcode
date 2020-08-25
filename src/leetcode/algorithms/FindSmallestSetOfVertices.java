package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1557. Minimum Number of Vertices to Reach All Nodes
 *
 * @author Baltan
 * @date 2020-08-24 23:40
 */
public class FindSmallestSetOfVertices {
    public static void main(String[] args) {
        System.out.println(findSmallestSetOfVertices(6,
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(0, 2), Arrays.asList(2, 5),
                        Arrays.asList(3, 4), Arrays.asList(4, 2))));
        System.out.println(findSmallestSetOfVertices(5, Arrays.asList(Arrays.asList(0, 1), Arrays.asList(2,
                1), Arrays.asList(3, 1), Arrays.asList(1, 4), Arrays.asList(2, 4))));
    }

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new LinkedList<>();
        /**
         * available[i]表示是否可以通过其他点到达点i
         */
        boolean[] available = new boolean[n];

        for (List<Integer> edge : edges) {
            int to = edge.get(1);
            available[to] = true;
        }
        /**
         * 只有无法通过其他点到达的点才会被加入出发点集
         */
        for (int i = 0; i < n; i++) {
            if (!available[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
