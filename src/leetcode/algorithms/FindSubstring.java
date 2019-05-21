package leetcode.algorithms;

import java.util.*;

/**
 * Description: 30. Substring with Concatenation of All Words
 *
 * @author Baltan
 * @date 2018/9/2 14:28
 */
public class FindSubstring {
    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("wordgoodstudentgoodword", new String[]{"word", "student"}));
        System.out.println(
                findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(
                findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        int wordNum = words.length;
        int wordLength = words[0].length();
        int sLength = s.length();
        String subString;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> tempMap = new HashMap<>();
        for (int i = 0; i <= sLength - wordLength * wordNum; i++) {
            boolean flag = true;
            for (int j = i; j <= i + wordLength * (wordNum - 1); j += wordLength) {
                subString = s.substring(j, j + wordLength);
                if (!map.containsKey(subString)) {
                    flag = false;
                    break;
                }
                if (tempMap.getOrDefault(subString, 0) + 1 > map.get(subString)) {
                    flag = false;
                    break;
                }
                tempMap.put(subString, tempMap.getOrDefault(subString, 0) + 1);
            }
            tempMap.clear();
            if (flag) {
                res.add(i);
            }
        }
        return res;
    }
}
