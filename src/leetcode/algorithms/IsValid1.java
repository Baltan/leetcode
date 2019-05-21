package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 1003. Check If Word Is Valid After Substitutions
 *
 * @author Baltan
 * @date 2019-04-23 09:47
 */
public class IsValid1 {
    public static void main(String[] args) {
        System.out.println(isValid("abc"));
        System.out.println(isValid("aabcbc"));
        System.out.println(isValid("abcabc"));
        System.out.println(isValid("abcabcababcc"));
        System.out.println(isValid("aabcbcabc"));
        System.out.println(isValid("aabcbabcc"));
        System.out.println(isValid("abcabc"));

        System.out.println(isValid("abccba"));
        System.out.println(isValid("ab"));
        System.out.println(isValid("cababc"));
        System.out.println(isValid("bac"));
        System.out.println(isValid("aabbcc"));

    }

    public static boolean isValid(String S) {
        String standard = "abc";

        while (true) {
            int index = S.indexOf(standard);

            if (index == -1) {
                return false;
            }
            S = S.substring(0, index) + S.substring(index + 3);

            if (Objects.equals(S, "")) {
                return true;
            }
        }
    }
}
