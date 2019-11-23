package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 630. Course Schedule III
 *
 * @author Baltan
 * @date 2019-11-23 10:20
 */
public class ScheduleCourse {
    public static void main(String[] args) {
        int[][] courses1 = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(scheduleCourse(courses1));

        int[][] courses2 = {{1, 2}, {2, 3}};
        System.out.println(scheduleCourse(courses2));

        int[][] courses3 = {{5, 5}, {4, 6}, {2, 6}};
        System.out.println(scheduleCourse(courses3));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/course-schedule-iii/solution/ke-cheng-biao-iii-by-leetcode/"></a>
     *
     * @param courses
     * @return
     */
    public static int scheduleCourse(int[][] courses) {
        int time = 0;
        /**
         * 保存当前已经选择的课程的上课持续时间，并按照递减顺序排列
         */
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        /**
         * 将所有课程按照结束时间递增顺序排列
         */
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));

        for (int[] course : courses) {
            /**
             * 如果当前课程可以在课程的结束时间前修完，就选择当前课程并将当前课程的上课持续时间加入队列queue；否则
             * 如果已选择的课程中有上课持续时间超过当前课程的，就将该课程换成当前课程
             */
            if (time + course[0] <= course[1]) {
                queue.offer(course[0]);
                time += course[0];
            } else if (!queue.isEmpty() && queue.peek() > course[0]) {
                time -= queue.poll();
                time += course[0];
                queue.offer(course[0]);
            }
        }
        return queue.size();
    }
}
