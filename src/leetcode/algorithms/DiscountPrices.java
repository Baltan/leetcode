package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 2288. Apply Discount to Prices
 *
 * @author Baltan
 * @date 2023/1/22 15:15
 */
public class DiscountPrices {
    public static void main(String[] args) {
        System.out.println(discountPrices("706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6", 28));
        System.out.println(discountPrices("$76111 ab $6 $", 48));
        System.out.println(discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
        System.out.println(discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
    }

    public static String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        /**
         * 所有价格最终乘以的比例系数
         */
        double proportion = 1 - 0.01 * discount;

        outer:
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            /**
             * 单词word不是一个价格
             */
            if (!word.startsWith("$") || Objects.equals("$", word)) {
                continue;
            }
            /**
             * 当前价格的数值
             */
            long value = 0L;

            for (int j = 1; j < word.length(); j++) {
                char c = word.charAt(j);
                /**
                 * 存在非数字字符，单词word不是价格
                 */
                if (!Character.isDigit(c)) {
                    continue outer;
                }
                value = value * 10 + (c - '0');
            }
            /**
             * 替换价格，并保留两位小数
             */
            words[i] = "$" + String.format("%.2f", value * proportion);
        }
        return String.join(" ", words);
    }
}
