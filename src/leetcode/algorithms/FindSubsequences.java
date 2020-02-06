package leetcode.algorithms;

import java.util.*;

/**
 * Description: 491. Increasing Subsequences
 *
 * @author Baltan
 * @date 2020-02-06 12:03
 */
public class FindSubsequences {
    public static void main(String[] args) {
        System.out.println(findSubsequences(new int[]{4, 6, 7, 7}));
        System.out.println(findSubsequences(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
        System.out.println(findSubsequences(new int[]{15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
        System.out.println(findSubsequences(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        resultSet.add(new LinkedList<>());

        dfs(resultSet, nums, 0);

        Iterator<List<Integer>> it = resultSet.iterator();
        /**
         * 将resultSet中长度不足2的list删除
         */
        while (it.hasNext()) {
            List<Integer> list = it.next();

            if (list.size() < 2) {
                it.remove();
            }
        }
        return new LinkedList<>(resultSet);
    }

    public static void dfs(Set<List<Integer>> resultSet, int[] nums, int index) {
        if (index == nums.length) {
            return;
        }

        List<List<Integer>> temp = new LinkedList<>();
        /**
         * 对于resultSet已有的list，如果当前数字nums[index]不小于list中的最后一个数字，或者list
         * 中还没有数字，则list最后加上这个数字后仍是一个递增子序列
         */
        for (List<Integer> list : resultSet) {
            if (list.isEmpty() || nums[index] >= list.get(list.size() - 1)) {
                List<Integer> copyList = new LinkedList<>(list);
                copyList.add(nums[index]);
                /**
                 * 如果resultSet中还没有新的list，才将这个list添加到temp中，最后并入resultSet
                 */
                if (!resultSet.contains(copyList)) {
                    temp.add(copyList);
                }
            }
        }

        resultSet.addAll(temp);
        dfs(resultSet, nums, index + 1);
    }
}
