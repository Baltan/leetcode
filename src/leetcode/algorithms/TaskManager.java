package leetcode.algorithms;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Description: 3408. Design Task Manager
 *
 * @author Baltan
 * @date 2025/1/9 23:39
 */
public class TaskManager {
    /**
     * taskUser[i]表示taskId为i的任务的所属用户的userId
     */
    private int[] taskUser;
    /**
     * taskUser[i]表示taskId为i的任务的优先级
     */
    private int[] taskPriority;
    /**
     * 优先级 -> 当前优先级下所有任务的taskId集合，并且集合中的taskId按照倒序排列
     */
    private TreeMap<Integer, TreeSet<Integer>> priorityTasks;

    public TaskManager(List<List<Integer>> tasks) {
        /**
         * 根据题意，taskId属于[0,100000]
         */
        taskUser = new int[100001];
        taskPriority = new int[100001];
        priorityTasks = new TreeMap<>(Collections.reverseOrder());

        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            taskUser[taskId] = userId;
            taskPriority[taskId] = priority;
            priorityTasks.computeIfAbsent(priority, x -> new TreeSet<>(Collections.reverseOrder())).add(taskId);
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskUser[taskId] = userId;
        taskPriority[taskId] = priority;
        priorityTasks.computeIfAbsent(priority, x -> new TreeSet<>(Collections.reverseOrder())).add(taskId);
    }

    public void edit(int taskId, int newPriority) {
        rmv(taskId);
        taskPriority[taskId] = newPriority;
        priorityTasks.computeIfAbsent(newPriority, x -> new TreeSet<>(Collections.reverseOrder())).add(taskId);
    }

    public void rmv(int taskId) {
        int priority = taskPriority[taskId];
        priorityTasks.get(priority).remove(taskId);
        /**
         * 系统中已不存在优先级为priority的任务
         */
        if (priorityTasks.get(priority).isEmpty()) {
            priorityTasks.remove(priority);
        }
    }

    public int execTop() {
        if (priorityTasks.isEmpty()) {
            return -1;
        }
        int taskId = priorityTasks.firstEntry().getValue().getFirst();
        rmv(taskId);
        return taskUser[taskId];
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(List.of(List.of(1, 101, 10), List.of(2, 102, 20), List.of(3, 103, 15)));
        taskManager.add(4, 104, 5);
        taskManager.edit(102, 8);
        System.out.println(taskManager.execTop());
        taskManager.rmv(101);
        taskManager.add(5, 105, 15);
        System.out.println(taskManager.execTop());
    }
}
