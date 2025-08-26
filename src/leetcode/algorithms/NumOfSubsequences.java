package leetcode.algorithms;

/**
 * Description: 3628. Maximum Number of Subsequences After One Inserting
 *
 * @author Baltan
 * @date 2025/8/24 22:19
 */
public class NumOfSubsequences {
    public static void main(String[] args) {
        System.out.println(numOfSubsequences("LMCT"));
        System.out.println(numOfSubsequences("LCCT"));
        System.out.println(numOfSubsequences("L"));
    }

    public static long numOfSubsequences(String s) {
        /**
         * 未插入字母前，字符串s中子序列“LCT”的个数
         */
        long result = 0L;
        /**
         * 插入的大写字母可以和字符串s中原有字母构成子序列“LCT”的最大个数
         */
        long max = 0L;
        int length = s.length();
        /**
         * countsL[i+1]表示子串s[0……i]中字母“L”的个数
         */
        int[] countsL = new int[length + 1];
        /**
         * countsLC[i+1]表示子串s[0……i]中子序列“LC”的个数
         */
        int[] countsLC = new int[length + 1];
        /**
         * countsT[i]表示子串s[i……length-1]中字母“T”的个数
         */
        int[] countsT = new int[length + 1];
        /**
         * countsCT[i]表示子串s[i……length-1]中子序列“CT”的个数
         */
        int[] countsCT = new int[length + 1];

        for (int i = 0; i < length; i++) {
            countsL[i + 1] = countsL[i] + (s.charAt(i) == 'L' ? 1 : 0);
            /**
             * 如果s[i]为字母“C”，则可以和子串s[0……i-1]中的countsL[i]个字母“L”构成countsL[i]个子序列“LC”
             */
            countsLC[i + 1] = countsLC[i] + (s.charAt(i) == 'C' ? countsL[i] : 0);
        }

        for (int i = length - 1; i >= 0; i--) {
            countsT[i] = countsT[i + 1] + (s.charAt(i) == 'T' ? 1 : 0);
            /**
             * 如果s[i]为字母“C”，则可以和子串s[i+1……length-1]中的countsT[i+1]个字母“T”构成countsT[i+1]个子序列“CT”
             */
            countsCT[i] = countsCT[i + 1] + (s.charAt(i) == 'C' ? countsT[i + 1] : 0);

            if (s.charAt(i) == 'C') {
                /**
                 * 子串s[0……i-1]中有countsL[i]个字母“L”，子串s[i+1……length-1]中有countsT[i+1]个字母“T”，可以和当前字母“C”构成子序
                 * 列“LCT”的个数为countsL[i]*countsT[i+1]
                 */
                result += (long) countsL[i] * countsT[i + 1];
            }
            /**
             * 如果在s[i]左侧插入字母“L”，则可以和子串s[i……length-1]中的countsCT[i]个子序列“CT”构成countsCT[i]个子序列“LCT”
             */
            max = Math.max(max, countsCT[i]);
            /**
             * 如果在s[i]左侧插入字母“C”，则可以和子串s[0……i-1]中的countsL[i]个字母“L”和子串s[i……length-1]中的countsT[i]个字母“T”
             * 构成countsL[i]*countsT[i]个子序列“LCT”
             */
            max = Math.max(max, (long) countsL[i] * countsT[i]);
            /**
             * 如果在s[i]左侧插入字母“T”，则可以和子串s[0……i-1]中的countsLC[i]个子序列“LC”构成countsLC[i]个子序列“LCT”
             */
            max = Math.max(max, countsLC[i]);
        }
        /**
         * 此前只考虑了在字符串s原有字母的左侧插入字母的情况，但是也可以在s的最后插入字母“T”，此时可以和子串s[0……length-1]中的
         * countsLC[length]个子序列“LC”构成countsLC[length]个子序列“LCT”
         */
        return result + Math.max(max, countsLC[length]);
    }
}
