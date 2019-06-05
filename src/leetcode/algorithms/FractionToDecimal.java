package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 166. Fraction to Recurring Decimal
 *
 * @author Baltan
 * @date 2019-06-05 09:20
 */
public class FractionToDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 1));
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(1, 3));
        System.out.println(fractionToDecimal(1, 4));
        System.out.println(fractionToDecimal(1, 5));
        System.out.println(fractionToDecimal(1, 6));
        System.out.println(fractionToDecimal(1, 7));
        System.out.println(fractionToDecimal(1, 8));
        System.out.println(fractionToDecimal(1, 9));
        System.out.println(fractionToDecimal(1, 10));
        System.out.println(fractionToDecimal(1, 11));
        System.out.println(fractionToDecimal(1, 12));
        System.out.println(fractionToDecimal(1, 13));
        System.out.println(fractionToDecimal(1, 14));
        System.out.println(fractionToDecimal(1, 15));
        System.out.println(fractionToDecimal(1, 16));
        System.out.println(fractionToDecimal(1, 17));
        System.out.println(fractionToDecimal(1, 18));
        System.out.println(fractionToDecimal(1, 19));
        System.out.println(fractionToDecimal(1, 20));
        System.out.println(fractionToDecimal(2, 3));
        System.out.println(fractionToDecimal(2, 4));
        System.out.println(fractionToDecimal(2, 5));
        System.out.println(fractionToDecimal(2, 6));
        System.out.println(fractionToDecimal(2, 7));
        System.out.println(fractionToDecimal(2, 8));
        System.out.println(fractionToDecimal(2, 9));
        System.out.println(fractionToDecimal(2, 10));
        System.out.println(fractionToDecimal(3, 7));
        System.out.println(fractionToDecimal(4, 7));
        System.out.println(fractionToDecimal(5, 7));
        System.out.println(fractionToDecimal(6, 7));
        System.out.println(fractionToDecimal(61, 7));
        System.out.println(fractionToDecimal(62, 7));
        System.out.println(fractionToDecimal(63, 7));
        System.out.println(fractionToDecimal(64, 7));
        System.out.println(fractionToDecimal(65, 7));
        System.out.println(fractionToDecimal(66, 7));
        System.out.println(fractionToDecimal(67, 7));
        System.out.println(fractionToDecimal(111111, 1000000000));
        System.out.println(fractionToDecimal(-50, 8));
        System.out.println(fractionToDecimal(0, 8));
        System.out.println(fractionToDecimal(-1, -2147483648));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder builder = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        long lNumerator = numerator;
        long lDenominator = denominator;

        if (lNumerator < 0 && lDenominator > 0) {
            builder.append("-");
            lNumerator = -lNumerator;
        } else if (lNumerator > 0 && lDenominator < 0) {
            builder.append("-");
            lDenominator = -lDenominator;
        }

        if ((lNumerator * 1.0 / lDenominator) % 1 == 0) {
            builder.append(lNumerator / lDenominator);
            return builder.toString();
        }

        long quotient = lNumerator / lDenominator;
        long remainder = lNumerator - quotient * lDenominator;
        builder.append(quotient).append(".");
        lNumerator = remainder * 10;
        int position = 1;

        while (true) {
            if (map.containsKey(lNumerator)) {
                int index = builder.indexOf(".");
                builder.insert(index + map.get(lNumerator), "(");
                builder.append(")");
                return builder.toString();
            }

            map.put(lNumerator, position);
            quotient = lNumerator / lDenominator;
            remainder = lNumerator - quotient * lDenominator;
            builder.append(quotient);
            position++;

            if (remainder == 0) {
                return builder.toString();
            }
            lNumerator = remainder * 10;
        }
    }
}
