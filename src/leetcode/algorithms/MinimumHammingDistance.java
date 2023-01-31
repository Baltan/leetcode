package leetcode.algorithms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Description: 1722. Minimize Hamming Distance After Swap Operations
 *
 * @author Baltan
 * @date 2023/1/30 12:51
 */
public class MinimumHammingDistance {
    public static void main(String[] args) {
        int[] source1 = {1, 2, 3, 4};
        int[] target1 = {2, 1, 4, 5};
        int[][] allowedSwaps1 = {{0, 1}, {2, 3}};
        System.out.println(minimumHammingDistance(source1, target1, allowedSwaps1));

        int[] source2 = {1, 2, 3, 4};
        int[] target2 = {1, 3, 2, 4};
        int[][] allowedSwaps2 = {};
        System.out.println(minimumHammingDistance(source2, target2, allowedSwaps2));

        int[] source3 = {5, 1, 2, 4, 3};
        int[] target3 = {1, 5, 4, 2, 3};
        int[][] allowedSwaps3 = {{0, 4}, {4, 2}, {1, 3}, {1, 4}};
        System.out.println(minimumHammingDistance(source3, target3, allowedSwaps3));
    }

    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int result = 0;
        int length = source.length;
        /**
         * parents[i]表示索引i的父索引
         */
        int[] parents = new int[length];
        /**
         * roots[i]表示索引i所在树的根索引
         */
        int[] roots = new int[length];
        Integer[] indexes = IntStream.range(0, length).boxed().toArray(Integer[]::new);
        /**
         * 初始化假设所有索引的父索引都是其自身
         */
        for (int i = 0; i < length; i++) {
            parents[i] = i;
        }
        /**
         * 并查集构建多个独立的索引集合
         */
        for (int[] allowedSwap : allowedSwaps) {
            union(parents, allowedSwap[0], allowedSwap[1]);
        }
        /**
         * 计算每个索引的根索引
         */
        for (int i = 0; i < length; i++) {
            roots[i] = getRoot(parents, i);
        }
        /**
         * 将所有索引按照其根索引分组，同一分组中的索引对应数组中的数字是可以相互交换位置的
         */
        Map<Integer, List<Integer>> map = Arrays.stream(indexes).collect(Collectors.groupingBy(x -> roots[x]));

        for (List<Integer> indexList : map.values()) {
            /**
             * 计算数组source和target在indexList指定的索引处的子数组的最小汉明距离
             */
            result += getHammingDistance(source, target, indexList);
        }
        return result;
    }

    /**
     * 计算数组source和target在indexList指定的索引处的子数组的最小汉明距离
     *
     * @param source
     * @param target
     * @param indexList
     * @return
     */
    public static int getHammingDistance(int[] source, int[] target, List<Integer> indexList) {
        int result = indexList.size();
        /**
         * 数字i -> 数组source中数字i的个数
         */
        Map<Integer, Integer> sourceMap = new HashMap<>();
        /**
         * 数字i -> 数组target中数字i的个数
         */
        Map<Integer, Integer> targetMap = new HashMap<>();
        /**
         * 对数组source和target中的数字计数
         */
        for (int index : indexList) {
            sourceMap.put(source[index], sourceMap.getOrDefault(source[index], 0) + 1);
            targetMap.put(target[index], targetMap.getOrDefault(target[index], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : sourceMap.entrySet()) {
            int num = entry.getKey();
            int sourceCount = entry.getValue();
            int targetCount = targetMap.getOrDefault(num, 0);
            /**
             * 可以通过位置交换实现数组source和target在Math.min(sourceCount,targetCount)个索引上的值都为num，减小了汉明距离
             */
            result -= Math.min(sourceCount, targetCount);
        }
        return result;
    }

    /**
     * 查找索引i的根索引
     *
     * @param parents
     * @param i
     * @return
     */
    public static int getRoot(int[] parents, int i) {
        while (parents[i] != i) {
            i = parents[i];
        }
        return i;
    }

    /**
     * 能否将索引x所在的集合和索引y所在的集合合并
     *
     * @param parents
     * @param x
     * @param y
     */
    public static void union(int[] parents, int x, int y) {
        int xRoot = getRoot(parents, x);
        int yRoot = getRoot(parents, y);

        if (xRoot != yRoot) {
            parents[yRoot] = xRoot;
        }
    }
}
