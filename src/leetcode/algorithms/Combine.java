package leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 77. Combinations
 *
 * @author Baltan
 * @date 2019-03-25 09:41
 */
public class Combine {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(6, 3));
        System.out.println(combine(10, 4));
        System.out.println(combine(5, 5));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        /**
         * 可选的数字
         */
        List<Integer> nums = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        dfs(result, nums, new LinkedList<>(), k, 0);
        return result;
    }

    /**
     * @param result     结果集，保存所有满足要求的组合
     * @param nums       可以加入到组合temp中的可选数字列表
     * @param temp       当前正处理的组合
     * @param k          temp中还缺k个数字，目标是在temp中加入k个数字
     * @param startIndex 从该索引开始逐一将nums中的数字加入到temp中
     */
    public static void dfs(List<List<Integer>> result, List<Integer> nums, LinkedList<Integer> temp, int k,
                           int startIndex) {
        /**
         * 如果k为0，说明temp中已经加入了k个数字，将temp加入到result中
         */
        if (k == 0) {
            result.add(new ArrayList<>(temp));
        }

        int size = nums.size();
        /**
         * 从startIndex开始将nums中剩余可选的数字逐一加入到temp中并递归
         */
        for (int i = startIndex; i < size; i++) {
            /**
             * 加入到组合temp中的数字
             */
            int insertedNum = nums.get(i);
            temp.offerLast(insertedNum);
            dfs(result, nums, temp, k - 1, i + 1);
            temp.pollLast();
        }
    }
}
