package leetcode.algorithms;

/**
 * Description: 58. Length of Last Word
 *
 * @author Baltan
 * @date 2017/11/27 16:31
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord(""));
        System.out.println(lengthOfLastWord("Java"));
        System.out.println(lengthOfLastWord("a "));
        System.out.println(lengthOfLastWord("b   a    "));
    }

    public static int lengthOfLastWord(String s) {
        if (s.trim().equals("")) {
            return 0;
        }
        if (!s.contains(" ")) {
            return s.length();
        }
        int start = s.length() - 1;
        int end = 0;
        boolean findEnd = false;
        boolean findStart = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!s.substring(i, i + 1).equals(" ") && !findEnd) {
                end = i;
                findEnd = true;
            }
            if (s.substring(i, i + 1).equals(" ") && i < end && !findStart) {
                start = i + 1;
                findStart = true;
            }
        }
        if (!findStart) {
            start = 0;
        }
        return end - start + 1;
    }
}
