package leetcode.algorithms;

/**
 * Description: 1556. Thousand Separator
 *
 * @author Baltan
 * @date 2020-09-20 23:31
 */
public class ThousandSeparator {
    public static void main(String[] args) {
        System.out.println(thousandSeparator(987));
        System.out.println(thousandSeparator(1234));
        System.out.println(thousandSeparator(123456789));
        System.out.println(thousandSeparator(0));
    }

    public static String thousandSeparator(int n) {
        if (n == 0) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        /**
         * 连续添加数字的个数，每隔三个数字需要添加一个"."
         */
        int count = 0;

        while (n > 0) {
            /**
             * 每隔三个数字需要添加一个"."
             */
            if (count == 3) {
                builder.append(".");
                count = 0;
            }

            builder.append(n % 10);
            n /= 10;
            count++;
        }
        return builder.reverse().toString();
    }
}
