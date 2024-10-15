package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 3314. Construct the Minimum Bitwise Array I
 *
 * @author baltan
 * @date 2024/10/14 09:07
 * @see MinBitwiseArray1
 */
public class MinBitwiseArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(minBitwiseArray(List.of(2, 3, 5, 7)));
        OutputUtils.print1DIntegerArray(minBitwiseArray(List.of(11, 13, 31)));
    }

    public static int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];
        /**
         * 根据题意，nums[i]∈[2,1000]
         */
        int max = 1000;
        /**
         * indexes[i]保存数组nums中所有元素i的索引值
         */
        List<Integer>[] indexes = new List[max + 1];
        Arrays.fill(result, -1);
        /**
         * 保存数组nums中每个元素的索引值
         */
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);

            if (indexes[num] == null) {
                indexes[num] = new ArrayList<>();
            }
            indexes[num].add(i);
        }
        /**
         * 因为按位或运算的结果总是大于原有值，所以result中的元素总是不会大于题意指定的最大值1000，为了求得最小值，从1000开始倒序逐一进行
         * 按位或运算即可
         */
        for (int i = max; i >= 0; i--) {
            int or = i | (i + 1);
            /**
             * 保存数组nums中元素or所在的索引值对应的result[i]
             */
            if (or <= max && indexes[or] != null) {
                for (int index : indexes[or]) {
                    result[index] = i;
                }
            }
        }
        return result;
    }
}
