package leetcode.algorithms;

import java.util.*;

/**
 * Description: 893. Groups of Special-Equivalent Strings
 *
 * @author Baltan
 * @date 2019-03-14 17:17
 */
public class NumSpecialEquivGroups {
    public static void main(String[] args) {
        System.out.println(numSpecialEquivGroups(new String[]{"a", "b", "c", "a", "c", "c"}));
        System.out.println(numSpecialEquivGroups(new String[]{"aa", "bb", "ab", "ba"}));
        System.out.println(numSpecialEquivGroups(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}));
        System.out.println(numSpecialEquivGroups(new String[]{"abcd", "cdab", "adcb", "cbad"}));
    }

    public static int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>(A.length);
        for (String str : A) {
            List<Character> evenList = new ArrayList<>();
            List<Character> oddList = new ArrayList<>();

            char[] charArray = str.toCharArray();
            int length = charArray.length;

            for (int i = 0; i < length; i++) {
                if ((i & 1) == 0) {
                    evenList.add(str.charAt(i));
                } else {
                    oddList.add(str.charAt(i));
                }
            }
            Collections.sort(evenList);
            Collections.sort(oddList);

            evenList.addAll(oddList);

            char[] newCharArray = new char[length];

            for (int i = 0; i < length; i++) {
                newCharArray[i] = evenList.get(i);
            }

            set.add(new String(newCharArray));
        }
        return set.size();
    }
}
