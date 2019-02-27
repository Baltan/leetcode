package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description:Contains Duplicate
 * @author Baltan
 *
 * @date 2017/11/7 16:37
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {2, 14, 18, 22, 22};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            if (nums[i] == nums[j]) {
                return true;
            }
        }
        return false;
    }
}
