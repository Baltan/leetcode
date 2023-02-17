package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 2363. Merge Similar Items
 *
 * @author Baltan
 * @date 2023/2/14 09:31
 */
public class MergeSimilarItems {
    public static void main(String[] args) {
        int[][] items11 = {{1, 1}, {4, 5}, {3, 8}};
        int[][] items12 = {{3, 1}, {1, 5}};
        System.out.println(mergeSimilarItems(items11, items12));

        int[][] items21 = {{1, 1}, {3, 2}, {2, 3}};
        int[][] items22 = {{2, 1}, {3, 2}, {1, 3}};
        System.out.println(mergeSimilarItems(items21, items22));

        int[][] items31 = {{1, 3}, {2, 2}};
        int[][] items32 = {{7, 1}, {2, 2}, {1, 4}};
        System.out.println(mergeSimilarItems(items31, items32));
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> result = new ArrayList<>();
        /**
         * 根据题意，每个物品的价值∈[1,1000]
         */
        int max = 1000;
        /**
         * weights[i]表示价值为i的物品的总重量
         */
        int[] weights = new int[max + 1];

        for (int[] item : items1) {
            weights[item[0]] += item[1];
        }

        for (int[] item : items2) {
            weights[item[0]] += item[1];
        }

        for (int i = 1; i <= max; i++) {
            if (weights[i] != 0) {
                result.add(Arrays.asList(i, weights[i]));
            }
        }
        return result;
    }
}
