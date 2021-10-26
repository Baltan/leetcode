package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 2047. Number of Valid Words in a Sentence
 *
 * @author Baltan
 * @date 2021/10/26 16:43
 */
public class CountValidWords {
    public static void main(String[] args) {
        System.out.println(countValidWords("cat and  dog"));
        System.out.println(countValidWords("!this  1-s b8d!"));
        System.out.println(countValidWords("alice and  bob are playing stone-game10"));
        System.out.println(countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }

    public static int countValidWords(String sentence) {
        int result = 0;
        StringBuilder builder = new StringBuilder();
        sentence = sentence + " ";

        for (char c : sentence.toCharArray()) {
            if (c == ' ') {
                if (checkValidWord(builder.toString())) {
                    result++;
                }
                builder = new StringBuilder();
            } else {
                builder.append(c);
            }
        }
        return result;
    }

    /**
     * 校验是否是有效单词
     *
     * @param token
     * @return
     */
    private static boolean checkValidWord(String token) {
        if (Objects.equals(token, "") || token.startsWith("-") || token.endsWith("-")) {
            return false;
        }
        /**
         * 连字符个数
         */
        int hyphenCount = 0;
        /**
         * 标点符号个数
         */
        int punctuationCount = 0;
        char[] charArray = token.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            int c = charArray[i];
            /**
             * 存在数字
             */
            if ('0' <= c && '9' >= c) {
                return false;
            } else if (c == '-') {
                hyphenCount++;
                /**
                 * 连字符个数超过1个
                 */
                if (hyphenCount > 1) {
                    return false;
                }
                /**
                 * 连字符前面不是小写字母
                 */
                if (charArray[i - 1] < 'a' || charArray[i - 1] > 'z') {
                    return false;
                }
                /**
                 * 连字符后面不是小写字母
                 */
                if (charArray[i + 1] < 'a' || charArray[i + 1] > 'z') {
                    return false;
                }
            } else if (c == '!' || c == ',' || c == '.') {
                punctuationCount++;
                /**
                 * 标点符号不在最后一位
                 */
                if (i != charArray.length - 1) {
                    return false;
                }
                /**
                 * 标点符号个数超过1个
                 */
                if (punctuationCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
