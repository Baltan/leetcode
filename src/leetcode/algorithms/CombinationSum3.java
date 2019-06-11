package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 216. Combination Sum III
 *
 * @author Baltan
 * @date 2019-06-11 09:01
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(5, 18));
        System.out.println(combinationSum3(3, 5));
        System.out.println(combinationSum3(1, 3));
        System.out.println(combinationSum3(2, 18));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            nums.add(i);
        }

        help(result, list, nums, n, k, 1);
        return result;
    }

    public static void help(List<List<Integer>> result, List<Integer> list, List<Integer> nums, int n,
                            int k, int min) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (k <= 0 && n != 0) {
            return;
        }

        if (n <= 0 && k != 0) {
            return;
        }

        int length = nums.size();

        for (int i = 0; i < length; i++) {
            int num = nums.get(i);

            if (num < min) {
                continue;
            }

            list.add(num);
            nums.remove(new Integer(num));
            help(result, list, nums, n - num, k - 1, num + 1);
            nums.add(i, num);
            list.remove(list.size() - 1);
        }
    }
}
