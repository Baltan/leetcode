package leetcode.algorithms;

/**
 * Description: 3330. Find the Original Typed String I
 *
 * @author Baltan
 * @date 2024/11/1 22:55
 */
public class PossibleStringCount {
    public static void main(String[] args) {
        System.out.println(possibleStringCount("abbcccc"));
        System.out.println(possibleStringCount("abcd"));
        System.out.println(possibleStringCount("aaaa"));
    }

    public static int possibleStringCount(String word) {
        int result = 0;

        for (int i = 1; i < word.length(); i++) {
            /**
             * 每当遇到和前一个相同的字母，可能就是重复出入的
             */
            if (word.charAt(i) == word.charAt(i - 1)) {
                result++;
            }
        }
        /**
         * 还有一种情况是所有字母都是正确输入的
         */
        return result + 1;
    }
}
