package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 1665. Minimum Initial Energy to Finish Tasks
 *
 * @author Baltan
 * @date 2024/1/14 00:46
 */
public class MinimumEffort {
    public static void main(String[] args) {
        System.out.println(minimumEffort(new int[][]{{1, 2}, {2, 4}, {4, 8}}));
        System.out.println(minimumEffort(new int[][]{{1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}}));
        System.out.println(minimumEffort(new int[][]{{1, 7}, {2, 8}, {3, 9}, {4, 10}, {5, 11}, {6, 12}}));
    }

    public static int minimumEffort(int[][] tasks) {
        int result = 0;
        /**
         * 对于每一项任务来说，x[1]-x[0]为完成这项任务浪费的能量，因为实际只需要x[0]，却必须要准备x[1]。越是浪费的多的任务，应该尽可能地排
         * 在后面，否则初始能量如果被过早地浪费可能导致后面的任务能量不足。将所有任务按照浪费能量升序排列
         */
        Arrays.sort(tasks, Comparator.comparingInt(x -> (x[1] - x[0])));

        for (int[] task : tasks) {
            /**
             * 任务task实际只需要能量result+task[0]，但是至少要准备task[1]，两者取较大值
             */
            result = Math.max(result + task[0], task[1]);
        }
        return result;
    }
}
