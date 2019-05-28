package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 131. Palindrome Partitioning
 *
 * @author Baltan
 * @date 2019-05-28 09:25
 */
public class Partition2 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition("a"));
        System.out.println(partition(""));
        System.out.println(partition("abaaaaaaaa"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        dfs(result, list, s);
        return result;
    }

    public static void dfs(List<List<String>> result, List<String> list, String s) {
        int length = s.length();

        if (length == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 1; i <= length; i++) {
            String head = s.substring(0, i);

            if (isPalindrome(head)) {
                String rest = s.substring(i);
                list.add(head);
                dfs(result, list, rest);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int length = s.length();
        int half = length >> 1;

        if ((length & 1) == 1) {
            int lo = half - 1;
            int hi = half + 1;

            while (lo >= 0 && hi < length) {
                if (s.charAt(lo) != s.charAt(hi)) {
                    return false;
                }
                lo--;
                hi++;
            }
        } else {
            int lo = half - 1;
            int hi = half;

            while (lo >= 0 && hi < length) {
                if (s.charAt(lo) != s.charAt(hi)) {
                    return false;
                }
                lo--;
                hi++;
            }
        }
        return true;
    }
}
