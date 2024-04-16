package leetcode.algorithms;

/**
 * Description: 3110. Score of a String
 *
 * @author Baltan
 * @date 2024/4/16 22:38
 */
public class ScoreOfString {
    public static void main(String[] args) {
        System.out.println(scoreOfString("hello"));
        System.out.println(scoreOfString("zaz"));
    }

    public static int scoreOfString(String s) {
        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            result += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return result;
    }
}
