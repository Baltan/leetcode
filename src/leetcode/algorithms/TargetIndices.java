package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 2089. Find Target Indices After Sorting Array
 *
 * @author Baltan
 * @date 2021/11/28 14:31
 */
public class TargetIndices {
    public static void main(String[] args) {
        System.out.println(targetIndices(new int[]{1, 2, 5, 2, 3}, 2));
        System.out.println(targetIndices(new int[]{1, 2, 5, 2, 3}, 3));
        System.out.println(targetIndices(new int[]{1, 2, 5, 2, 3}, 5));
        System.out.println(targetIndices(new int[]{1, 2, 5, 2, 3}, 4));
    }

    public static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            /**
             * 保存目标值的索引位置
             */
            if (nums[i] == target) {
                result.add(i);
            }
        }
        return result;
    }
}
