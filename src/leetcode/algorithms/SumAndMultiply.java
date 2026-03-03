package leetcode.algorithms;

/**
 * Description: 3754. Concatenate Non-Zero Digits and Multiply by Sum I
 *
 * @author baltan
 * @date 2026/1/26 11:22
 * @see SumAndMultiply1
 */
public class SumAndMultiply {
    public static void main(String[] args) {
        System.out.println(sumAndMultiply(65463628));
        System.out.println(sumAndMultiply(10203004));
        System.out.println(sumAndMultiply(1000));
    }

    public static long sumAndMultiply(int n) {
        /**
         * 数字n的各个数位上数字之和
         */
        int sum = 0;
        /**
         * 数字中所有非零数字按照它们的原始顺序连接起来后的值
         */
        int x = 0;
        /**
         * 数字x中各个数位的权重，从个位往上依次为1、10、100……
         */
        int weight = 1;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;

            if (digit != 0) {
                x += digit * weight;
                weight *= 10;
            }
            n /= 10;
        }
        return (long) sum * x;
    }
}
