package leetcode.algorithms;

import java.util.*;

/**
 * Description: 40. Combination Sum II
 *
 * @author Baltan
 * @date 2018/9/4 13:08
 * @see CombinationSum1
 * @see CombinationSum3
 * @see CombinationSum4
 * @see Combine
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return result;
        }
        /**
         * 将所有可选数字按照升序排列
         */
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();

        dfs(result, temp, 0, candidates, target, 0);
        return result;
    }

    /**
     * 深度优先搜索
     *
     * @param result
     * @param temp
     * @param sum        当前组合temp中的所有值的和
     * @param candidates 可选数字列表
     * @param target
     * @param startIndex 从candidates的第startIndex索引开始尝试追加数字到temp中
     */
    public static void dfs(List<List<Integer>> result, List<Integer> temp, int sum, int[] candidates,
                           int target, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        int length = candidates.length;
        /**
         * 准备追加到组合temp中的数字
         */
        int num = 0;

        for (int i = startIndex; i < length; i++) {
            /**
             * 如果当前准备追加到组合temp中的数字和上一轮追加的数字相同就跳过，避免出现重复的组合
             */
            if (num != 0 && candidates[i] == num) {
                continue;
            }
            /**
             * 当前追加到组合temp中的数字
             */
            num = candidates[i];
            /**
             * 每次追加到temp中的数字都不小于当前temp中的最大数字，并且不能使temp中数字的和大于target
             */
            if (sum + num <= target) {
                temp.add(num);
                dfs(result, temp, sum + num, candidates, target, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
