package leetcode.algorithms;

/**
 * Description: 709. To Lower Case
 *
 * @author Baltan
 * @date 2018/7/30 08:57
 */
public class ToLowerCase {
    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello"));
        System.out.println(toLowerCase("here"));
        System.out.println(toLowerCase("LOVELY"));
        System.out.println(toLowerCase(""));
    }

    public static String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        char letter;
        for (int i = 0; i < str.length(); i++) {
            letter = str.charAt(i);
            if (letter >= 65 && letter <= 90) {
                letter = (char) (letter + 32);
                sb.append(letter);
            } else {
                sb.append(letter);
            }
        }
        return sb.toString();
    }
}
