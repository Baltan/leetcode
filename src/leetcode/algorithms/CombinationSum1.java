package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 39. Combination Sum
 *
 * @author Baltan
 * @date 2018/9/4 10:36
 */
public class CombinationSum1 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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

        for (int i = startIndex; i < length; i++) {
            /**
             * 当前准备追加到组合temp中的数字
             */
            int num = candidates[i];
            /**
             * 每次追加到temp中的数字都不小于当前temp中的最大数字，并且不能使temp中数字的和大于target
             */
            if (sum + num <= target) {
                temp.add(num);
                dfs(result, temp, sum + num, candidates, target, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
