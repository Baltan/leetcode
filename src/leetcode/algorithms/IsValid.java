package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: 20. Valid Parentheses
 *
 * @author Baltan
 * @date 2017/11/25 12:07
 */
public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        Stack<String> sta = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String currCharacter = s.substring(i, i + 1);
            if ("(".equals(currCharacter) || "[".equals(currCharacter) || "{".equals(currCharacter)) {
                sta.push(currCharacter);
            }
            if (")".equals(currCharacter)) {
                if (sta.isEmpty() || !"(".equals(sta.peek())) {
                    return false;
                } else {
                    sta.pop();
                }
            }
            if ("]".equals(currCharacter)) {
                if (sta.isEmpty() || !"[".equals(sta.peek())) {
                    return false;
                } else {
                    sta.pop();
                }
            }
            if ("}".equals(currCharacter)) {
                if (sta.isEmpty() || !"{".equals(sta.peek())) {
                    return false;
                } else {
                    sta.pop();
                }
            }
        }
        if (!sta.isEmpty()) {
            return false;
        }
        return true;
    }
}