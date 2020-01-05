package leetcode.algorithms;

/**
 * Description: 1309. Decrypt String from Alphabet to Integer Mapping
 *
 * @author Baltan
 * @date 2020-01-05 13:09
 */
public class FreqAlphabets {
    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
        System.out.println(freqAlphabets("1326#"));
        System.out.println(freqAlphabets("25#"));
        System.out.println(freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }

    public static String freqAlphabets(String s) {
        StringBuilder builder = new StringBuilder();
        int length = s.length();

        for (int i = 0; i < length; ) {
            /**
             * 如果当前字符后面的第二个字符是'#'，则这三个字符的字符串是一组的，否则当前字符单独为一组
             */
            if (i + 2 < length && s.charAt(i + 2) == '#') {
                /**
                 * 含"#"的字符串前两个字符代表的数字
                 */
                int value = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                char c = (char) ('a' + value - 1);
                builder.append(c);
                i += 3;
            } else {
                int value = s.charAt(i) - '0';
                char c = (char) ('a' + value - 1);
                builder.append(c);
                i += 1;
            }
        }
        return builder.toString();
    }
}
