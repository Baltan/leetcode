package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 14. Longest Common Prefix
 *
 * @author Baltan
 * @date 2017/11/27 15:33
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs1 = {"abcdef", "abcde", "abcdk", "abc"};
        String[] strs2 = {"abcdef", "abcde", "abcdk", "abbbbbb"};
        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix(strs2));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            Set<String> hs = new HashSet<>();
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() > i) {
                    hs.add(strs[j].substring(i, i + 1));
                } else {
                    return strs[0].substring(0, i);
                }
            }
            if (hs.size() > 1) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
