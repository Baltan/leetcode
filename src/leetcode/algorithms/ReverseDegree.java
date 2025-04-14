package leetcode.algorithms;

/**
 * Description: 3498. Reverse Degree of a String
 * @author Baltan
 * @date 2025/4/14 23:31
 */
public class ReverseDegree {
    public static void main(String[] args) {
        System.out.println(reverseDegree("abc"));
        System.out.println(reverseDegree("zaza"));
    }

    public static int reverseDegree(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result += (i + 1) * (26 - s.charAt(i) + 'a');
        }
        return result;
    }
}
