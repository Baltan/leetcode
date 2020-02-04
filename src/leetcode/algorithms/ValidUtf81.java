package leetcode.algorithms;

/**
 * Description: 393. UTF-8 Validation
 *
 * @author Baltan
 * @date 2020-02-04 11:59
 */
public class ValidUtf81 {
    public static void main(String[] args) {
        int[] data1 = {197, 130, 1};
        System.out.println(validUtf8(data1));

        int[] data2 = {235, 140, 4};
        System.out.println(validUtf8(data2));

        int[] data3 = {255};
        System.out.println(validUtf8(data3));
    }

    /**
     * 参考：<a href="https://leetcode.com/submissions/detail/300078175/"></a>
     *
     * @param data
     * @return
     */
    public static boolean validUtf8(int[] data) {
        int length = data.length;

        for (int i = 0; i < length; ) {
            /**
             * 字节第一位为0的情况
             */
            if ((data[i] >> 7 & 1) == 0) {
                i++;
            } else if ((data[i] >> 5 & 0b111) == 0b110) {
                /**
                 * 字节前三位为110的情况
                 */
                if (i + 1 < length && (data[i + 1] >> 6 & 0b11) == 0b10) {
                    i += 2;
                } else {
                    return false;
                }
            } else if ((data[i] >> 4 & 0b1111) == 0b1110) {
                /**
                 * 字节前四位为1110的情况
                 */
                if (i + 1 < length && i + 2 < length && (data[i + 1] >> 6 & 0b11) == 0b10 &&
                        (data[i + 2] >> 6 & 0b11) == 0b10) {
                    i += 3;
                } else {
                    return false;
                }
            } else if ((data[i] >> 3 & 0b11111) == 0b11110) {
                /**
                 * 字节前五位为11110的情况
                 */
                if (i + 1 < length && i + 2 < length && i + 3 < length && (data[i + 1] >> 6 & 0b11) == 0b10 &&
                        (data[i + 2] >> 6 & 0b11) == 0b10 && (data[i + 3] >> 6 & 0b11) == 0b10) {
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
}
