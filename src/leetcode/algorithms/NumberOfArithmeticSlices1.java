package leetcode.algorithms;

import java.util.*;

/**
 * Description: 446. Arithmetic Slices II - Subsequence
 *
 * @author Baltan
 * @date 2024/7/27 16:10
 */
public class NumberOfArithmeticSlices1 {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{15, 19, 19, 23, 23}));
        System.out.println(numberOfArithmeticSlices(new int[]{79, 20, 64, 28, 67, 81, 60, 58, 97, 85, 92, 96, 82, 89, 46, 50, 15, 2, 36, 44, 54, 2, 90, 37, 7, 79, 26, 40, 34, 67, 64, 28, 60, 89, 46, 31, 9, 95, 43, 19, 47, 64, 48, 95, 80, 31, 47, 19, 72, 99, 28, 46, 13, 9, 64, 4, 68, 74, 50, 28, 69, 94, 93, 3, 80, 78, 23, 80, 43, 49, 77, 18, 68, 28, 13, 61, 34, 44, 80, 70, 55, 85, 0, 37, 93, 40, 47, 47, 45, 23, 26, 74, 45, 67, 34, 20, 33, 71, 48, 96}));
        System.out.println(numberOfArithmeticSlices(new int[]{2147483638, 2147483639, 2147483640, 2147483641, 2147483642, 2147483643, 2147483644, 2147483645, 2147483646, 2147483647, -2147483648, -2147483647, -2147483646, -2147483645, -2147483644, -2147483643, -2147483642, -2147483641, -2147483640, -2147483639}));
        System.out.println(numberOfArithmeticSlices(new int[]{2, 2, 3, 4}));
        System.out.println(numberOfArithmeticSlices(new int[]{0, 2000000000, -294967296}));
        System.out.println(numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
        System.out.println(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        /**
         * 数组nums中所有递增等差子序列的数量
         */
        result += countIncrementSequence(nums);
        /**
         * 在数组nums中所有常数等差子序列的数量
         */
        result += countConstantSequence(nums);
        /**
         * 将数组nums翻转后，计算新数组中所有递增等差子序列的数量，相当于在原数组nums中计算所有递减等差子序列的数量
         */
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        /**
         * 数组nums中所有递减等差子序列的数量
         */
        result += countIncrementSequence(nums);
        return result;
    }

    /**
     * 在数组nums中计算所有递增等差子序列的数量
     *
     * @param nums
     * @return
     */
    public static int countIncrementSequence(int[] nums) {
        int result = 0;
        /**
         * i -> {j -> {k -> v}}表示最后一个数字为i，步长为j，长度为k的递增等差子序列的个数为v
         */
        Map<Integer, Map<Integer, Map<Integer, Integer>>> dp = new HashMap<>();
        /**
         * i -> v表示此前数字i已出现的次数为v
         */
        Map<Integer, Integer> counts = new HashMap<>();
        /**
         * 此前已出现过的数字
         */
        Set<Integer> prevNums = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
            /**
             * 判断数字nums[i]是否可以追加在此前已出现过的数字prevNum后构成递增等差子序列
             */
            for (int prevNum : prevNums) {
                /**
                 * 数字nums[i]不可能和prevNum构成递增等差子序列
                 */
                if (nums[i] <= prevNum) {
                    continue;
                }
                int step = nums[i] - prevNum;
                /**
                 * 超过整型范围的情况
                 */
                if (prevNum + step != nums[i]) {
                    continue;
                }
                /**
                 * 最后一个数字为prevNum，步长为step的的递增等差子序列长度 -> 数量
                 */
                Map<Integer, Integer> prevMap = dp.getOrDefault(prevNum, Collections.emptyMap()).getOrDefault(step, Collections.emptyMap());
                /**
                 * 最后一个数字为nums[i]，步长为step的的递增等差子序列长度 -> 数量
                 */
                Map<Integer, Integer> iMap = dp.computeIfAbsent(nums[i], x -> new HashMap<>())
                        .computeIfAbsent(step, x -> new HashMap<>());
                /**
                 * prevNum和nums[i]构成长度为2的递增等差子序列
                 */
                iMap.put(2, iMap.getOrDefault(2, 0) + counts.get(prevNum));
                /**
                 * 最后两个元素依次为prevNum和nums[i]，且长度至少为3的递增等差子序列
                 */
                prevMap.forEach((k, v) -> iMap.put(k + 1, iMap.getOrDefault(k + 1, 0) + v));
            }
            prevNums.add(nums[i]);
        }

        for (Map.Entry<Integer, Map<Integer, Map<Integer, Integer>>> entry1 : dp.entrySet()) {
            for (Map.Entry<Integer, Map<Integer, Integer>> entry2 : entry1.getValue().entrySet()) {
                for (Map.Entry<Integer, Integer> entry3 : entry2.getValue().entrySet()) {
                    if (entry3.getKey() >= 3) {
                        result += entry3.getValue();
                    }
                }
            }
        }
        return result;
    }

    /**
     * 在数组nums中计算所有常数等差子序列的数量
     *
     * @param nums
     * @return
     */
    public static int countConstantSequence(int[] nums) {
        int result = 0;
        /**
         * i -> v表示数组nums中数字i出现的次数为v
         */
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for (int count : counts.values()) {
            if (count >= 3) {
                /**
                 * count个数字i可以构成的常数等差子序列的数量为：
                 * C(count,3)+C(count,4)+……+C(count,count)
                 * =2^count-C(count,0)-C(count,1)-C(count,2)
                 * =2^count-1-count-count*(count-1)/2
                 */
                result += (1 << count) - 1 - count - count * (count - 1) / 2;
            }
        }
        return result;
    }
}
