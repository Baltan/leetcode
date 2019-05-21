package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 791. Custom Sort String
 *
 * @author Baltan
 * @date 2018/8/11 23:04
 */
public class CustomSortString {
    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
        System.out.println(customSortString("cba", "bc"));
        System.out.println(customSortString("cba", "a"));
        System.out.println(customSortString("cba", "abcdeabcdeedbac"));
    }

    public static String customSortString(String S, String T) {
        if ("".equals(S) || "".equals(T) || S == null || T == null) {
            return T;
        }
        Map<Character, Integer> map = new HashMap(S.length());
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }

        char[] tArray = T.toCharArray();
        for (int i = T.length() - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                char firstLetter = tArray[j - 1];
                char secondLetter = tArray[j];
                int firstLetterIndex = map.get(firstLetter) == null ? -1 : map.get(firstLetter);
                int secondLetterIndex = map.get(secondLetter) == null ? -1 : map.get(secondLetter);
                if (firstLetterIndex > secondLetterIndex) {
                    char temp = firstLetter;
                    tArray[j - 1] = secondLetter;
                    tArray[j] = temp;
                }
            }
        }
        return new String(tArray);
    }
}
