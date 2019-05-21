package leetcode.algorithms;

/**
 * Description: 344. Reverse String
 *
 * @author Baltan
 * @date 2017/11/17 14:22
 */
public class ReverseString {
    public static void main(String[] args) {
        String s1 = "hello";
        System.out.println(reverseString(s1));
    }

    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s, i, i + 1);
        }
        return sb.toString();
    }
}
