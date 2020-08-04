package leetcode.algorithms;

import java.util.*;

/**
 * Description: 207. Course Schedule
 *
 * @author Baltan
 * @date 2020-08-04 21:05
 * @see CanFinish
 */
public class CanFinish1 {
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
         * 课程i -> 以课程i为先修课程的所有课程集合
         */
        Map<Integer, Set<Integer>> map1 = new HashMap<>();
        /**
         * 课程i -> 课程i的未修先修课程数
         */
        Map<Integer, Integer> map2 = new HashMap<>();
        /**
         * 先修课程数i -> 剩余先修课程数为i的课程集合
         */
        Map<Integer, Set<Integer>> map3 = new HashMap<>();
        /**
         * 保存所有没有未修先修课程的课程
         */
        Queue<Integer> queue = new LinkedList<>();
        /**
         * 已完成的课程数
         */
        int completedCount = 0;
        /**
         * 初始化
         */
        for (int i = 0; i < numCourses; i++) {
            map1.put(i, new HashSet<>());
            map2.put(i, 0);
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            map1.get(preCourse).add(course);
            map2.put(course, map2.get(course) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            int course = entry.getKey();
            /**
             * 课程course未修先修课程的数量
             */
            int count = entry.getValue();
            map3.putIfAbsent(count, new HashSet<>());
            map3.get(count).add(course);
        }
        /**
         * 如果没有未修先修课程数为0的课程，即所有课程都有先修课程，则所有课程都无法完成，返回false
         */
        if (!map3.containsKey(0)) {
            return false;
        }
        /**
         * 将没有未修先修课程的课程入队
         */
        for (int course : map3.get(0)) {
            queue.offer(course);
        }

        while (!queue.isEmpty()) {
            int preCourse = queue.poll();
            completedCount++;

            for (int course : map1.get(preCourse)) {
                /**
                 * 如果课程course的未修先修课程只剩preCourse一门，则完成preCourse后，course也没有未修先修课程
                 * 了，将course入队，否则更新course的未修先修课程数
                 */
                if (map2.get(course) == 1) {
                    queue.offer(course);
                } else {
                    map2.put(course, map2.get(course) - 1);
                }
            }
        }
        /**
         * 判断已完成的课程数是否等于总课程数
         */
        return completedCount == numCourses;
    }
}
