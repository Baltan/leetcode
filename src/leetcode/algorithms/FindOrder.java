package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 210. Course Schedule II
 *
 * @author Baltan
 * @date 2019-06-07 10:25
 */
public class FindOrder {
    public static void main(String[] args) {
        int[][] prerequisites1 = {{1, 0}};
        OutputUtils.print1DIntegerArray(findOrder(2, prerequisites1));

        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        OutputUtils.print1DIntegerArray(findOrder(4, prerequisites2));

        int[][] prerequisites3 = {{1, 0}, {0, 3}, {3, 2}, {2, 1}};
        OutputUtils.print1DIntegerArray(findOrder(4, prerequisites3));

        int[][] prerequisites4 = {{}};
        OutputUtils.print1DIntegerArray(findOrder(3, prerequisites4));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }

        List<Integer> arrangement = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer, List<Integer>> needPre = new HashMap();

        for (int[] prerequisite : prerequisites) {
            queue.offer(prerequisite);
            int course = prerequisite[0];
            int preCourse = prerequisite[1];

            if (needPre.containsKey(course)) {
                needPre.get(course).add(preCourse);
            } else {
                List<Integer> preCourses = new ArrayList<>();
                preCourses.add(preCourse);
                needPre.put(course, preCourses);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (!needPre.containsKey(i)) {
                arrangement.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                int[] prerequisite = queue.poll();
                int course = prerequisite[0];
                int preCourse = prerequisite[1];

                if (arrangement.contains(preCourse)) {
                    List<Integer> preCourses = needPre.get(course);
                    preCourses.remove(new Integer(preCourse));
                    flag = true;

                    if (preCourses.isEmpty()) {
                        arrangement.add(course);
                    }
                } else {
                    queue.offer(prerequisite);
                }
            }

            if (!flag) {
                return new int[]{};
            }
        }

        for (int i = 0; i < numCourses; i++) {
            result[i] = arrangement.get(i);
        }
        return result;
    }
}
