package leetcode.algorithms;

/**
 * Description: 2744. Find Maximum Number of String Pairs
 *
 * @author Baltan
 * @date 2023/6/25 20:16
 */
public class MaximumNumberOfStringPairs {
    public static void main(String[] args) {
        System.out.println(maximumNumberOfStringPairs(new String[]{"cd", "ac", "dc", "ca", "zz"}));
        System.out.println(maximumNumberOfStringPairs(new String[]{"ab", "ba", "cc"}));
        System.out.println(maximumNumberOfStringPairs(new String[]{"aa", "ab"}));
    }

    public static int maximumNumberOfStringPairs(String[] words) {
        int result = 0;
        /**
         * matrix[i][j]表示第一个字母为i+'a'，第二个字母为j+'a'的字符串是否存在；
         */
        boolean[][] matrix = new boolean[26][26];

        for (String word : words) {
            matrix[word.charAt(0) - 'a'][word.charAt(1) - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                if (matrix[i][j] && matrix[j][i]) {
                    result++;
                }
            }
        }
        return result;
    }
}
