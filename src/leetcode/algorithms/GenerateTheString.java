package leetcode.algorithms;

/**
 * Description: 1374. Generate a String With Characters That Have Odd Counts
 *
 * @author Baltan
 * @date 2020-09-02 23:12
 */
public class GenerateTheString {
    public static void main(String[] args) {
        System.out.println(generateTheString(4));
        System.out.println(generateTheString(2));
        System.out.println(generateTheString(7));
    }

    public static String generateTheString(int n) {
        StringBuilder builder = new StringBuilder(n);
        /**
         * 如果n为奇数，就构建一个包含n个"a"的字符串；如果n为偶数，就构建一个包含1个"a"和n-1个"b"的字符串
         */
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                builder.append('a');
            }
        } else {
            builder.append('a');

            for (int i = 1; i < n; i++) {
                builder.append('b');
            }
        }
        return builder.toString();
    }
}
