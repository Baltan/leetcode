package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 90. Subsets II
 *
 * @author Baltan
 * @date 2019-05-20 11:01
 * @see Subsets
 * @see leetcode.interview.Subsets
 */
public class SubsetsWithDup {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(subsetsWithDup(new int[]{1, 2, 3}));
        System.out.println(subsetsWithDup(new int[]{1, 2, 3, 4}));
        System.out.println(subsetsWithDup(new int[]{1, 2, 2, 3, 3, 3, 4, 4}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
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
            /**
             * 如果当前要加入temp的元素之前已经尝试过，则直接跳过
             */
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.offerLast(nums[i]);
            dfs(result, temp, nums, i + 1);
            /**
             * 将之前新加入temp中的元素移除，使temp还原到开始时的状态，尝试加入其他元素
             */
            temp.pollLast();
        }
    }
}
