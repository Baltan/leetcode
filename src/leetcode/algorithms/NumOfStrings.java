package leetcode.algorithms;

/**
 * Description: 1967. Number of Strings That Appear as Substrings in Word
 *
 * @author Baltan
 * @date 2022/1/29 13:38
 */
public class NumOfStrings {
    public static void main(String[] args) {
        System.out.println(numOfStrings(new String[]{"a", "abc", "bc", "d"}, "abc"));
        System.out.println(numOfStrings(new String[]{"a", "b", "c"}, "aaaaabbbbb"));
        System.out.println(numOfStrings(new String[]{"a", "a", "a"}, "ab"));
    }

    public static int numOfStrings(String[] patterns, String word) {
        int result = 0;

        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                result++;
            }
        }
        return result;
    }
}
