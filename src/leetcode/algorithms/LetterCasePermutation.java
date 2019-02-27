package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Letter Case Permutation
 *
 * @author Baltan
 * @date 2018/7/31 17:24
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutation("3z4"));
        System.out.println(letterCasePermutation("12345"));
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        String str;
        char c;
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            if (c >= 65 && c <= 90) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    str = list.get(j);
                    list.add(new StringBuilder(str).deleteCharAt(i).insert(i, String.valueOf(c).toLowerCase())
                            .toString());
                }
                list.add(new StringBuilder(S).deleteCharAt(i).insert(i, String.valueOf(c).toLowerCase())
                        .toString());
            } else if (c >= 97 && c <= 122) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    str = list.get(j);
                    list.add(new StringBuilder(str).deleteCharAt(i).insert(i, String.valueOf(c).toUpperCase())
                            .toString());
                }
                list.add(new StringBuilder(S).deleteCharAt(i).insert(i, String.valueOf(c).toUpperCase())
                        .toString());
            }
        }
        list.add(S);
        return list;
    }
}
