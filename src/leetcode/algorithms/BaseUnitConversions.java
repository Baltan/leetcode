package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: 3528. Unit Conversion I
 *
 * @author Baltan
 * @date 2025/5/5 18:17
 */
public class BaseUnitConversions {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(baseUnitConversions(new int[][]{{0, 1, 1000000000}, {1, 2, 1000000000}}));
        OutputUtils.print1DIntegerArray(baseUnitConversions(new int[][]{{0, 1, 2}, {1, 2, 3}}));
        OutputUtils.print1DIntegerArray(baseUnitConversions(new int[][]{{0, 1, 2}, {0, 2, 3}, {1, 3, 4}, {1, 4, 5}, {2, 5, 2}, {4, 6, 3}, {5, 7, 4}}));
    }

    public static int[] baseUnitConversions(int[][] conversions) {
        int[] result = new int[conversions.length + 1];
        long[] baseUnitConversion = new long[conversions.length + 1];
        int mod = 1000000007;
        /**
         * 构建图，单位i -> 已知从单位i可以直接换算的其他单位集合
         */
        Map<Integer, List<int[]>> graph = Arrays.stream(conversions)
                .collect(Collectors.groupingBy(x -> x[0]));
        /**
         * 保存所有已知和单位0换算关系的单位
         */
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        baseUnitConversion[0] = 1;
        /**
         * 从单位0开始广度优先搜索计算单位0和其他所有单位的转换关系
         */
        while (!queue.isEmpty()) {
            int sourceUnit = queue.poll();
            List<int[]> conversionList = graph.get(sourceUnit);

            if (conversionList != null) {
                for (int[] conversion : conversionList) {
                    /**
                     * 1个单位0等于result[sourceUnit]个单位sourceUnit，1个单位sourceUnit等于conversion[2]个单位conversion[1]，
                     * 所以1个单位0等于result[sourceUnit]*conversion[2]个单位conversion[1]
                     */
                    baseUnitConversion[conversion[1]] = baseUnitConversion[sourceUnit] * conversion[2] % mod;
                    queue.offer(conversion[1]);
                }
            }
        }

        for (int i = 0; i <= conversions.length; i++) {
            result[i] = (int) baseUnitConversion[i];
        }
        return result;
    }
}
