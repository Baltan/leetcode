package leetcode.algorithms;

/**
 * Description: 405. Convert a Number to Hexadecimal
 *
 * @author Baltan
 * @date 2020-03-08 11:52
 */
public class ToHex {
    public static void main(String[] args) {
        System.out.println(toHex(26));
        System.out.println(toHex(-1));
        System.out.println(toHex(Integer.MIN_VALUE));
        System.out.println(toHex(Integer.MAX_VALUE));
        System.out.println(toHex(0));
    }

    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        /**
         * 十六进制整型最多八位
         */
        int count = 8;
        /**
         * 将num的二进制表示，从最低位开始，每四位截取转化为十六进制表示即可
         */
        while (count > 0 && num != 0) {
            /**
             * 截取最低四位二进制数
             */
            int value = num & 0b1111;
            builder.insert(0, arr[value]);
            num >>= 4;
            count--;
        }
        return builder.toString();
    }
}
