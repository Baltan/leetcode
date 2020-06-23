package leetcode.algorithms;

/**
 * Description: 67. Add Binary
 *
 * @author Baltan
 * @date 2017/11/24 20:58
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("0", "0"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int aLength = aChars.length;
        int bLength = bChars.length;
        int aIndex = aLength - 1;
        int bIndex = bLength - 1;
        StringBuilder builder = new StringBuilder(Math.max(aLength, bLength) + 1);
        /**
         * 进位
         */
        int carry = 0;
        /**
         * 从a和b的低位开始向高位逐一计算
         */
        while (aIndex >= 0 || bIndex >= 0) {
            int sum = carry;

            if (aIndex >= 0) {
                sum += aChars[aIndex] - '0';
            }

            if (bIndex >= 0) {
                sum += bChars[bIndex] - '0';
            }
            /**
             * 因为是二进制求和，所以要逢二进一
             */
            if (sum >= 2) {
                builder.insert(0, sum - 2);
                carry = 1;
            } else {
                builder.insert(0, sum);
                carry = 0;
            }
            aIndex--;
            bIndex--;
        }
        /**
         * 如果a和b的最高位求和之后还有进位1
         */
        if (carry == 1) {
            builder.insert(0, carry);
        }
        return builder.toString();
    }
}
