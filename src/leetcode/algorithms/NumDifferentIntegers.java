package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1805. Number of Different Integers in a String
 *
 * @author Baltan
 * @date 2022/6/28 11:36
 */
public class NumDifferentIntegers {
    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("035985750011523523129774573439111590559325a1554234973"));
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(numDifferentIntegers("leet1234code234"));
        System.out.println(numDifferentIntegers("a1b01c001"));
        System.out.println(numDifferentIntegers("0a0"));
    }

    public static int numDifferentIntegers(String word) {
        /**
         * 保证当word的结尾部分的字符串也表示为一个数字时，不会被遗漏
         */
        word = word + "a";
        Set<String> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                builder.append(c);
            } else if (builder.length() > 0) {
                /**
                 * 英文字符前的部分字符串构成一个完整的数字，删除该数字字符串的前导0
                 */
                while (builder.length() > 0 && builder.charAt(0) == '0') {
                    builder.deleteCharAt(0);
                }
                /**
                 * 如果删除前导0后，该数字字符串长度为0，说明元数字字符串的值为0
                 */
                set.add(builder.length() == 0 ? "0" : builder.toString());
                builder = new StringBuilder();
            }
        }
        return set.size();
    }
}
