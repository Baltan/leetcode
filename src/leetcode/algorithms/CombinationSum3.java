package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 216. Combination Sum III
 *
 * @author Baltan
 * @date 2019-06-11 09:01
 * @see CombinationSum1
 * @see CombinationSum2
 * @see CombinationSum4
 * @see Combine
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
        /**
         * 如果n和k都为0，此时组合list已满足要求，将组合加入result
         */
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        /**
         * 如果组合以包含k个数，但k个数的和不为n，组合list无法满足要求
         */
        if (k <= 0 && n != 0) {
            return;
        }
        /**
         * 如果组合不足k个数，但组合中数字的和已达到n，组合list无法满足要求
         */
        if (n <= 0 && k != 0) {
            return;
        }

        int length = nums.size();

        for (int i = 0; i < length; i++) {
            int num = nums.get(i);
            /**
             * 将不小于当前组合可以添加的最小值的数字加入组合中
             */
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
