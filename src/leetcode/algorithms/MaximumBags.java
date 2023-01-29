package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Description: 2279. Maximum Bags With Full Capacity of Rocks
 *
 * @author Baltan
 * @date 2023/1/22 16:35
 */
public class MaximumBags {
    public static void main(String[] args) {
        System.out.println(maximumBags(new int[]{2, 3, 4, 5}, new int[]{1, 2, 4, 4}, 2));
        System.out.println(maximumBags(new int[]{10, 2, 2}, new int[]{2, 2, 0}, 100));
    }

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int result = 0;
        Integer[] indexes = IntStream.range(0, capacity.length).boxed().toArray(Integer[]::new);
        /**
         * 将所有索引按照背包剩余容量升序排列
         */
        Arrays.sort(indexes, Comparator.comparingInt(x -> (capacity[x] - rocks[x])));
        /**
         * 按序在背包中装石头，尽可能将每个背包装满
         */
        for (int index : indexes) {
            /**
             * 背包中还能装的石头的数量
             */
            int diff = capacity[index] - rocks[index];

            if (additionalRocks >= diff) {
                result++;
                additionalRocks -= diff;
            } else {
                break;
            }
        }
        return result;
    }
}
