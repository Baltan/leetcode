package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3137. Minimum Number of Operations to Make Word K-Periodic
 *
 * @author Baltan
 * @date 2024/5/6 22:10
 */
public class MinimumOperationsToMakeKPeriodic {
    public static void main(String[] args) {
        System.out.println(minimumOperationsToMakeKPeriodic("leetcodeleet", 4));
        System.out.println(minimumOperationsToMakeKPeriodic("leetcoleet", 2));
    }

    public static int minimumOperationsToMakeKPeriodic(String word, int k) {
        /**
         * 字符串word中每个子串word.substring(nk,nk+k)出现的次数
         */
        Map<String, Integer> countMap = new HashMap<>();
        /**
         * 字符串word中出现最多的子串的次数
         */
        int most = 0;

        for (int i = 0; i < word.length(); i += k) {
            String substring = word.substring(i, i + k);
            int count = countMap.getOrDefault(substring, 0) + 1;
            countMap.put(substring, count);
            most = Math.max(most, count);
        }
        /**
         * 保持出现最多次的子串不动，其余的子串word.substring(nk,nk+k)都替换为该子串即可
         */
        return word.length() / k - most;
    }
}
