package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3324. Find the Sequence of Strings Appeared on the Screen
 *
 * @author Baltan
 * @date 2024/10/20 15:44
 */
public class StringSequence {
    public static void main(String[] args) {
        System.out.println(stringSequence("abc"));
        System.out.println(stringSequence("he"));
    }

    public static List<String> stringSequence(String target) {
        List<String> result = new ArrayList<>();
        String s = "";

        for (char c : target.toCharArray()) {
            /**
             * 从字符'a'开始切换，直到得到c所表示的字符
             */
            for (char i = 'a'; i <= c; i++) {
                result.add(s + i);
            }
            s += c;
        }
        return result;
    }
}
