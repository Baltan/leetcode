package leetcode.algorithms;

/**
 * Description: 43. Multiply Strings
 *
 * @author Baltan
 * @date 2018/9/5 10:45
 */
public class Multiply {
    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));
        System.out.println(multiply("123", "456"));
        System.out.println(multiply("123456", "789"));
        System.out.println(multiply("9133", "0"));
    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int length1 = num1.length();
        int length2 = num2.length();
        int totalLength = length1 + length2;
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        char[] result = new char[length1 + length2];
        /**
         * 进位
         */
        int carry = 0;
        /**
         * 最最低位开始向最高位计算result的每一位的值
         */
        for (int i = totalLength - 1; i >= 0; i--) {
            /**
             * num1和num2尾部剩余数字长度之和，即最后计算出的值sum实际代表sum*(10^totalTailLength)
             */
            int totalTailLength = totalLength - 1 - i;
            int x;
            int y;
            int sum = 0;
            /**
             * j为num1尾部剩余数字的个数，则totalTailLength-j为num2尾部剩余数字的个数
             */
            for (int j = 0; j <= totalTailLength; j++) {
                if (length1 - 1 - j >= 0 && length2 - 1 - (totalTailLength - j) >= 0) {
                    x = chars1[length1 - 1 - j] - '0';
                    y = chars2[length2 - 1 - (totalTailLength - j)] - '0';
                    sum += x * y;
                } else {
                    sum += 0;
                }
            }
            sum += carry;
            result[i] = (char) (sum % 10 + '0');
            carry = sum / 10;
        }
        /**
         * 如果result最高位为0，则把该位去掉
         */
        return result[0] == '0' ? new String(result).substring(1) : new String(result);
    }
}
