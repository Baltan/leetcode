package leetcode.algorithms;

/**
 * Description: 1071. Greatest Common Divisor of Strings
 *
 * @author Baltan
 * @date 2019-06-02 16:50
 */
public class GcdOfStrings {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("ABCABCABCABC", "ABCABCABCABC"));
        System.out.println(gcdOfStrings("LEET", "CODE"));
        System.out.println(gcdOfStrings("LEET", ""));
    }

    public static String gcdOfStrings(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());

        for (int i = length; i > 0; i--) {
            if (str1.length() % i == 0 && str2.length() % i == 0) {
                String s1 = str1;
                String s2 = str2;
                String sub = str1.substring(0, i);

                while (s1.length() != 0) {
                    if (s1.contains(sub)) {
                        s1 = s1.substring(i);
                    } else {
                        return "";
                    }
                }

                while (s2.length() != 0) {
                    if (s2.contains(sub)) {
                        s2 = s2.substring(i);
                    } else {
                        return "";
                    }
                }

                if (s1.length() == 0 && s2.length() == 0) {
                    return sub;
                }
            }
        }
        return "";
    }
}
