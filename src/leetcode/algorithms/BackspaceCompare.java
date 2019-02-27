package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: Backspace String Compare
 *
 * @author Baltan
 * @date 2018/8/2 18:24
 */
public class BackspaceCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));
    }

    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c != '#') {
                stackS.push(c);
            } else {
                if (stackS.size() != 0) {
                    stackS.pop();
                }
            }
        }

        for (char c : T.toCharArray()) {
            if (c != '#') {
                stackT.push(c);
            } else {
                if (stackT.size() != 0) {
                    stackT.pop();
                }
            }
        }
        return stackS.equals(stackT);
    }
}
