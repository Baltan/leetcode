package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3159. Find Occurrences of an Element in an Array
 *
 * @author baltan
 * @date 2024/5/27 09:01
 */
public class OccurrencesOfElement {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(occurrencesOfElement(new int[]{1, 3, 1, 7}, new int[]{1, 3, 2, 4}, 1));
        OutputUtils.print1DIntegerArray(occurrencesOfElement(new int[]{1, 2, 3}, new int[]{10}, 5));
    }

    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] result = new int[queries.length];
        /**
         * 依次保存数组nums中元素x出现的索引值
         */
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                indexes.add(i);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            result[i] = queries[i] > indexes.size() ? -1 : indexes.get(queries[i] - 1);
        }
        return result;
    }
}
