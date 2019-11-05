package leetcode.algorithms;

/**
 * Description: 1247. Minimum Swaps to Make Strings Equal
 *
 * @author Baltan
 * @date 2019-11-05 08:55
 */
public class MinimumSwap {
    public static void main(String[] args) {
        System.out.println(minimumSwap("xx", "yy"));
        System.out.println(minimumSwap("xy", "yx"));
        System.out.println(minimumSwap("xx", "xy"));
        System.out.println(minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
        System.out.println(minimumSwap("x", "y"));
        System.out.println(minimumSwap("x", "x"));
    }

    public static int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }

        int result = 0;
        int length = s1.length();
        /**
         * 对应位置上s1为x，s2为y的字符对数
         */
        int x1y2Count = 0;
        /**
         * 对应位置上s1为y，s2为x的字符对数
         */
        int y1x2Count = 0;
        /**
         * 逐一比较s1和s2对应位置上的字符，记录下不同字符的对数，对于对应位置上已经一样的字符，不需要任何操作
         */
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                x1y2Count++;
            } else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                y1x2Count++;
            }
        }
        /**
         * 如果不同字符对数总共有奇数对，不可能通过交换使两个字符串相等
         */
        if (((x1y2Count + y1x2Count) & 1) == 1) {
            return -1;
        }
        /**
         * 任意两对同样的不同字符对可以通过一次交换使两个字符串相同，例如：
         * xx            xy
         * yy     =>     xy
         */
        result += x1y2Count >> 1;
        result += y1x2Count >> 1;
        /**
         * 如果还剩下两个不一样的不同字符对，可以通过两次交换使两个字符串相同，例如：
         * xy            xx            xy
         * yx     =>     yy     =>     xy
         */
        result += (x1y2Count & 1) == 1 ? 2 : 0;
        return result;
    }
}
