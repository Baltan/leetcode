package leetcode.algorithms;

/**
 * Description: 2042. Check if Numbers Are Ascending in a Sentence
 *
 * @author Baltan
 * @date 2021/11/19 13:49
 */
public class AreNumbersAscending {
    public static void main(String[] args) {
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println(areNumbersAscending("hello world 5 x 5"));
        System.out.println(
                areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
        System.out.println(areNumbersAscending("4 5 11 26"));
        System.out.println(areNumbersAscending("a 1 2 3"));
    }

    public static boolean areNumbersAscending(String s) {
        /**
         * 头部空格为了在对s的第一个字符进行判断时，其也有前导字符；尾部空格为了s的最后一个token为数字时，其也能被判定到
         */
        s = " " + s + " ";
        int prevNum = 0;
        int currNum = 0;

        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            char prevChar = s.charAt(i - 1);

            if (currChar >= '0' && currChar <= '9') {
                /**
                 * 如果前导字符不为数字，说明当前字符是一个数字token的最高位，需要从0开始累加计算
                 */
                if (prevChar < '0' || prevChar > '9') {
                    currNum = 0;
                }
                /**
                 * 当前token如果是数字，累加计算
                 */
                currNum = currNum * 10 + (currChar - '0');
            } else {
                /**
                 * 如果前导字符是数字，说明刚获得一个数字token，需要和再前面的数字token进行大小比较
                 */
                if (prevChar >= '0' && prevChar <= '9') {
                    if (currNum <= prevNum) {
                        return false;
                    }
                    /**
                     * 保存当前数字token，用于后续比较计算
                     */
                    prevNum = currNum;
                }
            }
        }
        return true;
    }
}
