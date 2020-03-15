package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 78. Subsets
 *
 * @author Baltan
 * @date 2019-03-25 13:48
 * @see leetcode.interview.Subsets
 * @see SubsetsWithDup
 */
public class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{1, 2, 3, 4}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), nums, 0);
        return result;
    }

    public static void dfs(List<List<Integer>> result, LinkedList<Integer> temp, int[] nums, int start) {
        result.add(new LinkedList<>(temp));
        /**
         * 此时没有更多的元素可以加入到temp中了，直接return
         */
        if (start == nums.length) {
            return;
        }
        /**
         * 逐一在temp中加入新的元素然后递归
         */
        for (int i = start; i < nums.length; i++) {
            temp.offerLast(nums[i]);
            dfs(result, temp, nums, i + 1);
            /**
             * 将之前新加入temp中的元素移除，使temp还原到开始时的状态，尝试加入其他元素
             */
            temp.pollLast();
        }
    }
}
