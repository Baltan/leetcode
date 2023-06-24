package leetcode.algorithms;

/**
 * Description: 1278. Palindrome Partitioning III
 *
 * @author Baltan
 * @date 2023/3/26 20:01
 */
public class PalindromePartition {
    public static void main(String[] args) {
        System.out.println(palindromePartition("abc", 2));
        System.out.println(palindromePartition("aabbc", 3));
        System.out.println(palindromePartition("leetcode", 8));
    }

    public static int palindromePartition(String s, int k) {
        int length = s.length();
        char[] charArray = s.toCharArray();
        /**
         * dp[i][j]表示将字符串s的前i个字符构成的前缀子串分割成j个回文子串最少需要修改的字符数，题目所求即为dp[length][k]
         */
        int[][] dp = new int[length + 1][k + 1];
        /**
         * i表示字符串s的前缀子串的长度，j表示前缀子串被分割成的回文子串的数量
         */
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j == 1) {
                    /**
                     * 计算将s.substring(0,i)变成回文子串需要修改的字符数量
                     */
                    dp[i][1] = getCount(charArray, 0, i - 1);
                } else {
                    /**
                     * 将分割多个子串的情况都初始化为一个极大值，表示最坏情况，后续进行优化
                     */
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        /**
         * i表示字符串s的前缀子串的长度，j表示前缀子串被分割成的回文子串的数量，l表示构成前j-1个回文子串的前缀子串的长度
         */
        for (int i = 2; i <= length; i++) {
            for (int j = 2; j <= k; j++) {
                for (int l = j - 1; l < i; l++) {
                    /**
                     * s.substring(0,l)被分割成j-1个回文子串，s.substring(l,i)需要通过修改若干字符得到最后一个回文子串
                     */
                    dp[i][j] = Math.min(dp[i][j], dp[l][j - 1] + getCount(charArray, l, i - 1));
                }
            }
        }
        return dp[length][k];
    }

    /**
     * 计算将s.substring(lo,hi+1)这部分子串变成回文子串需要修改的字符数量
     *
     * @param charArray
     * @param lo
     * @param hi
     * @return
     */
    public static int getCount(char[] charArray, int lo, int hi) {
        int count = 0;

        while (lo < hi) {
            if (charArray[lo] != charArray[hi]) {
                count++;
            }
            lo++;
            hi--;
        }
        return count;
    }
}
