package leetcode.algorithms;

/**
 * Description: 3325. Count Substrings With K-Frequency Characters I
 *
 * @author Baltan
 * @date 2024/10/20 16:10
 */
public class NumberOfSubstrings3 {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abacb", 2));
        System.out.println(numberOfSubstrings("abcde", 1));
    }

    public static int numberOfSubstrings(String s, int k) {
        int result = 0;
        int length = s.length();
        /**
         * prefixCounts[i][0]-prefixCounts[i][25]依次表示前缀子串s[0……i]中字符a-z的个数
         */
        int[][] prefixCounts = new int[length + 1][26];

        for (int i = 0; i < length; i++) {
            System.arraycopy(prefixCounts[i], 0, prefixCounts[i + 1], 0, 26);
            prefixCounts[i + 1][s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < length; i++) {
            /**
             * 如果子串s[i……length-1]中不存在某个字符出现的次数至少为k次，则所有子串s[i……x]（x<=length-1）和s[x……length-1]（x>=i）
             * 中也都不存在某个字符出现的次数至少为k次，可以结束计算
             */
            if (!check(prefixCounts, i, length - 1, k)) {
                break;
            }
            int lo = i;
            int hi = length - 1;
            /**
             * 二分查找最小的x使得子串s[i……x]中存在某个字符出现的次数至少为k次，此时，子串s[i……x+1]、……、s[i……length-1]也都符合要求
             */
            while (lo < hi) {
                int mid = (lo + hi) / 2;

                if (check(prefixCounts, i, mid, k)) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            result += length - lo;
        }
        return result;
    }

    /**
     * 判断字符串中是否存在某个字符出现的次数至少为k次
     *
     * @param prefixCounts
     * @param start
     * @param end
     * @param k
     * @return
     */
    public static boolean check(int[][] prefixCounts, int start, int end, int k) {
        for (int j = 0; j < 26; j++) {
            if (prefixCounts[end + 1][j] - prefixCounts[start][j] >= k) {
                return true;
            }
        }
        return false;
    }
}
