package leetcode.algorithms;

/**
 * Description: 2432. The Employee That Worked on the Longest Task
 *
 * @author Baltan
 * @date 2023/2/9 10:41
 */
public class HardestWorker {
    public static void main(String[] args) {
        System.out.println(hardestWorker(10, new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}}));
        System.out.println(hardestWorker(26, new int[][]{{1, 1}, {3, 7}, {2, 12}, {7, 17}}));
        System.out.println(hardestWorker(2, new int[][]{{0, 10}, {1, 20}}));
    }

    public static int hardestWorker(int n, int[][] logs) {
        int result = Integer.MAX_VALUE;
        int maxTime = Integer.MIN_VALUE;
        /**
         * 当前任务开始时间
         */
        int startTime = 0;

        for (int[] log : logs) {
            int time = log[1] - startTime;

            if (time > maxTime || (time == maxTime && log[0] < result)) {
                result = log[0];
                maxTime = time;
            }
            startTime = log[1];
        }
        return result;
    }
}
