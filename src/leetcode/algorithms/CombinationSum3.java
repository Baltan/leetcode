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
        List<Integer> candidates = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            candidates.add(i);
        }

        dfs(result, new ArrayList<>(), candidates, n, k, 0);
        return result;
    }

    /**
     * @param result
     * @param temp
     * @param candidates
     * @param n          当前组合temp中的所有值的和
     * @param k          当前组合中剩余需要添加数字的个数
     * @param startIndex 从candidates的第startIndex索引开始尝试追加数字到temp中
     */
    public static void dfs(List<List<Integer>> result, List<Integer> temp, List<Integer> candidates, int n,
                           int k, int startIndex) {
        /**
         * 如果n和k都为0，此时组合temp已满足要求，将组合加入result
         */
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        /**
         * 如果组合已包含k个数，但k个数的和不为n，组合temp无法满足要求
         */
        if (k == 0 && n != 0) {
            return;
        }
        /**
         * 如果组合不足k个数，但组合temp中数字的和已达到n，组合temp无法满足要求
         */
        if (n <= 0 && k != 0) {
            return;
        }

        int length = candidates.size();

        for (int i = startIndex; i < length; i++) {
            int num = candidates.get(i);
            temp.add(num);
            dfs(result, temp, candidates, n - num, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
