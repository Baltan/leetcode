package leetcode.algorithms;

import java.util.*;

/**
 * Description: 47. Permutations II
 *
 * @author Baltan
 * @date 2019-03-24 13:50
 * @see Permute
 * @see Permute1
 * @see PermuteUnique1
 * @see leetcode.interview.Permutation
 * @see leetcode.interview.Permutation1
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
                /**
                 * 除去当前数字外其他数字构成的数组
                 */
                int[] arr = Arrays.copyOfRange(nums, 1, length);
                /**
                 * 递归查找其他字符的所有排列
                 */
                List<List<Integer>> res = permuteUnique(arr);
                /**
                 * 将其他数字得到的所有排列开头加上当前开头的数字nums[0]
                 */
                for (List<Integer> val : res) {
                    val.add(0, nums[0]);
                    result.add(val);
                }
            } else if (nums[i] == nums[i - 1]) {
                /**
                 * 如果当前数字和上一次循环的数字一样的话，直接跳过循环，因为以这个数字打头的所有的排列在上一
                 * 轮循环中已经都得到了
                 */
                continue;
            } else {
                int[] arr = new int[length - 1];
                /**
                 * 除去当前数字外其他数字构成的数组
                 */
                for (int j = 0; j < length - 1; j++) {
                    if (j < i) {
                        arr[j] = nums[j];
                    } else {
                        arr[j] = nums[j + 1];
                    }
                }
                /**
                 * 递归查找其他字符的所有排列
                 */
                List<List<Integer>> res = permuteUnique(arr);
                /**
                 * 将其他数字得到的所有排列开头加上当前开头的数字nums[i]
                 */
                for (List<Integer> val : res) {
                    val.add(0, nums[i]);
                    result.add(val);
                }
            }
        }
        return result;
    }
}
