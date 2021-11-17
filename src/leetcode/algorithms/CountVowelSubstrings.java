package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 2062. Count Vowel Substrings of a String
 *
 * @author Baltan
 * @date 2021/11/17 13:41
 */
public class CountVowelSubstrings {
    public static void main(String[] args) {
        System.out.println(countVowelSubstrings("aeiouu"));
        System.out.println(countVowelSubstrings("unicornarihan"));
        System.out.println(countVowelSubstrings("cuaieuouac"));
        System.out.println(countVowelSubstrings("bbaeixoubb"));
    }

    public static int countVowelSubstrings(String word) {
        int result = 0;
        int length = word.length();
        /**
         * 可能符合条件的子字符串可能的最大起始索引位置
         */
        int maxStartIndex = length - 5;

        for (int i = 0; i <= maxStartIndex; i++) {
            /**
             * 标记以word[i]开头的子字符串中原因字母的数量
             */
            Set<Character> vowelSet = new HashSet<>();

            for (int j = i; j < length; j++) {
                char c = word.charAt(j);
                /**
                 * 如果遇到非元音字母，则子字符串不符合条件
                 */
                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                    break;
                }

                vowelSet.add(c);
                /**
                 * 子字符串中包含五中元音字母，符合条件
                 */
                if (vowelSet.size() == 5) {
                    result++;
                }
            }
        }
        return result;
    }
}
