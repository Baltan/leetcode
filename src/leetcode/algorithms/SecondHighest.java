package leetcode.algorithms;

/**
 * Description: 1796. Second Largest Digit in a String
 *
 * @author Baltan
 * @date 2022/7/4 09:24
 */
public class SecondHighest {
    public static void main(String[] args) {
        System.out.println(secondHighest("dfa12321afd"));
        System.out.println(secondHighest("abc1111"));
        System.out.println(secondHighest("7629451899864"));
        System.out.println(secondHighest("91"));
    }

    public static int secondHighest(String s) {
        /**
         * 字符串s中最大的数字
         */
        int first = -1;
        /**
         * 字符串s中第二大的数字
         */
        int second = -2;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int value = c - '0';

                if (value > first) {
                    second = first;
                    first = value;
                } else if (value != first && value > second) {
                    second = value;
                }
            }
        }
        /**
         * 如果second仍为初始值-2，说明字符串s中不存在第二大的数字
         */
        return second == -2 ? -1 : second;
    }
}
