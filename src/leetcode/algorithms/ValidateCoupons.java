package leetcode.algorithms;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * Description: 3606. Coupon Code Validator
 *
 * @author Baltan
 * @date 2025/8/14 23:38
 */
public class ValidateCoupons {
    public static void main(String[] args) {
        String[] code1 = {"SAVE20", "", "PHARMA5", "SAVE@20"};
        String[] businessLine1 = {"restaurant", "grocery", "pharmacy", "restaurant"};
        boolean[] isActive1 = {true, true, true, true};
        System.out.println(validateCoupons(code1, businessLine1, isActive1));

        String[] code2 = {"GROCERY15", "ELECTRONICS_50", "DISCOUNT10"};
        String[] businessLine2 = {"grocery", "electronics", "invalid"};
        boolean[] isActive2 = {false, true, true};
        System.out.println(validateCoupons(code2, businessLine2, isActive2));
    }

    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        return IntStream.range(0, code.length)
                .boxed()
                .filter(x -> {
                    if (!isActive[x]) {
                        return false;
                    }

                    if (code[x].isEmpty()) {
                        return false;
                    }

                    if (!Objects.equals(businessLine[x], "electronics") &&
                            !Objects.equals(businessLine[x], "grocery") &&
                            !Objects.equals(businessLine[x], "pharmacy") &&
                            !Objects.equals(businessLine[x], "restaurant")) {
                        return false;
                    }

                    for (char c : code[x].toCharArray()) {
                        if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && !(c >= '0' && c <= '9') && c != '_') {
                            return false;
                        }
                    }
                    return true;
                })
                .sorted((x, y) -> Objects.equals(businessLine[x], businessLine[y]) ?
                        code[x].compareTo(code[y]) : businessLine[x].compareTo(businessLine[y]))
                .map(x -> code[x])
                .toList();
    }
}
