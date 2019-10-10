package leetcode.algorithms;

/**
 * Description: 1208. Get Equal Substrings Within Budget
 *
 * @author Baltan
 * @date 2019-10-01 09:33
 */
public class EqualSubstring {
    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "bcdf", 3));
        System.out.println(equalSubstring("abcd", "cdef", 3));
        System.out.println(equalSubstring("abcd", "acde", 0));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int result = 0;
        int length = s.length();
        int[] prefixSum = new int[length + 1];
        /**
         * 计算将s的字符逐一转化成t对应的字符的开销的前缀和
         */
        for (int i = 0; i < length; i++) {
            prefixSum[i + 1] = prefixSum[i] + Math.abs(s.charAt(i) - t.charAt(i));
        }
        /**
         * 计算可以转化的子串的最大长度
         */
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                /**
                 * 固定最后一个字符为原来字符串的第i个字符，如果长度为i-j的子串转化的开销已经大于maxCost，
                 * 可以直接退出内层循环，将最后一个字符的位置右移一个继续计算
                 */
                if (prefixSum[i] - prefixSum[j] > maxCost) {
                    break;
                } else {
                    result = Math.max(result, i - j);
                }
            }
        }
        return result;
    }
}
