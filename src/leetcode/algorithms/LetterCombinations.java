package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 17. Letter Combinations of a Phone Number
 *
 * @author Baltan
 * @date 2018/8/29 11:15
 */
public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("23456").size());
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
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
        char[] array = map.get(fistChar);
        if (digits.length() > 1) {
            String tailString = digits.substring(1);
            List<String> list = letterCombinations(tailString);
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < list.size(); j++) {
                    res.add(new StringBuilder().append(array[i]).append(list.get(j)).toString());
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                res.add(new StringBuilder().append(array[i]).toString());
            }
        }
        return res;
    }
}
