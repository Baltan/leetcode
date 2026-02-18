package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3805. Count Caesar Cipher Pairs
 *
 * @author baltan
 * @date 2026/2/16 14:24
 */
public class CountPairs7 {
    public static void main(String[] args) {
        System.out.println(countPairs(new String[]{"fusion", "layout"}));
        System.out.println(countPairs(new String[]{"ab", "aa", "za", "aa"}));
    }

    public static long countPairs(String[] words) {
        long result = 0L;
        /**
         * 将数组words中的所有字符串都凯撒加密为以字符a开头的字符串后，对其计数
         */
        Map<String, Integer> countMap = new HashMap<>();

        /**
         * 每个字符凯撒加密需要向左移动端偏移量
         */
        /**
         * 将字符串words[i]凯撒加密为以字符a开头的字符串
         */
        for (String word : words) {
            char[] charArray = word.toCharArray();
            /**
             * 每个字符凯撒加密需要向左移动端偏移量
             */
            int distance = charArray[0] - 'a';
            /**
             * 将字符串words[i]凯撒加密为以字符a开头的字符串
             */
            for (int j = 0; j < charArray.length; j++) {
                charArray[j] = (char) ((charArray[j] + 26 - distance) % 26);
            }
            String cipher = new String(charArray);
            result += countMap.getOrDefault(cipher, 0);
            countMap.merge(cipher, 1, Integer::sum);
        }
        return result;
    }
}
