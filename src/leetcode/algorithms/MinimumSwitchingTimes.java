package leetcode.algorithms;

/**
 * Description: LCP 39. 无人机方阵
 *
 * @author Baltan
 * @date 2022/3/1 16:42
 */
public class MinimumSwitchingTimes {
    public static void main(String[] args) {
        int[][] source1 = {{1, 3}, {5, 4}};
        int[][] target1 = {{3, 1}, {6, 5}};
        System.out.println(minimumSwitchingTimes(source1, target1));

        int[][] source2 = {{1, 2, 3}, {3, 4, 5}};
        int[][] target2 = {{1, 3, 5}, {2, 3, 4}};
        System.out.println(minimumSwitchingTimes(source2, target2));
    }

    public static int minimumSwitchingTimes(int[][] source, int[][] target) {
        /**
         * source和target中不同颜色灯光的个数
         */
        int differentCount = 0;
        /**
         * 根据题意，灯光颜色最大为10000
         */
        int max = 10000;
        /**
         * source中每种颜色灯光的数量
         */
        int[] sourceCount = new int[max + 1];
        /**
         * target中每种颜色灯光的数量
         */
        int[] targetCount = new int[max + 1];
        int rows = source.length;
        int cols = source[0].length;
        /**
         * 对source和target中每种颜色灯光的数量进行计数
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sourceCount[source[i][j]]++;
                targetCount[target[i][j]]++;
            }
        }
        /**
         * 对source和target中不同颜色灯光的总数进行计数，其中一半修改下颜色即可
         */
        for (int i = 0; i <= max; i++) {
            differentCount += Math.abs(sourceCount[i] - targetCount[i]);
        }
        return differentCount / 2;
    }
}
