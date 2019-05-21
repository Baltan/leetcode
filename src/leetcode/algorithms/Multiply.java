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
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        char[] array = new char[length1 + length2];
        int arrayLength = length1 + length2;
        int carry = 0;
        for (int i = arrayLength - 1; i >= 0; i--) {
            int offset = arrayLength - 1 - i;
            int firstNum;
            int secondNum;
            int sum = 0;
            for (int j = 0; j <= offset; j++) {
                if (length1 - 1 - j >= 0 && length2 - 1 - (offset - j) >= 0) {
                    firstNum = num1Array[length1 - 1 - j] - '0';
                    secondNum = num2Array[length2 - 1 - (offset - j)] - '0';
                    sum += firstNum * secondNum;
                } else {
                    sum += 0;
                }
            }
            sum += carry;
            array[i] = (char) (sum % 10 + '0');
            carry = sum / 10;
        }
        return array[0] == '0' ? new String(array).substring(1) : new String(array);
    }
}
