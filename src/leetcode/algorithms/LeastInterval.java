package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 621. Task Scheduler
 *
 * @author Baltan
 * @date 2019-08-18 16:34
 */
public class LeastInterval {
    public static void main(String[] args) {
        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(tasks1, 2));

        char[] tasks2 = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'D'};
        System.out.println(leastInterval(tasks2, 0));

        char[] tasks3 = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'D'};
        System.out.println(leastInterval(tasks3, 1));

        char[] tasks4 = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'D'};
        System.out.println(leastInterval(tasks4, 2));

        char[] tasks5 = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'D'};
        System.out.println(leastInterval(tasks5, 3));

        char[] tasks6 = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'D'};
        System.out.println(leastInterval(tasks6, 4));

        char[] tasks7 = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'D'};
        System.out.println(leastInterval(tasks7, 5));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        /**
         * 对每种任务出现的次数进行统计
         */
        for (char task : tasks) {
            count[task - 'A']++;
        }
        /**
         * 将所有任务出现的此处按照递增顺序排序
         */
        Arrays.sort(count);
        /**
         * 出现次数最多的任务出现的次数maxFrequency
         */
        int maxFrequency = count[25];
        int maxFrequencyCount = 0;
        /**
         * 计算出现次数同为最多的任务的种类数maxFrequencyCount
         */
        for (int i = 25; i >= 0; i--) {
            if (count[i] == maxFrequency) {
                maxFrequencyCount++;
            } else {
                break;
            }
        }
        /**
         * 任选一种出现次数最多的任务，该种任务每两次执行之间必须有n个间隔可以用于执行其他任务或待命，
         * 则一共中间可以有(maxFrequency-1)*n个间隔，此时总时间为maxFrequency+(maxFrequency-1)*n，
         * 此时出现次数最多的任务还剩(maxFrequencyCount-1)种，总任务还剩(taskCount-maxFrequency)个。
         *
         * 例如：任务情况为A、A、A、B、B、B、C、C、C、D、D、D，冷却时间n=2，可以设置A、_、_、A、_、_、A
         * 这样的任务安排
         */
        int blankCount = (maxFrequency - 1) * n;
        int length = maxFrequency + blankCount;
        int taskCount = tasks.length;
        maxFrequencyCount--;
        taskCount -= maxFrequency;
        /**
         * 仍旧先执行出现次数最多的任务。
         *
         * 如果出现次数最多的任务剩余种类maxFrequencyCount不大于n种，那么对于每种任务，可以在之前的
         * (maxFrequency-1)*n个间隔中每隔n个间隔执行下同种任务，但是最后需要增加maxFrequencyCount个时
         * 间用于执行每种任务的最后一次任务，此时中间还剩blankCount/n*(n-maxFrequencyCount)个间隔可以
         * 用于执行其他任务或待命，总任务还剩(taskCount-maxFrequencyCount*maxFrequency)个。
         *
         * 例如：任务情况为A、A、A、B、B、B，冷却时间n=2，可以设置A、_、_、A、_、_、A这样的任务安排，执
         * 行B后，情况为A、B、_、A、B、_、A、B
         *
         * 如果出现次数最多的任务剩余种类maxFrequencyCount大于n种，那么先安排其中的n种任务，可以在之前的
         * (maxFrequency-1)*n个间隔中每隔n个间隔执行下同种任务，但是最后需要增加n个的时间用于执行每种任
         * 务的最后一次任务，此时中间还剩0个间隔可以用于执行其他任务或待命，总任务还剩(taskCount-n*maxFrequency)个。
         *
         * 例如：任务情况为A、A、A、B、B、B、C、C、C、D、D、D，冷却时间n=2，可以设置A、_、_、A、_、_、A
         * 这样的任务安排，执行B、C后，情况为A、B、C、A、B、C、A、B、C
         */
        if (maxFrequencyCount <= n) {
            length += maxFrequencyCount;
            blankCount = blankCount / n * (n - maxFrequencyCount);
            taskCount -= maxFrequencyCount * maxFrequency;
        } else {
            length += n;
            blankCount = 0;
            taskCount -= n * maxFrequency;
        }
        /**
         * 如果剩下还有没执行的任务，先在上面剩下的blankCount个间隔上安排，如果间隔不够，需要再增加
         * (taskCount - blankCount)个时间
         */
        length += Math.max(0, taskCount - blankCount);
        return length;
    }
}
