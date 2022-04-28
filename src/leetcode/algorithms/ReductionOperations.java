package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1887. Reduction Operations to Make the Array Elements Equal
 *
 * @author Baltan
 * @date 2022/4/27 19:14
 */
public class ReductionOperations {
    public static void main(String[] args) {
        System.out.println(reductionOperations(new int[]{5, 1, 3}));
        System.out.println(reductionOperations(new int[]{1, 1, 1}));
        System.out.println(reductionOperations(new int[]{1, 1, 2, 2, 3}));
    }

    public static int reductionOperations(int[] nums) {
        int result = 0;
        /**
         * 数字i -> i在数组nums中出现的次数
         */
        Map<Integer, Integer> countMap = new HashMap<>();
        /**
         * 数组nums中所有元素去重后升序排列
         */
        int[] sortedNums = Arrays.stream(nums)
                .distinct()
                .sorted()
                .toArray();
        /**
         * 对数组nums中每种数字出现的次数进行计数
         */
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        /**
         * sortedNums中每个数字的索引值，即为递减到sortedNums中最小值需要的操作次数
         */
        for (int i = 0; i < sortedNums.length; i++) {
            /**
             * 数字sortedNums[i]的操作数 * 数组nums中数字sortedNums[i]出现的次数
             */
            result += i * countMap.get(sortedNums[i]);
        }
        return result;
    }
}
