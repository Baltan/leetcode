package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2845. Count of Interesting Subarrays
 *
 * @author baltan
 * @date 2023/9/5 10:00
 */
public class CountInterestingSubarrays {
    public static void main(String[] args) {
        System.out.println(countInterestingSubarrays(Arrays.asList(1, 100000), 1000000000, 1));
        System.out.println(countInterestingSubarrays(Arrays.asList(1, 2, 1, 2, 1, 2), 2, 1));
        System.out.println(countInterestingSubarrays(Arrays.asList(7, 2), 7, 0));
        System.out.println(countInterestingSubarrays(Arrays.asList(3, 2, 4), 2, 1));
        System.out.println(countInterestingSubarrays(Arrays.asList(3, 1, 9, 6), 3, 0));
    }

    public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long result = 0L;
        /**
         * 数组nums中相邻的两个除以modulo余k的数之间间隔几个数字
         */
        int interval = 0;
        /**
         * 将数组nums中的数字用所有除以modulo余k的数隔开，记录每个间隔中被子数组截取的方案数
         */
        List<Integer> selections = new ArrayList<>();

        for (int num : nums) {
            if (num % modulo == k) {
                /**
                 * 数组nums中相邻的两个除以modulo余k的数之间间隔interval个数字，则在截取子数组时，次间隔中可选的数字个数为[0,interval]
                 */
                selections.add(interval + 1);
                /**
                 * 重置用于计算下一个间隔
                 */
                interval = 0;
            } else {
                interval++;
            }
        }
        /**
         * 数组nums中最后一个除以modulo余k的数之后的数字个数为interval
         */
        selections.add(interval + 1);
        /**
         * 数组selections中除以modulo的余数i -> 数组selections中所有除以modulo的余数为i的索引值构成的数组的前缀和
         */
        Map<Integer, List<Integer>> prefixSumsMap = new HashMap<>();

        for (int i = 0; i < selections.size(); i++) {
            int row = i % modulo;
            List<Integer> prefixSums = prefixSumsMap.computeIfAbsent(row, x -> new ArrayList<>(Arrays.asList(0)));
            prefixSums.add(prefixSums.get(prefixSums.size() - 1) + selections.get(i));
        }
        /**
         * 将子数组的左端点放在selections[i]对应nums的间隔内
         */
        for (int i = 0; i < selections.size(); i++) {
            if (k == 0) {
                /**
                 * 间隔内的selections[i]-1个元素可以构成长度为[1,selections[i]-1]的子数组，共有1+2+……+(selections[i]-1)种情况
                 */
                int count = selections.get(i) - 1;
                result += (long) (count + 1) * count / 2;
            }
            /**
             * 如果子数组中至少有一个除以modulo余k的数，因为左端点位于selections[i]区间，所以右端点至少在selections[i+k]区间，并且当k
             * 为0时，右端点至少在selections[i+modulo]区间
             */
            int first = i + (k == 0 ? modulo : k);
            /**
             * 不存在符合条件的右端点，直接退出
             */
            if (first >= selections.size()) {
                continue;
            }
            /**
             * 选择数组selections中所有除以modulo余数为row的索引
             */
            int row = (i + k) % modulo;
            List<Integer> prefixSums = prefixSumsMap.get(row);
            /**
             * 右端点可选方案数为selections[first]+selections[first+modulo]+……+selections[first+k*modulo]
             */
            result += (long) selections.get(i) * (prefixSums.get(prefixSums.size() - 1) - prefixSums.get(first / modulo));
        }
        return result;
    }
}
