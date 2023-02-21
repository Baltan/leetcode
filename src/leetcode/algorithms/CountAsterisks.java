package leetcode.algorithms;

/**
 * Description: 2315. Count Asterisks
 *
 * @author Baltan
 * @date 2023/2/16 09:35
 */
public class CountAsterisks {
    public static void main(String[] args) {
        System.out.println(countAsterisks("l|*e*et|c**o|*de|"));
        System.out.println(countAsterisks("iamprogrammer"));
        System.out.println(countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
    }

    public static int countAsterisks(String s) {
        int result = 0;
        /**
         * 当前字符是否在一对"|"之间
         */
        boolean in = false;

        for (char c : s.toCharArray()) {
            if (c == '|') {
                in = !in;
            } else if (!in && c == '*') {
                result++;
            }
        }
        return result;
    }
}
