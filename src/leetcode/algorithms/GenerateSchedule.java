package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3680. Generate Schedule
 *
 * @author Baltan
 * @date 2025/12/20 14:14
 */
public class GenerateSchedule {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(generateSchedule(3));
        System.out.println("---------------------------------");
        OutputUtils.print2DIntegerArray(generateSchedule(5));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/generate-schedule/solutions/3781174/gou-zao-ti-pythonjavacgo-by-endlesscheng-wtgu/"></a>
     *
     * @param n
     * @return
     */
    public static int[][] generateSchedule(int n) {
        if (n < 5) {
            return new int[][]{};
        }
        int[][] result = new int[n * (n - 1)][];
        int index = 0;
        /**
         * 依次排列比赛(0,distance)、(1,(1+distance)%n)、(2,(2+distance)%n)、……、(n-1,(n-1+distance)%n)，当distance不为1，且
         * 不为n-1时，可以保证相邻两场比赛的四支队伍没有重复
         */
        for (int distance = 2; distance < n - 1; distance++) {
            for (int i = 0; i < n; i++) {
                result[index++] = new int[]{i, (i + distance) % n};
            }
        }
        /**
         * 对于比赛(0,1)、(1,2)、(2,3)、……、(n-1,0)和比赛(n-1,n-2)、(0,n-1)、(1,0)、……、(n-2,n-3)，将它们依次交替排列，可以保证相邻
         * 两场比赛的四支队伍没有重复
         */
        for (int i = 0; i < n; i++) {
            result[index++] = new int[]{i, (i + 1) % n};
            result[index++] = new int[]{(i - 1 + n) % n, (i - 2 + n) % n};
        }
        return result;
    }
}
