package leetcode.algorithms;

/**
 * Description: 1092. Shortest Common Supersequence
 *
 * @author Baltan
 * @date 2023/9/24 14:23
 */
public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac", "cab"));
        System.out.println(shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));
        System.out.println(shortestCommonSupersequence("bcaaacbbbcbdcaddadcacbdddcdcccdadadcbabaccbccdcdcbcaccacbbdcbabb", "dddbbdcbccaccbababaacbcbacdddcdabadcacddbacadabdabcdbaaabaccbdaa"));
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        String[][] dp = new String[length1 + 1][length2 + 1];

        for (int i = 0; i <= length1; i++) {
            dp[i][0] = str1.substring(0, i);
        }

        for (int j = 0; j <= length2; j++) {
            dp[0][j] = str2.substring(0, j);
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    String sequence1 = dp[i - 1][j] + str1.charAt(i - 1);
                    String sequence2 = dp[i][j - 1] + str2.charAt(j - 1);
                    dp[i][j] = sequence1.length() < sequence2.length() ? sequence1 : sequence2;
                }
            }
        }
        return dp[length1][length2];
    }
}
