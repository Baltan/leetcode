package leetcode.algorithms;

/**
 * Description: 393. UTF-8 Validation
 *
 * @author Baltan
 * @date 2020-02-04 11:59
 */
public class ValidUtf8 {
    public static void main(String[] args) {
        int[] data1 = {197, 130, 1};
        System.out.println(validUtf8(data1));

        int[] data2 = {235, 140, 4};
        System.out.println(validUtf8(data2));
    }

    public static boolean validUtf8(int[] data) {
        int length = data.length;
        /**
         * mask和data[i]做或运算后截取最后八位可以得到一个字节
         */
        int mask = Integer.parseInt("100000000", 2);

        for (int i = 0; i < length; ) {
            String binaryString = help(data[i], mask);

            if (binaryString.startsWith("0")) {
                i++;
            } else if (binaryString.startsWith("110")) {
                if (i + 1 < length && help(data[i + 1], mask).startsWith("10")) {
                    i += 2;
                } else {
                    return false;
                }
            } else if (binaryString.startsWith("1110")) {
                if (i + 1 < length && i + 2 < length && help(data[i + 1], mask).startsWith("10") &&
                        help(data[i + 2], mask).startsWith("10")) {
                    i += 3;
                } else {
                    return false;
                }
            } else if (binaryString.startsWith("11110")) {
                if (i + 1 < length && i + 2 < length && i + 3 < length &&
                        help(data[i + 1], mask).startsWith("10") &&
                        help(data[i + 2], mask).startsWith("10") &&
                        help(data[i + 3], mask).startsWith("10")) {
                    i += 4;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取数字num二进制表示的末尾8位
     *
     * @param num
     * @param mask
     * @return
     */
    public static String help(int num, int mask) {
        /**
         * mask=256，二进制表示为0b100000000，和num做或运算后截取最后八位
         */
        String binaryString = Integer.toBinaryString(num | mask);
        return binaryString.substring(binaryString.length() - 8);
    }
}
