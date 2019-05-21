package leetcode.algorithms;

/**
 * Description: 796. Rotate String
 *
 * @author Baltan
 * @date 2018/8/1 17:16
 */
public class RotateString {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("abcde", "abced"));
        System.out.println(rotateString("", ""));
    }

    public static boolean rotateString(String A, String B) {
        if ("".equals(A) && "".equals(B)) {
            return true;
        }
        int lengthA = A.length();
        for (int i = 0; i < lengthA; i++) {

            if ((A.substring(i, lengthA) + A.substring(0, i)).equals(B)) {
                return true;
            }
        }
        return false;
    }
}
