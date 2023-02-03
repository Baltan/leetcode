package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2285. Maximum Total Importance of Roads
 *
 * @author Baltan
 * @date 2023/1/21 15:14
 */
public class MaximumImportance {
    public static void main(String[] args) {
        System.out.println(maximumImportance(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}}));
        System.out.println(maximumImportance(5, new int[][]{{0, 3}, {2, 4}, {1, 3}}));
    }

    public static long maximumImportance(int n, int[][] roads) {
        long result = 0L;
        /**
         * counts[i]表示和城市i相连的其他城市的数量，即计算所有道路重要性之和时，城市i的数值会被累加的次数
         */
        int[] counts = new int[n];
        /**
         * 待分配给城市的数值
         */
        int value = n;

        for (int[] road : roads) {
            counts[road[0]]++;
            counts[road[1]]++;
        }
        /**
         * 只需为有相邻城市的城市分配数值，并且将这些城市被累加的次数按照升序排列
         */
        counts = Arrays.stream(counts).filter(x -> x > 0).sorted().toArray();
        /**
         * 城市数值被累加的次数越多，分配的数值就越大
         */
        for (int i = counts.length - 1; i >= 0; i--) {
            result += 1L * counts[i] * value--;
        }
        return result;
    }
}
