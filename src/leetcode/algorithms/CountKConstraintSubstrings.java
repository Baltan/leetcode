package leetcode.algorithms;

/**
 * Description: 3258. Count Substrings That Satisfy K-Constraint I
 *
 * @author baltan
 * @date 2024/8/20 09:23
 * @see CountKConstraintSubstrings1
 */
public class CountKConstraintSubstrings {
    public static void main(String[] args) {
        System.out.println(countKConstraintSubstrings("10101", 1));
        System.out.println(countKConstraintSubstrings("1010101", 2));
        System.out.println(countKConstraintSubstrings("11111", 1));
    }

    public static int countKConstraintSubstrings(String s, int k) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int zeros = 0;
            int ones = 0;
            /**
             * 判断所有以s[i]开头的子串是否满足k约束
             */
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    zeros++;
                } else {
                    ones++;
                }

                if (zeros > k && ones > k) {
                    break;
                }
                result++;
            }
        }
        return result;
    }
}
