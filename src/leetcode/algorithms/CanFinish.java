package leetcode.algorithms;

import java.util.*;

/**
 * Description: 207. Course Schedule
 *
 * @author Baltan
 * @date 2019-06-06 10:45
 * @see CanFinish1
 */
public class CanFinish {
    public static void main(String[] args) {
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(canFinish(2, prerequisites1));

        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(canFinish(2, prerequisites2));

        int[][] prerequisites3 = {{}};
        System.out.println(canFinish(2, prerequisites3));

        int[][] prerequisites4 = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(canFinish(4, prerequisites4));

        int[][] prerequisites5 = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
        System.out.println(canFinish(4, prerequisites5));

        int[][] prerequisites6 = {{1, 0}, {2, 0}};
        System.out.println(canFinish(3, prerequisites6));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        /**
         * 保存所有需要先修其他课程的课程
         */
        Set<Integer> needPre = new HashSet<>();
        /**
         * 已经学习的课程
         */
        Set<Integer> isTaken = new HashSet<>();
        /**
         * preCourses[i]表示课程i的所有先修课程
         */
        List<Integer>[] preCourses = new List[numCourses];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            preCourses[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            queue.offer(prerequisite);
            needPre.add(prerequisite[0]);
            preCourses[prerequisite[0]].add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!needPre.contains(i)) {
                isTaken.add(i);
            }
        }

        while (!queue.isEmpty()) {
            /**
             * 标记此轮循环后所有课程的学习情况是否发生变化
             */
            boolean flag = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] prerequisite = queue.poll();
                int course = prerequisite[0];
                int preCourse = prerequisite[1];
                /**
                 * 如果course的先修课程preCourse还未修，则course也无法完成，将prerequisite重新放回queue最后，
                 * 以后再做判断
                 */
                if (!isTaken.contains(preCourse)) {
                    queue.offer(prerequisite);
                } else {
                    /**
                     * 移除course的先修课程preCourse
                     */
                    preCourses[course].remove(new Integer(preCourse));
                    flag = true;
                    /**
                     * 如果course的所有先修课程都已经被完成了，则course也可以完成
                     */
                    if (preCourses[course].isEmpty()) {
                        isTaken.add(course);
                    }
                }
            }
            /**
             * 如果此轮循环没有发生任何变化，则说明剩下的课程都不能被完成了，直接返回false
             */
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
