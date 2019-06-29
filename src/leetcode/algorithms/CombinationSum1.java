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

        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();

        dfs(result, temp, 0, candidates, target);
        return result;
    }

    public static void dfs(List<List<Integer>> result, List<Integer> temp, int sum, int[] candidates,
                           int target) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int num : candidates) {
            if ((temp.isEmpty() || num >= temp.get(temp.size() - 1)) && sum + num <= target) {
                temp.add(num);
                dfs(result, temp, sum + num, candidates, target);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
