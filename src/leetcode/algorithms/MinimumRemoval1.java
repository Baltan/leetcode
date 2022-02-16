package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2170. Minimum Operations to Make the Array Alternating
 *
 * @author Baltan
 * @date 2022/2/15 08:52
 */
public class MinimumRemoval1 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(
                new int[]{69, 91, 47, 74, 75, 94, 22, 100, 43, 50, 82, 47, 40, 51, 90, 27, 98, 85, 47, 14, 55,
                        82, 52, 9, 65, 90, 86, 45, 52, 52, 95, 40, 85, 3, 46, 77, 16, 59, 32, 22, 41, 87, 89,
                        78, 59, 78, 34, 26, 71, 9, 82, 68, 80, 74, 100, 6, 10, 53, 84, 80, 7, 87, 3, 82, 26,
                        26, 14, 37, 26, 58, 96, 73, 41, 2, 79, 43, 56, 74, 30, 71, 6, 100, 72, 93, 83, 40, 28,
                        79, 24}));
        System.out.println(minimumOperations(new int[]{3, 1, 3, 2, 4, 3}));
        System.out.println(minimumOperations(new int[]{1, 2, 2, 2, 2}));
        System.out.println(minimumOperations(new int[]{2, 2, 2, 2, 2}));
        System.out.println(minimumOperations(new int[]{2, 2, 2, 2, 2, 2}));
        System.out.println(minimumOperations(new int[]{2}));
        System.out.println(minimumOperations(new int[]{1, 2, 3}));
        System.out.println(minimumOperations(new int[]{3, 2, 3}));
    }

    public static int minimumOperations(int[] nums) {
        int length = nums.length;

        if (nums.length == 1) {
            return 0;
        }
        /**
         * 对偶数索引位置上的元素个数计数
         */
        Map<Integer, Integer> evenCountMap = new HashMap<>();
        /**
         * 对奇数索引位置上的元素个数计数
         */
        Map<Integer, Integer> oddCountMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                evenCountMap.put(nums[i], evenCountMap.getOrDefault(nums[i], 0) + 1);
            } else {
                oddCountMap.put(nums[i], oddCountMap.getOrDefault(nums[i], 0) + 1);
            }
        }
        /**
         * 奇数索引位置上的数字总个数
         */
        int oddTotalCount = length / 2;
        /**
         * 偶数索引位置上的数字总个数
         */
        int evenTotalCount = length - oddTotalCount;
        ArrayList<Map.Entry<Integer, Integer>> evenEntryList = new ArrayList<>(evenCountMap.entrySet());
        ArrayList<Map.Entry<Integer, Integer>> oddEntryList = new ArrayList<>(oddCountMap.entrySet());
        /**
         * 按照元素出现的次数倒序排列
         */
        Collections.sort(evenEntryList, (x, y) -> y.getValue() - x.getValue());
        Collections.sort(oddEntryList, (x, y) -> y.getValue() - x.getValue());
        /**
         * 如果奇数索引位置上出现最多的数字和偶数索引位置上出现最多的数字不同，则将剩下的数字修改为和这两个数字相同即可。如果奇数
         * 索引位置上出现最多的数字和偶数索引位置上出现最多的数字相同，则将这两者中一个保留出现次数最多的数字，另一个保留出现次数
         * 第二多的数字即可
         */
        if (!Objects.equals(evenEntryList.get(0).getKey(), oddEntryList.get(0).getKey())) {
            return (evenTotalCount - evenEntryList.get(0).getValue()) +
                    (oddTotalCount - oddEntryList.get(0).getValue());
        } else {
            return Math.min(
                    /**
                     * 偶数索引位置上保留出现次数最多的数字，奇数索引位置上保留出现次数第二多的数字
                     */
                    (evenTotalCount - evenEntryList.get(0).getValue()) +
                            (oddTotalCount - (oddEntryList.size() == 1 ? 0 : oddEntryList.get(1).getValue())),
                    /**
                     * 偶数索引位置上保留出现次数第二多的数字，奇数索引位置上保留出现次数最多的数字
                     */
                    (evenTotalCount - (evenEntryList.size() == 1 ? 0 : evenEntryList.get(1).getValue())) +
                            (oddTotalCount - oddEntryList.get(0).getValue()));
        }
    }
}
