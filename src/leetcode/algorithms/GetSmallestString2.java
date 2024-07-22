package leetcode.algorithms;

/**
 * Description: 3216. Lexicographically Smallest String After a Swap
 *
 * @author baltan
 * @date 2024/7/17 15:02
 */
public class GetSmallestString2 {
    public static void main(String[] args) {
        System.out.println(getSmallestString("45320"));
        System.out.println(getSmallestString("001"));
    }

    public static String getSmallestString(String s) {
        char[] charArray = s.toCharArray();
        /**
         * 从前向后找到第一组相邻的数字，它们奇偶性相同并且前面的数字大于后面的数字，交换它们的位置即可
         */
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] < charArray[i - 1] && ((charArray[i] - '0') & 1) == ((charArray[i - 1] - '0') & 1)) {
                char temp = charArray[i];
                charArray[i] = charArray[i - 1];
                charArray[i - 1] = temp;
                break;
            }
        }
        return new String(charArray);
    }
}
