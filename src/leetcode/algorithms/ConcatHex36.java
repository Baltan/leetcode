package leetcode.algorithms;

/**
 * Description: 3602. Hexadecimal and Hexatrigesimal Conversion
 *
 * @author Baltan
 * @date 2025/8/7 22:59
 */
public class ConcatHex36 {
    public static void main(String[] args) {
        System.out.println(concatHex36(13));
        System.out.println(concatHex36(36));
    }

    public static String concatHex36(int n) {
        StringBuilder builder = new StringBuilder();
        /**
         * 将num1换算为16进制值
         */
        int num1 = n * n;
        /**
         * 将num2换算为36进制值
         */
        int num2 = num1 * n;

        while (num2 != 0) {
            int remainder = num2 % 36;
            num2 /= 36;
            /**
             * 使用{@link StringBuilder#append(Object)}重载方法，使得结果字符串中能同时保留数字和大写字母
             */
            builder.append(remainder >= 10 ? (char) ('A' + remainder - 10) : String.valueOf(remainder));
        }

        while (num1 != 0) {
            int remainder = num1 % 16;
            num1 >>= 4;
            builder.append(remainder >= 10 ? (char) ('A' + remainder - 10) : String.valueOf(remainder));
        }
        return builder.reverse().toString();
    }
}
