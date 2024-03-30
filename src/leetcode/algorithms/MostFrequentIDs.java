package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 3092. Most Frequent IDs
 *
 * @author Baltan
 * @date 2024/3/30 22:30
 */
public class MostFrequentIDs {
    public static void main(String[] args) {
        OutputUtils.print1DLongArray(mostFrequentIDs(new int[]{2, 3, 2, 1}, new int[]{3, 2, -3, 1}));
        OutputUtils.print1DLongArray(mostFrequentIDs(new int[]{5, 5, 3}, new int[]{2, -2, 1}));
    }

    public static long[] mostFrequentIDs(int[] nums, int[] freq) {
        long[] result = new long[nums.length];
        /**
         * frequencies[i]表示值为i的ID出现的次数
         */
        long[] frequencies = new long[100001];
        /**
         * ID的出现次数f -> 出现f次的ID的集合，按照ID出现的次数降序排列
         */
        TreeMap<Long, Set<Integer>> frequencyMap = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            /**
             * 值为num的ID需要从出现次数为frequencies[num]的集合中删除，如果此时没有ID出现的次数为frequencies[num]了，要将这个次数对
             * 应的key从frequencyMap中删除
             */
            if (frequencyMap.getOrDefault(frequencies[num], Collections.emptySet()).size() < 2) {
                frequencyMap.remove(frequencies[num]);
            } else {
                frequencyMap.getOrDefault(frequencies[num], Collections.emptySet()).remove(num);
            }
            frequencies[num] += freq[i];
            /**
             * 值为num的ID需要新加入出现次数为frequencies[num]的集合中
             */
            frequencyMap.computeIfAbsent(frequencies[num], x -> new HashSet<>()).add(num);
            /**
             * 获取出现次数最多的ID集合对应的次数
             */
            result[i] = frequencyMap.firstKey();
        }
        return result;
    }
}
