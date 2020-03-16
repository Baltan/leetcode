package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 46. Permutations
 *
 * @author Baltan
 * @date 2018/9/14 09:38
 * @see Permute
 * @see PermuteUnique
 * @see PermuteUnique1
 * @see leetcode.interview.Permutation
 * @see leetcode.interview.Permutation1
 */
public class Permute1 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute(new int[]{1, 2, 3, 4}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Arrays.asList(Arrays.asList());
        }

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> numList = new ArrayList<>(nums.length);

        for (int num : nums) {
            numList.add(num);
        }
        dfs(result, new LinkedList<>(), numList);
        return result;
    }

    public static void dfs(List<List<Integer>> result, LinkedList<Integer> temp, List<Integer> numList) {
        /**
         * 如果numList中没有数字可以再添加到temp中了，说明所有数字已经完成一组排列，将这个排列加入result
         */
        if (numList.isEmpty()) {
            result.add(new LinkedList<>(temp));
        }
        /**
         * 考虑以每个数字开头的所有排列
         */
        for (int i = 0; i < numList.size(); i++) {
            int num = numList.get(i);
            temp.offerLast(num);
            /**
             * 当前数字在递归查找其他数字的所有排列的过程中不会再出现，暂时从numList中移除
             */
            numList.remove(i);
            dfs(result, temp, numList);
            /**
             * 还原numList到初始状态
             */
            numList.add(i, num);
            /**
             * 还原temp到初始状态
             */
            temp.pollLast();
        }
    }
}
