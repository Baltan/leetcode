package leetcode.algorithms;

/**
 * Description: 2609. Find the Longest Balanced Substring of a Binary String
 *
 * @author Baltan
 * @date 2023/4/2 19:09
 */
public class FindTheLongestBalancedSubstring {
    public static void main(String[] args) {
        System.out.println(findTheLongestBalancedSubstring("01000111"));
        System.out.println(findTheLongestBalancedSubstring("00111"));
        System.out.println(findTheLongestBalancedSubstring("111"));
        System.out.println(findTheLongestBalancedSubstring("0000111"));
        System.out.println(findTheLongestBalancedSubstring("000111"));
    }

    public static int findTheLongestBalancedSubstring(String s) {
        int result = 0;
        /**
         * 当前连续的数字0的个数
         */
        int count0 = 0;
        /**
         * 当前连续的数字1的个数
         */
        int count1 = 0;
        /**
         * 当前是否在对连续的数字0计数
         */
        boolean find0 = true;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                /**
                 * 之前的数字为1，从当前数字开始对连续的数字0计数
                 */
                if (!find0) {
                    count0 = 0;
                    find0 = true;
                }
                count0++;
            } else {
                /**
                 * 之前的数字为0，从当前数字开始对连续的数字1计数
                 */
                if (find0) {
                    count1 = 0;
                    find0 = false;
                }
                count1++;
                /**
                 * 当前得到的平衡子串的长度为Math.min(count0,count1)*2
                 */
                result = Math.max(result, Math.min(count0, count1) * 2);
            }
        }
        return result;
    }
}
