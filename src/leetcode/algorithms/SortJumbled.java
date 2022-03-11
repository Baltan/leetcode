package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 2191. Sort the Jumbled Numbers
 *
 * @author Baltan
 * @date 2022/3/10 17:41
 */
public class SortJumbled {
    public static void main(String[] args) {
        int[] mapping1 = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums1 = {991, 338, 38};
        OutputUtils.print1DIntegerArray(sortJumbled(mapping1, nums1));

        int[] mapping2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums2 = {789, 456, 123};
        OutputUtils.print1DIntegerArray(sortJumbled(mapping2, nums2));

        int[] mapping3 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] nums3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        OutputUtils.print1DIntegerArray(sortJumbled(mapping3, nums3));
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;
        /**
         * i -> 映射后为值为i的nums中的数字列表，按nums中出现的顺序排列
         */
        Map<Integer, List<Integer>> map = new TreeMap<>(Comparator.comparingInt(x -> x));

        for (int num : nums) {
            /**
             * 原数字
             */
            int originalNum = num;
            /**
             * 映射后的数字
             */
            int mappedNum = 0;
            /**
             * 如果num为0，直接映射到mapping[0]；否则将num逐位映射
             */
            if (num == 0) {
                mappedNum = mapping[0];
            } else {
                /**
                 * 映射数位的权重（个位、十位、百位……）
                 */
                int weight = 1;

                while (num > 0) {
                    int digit = num % 10;
                    num /= 10;
                    mappedNum += mapping[digit] * weight;
                    weight *= 10;
                }
            }
            List<Integer> originalNums = map.computeIfAbsent(mappedNum, i -> new LinkedList<>());
            originalNums.add(originalNum);
        }
        /**
         * 按映射后的数字从小到大取出原数字
         */
        for (List<Integer> originalNums : map.values()) {
            for (int originalNum : originalNums) {
                result[index++] = originalNum;
            }
        }
        return result;
    }
}
