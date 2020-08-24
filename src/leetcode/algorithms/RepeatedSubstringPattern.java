package leetcode.algorithms;

/**
 * Description: 459. Repeated Substring Pattern
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
        int halfLength = length / 2;

        outer:
        for (int i = 1; i <= halfLength; i++) {
            /**
             * 只有s的长度为子串的长度i的整数倍，才有可能满足要求
             */
            if (length % i == 0) {
                /**
                 * 长度为i的子串
                 */
                String substring = s.substring(0, i);
                /**
                 * 逐一判断s截取下来的每一个长度为i的子串是否和第一个子串substring相同，如果不同则判断下一个可
                 * 能的子串
                 */
                for (int j = i; j < length; j += i) {
                    if (!s.substring(j, j + i).equals(substring)) {
                        continue outer;
                    }
                }
                /**
                 * 当前长度为i的子串满足要求，直接返回true
                 */
                return true;
            }
        }
        return false;
    }
}
