package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2050. Parallel Courses III
 *
 * @author Baltan
 * @date 2023/9/13 23:23
 */
public class MinimumTime2 {
    public static void main(String[] args) {
        int[][] relations1 = {{1, 3}, {2, 3}};
        int[] time1 = {3, 2, 5};
        System.out.println(minimumTime(3, relations1, time1));

        int[][] relations2 = {{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}};
        int[] time2 = {1, 2, 3, 4, 5};
        System.out.println(minimumTime(5, relations2, time2));
    }

    public static int minimumTime(int n, int[][] relations, int[] time) {
        int result = 0;
        int[] endTimes = new int[n + 1];
        Set<Integer>[] prevCourses = new Set[n + 1];
        List<Integer>[] nextCourses = new List[n + 1];
        Queue<Integer> completedCourses = new LinkedList<>();
        Arrays.setAll(prevCourses, x -> new HashSet<>());
        Arrays.setAll(nextCourses, x -> new ArrayList<>());

        for (int[] relation : relations) {
            prevCourses[relation[1]].add(relation[0]);
            nextCourses[relation[0]].add(relation[1]);
        }

        for (int i = 1; i <= n; i++) {
            if (prevCourses[i].isEmpty()) {
                completedCourses.offer(i);
                endTimes[i] = time[i - 1];
                result = Math.max(result, endTimes[i]);
            }
        }

        while (!completedCourses.isEmpty()) {
            int completedCourse = completedCourses.poll();

            for (int course : nextCourses[completedCourse]) {
                endTimes[course] = Math.max(endTimes[course], endTimes[completedCourse] + time[course - 1]);
                result = Math.max(result, endTimes[course]);
                prevCourses[course].remove(completedCourse);

                if (prevCourses[course].isEmpty()) {
                    completedCourses.offer(course);
                }
            }
        }
        return result;
    }
}
