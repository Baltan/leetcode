package leetcode.algorithms;

/**
 * Description: 1208. Get Equal Substrings Within Budget（5207. 尽可能使字符串相等）
 *
 * @author Baltan
 * @date 2019-10-01 09:33
 */
public class EqualSubstring1 {
    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "bcdf", 3));
        System.out.println(equalSubstring("abcd", "cdef", 3));
        System.out.println(equalSubstring("abcd", "acde", 0));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int result = 0;
        int length = s.length();
        int[] differences = new int[length];
        int cost = 0;
        int start = 0;
        int end = 0;
        /**
         * 计算将s的字符逐一转化成t对应的字符的开销
         */
        for (int i = 0; i < length; i++) {
            differences[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        /**
         * 维护两个指针，start指向子串的第一个字符的索引，end指向子串的最后一个字符的索引，如果当前转化的总开销
         * 不大于maxCost，就更新子串的最大长度，并将end右移一个位置继续计算；如果当前转化的总开销大于maxCost，
         * 就将start和end都右移一个位置继续计算
         */
        while (end < length) {
            cost += differences[end];

            if (cost <= maxCost) {
                result = Math.max(result, end - start + 1);
                end++;
            } else {
                cost -= differences[start];
                start++;
                end++;
            }
        }
        return result;
    }
}
