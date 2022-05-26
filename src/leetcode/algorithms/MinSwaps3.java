package leetcode.algorithms;

/**
 * Description: 1864. Minimum Number of Swaps to Make the Binary String Alternating
 *
 * @author Baltan
 * @date 2022/5/26 09:39
 */
public class MinSwaps3 {
    public static void main(String[] args) {
        System.out.println(minSwaps("111000"));
        System.out.println(minSwaps("010"));
        System.out.println(minSwaps("1110"));
    }

    public static int minSwaps(String s) {
        int result = Integer.MAX_VALUE;
        char[] charArray = s.toCharArray();
        /**
         * 假设s最后能变成交替字符串"010101……"，遍历过程中，某一位最终的目标字符
         */
        char targetStartsWith0 = '0';
        /**
         * 假设s最后能变成交替字符串"101010……"，遍历过程中，某一位最终的目标字符
         */
        char targetStartsWith1 = '1';
        /**
         * 假设s最后能变成交替字符串"010101……"，遍历过程中，0变为1的次数
         */
        int x = 0;
        /**
         * 假设s最后能变成交替字符串"010101……"，遍历过程中，1变为0的次数
         */
        int y = 0;
        /**
         * 假设s最后能变成交替字符串"101010……"，遍历过程中，0变为1的次数
         */
        int m = 0;
        /**
         * 假设s最后能变成交替字符串"101010……"，遍历过程中，1变为0的次数
         */
        int n = 0;

        for (char c : charArray) {
            /**
             * 当前字符和目标字符不同，需要修改当前字符
             */
            if (c != targetStartsWith0) {
                if (c == '0') {
                    x++;
                } else {
                    y++;
                }
            }
            /**
             * 当前字符和目标字符不同，需要修改当前字符
             */
            if (c != targetStartsWith1) {
                if (c == '0') {
                    m++;
                } else {
                    n++;
                }
            }
            /**
             * 交替字符串中，下一位的目标字符和当前目标字符不同
             */
            targetStartsWith0 = targetStartsWith0 == '0' ? '1' : '0';
            targetStartsWith1 = targetStartsWith1 == '0' ? '1' : '0';
        }
        /**
         * 如果0变为1的次数和1变为0的次数相同则可以完成交换
         */
        if (x == y) {
            result = Math.min(result, x);
        }
        /**
         * 如果0变为1的次数和1变为0的次数相同则可以完成交换
         */
        if (m == n) {
            result = Math.min(result, m);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
