package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2452. Words Within Two Edits of Dictionary
 *
 * @author Baltan
 * @date 2022/12/4 13:30
 */
public class TwoEditWords {
    public static void main(String[] args) {
        System.out.println(twoEditWords(new String[]{"word", "note", "ants", "wood"}, new String[]{"wood", "joke", "moat"}));
        System.out.println(twoEditWords(new String[]{"yes"}, new String[]{"not"}));
    }

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String query : queries) {
            for (String word : dictionary) {
                if (isMatched(query, word)) {
                    result.add(query);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 字符串query内否在两次修改之内得到字符串word
     *
     * @param query
     * @param word
     * @return
     */
    public static boolean isMatched(String query, String word) {
        int length = query.length();
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (query.charAt(i) != word.charAt(i)) {
                count++;
            }

            if (count > 2) {
                return false;
            }
        }
        return true;
    }
}
