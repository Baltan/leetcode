package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: Combination Sum
 *
 * @author Baltan
 * @date 2018/9/4 10:36
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0 || candidates[0] > target) {
            return res;
        }

        if (candidates.length == 1 && target % candidates[0] == 0) {
            int num = target / candidates[0];
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                list.add(candidates[0]);
            }
            res.add(list);
            return res;
        } else if (candidates.length == 1 && target % candidates[0] != 0) {
            return res;
        }
        for (int i = candidates.length - 1; i >= 0; i--) {
            int[] subArray = Arrays.copyOf(candidates, i + 1);
            List<List<Integer>> list = combinationSum(subArray, target - subArray[i]);
            for (int k = 0; k < list.size(); k++) {
                list.get(k).add(subArray[i]);
            }
            if (target - subArray[i] == 0) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(subArray[i]);
                list.add(list1);
            }
            res.addAll(list);
        }
        return res;
    }
}
