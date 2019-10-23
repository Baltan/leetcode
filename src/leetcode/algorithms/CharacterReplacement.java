package leetcode.algorithms;

/**
 * Description: 424. Longest Repeating Character Replacement
 *
 * @author Baltan
 * @date 2019-10-23 10:21
 */
public class CharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
        System.out.println(characterReplacement("AABABABABABABABBBAABAABAABBAABABAAAABABBBA", 5));
    }

    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        /**
         * 最长重复字符串的长度
         */
        int result = 1;
        int length = s.length();
        /**
         * 左指针，指向当前子串的起始索引
         */
        int lo = 0;
        /**
         * 右指针，指向当前子串的结束索引
         */
        int hi = 0;
        /**
         * 记录当前子串中每个大写字母出现的次数
         */
        int[] count = new int[26];
        /**
         * 记录当前子串中出现最多次的大写字母出现的次数
         */
        int max = 0;

        while (lo < length && lo <= hi) {
            /**
             * 逐位向右移动右指针
             */
            while (hi < length) {
                char addChar = s.charAt(hi);
                count[addChar - 'A']++;
                max = Math.max(max, count[addChar - 'A']);
                /**
                 * 当前子串如果要变成重复字符串需要替换字母的次数为hi-lo+1-max次，如果不大于k次，就更新最长重
                 * 复字符串的长度，并将右指针右移一位，如果大于k次，就退出当前循环。
                 */
                if (hi - lo + 1 - max <= k) {
                    result = Math.max(result, hi - lo + 1);
                    hi++;
                } else {
                    break;
                }
            }
            /**
             * 将左指针和右指针同时向右移动一位，移动移动左指针后，需要将左指针之前指向的大写字母出现的次数减1
             */
            char removeChar = s.charAt(lo);
            count[removeChar - 'A']--;
            lo++;
            hi++;
        }
        return result;
    }
}
