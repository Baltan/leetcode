package leetcode.algorithms;

/**
 * Description: 1844. Replace All Digits with Characters
 *
 * @author Baltan
 * @date 2022/6/7 09:14
 */
public class ReplaceDigits {
    public static void main(String[] args) {
        System.out.println(replaceDigits("a1c1e1"));
        System.out.println(replaceDigits("a1b2c3d4e"));
    }

    public static String replaceDigits(String s) {
        char[] charArray = s.toCharArray();

        for (int i = 1; i < charArray.length; i += 2) {
            charArray[i] = (char) (charArray[i - 1] + (charArray[i] - '0'));
        }
        return new String(charArray);
    }
}
