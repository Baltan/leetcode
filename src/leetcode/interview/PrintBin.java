package leetcode.interview;

/**
 * Description: 面试题 05.02. 二进制数转字符串
 *
 * @author Baltan
 * @date 2020-03-14 22:02
 */
public class PrintBin {
    public static void main(String[] args) {
        System.out.println(printBin(0.625));
        System.out.println(printBin(0.1));
    }

    public static String printBin(double num) {
        StringBuilder builder = new StringBuilder("0.");
        /**
         * 从十分位开始逐一判断，num的二进制表示中该位是否是1，最多有30位小数
         */
        for (int i = 1; i <= 30; i++) {
            double value = Math.pow(0.5, i);

            if (num >= value) {
                builder.append(1);
                num -= value;
            } else {
                builder.append(0);
            }

            if (num == 0) {
                return builder.toString();
            }
        }
        return "ERROR";
    }
}
