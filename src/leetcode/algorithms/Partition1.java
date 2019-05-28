package leetcode.algorithms;

import java.util.*;

/**
 * Description: 131. Palindrome Partitioning
 *
 * @author Baltan
 * @date 2019-05-28 09:25
 */
public class Partition1 {
    public static void main(String[] args) {
//        System.out.println(partition("aab"));
//        System.out.println(partition("a"));
//        System.out.println(partition(""));
        System.out.println(partition("abaaaaaaaa"));
    }

    private static Map<String, List<List<String>>> map = new HashMap<>();
    private static Map<String, Boolean> palindromeMap = new HashMap<>();

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        if (s.length() == 0) {
            List<String> list = new ArrayList<>();
            result.add(list);
            return result;
        }

        if (s.length() == 1) {
            List<String> list = new ArrayList<>();
            list.add(s);
            result.add(list);
            return result;
        }

        int length = s.length();

        for (int i = 1; i <= length; i++) {
            String head = s.substring(0, i);
            if (isPalindrome(head)) {
                String tail = s.substring(i);
                List<List<String>> strList;

                if (map.containsKey(tail)) {
                    strList = map.get(tail);
                } else {
                    strList = partition(tail);
                    map.put(tail, strList);
                }

                List<List<String>> list = new ArrayList<>();

                for (List<String> strings : strList) {
                    list.add(new ArrayList<>(strings));
                }

                for (List<String> strings : list) {
                    strings.add(0, head);
                    result.add(strings);
                }
            }
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        if (palindromeMap.containsKey(s)) {
            return palindromeMap.get(s);
        } else {
            int length = s.length();
            int half = length >> 1;

            if ((length & 1) == 1) {
                int lo = half - 1;
                int hi = half + 1;

                while (lo >= 0 && hi < length) {
                    if (s.charAt(lo) != s.charAt(hi)) {
                        palindromeMap.put(s, false);
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
                        palindromeMap.put(s, false);
                        return false;
                    }
                    lo--;
                    hi++;
                }
            }
            palindromeMap.put(s, true);
            return true;
        }
    }
}
