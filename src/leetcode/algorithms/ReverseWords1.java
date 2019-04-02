package leetcode.algorithms;

/**
 * Description: Reverse Words in a String
 *
 * @author Baltan
 * @date 2019-04-02 09:23
 */
public class ReverseWords1 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int start = 0;
        int end = 0;
        int length = s.length();

        while (end <= length) {
            if (start < length && s.charAt(start) == ' ') {
                start++;
                end++;
            } else if (end < length && s.charAt(end) != ' ') {
                end++;
            } else {
                builder.insert(0, s.substring(start, end).trim());
                builder.insert(0, ' ');
                start = end + 1;
                end = start;
            }
        }
        return builder.toString().trim();
    }
}
