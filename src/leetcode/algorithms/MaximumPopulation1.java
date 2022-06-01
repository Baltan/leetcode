package leetcode.algorithms;

/**
 * Description: 1854. Maximum Population Year
 *
 * @author Baltan
 * @date 2022/5/31 22:55
 * @see MaximumPopulation
 */
public class MaximumPopulation1 {
    public static void main(String[] args) {
        int[][] logs1 = {{1993, 1999}, {2000, 2010}};
        System.out.println(maximumPopulation(logs1));

        int[][] logs2 = {{1950, 1961}, {1960, 1971}, {1970, 1981}};
        System.out.println(maximumPopulation(logs2));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/maximum-population-year/solution/ren-kou-zui-duo-de-nian-fen-by-leetcode-5m7r4/"></a>
     *
     * @param logs
     * @return
     */
    public static int maximumPopulation(int[][] logs) {
        int result = 0;
        /**
         * 根据题意，出生年份和死亡年份在[1950,2050]范围内，populations[0]-populations[100]依次表示1950年-2050年每年的
         * 人口数变化数
         */
        int[] populations = new int[2050 - 1950 + 1];
        int max = Integer.MIN_VALUE;
        /**
         * 从起始开始到某一年的累计人口变化数
         */
        int current = 0;
        /**
         * 统计每年的人口数变化数
         */
        for (int[] log : logs) {
            int birth = log[0] - 1950;
            int death = log[1] - 1950;
            populations[birth]++;
            populations[death]--;
        }
        /**
         * 查找人口变化数最大的最小年份
         */
        for (int i = 0; i < populations.length; i++) {
            current += populations[i];

            if (current > max) {
                max = current;
                result = i + 1950;
            }
        }
        return result;
    }
}
