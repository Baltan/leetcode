package leetcode.algorithms;

import java.util.*;

/**
 * Description: Combination Sum II
 *
 * @author Baltan
 * @date 2018/9/4 13:08
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0 || candidates[0] > target) {
            return res;
        }
        if (candidates.length == 1 && target == candidates[0]) {
            List<Integer> list = new ArrayList<>();
            list.add(candidates[0]);
            res.add(list);
            return res;
        } else if (candidates.length == 1 && target != candidates[0]) {
            return res;
        }

        Set<List<Integer>> set = new HashSet<>();
        for (int i = candidates.length - 1; i >= 0; i--) {
            int[] subArray = Arrays.copyOf(candidates, i);
            List<List<Integer>> list = combinationSum2(subArray, target - candidates[i]);
            for (int k = 0; k < list.size(); k++) {
                list.get(k).add(candidates[i]);
            }
            if (target - candidates[i] == 0) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(candidates[i]);
                list.add(list1);
            }
            set.addAll(list);
        }
        res = new ArrayList<>(set);
        return res;
    }
}
