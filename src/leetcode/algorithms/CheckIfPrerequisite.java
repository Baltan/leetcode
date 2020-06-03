package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1462. Course Schedule IV
 *
 * @author Baltan
 * @date 2020-06-02 16:20
 * @see CheckIfPrerequisite1
 * @see FindTheCity
 */
public class CheckIfPrerequisite {
    public static void main(String[] args) {
        int[][] prerequisites1 = {{1, 0}};
        int[][] queries1 = {{0, 1}, {1, 0}};
        System.out.println(checkIfPrerequisite(2, prerequisites1, queries1));

        int[][] prerequisites2 = {};
        int[][] queries2 = {{1, 0}, {0, 1}};
        System.out.println(checkIfPrerequisite(2, prerequisites2, queries2));

        int[][] prerequisites3 = {{1, 2}, {1, 0}, {2, 0}};
        int[][] queries3 = {{1, 0}, {1, 2}};
        System.out.println(checkIfPrerequisite(3, prerequisites3, queries3));

        int[][] prerequisites4 = {{1, 0}, {2, 0}};
        int[][] queries4 = {{0, 1}, {2, 0}};
        System.out.println(checkIfPrerequisite(3, prerequisites4, queries4));

        int[][] prerequisites5 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] queries5 = {{0, 4}, {4, 0}, {1, 3}, {3, 0}};
        System.out.println(checkIfPrerequisite(5, prerequisites5, queries5));
    }

    public static List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>(queries.length);
        /**
         * 课程i -> 课程i的所有先修课程集合
         */
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            map.putIfAbsent(prerequisite[1], new HashSet<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
        }

        outer:
        for (int[] query : queries) {
            Queue<Integer> queue = new LinkedList<>();
            /**
             * 标记课程i是否已经修过
             */
            boolean[] isVisited = new boolean[n];
            queue.offer(query[1]);

            while (!queue.isEmpty()) {
                int course = queue.poll();
                isVisited[course] = true;
                Set<Integer> preCourses = map.get(course);

                if (preCourses != null) {
                    /**
                     * 如果先修课程集合中包含query[0]，则说明query[0]是query[1]的先修课程
                     */
                    if (preCourses.contains(query[0])) {
                        result.add(true);
                        continue outer;
                    }
                    /**
                     * 将还没有修过的先修课程加入队列
                     */
                    for (int preCourse : preCourses) {
                        if (!isVisited[preCourse]) {
                            queue.offer(preCourse);
                        }
                    }
                }
            }
            result.add(false);
        }
        return result;
    }
}
