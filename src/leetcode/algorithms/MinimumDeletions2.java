package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3085. Minimum Deletions to Make String K-Special
 *
 * @author baltan
 * @date 2024/3/21 16:44
 */
public class MinimumDeletions2 {
    public static void main(String[] args) {
        System.out.println(minimumDeletions("aabcaba", 0));
        System.out.println(minimumDeletions("dabdcbdcdcd", 2));
        System.out.println(minimumDeletions("aaabaaa", 2));
    }

    public static int minimumDeletions(String word, int k) {
        int result = Integer.MAX_VALUE;
        /**
         * counts[0]-counts[25]依次表示字符串word中字母a-z的个数
         */
        int[] counts = new int[26];
        /**
         * n -> 字符串word中出现n次的不同字母的个数
         */
        Map<Integer, Integer> frequencyMap = new HashMap<>((int) (26 / 0.75 + 1));

        for (char c : word.toCharArray()) {
            counts[c - 'a']++;
        }

        for (int frequency : counts) {
            if (frequency != 0) {
                frequencyMap.put(frequency, frequencyMap.getOrDefault(frequency, 0) + 1);
            }
        }
        /**
         * 遍历最终剩下的k-special字符串中出现次数最少的字母的频数outerEntry.getKey()
         */
        for (Map.Entry<Integer, Integer> outerEntry : frequencyMap.entrySet()) {
            int deletions = 0;

            for (Map.Entry<Integer, Integer> innerEntry : frequencyMap.entrySet()) {
                if (innerEntry.getKey() < outerEntry.getKey()) {
                    /**
                     * 如果字符串word中某个字母出现的次数少于outerEntry.getKey()，则要将这个字母全部删除
                     */
                    deletions += innerEntry.getKey() * innerEntry.getValue();
                } else if (innerEntry.getKey() - outerEntry.getKey() > k) {
                    /**
                     * 如果字符串word中某个字母出现的次数与outerEntry.getKey()之差大于k，则要将多余的字母删除，直到字符串word中该字母
                     * 出现的次数与outerEntry.getKey()之差不大于k
                     */
                    deletions += (innerEntry.getKey() - outerEntry.getKey() - k) * innerEntry.getValue();
                }
            }
            result = Math.min(result, deletions);
        }
        return result;
    }
}
