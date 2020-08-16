package leetcode.algorithms;

/**
 * Description: 1540. Can Convert String in K Moves
 *
 * @author Baltan
 * @date 2020-08-16 16:11
 */
public class CanConvertString {
    public static void main(String[] args) {
        System.out.println(canConvertString("input", "ouput", 9));
        System.out.println(canConvertString("abc", "bcd", 10));
        System.out.println(canConvertString("aab", "bbb", 27));
    }

    public static boolean canConvertString(String s, String t, int k) {
        /**
         * 如果s和t的长度不同，则s一定无法转变成t
         */
        if (s.length() != t.length()) {
            return false;
        }

        int length = s.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        /**
         * remainderCount[i]表示将s的某个字符转变成t的对应字符需要操作i+26k(k属于N)次的字符的个数
         */
        int[] remainderCount = new int[26];
        /**
         * 计算将s的每个字符转变成t的对应字符需要的最小操作次数
         */
        for (int i = 0; i < length; i++) {
            if (sChars[i] <= tChars[i]) {
                remainderCount[tChars[i] - sChars[i]]++;
            } else {
                remainderCount[26 + tChars[i] - sChars[i]]++;
            }
        }
        /**
         * 如果s和t对应位置上的字符相同，则不需要操作，所以可以不用考虑
         */
        for (int i = 1; i < 26; i++) {
            /**
             * s中有remainderCount[i]个字符转变成t的对应字符需要的操作次数为i次，则这些字符被操作的次数依次为
             * i,i+26*1,i+26*2,……,i+26*(remainderCount[i]-1)，最多需要操作次数为
             * i+26*(remainderCount[i]-1)，如果最多次数大于k次，则该字符无法完成转变，则s也无法转变成t，返回
             * false
             */
            int maxMoves = i + (remainderCount[i] - 1) * 26;

            if (maxMoves > k) {
                return false;
            }
        }
        return true;
    }
}
