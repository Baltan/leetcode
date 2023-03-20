package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2597. The Number of Beautiful Subsets
 *
 * @author Baltan
 * @date 2023/3/19 13:53
 */
public class BeautifulSubsets {
    public static void main(String[] args) {
        System.out.println(beautifulSubsets(new int[]{2, 4, 6}, 2));
        System.out.println(beautifulSubsets(new int[]{1}, 1));
    }

    private static int result;

    public static int beautifulSubsets(int[] nums, int k) {
        result = 0;
        /**
         * counts[i]表示数组nums中元素i的个数，根据题意i∈[1,1000]
         */
        int[] counts = new int[1001];
        /**
         * numList保存数组nums中各个不同的元素
         */
        List<Integer> numList = new ArrayList<>();
        /**
         * 保存已经加入美丽子集中的元素
         */
        Set<Integer> subset = new HashSet<>();
        /**
         * 对数组nums中每个元素出现的次数计数
         */
        for (int num : nums) {
            counts[num]++;
        }
        /**
         * 收集数组nums中各个不同的元素
         */
        for (int i = 1; i <= 1000; i++) {
            if (counts[i] > 0) {
                numList.add(i);
            }
        }
        Collections.sort(numList);

        for (int i = 0; i < numList.size(); i++) {
            int num = numList.get(i);
            subset.add(num);
            /**
             * 根据题意，k≠0，所以如果数组nums中的元素num可以加入美丽子集，则可以从nums中选出1、2、……、counts[num]个元素num加入美丽子集，
             * 取法总数为(2^counts[num])-1
             */
            int count = (1 << counts[num]) - 1;
            result += count;
            dfs(numList, counts, i + 1, subset, count, k);
            subset.remove(num);
        }
        return result;
    }

    /**
     * 回溯计算不同美丽子集的个数
     *
     * @param numList
     * @param counts
     * @param index   判断元素numList[index]能否加入当前的美丽子集
     * @param subset
     * @param total   已选择的元素可以确定的不同美丽子集的数量
     * @param k
     */
    public static void dfs(List<Integer> numList, int[] counts, int index, Set<Integer> subset, int total, int k) {
        if (index == numList.size()) {
            return;
        }
        int num = numList.get(index);
        /**
         * 只有当前美丽子集中不存在元素num-k，才可以将元素num加入美丽子集，考虑将元素num加入美丽子集的情况
         */
        if (!subset.contains(num - k)) {
            subset.add(num);
            /**
             * 根据题意，k≠0，所以如果数组nums中的元素num可以加入美丽子集，则可以从nums中选出1、2、……、counts[num]个元素num加入美丽子集，
             * 取法总数为(2^counts[num])-1
             */
            int count = (1 << counts[num]) - 1;
            result += total * count;
            dfs(numList, counts, index + 1, subset, total * count, k);
            subset.remove(num);
        }
        /**
         * 考虑不将元素num加入美丽子集的情况
         */
        dfs(numList, counts, index + 1, subset, total, k);
    }
}
