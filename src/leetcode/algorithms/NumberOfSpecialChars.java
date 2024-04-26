package leetcode.algorithms;

/**
 * Description: 3120. Count the Number of Special Characters I
 *
 * @author Baltan
 * @date 2024/4/25 22:21
 * @see NumberOfSpecialChars1
 */
public class NumberOfSpecialChars {
    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars("aaAbcBC"));
        System.out.println(numberOfSpecialChars("abc"));
        System.out.println(numberOfSpecialChars("abBCab"));
    }

    public static int numberOfSpecialChars(String word) {
        int result = 0;
        /**
         * lowercase[0]-lowercase[25]依次表示字符串word中字母a-z是否出现过
         */
        boolean[] lowercase = new boolean[26];
        /**
         * uppercase[0]-uppercase[25]依次表示字符串word中字母A-Z是否出现过
         */
        boolean[] uppercase = new boolean[26];

        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowercase[c - 'a'] = true;
            } else {
                uppercase[c - 'A'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (lowercase[i] && uppercase[i]) {
                result++;
            }
        }
        return result;
    }
}
