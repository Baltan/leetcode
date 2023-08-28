package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Description: 2828. Check if a String Is an Acronym of Words
 *
 * @author baltan
 * @date 2023/8/23 14:44
 */
public class IsAcronym {
    public static void main(String[] args) {
        System.out.println(isAcronym(Arrays.asList("alice", "bob", "charlie"), "abc"));
        System.out.println(isAcronym(Arrays.asList("an", "apple"), "a"));
        System.out.println(isAcronym(Arrays.asList("never", "gonna", "give", "up", "on", "you"), "ngguoy"));
    }

    public static boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        int length = s.length();
        /**
         * 逐个比较字符串words[i]的首个字符和s中的第i个字符是否一样，如果不一样直接返回false
         */
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != words.get(i).charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
