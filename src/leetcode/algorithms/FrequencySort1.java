package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Description: 1636. Sort Array by Increasing Frequency
 *
 * @author Baltan
 * @date 2022/9/22 09:24
 */
public class FrequencySort1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(frequencySort(new int[]{1, 1, 2, 2, 2, 3}));
        OutputUtils.print1DIntegerArray(frequencySort(new int[]{2, 3, 1, 3, 2}));
        OutputUtils.print1DIntegerArray(frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1}));
    }

    public static int[] frequencySort(int[] nums) {
        int[] result = new int[nums.length];
        /**
         * 根据题意，数组nums中的数字∈[-100,100]，最多可能有201种值
         */
        final int COUNT = 201;
        /**
         * frequencies[i]表示数组nums中数字i-100出现过的次数
         */
        int[] frequencies = new int[COUNT];
        /**
         * 得到索引数组[0,1,2,3,……,200]
         */
        Integer[] indexes = IntStream.range(0, COUNT).boxed().toArray(Integer[]::new);
        int position = 0;
        /**
         * 统计数组nums中每个数字出现过的次数
         */
        for (int num : nums) {
            frequencies[num + 100]++;
        }
        /**
         * 索引数组排序：按照索引代表的数字index-100在数组nums中出现的次数升序排列，如果出现的次数相同，则按照数字大小降序排列
         */
        Arrays.sort(indexes, (x, y) -> {
            if (frequencies[x] == frequencies[y]) {
                return y - x;
            } else {
                return frequencies[x] - frequencies[y];
            }
        });

        for (int index : indexes) {
            /**
             * 说明数字index-100在数组nums中不存在
             */
            if (frequencies[index] == 0) {
                continue;
            }
            int num = index - 100;
            /**
             * 数字index-100在数组nums中出现了frequencies[index]次
             */
            for (int i = 0; i < frequencies[index]; i++) {
                result[position++] = num;
            }
        }
        return result;
    }
}
