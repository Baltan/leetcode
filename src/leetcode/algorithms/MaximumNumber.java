package leetcode.algorithms;

/**
 * Description: 1946. Largest Number After Mutating Substring
 *
 * @author Baltan
 * @date 2022/2/16 11:41
 */
public class MaximumNumber {
    public static void main(String[] args) {
        System.out.println(maximumNumber("132", new int[]{9, 8, 5, 0, 3, 6, 4, 2, 6, 8}));
        System.out.println(maximumNumber("021", new int[]{9, 4, 3, 5, 7, 2, 1, 9, 0, 6}));
        System.out.println(maximumNumber("5", new int[]{1, 4, 7, 5, 3, 2, 5, 6, 9, 4}));
    }

    public static String maximumNumber(String num, int[] change) {
        char[] charArray = num.toCharArray();
        /**
         * 找到num中最高位的可以被变大的数字
         */
        int firstIndex = -1;

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int value = c - '0';

            if (change[value] > value) {
                firstIndex = i;
                break;
            }
        }
        /**
         * 没有一个数字可以被变大，说明原数字num不能变大
         */
        if (firstIndex == -1) {
            return num;
        }
        /**
         * 从firstIndex位开始向低位逐一判断能否使当前位的数字变得更大，直到遇到一个数字转变之后会变小为止
         */
        for (int i = firstIndex; i < charArray.length; i++) {
            char c = charArray[i];
            int value = c - '0';

            if (change[value] < value) {
                break;
            } else {
                charArray[i] = (char) (change[value] + '0');
            }
        }
        return new String(charArray);
    }
}
