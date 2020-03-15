package leetcode.interview;

/**
 * Description: 面试题 05.06. 整数转换
 *
 * @author Baltan
 * @date 2020-03-15 14:29
 */
public class ConvertInteger {
    public static void main(String[] args) {
        System.out.println(convertInteger(29, 15));
        System.out.println(convertInteger(1, 2));
        System.out.println(convertInteger(424242, -42243553));
    }

    public static int convertInteger(int A, int B) {
        int result = 0;

        while (A != 0 || B != 0) {
            if ((A & 1) != (B & 1)) {
                result++;
            }
            /**
             * 因为A和B可能为负数，要进行无符号右移，右移后负数的高位也是补0
             */
            A >>>= 1;
            B >>>= 1;
        }
        return result;
    }
}
