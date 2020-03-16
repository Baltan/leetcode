package leetcode.algorithms;

import java.util.*;

/**
 * Description: 47. Permutations II
 *
 * @author Baltan
 * @date 2019-03-24 13:50
 * @see Permute
 * @see Permute1
 * @see PermuteUnique
 * @see leetcode.interview.Permutation
 * @see leetcode.interview.Permutation1
 */
public class PermuteUnique1 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2, 2}));
        System.out.println(permuteUnique(new int[]{1, 2, 3, 4}));
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
        System.out.println(permuteUnique(new int[]{1, 2}));
        System.out.println(permuteUnique(new int[]{1}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        int length = nums.length;

        List<Integer> numList = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            numList.add(nums[i]);
        }

        Collections.sort(numList);
        dfs(result, numList, new LinkedList<>());
        return result;
    }

    public static void dfs(List<List<Integer>> result, List<Integer> numList, LinkedList<Integer> temp) {
        /**
         * 如果numList中没有数字可以再拼接到temp中了，说明所有数字已经完成一组排列，将这个排列加入result
         */
        if (numList.isEmpty()) {
            result.add(new LinkedList<>(temp));
        }
        /**
         * 考虑以每个数字开头的所有排列
         */
        for (int i = 0; i < numList.size(); i++) {
            int num = numList.get(i);
            /**
             * 如果当前数字和上一次循环的数字一样的话，直接跳过循环，因为以这个数字打头的所有的排列在上一轮循
             * 环中已经都得到了
             */
            if (i > 0 && Objects.equals(numList.get(i), (numList.get(i - 1)))) {
                continue;
            }

            temp.offerLast(num);
            /**
             * 当前数字在递归查找其他字符的所有排列的过程中不会再出现，暂时从numList中移除
             */
            numList.remove(i);
            dfs(result, numList, temp);
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
