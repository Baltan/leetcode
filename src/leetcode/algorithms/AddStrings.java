package leetcode.algorithms;

/**
 * Description: 415. Add Strings
 *
 * @author Baltan
 * @date 2018/1/4 15:12
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("999", "1"));
        System.out.println(addStrings("999", "111"));
        System.out.println(addStrings("0", "0"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int num1Length = num1.length();
        int num2Length = num2.length();
        if (num1Length > num2Length) {
            int lengthDistance = num1Length - num2Length;
            StringBuilder sb = new StringBuilder(num2);
            for (int i = 0; i < lengthDistance; i++) {
                sb.insert(0, "0");
            }
            num2 = sb.toString();
        } else if (num2Length > num1Length) {
            int lengthDistance = num2Length - num1Length;
            StringBuilder sb = new StringBuilder(num1);
            for (int i = 0; i < lengthDistance; i++) {
                sb.insert(0, "0");
            }
            num1 = sb.toString();
        }
        int length = num1.length();
        int carryDigit = 0;
        int sum = 0;
        for (int i = length - 1; i >= 0; i--) {
            int addend1 = num1.charAt(i) - 48;
            int addend2 = num2.charAt(i) - 48;
            if ((sum = addend1 + addend2 + carryDigit) < 10) {
                result.insert(0, sum);
                carryDigit = 0;
            } else {
                result.insert(0, sum - 10);
                carryDigit = 1;
            }
        }
        if (carryDigit == 1) {
            result.insert(0, 1);
        }
        return result.toString();
    }
}
