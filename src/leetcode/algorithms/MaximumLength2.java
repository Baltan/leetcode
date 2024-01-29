package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3020. Find the Maximum Number of Elements in Subset
 *
 * @author Baltan
 * @date 2024/1/28 18:30
 */
public class MaximumLength2 {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{1, 1}));
        System.out.println(maximumLength(new int[]{5, 4, 1, 2, 2}));
        System.out.println(maximumLength(new int[]{1, 3, 2, 4}));
    }

    public static int maximumLength(int[] nums) {
        /**
         * 子集中至少有一个元素
         */
        int result = 1;
        /**
         * 数字i -> 数组nums中数字i的个数
         */
        Map<Integer, Integer> countMap = new HashMap<>();
        /**
         * isVisited[i]表示数字i是否在之前的子集中已被使用过
         */
        Set<Integer> isVisited = new HashSet<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        /**
         * 子集中的元素全为1的情况
         */
        if (countMap.containsKey(1)) {
            int count = countMap.get(1);
            result = Math.max(result, count % 2 == 1 ? count : count - 1);
        }
        /**
         * 考虑以entry.getKey()作为子集中的最小元素
         */
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            /**
             * 跳过子集中的元素全为1的情况，已计算过
             */
            if (entry.getKey() == 1) {
                continue;
            }
            /**
             * 如果数字entry.getKey()在之前的子集中已被使用过，则不需要再重复计算；如果数字entry.getKey()在数组nums中只有1个，则只能将
             * 其单独作为一个子集
             */
            if (isVisited.contains(entry.getKey()) || entry.getValue() == 1) {
                continue;
            }
            int subsetLength = 0;

            for (int i = entry.getKey(); ; i = i * i) {
                isVisited.add(i);
                int count = countMap.getOrDefault(i, 0);

                if (count == 0) {
                    /**
                     * 只能以上一次循环的i作为子集的中间元素x^k，而子集中有2个i，需要删除一个
                     */
                    result = Math.max(result, subsetLength - 1);
                    break;
                } else if (count == 1) {
                    /**
                     * 以i作为子集的中间元素x^k
                     */
                    result = Math.max(result, subsetLength + 1);
                    break;
                } else {
                    /**
                     * 将2个元素i加入子集中
                     */
                    subsetLength += 2;
                }
            }
        }
        return result;
    }
}
