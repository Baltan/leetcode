package leetcode.algorithms;

/**
 * Description: 1405. Longest Happy String
 *
 * @author Baltan
 * @date 2020-04-10 09:07
 */
public class LongestDiverseString {
    public static void main(String[] args) {
        System.out.println(longestDiverseString(1, 1, 7));
        System.out.println(longestDiverseString(2, 2, 1));
        System.out.println(longestDiverseString(7, 1, 0));
    }

    public static String longestDiverseString(int a, int b, int c) {
        StringBuilder builder = new StringBuilder(a + b + c);
        /**
         * 先给builder拼接两个字母
         */
        for (int i = 0; i < 2; i++) {
            /**
             * 如果没有可用的字母了，直接返回
             */
            if (a + b + c == 0) {
                return builder.toString();
            }
            /**
             * builder后面下一个追加的字母
             */
            char nextChar = getNextChar(a, b, c);

            switch (nextChar) {
                case 'a':
                    builder.append('a');
                    a--;
                    break;
                case 'b':
                    builder.append('b');
                    b--;
                    break;
                case 'c':
                    builder.append('c');
                    c--;
                    break;
            }
        }
        /**
         * 继续在builder后面追加字母
         */
        while (true) {
            /**
             * 如果没有可用的字母了，直接返回
             */
            if (a + b + c == 0) {
                return builder.toString();
            }
            /**
             * builder后面下一个追加的字母
             */
            char nextChar = getNextChar(a, b, c, builder);
            /**
             * 如果nextChar为' '，则builder后面没有可追加的字母了，退出循环
             */
            if (nextChar == ' ') {
                break;
            }

            switch (nextChar) {
                case 'a':
                    builder.append('a');
                    a--;
                    break;
                case 'b':
                    builder.append('b');
                    b--;
                    break;
                case 'c':
                    builder.append('c');
                    c--;
                    break;
            }
        }
        return builder.toString();
    }

    /**
     * 获取三个字母剩余个数最多的那个字母
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static char getNextChar(int a, int b, int c) {
        if (a >= b && a >= c) {
            return 'a';
        } else if (b >= a && b >= c) {
            return 'b';
        } else {
            return 'c';
        }
    }

    /**
     * 获取三个字母剩余个数最多的那个字母，如果得到的那个字母和builder的最后两个字母相同，就获取剩余个数次多
     * 的那个字母
     *
     * @param a
     * @param b
     * @param c
     * @param builder
     * @return
     */
    public static char getNextChar(int a, int b, int c, StringBuilder builder) {
        int most = 0;
        char mostChar = ' ';
        int length = builder.length();
        /**
         * 如果字母'a'的剩余个数更多，并且builder最后两个字母中有一个不为'a'，就可以在builder最后追加'a'
         */
        if (a > most && (builder.charAt(length - 1) != 'a' || builder.charAt(length - 2) != 'a')) {
            most = a;
            mostChar = 'a';
        }
        /**
         * 如果字母'b'的剩余个数更多，并且builder最后两个字母中有一个不为'b'，就可以在builder最后追加'b'
         */
        if (b > most && (builder.charAt(length - 1) != 'b' || builder.charAt(length - 2) != 'b')) {
            most = b;
            mostChar = 'b';
        }
        /**
         * 如果字母'c'的剩余个数更多，并且builder最后两个字母中有一个不为'c'，就可以在builder最后追加'c'
         */
        if (c > most && (builder.charAt(length - 1) != 'c' || builder.charAt(length - 2) != 'c')) {
            mostChar = 'c';
        }
        return mostChar;
    }
}
