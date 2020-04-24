package leetcode.algorithms;

/**
 * Description: 1415. The k-th Lexicographical String of All Happy Strings of Length n
 *
 * @author Baltan
 * @date 2020-04-23 21:11
 */
public class GetHappyString {
    public static void main(String[] args) {
        System.out.println(getHappyString(1, 3));
        System.out.println(getHappyString(1, 4));
        System.out.println(getHappyString(3, 9));
        System.out.println(getHappyString(2, 7));
        System.out.println(getHappyString(10, 100));
    }

    public static String getHappyString(int n, int k) {
        StringBuilder builder = new StringBuilder(n);
        /**
         * 首字母之后的长度为n-1的开心字符串可能的个数
         */
        int total = (int) Math.pow(2, n - 1);
        /**
         * 当前判断的位置的前一个字符
         */
        char prevChar;
        /**
         * 长度为n的开心字符串总共可能的个数为total*3个，如果k大于该值，就返回""
         */
        if (k > total * 3) {
            return "";
        }
        /**
         * 考虑第一个字符，以"a"、"b"、"c"开头的开心字符串各有total个，即按照字典顺序，第[1,total]个开心字符串
         * 以"a"开头，第[total+1,total*2]个开心字符串以"b"开头，第[total*2+1,total*3]个开心字符串以"c"开头，
         * 通过k的大小可以确定第一个字符
         */
        if (k <= total) {
            builder.append('a');
            prevChar = 'a';
        } else if (k <= total * 2) {
            builder.append('b');
            prevChar = 'b';
            /**
             * 减去以"a"开头的total个开心字符串
             */
            k -= total;
        } else {
            builder.append('c');
            prevChar = 'c';
            /**
             * 减去以"a"和"b"开头的total*2个开心字符串
             */
            k -= total * 2;
        }
        /**
         * 考虑剩下各个位置的字符，如果前一个位置上字符为"a"，则当前位置可以填的字符为"b"或"c"，当前位置填"b"或"
         * c"的开心字符串各有total个，即按照字典顺序，第[1,total]个开心字符串以"b"开头,第[total+1,total*2]个
         * 开心字符串以"b"开头，通过k的大小可以确定当前字符。前一个位置上的字符为"b"或"c"的情况类似。
         */
        for (int i = 1; i < n; i++) {
            /**
             * 剩下长度为n-1-i的开心字符串可能的个数
             */
            total /= 2;

            if (k <= total) {
                if (prevChar == 'a') {
                    /**
                     * "b"和"c"中取较小字符
                     */
                    builder.append('b');
                    prevChar = 'b';
                } else {
                    /**
                     * "a"和"c"中或"a"和"b"中取较小字符
                     */
                    builder.append('a');
                    prevChar = 'a';
                }
            } else {
                if (prevChar == 'c') {
                    /**
                     * "a"和"b"中取较大字符
                     */
                    builder.append('b');
                    prevChar = 'b';
                    /**
                     * 减去以"a"开头的total个开心字符串
                     */
                    k -= total;
                } else {
                    /**
                     * "b"和"c"中或"a"和"c"中取较大字符
                     */
                    builder.append('c');
                    prevChar = 'c';
                    /**
                     * 减去以"a"或"b"开头的total个开心字符串
                     */
                    k -= total;
                }
            }
        }
        return builder.toString();
    }
}
