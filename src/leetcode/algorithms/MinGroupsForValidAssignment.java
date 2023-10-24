package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2910. Minimum Number of Groups to Create a Valid Assignment
 *
 * @author Baltan
 * @date 2023/10/22 20:28
 */
public class MinGroupsForValidAssignment {
    public static void main(String[] args) {
        System.out.println(minGroupsForValidAssignment(new int[]{3, 2, 3, 2, 3}));
        System.out.println(minGroupsForValidAssignment(new int[]{10, 10, 10, 3, 1, 1}));
    }

    public static int minGroupsForValidAssignment(int[] nums) {
        /**
         * 元素i -> 数组nums中元素i的个数
         */
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        /**
         * 数组nums中出现次数最少的元素出现的次数
         */
        int min = Integer.MAX_VALUE;

        for (int count : countMap.values()) {
            min = Math.min(min, count);
        }
        /**
         * 数组nums中，对于只出现过min次的元素，分配后每组的元素个数至多为min+1，才有可能使该元素满足题意要求。令最终分配中，一部分数组中元
         * 素的个数为i个，一部分数组中元素的个数为i-1个
         */
        outer:
        for (int i = min + 1; i > 0; i--) {
            /**
             * 当前分配下最终得到的组数
             */
            int total = 0;

            for (int count : countMap.values()) {
                /**
                 * 尽可能地先把当前元素按照较大组分配，至多可以分配的组数
                 */
                int groups = count / i;
                /**
                 * 剩余当前元素的个数
                 */
                int remainder = count - groups * i;

                if (remainder == 0) {
                    total += groups;
                } else {
                    /**
                     * 剩余元素最终只能被分配到较小组中，如果不足i-1个，可以从每个较大组中各抽掉1个到较小组中，如果还不足以凑够i-1个，说明
                     * 这种分配方案不可行
                     */
                    if (i - 1 - remainder > groups) {
                        continue outer;
                    }
                    /**
                     * 最终得到group个较大组和1个较小组
                     */
                    total += groups + 1;
                }
            }
            return total;
        }
        return 1;
    }
}
