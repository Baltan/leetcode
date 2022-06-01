package leetcode.algorithms;

/**
 * Description: 1854. Maximum Population Year
 *
 * @author Baltan
 * @date 2022/5/31 22:55
 */
public class MaximumPopulation {
    public static void main(String[] args) {
        int[][] logs1 = {{1993, 1999}, {2000, 2010}};
        System.out.println(maximumPopulation(logs1));

        int[][] logs2 = {{1950, 1961}, {1960, 1971}, {1970, 1981}};
        System.out.println(maximumPopulation(logs2));
    }

    public static int maximumPopulation(int[][] logs) {
        int result = 0;
        /**
         * 根据题意，出生年份和死亡年份在[1950,2050]范围内，populations[0]-populations[100]依次表示1950年-2050年每年的
         * 人口数
         */
        int[] populations = new int[2050 - 1950 + 1];
        int max = Integer.MIN_VALUE;
        /**
         * 统计每年的人口数
         */
        for (int[] log : logs) {
            int birth = log[0] - 1950;
            int death = log[1] - 1950;

            for (int i = birth; i < death; i++) {
                populations[i]++;
            }
        }
        /**
         * 查找人口最多的最小年份
         */
        for (int i = 0; i < populations.length; i++) {
            if (populations[i] > max) {
                max = populations[i];
                result = i + 1950;
            }
        }
        return result;
    }
}
