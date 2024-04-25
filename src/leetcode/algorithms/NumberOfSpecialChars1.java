package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3121. Count the Number of Special Characters II
 *
 * @author Baltan
 * @date 2024/4/25 22:20
 * @see NumberOfSpecialChars
 */
public class NumberOfSpecialChars1 {
    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars("aaAbcBC"));
        System.out.println(numberOfSpecialChars("abc"));
        System.out.println(numberOfSpecialChars("AbBCab"));
    }

    public static int numberOfSpecialChars(String word) {
        int result = 0;
        char[] charArray = word.toCharArray();
        /**
         * lastLowercase[0]-lastLowercase[25]依次表示字符串word中字母a-z最后一次出现的索引位置
         */
        int[] lastLowercase = new int[26];
        /**
         * firstUppercase[0]-firstUppercase[25]依次表示字符串word中字母A-Z第一次出现的索引位置
         */
        int[] firstUppercase = new int[26];
        /**
         * 初始化假设a-z和A-Z在字符串word中都不存在
         */
        Arrays.fill(lastLowercase, -1);
        Arrays.fill(firstUppercase, -1);

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i]) && firstUppercase[charArray[i] - 'A'] == -1) {
                /**
                 * 大写字母charArray[i]在字符串word中第一次出现
                 */
                firstUppercase[charArray[i] - 'A'] = i;
            } else if (Character.isLowerCase(charArray[i])) {
                /**
                 * 小写字母charArray[i]在字符串word中最后一次出现
                 */
                lastLowercase[charArray[i] - 'a'] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            /**
             * 如果在字符串word中，某一个字母的小写形式最后一次出现在其大写形式第一次出现之前，则该字母是特殊字符
             */
            if (lastLowercase[i] != -1 && lastLowercase[i] < firstUppercase[i]) {
                result++;
            }
        }
        return result;
    }
}
