package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1865. Finding Pairs With a Certain Sum
 *
 * @author Baltan
 * @date 2022/5/24 09:13
 */
public class FindSumPairs {
    private int[] nums2;
    /**
     * nums1中的元素i -> 元素i在nums1中出现的次数
     */
    private Map<Integer, Integer> countMap1;
    /**
     * nums2中的元素i -> 元素i在nums2中出现的次数
     */
    private Map<Integer, Integer> countMap2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums2 = nums2;
        countMap1 = new HashMap<>();
        countMap2 = new HashMap<>();
        /**
         * 统计各个元素在nums1中出现的次数
         */
        for (int num : nums1) {
            countMap1.put(num, countMap1.getOrDefault(num, 0) + 1);
        }
        /**
         * 统计各个元素在nums2中出现的次数
         */
        for (int num : nums2) {
            countMap2.put(num, countMap2.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        /**
         * 将nums2[index]在将nums2中出现的次数减1
         */
        if (countMap2.get(nums2[index]) == 1) {
            countMap2.remove(nums2[index]);
        } else {
            countMap2.put(nums2[index], countMap2.get(nums2[index]) - 1);
        }
        nums2[index] += val;
        /**
         * 将nums2[index]+val在将nums2中出现的次数加1
         */
        countMap2.put(nums2[index], countMap2.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int result = 0;
        /**
         * 以长度较小的map作为基准，在另一个map中查找tot-entry.getKey()的个数
         */
        if (countMap1.size() < countMap2.size()) {
            for (Map.Entry<Integer, Integer> entry : countMap1.entrySet()) {
                if (countMap2.containsKey(tot - entry.getKey())) {
                    result += entry.getValue() * countMap2.get(tot - entry.getKey());
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : countMap2.entrySet()) {
                if (countMap1.containsKey(tot - entry.getKey())) {
                    result += entry.getValue() * countMap1.get(tot - entry.getKey());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindSumPairs findSumPairs1 =
                new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        System.out.println(findSumPairs1.count(7));
        findSumPairs1.add(3, 2);
        System.out.println(findSumPairs1.count(8));
        System.out.println(findSumPairs1.count(4));
        findSumPairs1.add(0, 1);
        findSumPairs1.add(1, 1);
        System.out.println(findSumPairs1.count(7));

        System.out.println("----------------------------");
    }
}
