package leetcode.algorithms;

import java.util.Set;

/**
 * Description: 3136. Valid Word
 *
 * @author baltan
 * @date 2024/5/9 15:14
 */
public class IsValid2 {
    public static void main(String[] args) {
        System.out.println(isValid("234Adas"));
        System.out.println(isValid("b3"));
        System.out.println(isValid("a3$e"));
    }

    public static boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        /**
         * 字符串word中是否存在元音字母
         */
        boolean hasVowel = false;
        /**
         * 字符串word中是否存在辅音字母
         */
        boolean hasConsonant = false;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        for (char c : word.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                if (!hasVowel) {
                    hasVowel = vowels.contains(c);
                }

                if (!hasConsonant) {
                    hasConsonant = !vowels.contains(c);
                }
            } else if (c < '0' || c > '9') {
                /**
                 * 字符c既不是英文字母，也不是数字，直接返回false
                 */
                return false;
            }
        }
        return hasVowel && hasConsonant;
    }
}
