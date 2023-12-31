package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2981. Find Longest Special Substring That Occurs Thrice I
 *
 * @author Baltan
 * @date 2023/12/31 20:53
 * @see MaximumLength1
 */
public class MaximumLength {
    public static void main(String[] args) {
        System.out.println(maximumLength("aaaa"));
        System.out.println(maximumLength("abcdef"));
        System.out.println(maximumLength("abcaba"));
    }

    public static int maximumLength(String s) {
        int result = -1;
        char[] charArray = s.toCharArray();
        /**
         * 子串 -> 字符串s中子串出现的次数
         */
        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int j = i;
            /**
             * 查找由charArray[i]作为第一个字符的特殊子串
             */
            while (j < s.length() && charArray[j] == charArray[i]) {
                String substring = new String(charArray, i, j - i + 1);
                countMap.put(substring, countMap.getOrDefault(substring, 0) + 1);
                j++;
            }
        }
        /**
         * 遍历所有特殊字串出现的次数，找到出现至少3次的最长特殊字串
         */
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= 3) {
                result = Math.max(result, entry.getKey().length());
            }
        }
        return result;
    }
}
