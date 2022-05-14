package leetcode.algorithms;

/**
 * Description: 2259. Remove Digit From Number to Maximize Result
 *
 * @author Baltan
 * @date 2022/5/12 10:58
 */
public class RemoveDigit {
    public static void main(String[] args) {
        System.out.println(removeDigit("123", '3'));
        System.out.println(removeDigit("1231", '1'));
        System.out.println(removeDigit("551", '5'));
    }

    public static String removeDigit(String number, char digit) {
        char[] charArray = number.toCharArray();
        int length = charArray.length;
        /**
         * digit在number中最后一次出现的索引位置
         */
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (charArray[i] == digit) {
                /**
                 * 从前向后遍历的过程中，如果某个digit比后一位的数字小，则移除这一位digit即可
                 */
                if (i + 1 < length && charArray[i] < charArray[i + 1]) {
                    return number.substring(0, i) + number.substring(i + 1);
                }
                index = i;
            }
        }
        /**
         * 移除number中的最后一个digit
         */
        return number.substring(0, index) + number.substring(index + 1);
    }
}
