package leetcode.algorithms;

/**
 * Description: 2278. Percentage of Letter in String
 *
 * @author Baltan
 * @date 2023/2/17 14:25
 */
public class PercentageLetter {
    public static void main(String[] args) {
        System.out.println(percentageLetter("foobar", 'o'));
        System.out.println(percentageLetter("jjjj", 'k'));
    }

    public static int percentageLetter(String s, char letter) {
        /**
         * 字符串s中字符letter的个数
         */
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == letter) {
                count++;
            }
        }
        return count * 100 / s.length();
    }
}
