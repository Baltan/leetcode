package leetcode.algorithms;

import java.util.*;

/**
 * Description: 17. Letter Combinations of a Phone Number
 *
 * @author Baltan
 * @date 2018/8/29 11:15
 * @see LetterCombinations1
 */
public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("23456"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        char fistChar = digits.charAt(0);
        char[] chars = map.get(fistChar);
        /**
         * 如果digits的长度大于1，则除去第一个数字后，后面还有数字，递归计算后面这串数字可以得到的所有组合
         */
        if (digits.length() > 1) {
            String tail = digits.substring(1);
            /**
             * 除第一个数字外，后面这串数字可以得到的所有组合
             */
            List<String> tailCombinations = letterCombinations(tail);
            /**
             * 将第一个数组可以得到的所有组合和这串数字可以得到的所有组合两两组合
             */
            for (char c : chars) {
                for (int j = 0; j < tailCombinations.size(); j++) {
                    result.add(c + tailCombinations.get(j));
                }
            }
        } else {
            /**
             * 后面没有数字，即digits值包含一位数字，则chars中的所有字符就是可以得到的所有组合
             */
            for (char c : chars) {
                result.add(String.valueOf(c));
            }
        }
        return result;
    }
}
