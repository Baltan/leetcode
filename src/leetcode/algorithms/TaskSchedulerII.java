package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2365. Task Scheduler II
 *
 * @author Baltan
 * @date 2023/1/12 09:14
 */
public class TaskSchedulerII {
    public static void main(String[] args) {
        System.out.println(taskSchedulerII(new int[]{1, 2, 1, 2, 3, 1}, 3));
        System.out.println(taskSchedulerII(new int[]{5, 8, 8, 5}, 2));
    }

    public static long taskSchedulerII(int[] tasks, int space) {
        long result = 0L;
        /**
         * 任务i -> 最近一次完成任务i的天数
         */
        Map<Integer, Long> taskDayMap = new HashMap<>();

        for (int task : tasks) {
            if (taskDayMap.containsKey(task)) {
                /**
                 * 上次完成任务task后，至少要第taskDayMap.get(task)+space+1天才能再完成任务task
                 */
                result = Math.max(taskDayMap.get(task) + space + 1, result + 1);
            } else {
                result++;
            }
            taskDayMap.put(task, result);
        }
        return result;
    }
}
