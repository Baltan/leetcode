package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1704. Determine if String Halves Are Alike
 *
 * @author Baltan
 * @date 2022/8/20 14:10
 */
public class HalvesAreAlike {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
        System.out.println(halvesAreAlike("textbook"));
    }

    public static boolean halvesAreAlike(String s) {
        /**
         * 字符串s前半部分和后半部分元音字符个数差
         */
        int different = 0;
        int halfLength = s.length() / 2;
        char[] charArray = s.toCharArray();
        Set<Character> vowels =
                new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        /**
         * 计算字符串s前半部分的元音个数
         */
        for (int i = 0; i < halfLength; i++) {
            if (vowels.contains(charArray[i])) {
                different++;
            }
        }
        /**
         * 抵扣掉字符串s后半部分的元音个数
         */
        for (int i = halfLength; i < s.length(); i++) {
            if (vowels.contains(charArray[i])) {
                different--;
            }
        }
        return different == 0;
    }
}
