package leetcode.algorithms;

/**
 * Description: 1323. Maximum 69 Number
 *
 * @author Baltan
 * @date 2020-02-02 13:41
 */
public class Maximum69Number {
    public static void main(String[] args) {
        System.out.println(maximum69Number(9996));
        System.out.println(maximum69Number(9999));
    }

    public static int maximum69Number(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int length = charArray.length;
        /**
         * 从前向后找到第一个"6"，改为"9"即可
         */
        for (int i = 0; i < length; i++) {
            if (charArray[i] == '6') {
                charArray[i] = '9';
                break;
            }
        }
        return Integer.valueOf(new String(charArray));
    }
}
