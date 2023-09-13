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
        /**
         * endTimes[i]表示完成课程i的最早时间
         */
        int[] endTimes = new int[n + 1];
        /**
         * prevCounts[i]表示课程i的先修课程数
         */
        int[] prevCounts = new int[n + 1];
        /**
         * prevCourses[i]表示完成课程i前需要完成的所有先修课程
         */
        List<Integer>[] prevCourses = new List[n + 1];
        /**
         * nextCourses[i]表示必须在完成课程i后才能开始的其他课程
         */
        List<Integer>[] nextCourses = new List[n + 1];
        /**
         * 保存所有已完成的课程
         */
        Queue<Integer> completedCourses = new LinkedList<>();
        Arrays.setAll(prevCourses, x -> new ArrayList<>());
        Arrays.setAll(nextCourses, x -> new ArrayList<>());

        for (int[] relation : relations) {
            prevCounts[relation[1]]++;
            prevCourses[relation[1]].add(relation[0]);
            nextCourses[relation[0]].add(relation[1]);
        }
        /**
         * 找到所有没有先修课程的课程加入队列，这部分课程可以在起始时间一起同步学习，并记录这些课程的完成时间
         */
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
                /**
                 * 对于已完成的课程completedCourse，如果必须在其之后开始的课程course紧接着它立刻开始学习，则课程course最早可以完成的时
                 * 间为endTimes[completedCourse]+time[course-1]和endTimes[course]之间的较大值
                 */
                endTimes[course] = Math.max(endTimes[course], endTimes[completedCourse] + time[course - 1]);
                result = Math.max(result, endTimes[course]);
                /**
                 * 因为课程course的先修课程completedCourse已经完成了，所以将course的先修课程数减1
                 */
                prevCounts[course]--;
                /**
                 * 如果课程course的所有先修课程已经完成了，说明课程course也在时刻endTimes[course]完成了
                 */
                if (prevCounts[course] == 0) {
                    completedCourses.offer(course);
                }
            }
        }
        return result;
    }
}
