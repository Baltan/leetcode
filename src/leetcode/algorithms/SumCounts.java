package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: 2913. Subarrays Distinct Element Sum of Squares I
 *
 * @author baltan
 * @date 2023/11/1 09:09
 */
public class SumCounts {
    public static void main(String[] args) {
        System.out.println(sumCounts(Arrays.asList(1, 2, 1)));
        System.out.println(sumCounts(Arrays.asList(1, 1)));
    }

    public static int sumCounts(List<Integer> nums) {
        int result = 0;
        int size = nums.size();

        for (int i = 0; i < size; i++) {
            /**
             * 以nums[i]作为第一个元素的子数组中的不同元素
             */
            Set<Integer> set = new HashSet<>();

            for (int j = i; j < size; j++) {
                set.add(nums.get(j));
                result += set.size() * set.size();
            }
        }
        return result;
    }
}
