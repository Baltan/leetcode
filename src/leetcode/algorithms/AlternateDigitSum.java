package leetcode.algorithms;

/**
 * Description: 2544. Alternating Digit Sum
 *
 * @author Baltan
 * @date 2023/2/1 10:10
 */
public class AlternateDigitSum {
    public static void main(String[] args) {
        System.out.println(alternateDigitSum(521));
        System.out.println(alternateDigitSum(111));
        System.out.println(alternateDigitSum(886996));
    }

    public static int alternateDigitSum(int n) {
        int result = 0;
        /**
         * 假设最低位个位的符号为+
         */
        int weight = 1;
        /**
         * 逐一将数字n的每一位数字连带符号相加
         */
        while (n != 0) {
            int digit = n % 10;
            result += digit * weight;
            n /= 10;
            weight = -weight;
        }
        /**
         * 如果最高位再前一位数字符号为正，说明我们假设的情况下最高位数字符号为负，需要取result的相反数
         */
        return weight == 1 ? -result : result;
    }
}
