package leetcode.algorithms;

/**
 * Description: 2264. Largest 3-Same-Digit Number in String
 *
 * @author Baltan
 * @date 2022/5/12 10:41
 */
public class LargestGoodInteger {
    public static void main(String[] args) {
        System.out.println(largestGoodInteger("6777133339"));
        System.out.println(largestGoodInteger("2300019"));
        System.out.println(largestGoodInteger("42352338"));
    }

    public static String largestGoodInteger(String num) {
        char[] charArray = num.toCharArray();
        /**
         * 最大优质整数的中间数字
         */
        int max = Integer.MIN_VALUE;
        /**
         * 最大优质整数的中间数字的索引位置
         */
        int midIndex = -1;

        for (int i = charArray.length - 2; i >= 1; ) {
            if (charArray[i] == charArray[i + 1] && charArray[i] == charArray[i - 1]) {
                if (charArray[i] - '0' > max) {
                    max = charArray[i] - '0';
                    midIndex = i;
                }
                /**
                 * 如果当前字符可以和左右两个字符构成一个优质整数，则以相邻字符作为中间字符的长度为3的子字符串 即使可以构成一个
                 * 优质整数，也不会比当前优质整数大，所以可以跳过判断
                 */
                i -= 2;
            } else {
                i -= 1;
            }
        }
        return max == Integer.MIN_VALUE ? "" : num.substring(midIndex - 1, midIndex + 2);
    }
}
