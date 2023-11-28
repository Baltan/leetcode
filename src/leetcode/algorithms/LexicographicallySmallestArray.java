package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Description: 2948. Make Lexicographically Smallest Array by Swapping Elements
 *
 * @author baltan
 * @date 2023/11/27 14:31
 */
public class LexicographicallySmallestArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(lexicographicallySmallestArray(new int[]{1, 5, 3, 9, 8}, 2));
        OutputUtils.print1DIntegerArray(lexicographicallySmallestArray(new int[]{1, 7, 6, 18, 2, 1}, 3));
        OutputUtils.print1DIntegerArray(lexicographicallySmallestArray(new int[]{1, 7, 28, 19, 10}, 3));
    }

    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] result = new int[nums.length];
        int length = nums.length;
        Integer[] indexes = IntStream.range(0, length).boxed().toArray(Integer[]::new);
        /**
         * 将数组nums的所有索引按照索引对应的元素升序排列
         */
        Arrays.sort(indexes, Comparator.comparingInt(x -> nums[x]));
        /**
         * 可以相互交换位置的一组索引
         */
        List<Integer> groupIndexes = new ArrayList<>();
        /**
         * 可以相互交换位置的一组元素
         */
        List<Integer> groupValues = new ArrayList<>();
        groupIndexes.add(indexes[0]);
        groupValues.add(nums[indexes[0]]);

        for (int i = 1; i <= length; i++) {
            /**
             * 数组nums中所有元素已被分组完，或当前元素不能和之前的元素相互交换位置
             */
            if (i == length || nums[indexes[i]] - nums[indexes[i - 1]] > limit) {
                Collections.sort(groupIndexes);
                Collections.sort(groupValues);
                /**
                 * 将该组所有元素按照升序依次填入到改组的索引中
                 */
                for (int j = 0; j < groupIndexes.size(); j++) {
                    result[groupIndexes.get(j)] = groupValues.get(j);
                }
                groupIndexes.clear();
                groupValues.clear();
            }
            /**
             * 收集可以相互交换位置的一组索引及其对应的元素
             */
            if (i != length) {
                groupIndexes.add(indexes[i]);
                groupValues.add(nums[indexes[i]]);
            }
        }
        return result;
    }
}
