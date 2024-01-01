package leetcode.algorithms;

/**
 * Description: 2982. Find Longest Special Substring That Occurs Thrice II
 *
 * @author Baltan
 * @date 2023/12/31 21:04
 * @see MaximumLength
 */
public class MaximumLength1 {
    public static void main(String[] args) {
        System.out.println(maximumLength("aaaa"));
        System.out.println(maximumLength("abcdef"));
        System.out.println(maximumLength("abcaba"));
    }

    public static int maximumLength(String s) {
        int result = -1;
        char[] charArray = s.toCharArray();
        /**
         * counts[i][j]表示字符串s中全部由字符char(i+'a')构成，长度为j且无法向左右继续延长的特殊子串的个数
         */
        int[][] counts = new int[26][s.length() + 1];

        for (int i = 0; i < s.length(); ) {
            int j = i;
            /**
             * 查找由charArray[i]作为第一个字符的特殊子串
             */
            while (j < s.length() && charArray[j] == charArray[i]) {
                j++;
            }
            counts[charArray[i] - 'a'][j - i]++;
            i = j;
        }
        outer:
        for (int[] count : counts) {
            for (int i = s.length(); i > 0; i--) {
                /**
                 * 长度为i特殊子串的个数=count[i]+count[i+1]*2+count[i+2]*3（如果存在的话）
                 */
                if (count[i] + (i + 1 <= s.length() ? count[i + 1] * 2 : 0) + (i + 2 <= s.length() ? count[i + 2] * 3 : 0) >= 3) {
                    result = Math.max(result, i);
                    continue outer;
                }
            }
        }
        return result;
    }
}
