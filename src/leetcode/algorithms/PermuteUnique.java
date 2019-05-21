package leetcode.algorithms;

import java.util.*;

/**
 * Description: 47. Permutations II
 *
 * @author Baltan
 * @date 2019-03-24 13:50
 */
public class PermuteUnique {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2, 2}));
        System.out.println(permuteUnique(new int[]{1, 2, 3, 4}));
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
        System.out.println(permuteUnique(new int[]{1, 2}));
        System.out.println(permuteUnique(new int[]{1}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>(1);
            list.add(nums[0]);
            result.add(list);
            return result;
        }

        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                int[] arr = Arrays.copyOfRange(nums, 1, length);
                List<List<Integer>> res = permuteUnique(arr);
                for (List<Integer> val : res) {
                    val.add(0, nums[0]);
                    result.add(val);
                }
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                int[] arr = new int[length - 1];

                for (int j = 0; j < length - 1; j++) {
                    if (j < i) {
                        arr[j] = nums[j];
                    } else {
                        arr[j] = nums[j + 1];
                    }
                }
                List<List<Integer>> res = permuteUnique(arr);
                for (List<Integer> val : res) {
                    val.add(0, nums[i]);
                    result.add(val);
                }
            }
        }
        return result;
    }
}
