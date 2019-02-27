package leetcode.algorithms;

/**
 * Description:Repeated Substring Pattern
 *
 * @author Baltan
 * @date 2017/11/24 14:43
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern("bb"));
        System.out.println(repeatedSubstringPattern("abcabc"));
        System.out.println(repeatedSubstringPattern("ababab"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        if (s.length() < 2) {
            return false;
        }
        int length = s.length();
        boolean flag = false;
        for (int i = 1; i <= length / 2; i++) {
            if (length % i == 0) {
                flag = true;
                String standard = s.substring(0, i);
                for (int j = i; j < length; j += i) {
                    if (!s.substring(j, j + i).equals(standard)) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    break;
                }
            }
        }
        return flag;
    }
}
