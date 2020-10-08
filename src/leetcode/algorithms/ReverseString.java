package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 344. Reverse String
 *
 * @author Baltan
 * @date 2017/11/17 14:22
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s1);
        System.out.println(Arrays.toString(s1));

        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s2);
        System.out.println(Arrays.toString(s2));

        char[] s3 = {};
        reverseString(s3);
        System.out.println(Arrays.toString(s3));

        char[] s4 = {'a'};
        reverseString(s4);
        System.out.println(Arrays.toString(s4));
    }

    public static void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }

        int mid = (s.length - 1) / 2;
        /**
         * 首尾配对交换字符
         */
        for (int i = 0; i <= mid; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
