package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1834. Single-Threaded CPU
 *
 * @author Baltan
 * @date 2022/6/12 14:17
 */
public class GetOrder {
    public static void main(String[] args) {
        int[][] tasks1 = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        OutputUtils.print1DIntegerArray(getOrder(tasks1));

        int[][] tasks2 = {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
        OutputUtils.print1DIntegerArray(getOrder(tasks2));

        int[][] tasks3 =
                {{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34},
                        {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}};
        OutputUtils.print1DIntegerArray(getOrder(tasks3));
    }

    public static int[] getOrder(int[][] tasks) {
        int[] result = new int[tasks.length];
        int index = 0;
        /**
         * 当前时间
         */
        int currentTime = 0;
        /**
         * 按照每项任务的开始时间升序排列
         */
        Queue<int[]> taskQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        /**
         * 优先按照每项任务的执行时间升序排列，执行时间相同时按照每项任务在tasks中的索引升序排列
         */
        Queue<int[]> processQueue = new PriorityQueue<>((x, y) -> x[1] != y[1] ? x[1] - y[1] : x[2] - y[2]);

        for (int i = 0; i < tasks.length; i++) {
            /**
             * [任务开始时间,任务执行时间,任务在tasks中的索引]
             */
            int[] task = new int[]{tasks[i][0], tasks[i][1], i};
            taskQueue.offer(task);
        }

        while (index < tasks.length) {
            if (!processQueue.isEmpty()) {
                int[] task = processQueue.poll();
                result[index++] = task[2];
                /**
                 * 当前执行任务的结束时间
                 */
                int finishTime = currentTime + task[1];
                /**
                 * 时间跳转到本次任务结束的时间
                 */
                currentTime = finishTime;
                /**
                 * 将finishTime之前开始的所有任务加入任务队列中
                 */
                while (!taskQueue.isEmpty() && taskQueue.peek()[0] <= finishTime) {
                    processQueue.offer(taskQueue.poll());
                }
            } else {
                /**
                 * 当前剩余任务的最早开始时间
                 */
                int minStartTime = taskQueue.peek()[0];
                /**
                 * 时间跳转到下一次任务开始的时间
                 */
                currentTime = minStartTime;
                /**
                 * 将在minStartTime开始的所有任务加入任务队列中
                 */
                while (!taskQueue.isEmpty() && taskQueue.peek()[0] == minStartTime) {
                    processQueue.offer(taskQueue.poll());
                }
            }
        }
        return result;
    }
}
