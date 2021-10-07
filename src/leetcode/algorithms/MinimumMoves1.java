package leetcode.algorithms;

/**
 * Description: 2027. Minimum Moves to Convert String
 *
 * @author Baltan
 * @date 2021/10/7 17:01
 */
public class MinimumMoves1 {
    public static void main(String[] args) {
        System.out.println(minimumMoves("XXX"));
        System.out.println(minimumMoves("XXOX"));
        System.out.println(minimumMoves("OOOO"));
    }

    public static int minimumMoves(String s) {
        int result = 0;
        int length = s.length();
        /**
         * 从左到右判断s的每一个字符，遇到"X"就进行一次翻转，并跳过接下去两个字符的判断
         */
        for (int i = 0; i < length; ) {
            if (s.charAt(i) == 'X') {
                result++;
                i += 3;
            } else {
                i++;
            }
        }
        return result;
    }
}
