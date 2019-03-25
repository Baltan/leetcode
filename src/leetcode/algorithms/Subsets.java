package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: Subsets
 *
 * @author Baltan
 * @date 2019-03-25 13:48
 */
public class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{1, 2, 3, 4}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        if (nums == null || nums.length == 0) {
            return result;
        }
        int length = nums.length;

        for (int i = 1; i <= length; i++) {
            result.addAll(help(nums, i));
        }
        return result;
    }

    public static List<List<Integer>> help(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int length = arr.length;

        if (k == 1) {
            for (int i = 0; i < length; i++) {
                List<Integer> list = new ArrayList<>(1);
                list.add(arr[i]);
                result.add(list);
            }
        } else {
            for (int i = 0; i <= length - k; i++) {
                int[] arr1 = Arrays.copyOfRange(arr, i + 1, arr.length);

                List<List<Integer>> list1 = help(arr1, k - 1);

                for (List<Integer> ele : list1) {
                    List<Integer> list = new ArrayList<>(k);
                    list.add(arr[i]);
                    list.addAll(ele);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
