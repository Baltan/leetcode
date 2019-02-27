package leetcode.algorithms;

import java.util.List;
import java.util.ArrayList;

/**
 * Description:Find All Numbers Disappeared in an Array
 * @author Baltan
 *
 * @date 2017/11/7 10:49
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int max = nums.length;
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = 1;
        }
        for (int i = 0; i < max; i++) {
            arr[nums[i] - 1] = 0;
        }
        for (int i = 0; i < max; i++) {
            if (arr[i] != 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
