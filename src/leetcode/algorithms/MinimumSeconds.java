package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2808. Minimum Seconds to Equalize a Circular Array
 *
 * @author Baltan
 * @date 2023/8/9 22:27
 */
public class MinimumSeconds {
    public static void main(String[] args) {
        System.out.println(minimumSeconds(Arrays.asList(1, 2, 1, 2)));
        System.out.println(minimumSeconds(Arrays.asList(2, 1, 3, 3, 2)));
        System.out.println(minimumSeconds(Arrays.asList(5, 5, 5, 5)));
    }

    public static int minimumSeconds(List<Integer> nums) {
        int result = Integer.MAX_VALUE;
        int length = nums.size();
        /**
         * 数字i -> 数字i在nums中的所在位置的索引（按照升序排列）
         */
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            map.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }
        /**
         * 假设indexes为数组nums中所有数字num的索引值，计算将数组中所有元素都变为num需要的最少操作次数
         */
        for (List<Integer> indexes : map.values()) {
            /**
             * 使得数组nums中所有元素都变为num需要的最少操作次数
             */
            int maxOperations = 0;
            int size = indexes.size();
            /**
             * 如果数组nums中只有一个数字num，其索引为m，则它使得数组nums中所有元素都变为num需要的操作次数为Math.max(m,length-1-m)
             */
            if (size == 1) {
                maxOperations = Math.max(indexes.get(0), length - 1 - indexes.get(0));
            }

            for (int i = 1; i < size; i++) {
                /**
                 * 数组nums中相邻的两个数字num，假设它们的索引为m和n，则使得它们之间的元素都变为num的最少操作次数为(n-m)/2
                 */
                maxOperations = Math.max(maxOperations, (indexes.get(i) - indexes.get(i - 1)) / 2);
            }
            /**
             * 数组nums中第一个和最后一个数字num，假设它们的索引为m和n，则使得nums.subList[0,m]和nums.subList[n,length-1]这部分元素
             * 都变为num的最少操作次数为(m+length-n)/2
             */
            maxOperations = Math.max(maxOperations, (indexes.get(0) + length - indexes.get(size - 1)) / 2);
            result = Math.min(result, maxOperations);
        }
        return result;
    }
}
