package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 844. Backspace String Compare
 *
 * @author Baltan
 * @date 2018/8/2 18:24
 */
public class BackspaceCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));
    }

    public static boolean backspaceCompare(String S, String T) {
        char[] charArrayS = new char[S.length()];
        char[] charArrayT = new char[T.length()];
        int indexS = 0;
        int indexT = 0;

        for (char c : S.toCharArray()) {
            if (c == '#') {
                /**
                 * 如果还有字母可删，就删除
                 */
                if (indexS > 0) {
                    indexS--;
                }
            } else {
                charArrayS[indexS++] = c;
            }
        }

        for (char c : T.toCharArray()) {
            if (c == '#') {
                /**
                 * 如果还有字母可删，就删除
                 */
                if (indexT > 0) {
                    indexT--;
                }
            } else {
                charArrayT[indexT++] = c;
            }
        }
        return Objects.equals(new String(charArrayS, 0, indexS), new String(charArrayT, 0, indexT));
    }
}
