package leetcode.interview;

/**
 * Description: 面试题 08.05. 递归乘法
 *
 * @author Baltan
 * @date 2020-03-15 22:24
 */
public class Multiply {
    public static void main(String[] args) {
        System.out.println(multiply(5,6));
        System.out.println(multiply(55,77));
        System.out.println(multiply(55,-77));
        System.out.println(multiply(-55,-77));
    }

    public static int multiply(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }

        if (A == 1) {
            return B;
        }

        if (B == 1) {
            return A;
        }

        if (A < 0 && B < 0) {
            return multiply(-A, -B);
        } else if (A < 0) {
            return -multiply(-A, B);
        } else if (B < 0) {
            return -multiply(A, -B);
        } else {
            int max = Math.max(A, B);
            int min = Math.min(A, B);
            int result = 0;
            /**
             * max的二进制表示中每位上的1从低位开始数所在的索引（0-based）
             */
            int bit = 0;
            /**
             * 例如：multiply(5,6)
             *     =5 × 6
             *     =5 × 0b110
             *     =((5×1)<<1) + ((5×1)<<2)
             *     =(multiply(5,1)<<1) + (multiply(5,1)<<2)
             *     =(5<<1) + (5<<2)
             *     =10 + 20
             *     =30
             */
            while (max > 0) {
                if ((max & 1) == 1) {
                    result += (multiply(1, min) << bit);
                }
                bit++;
                max >>= 1;
            }
            return result;
        }
    }
}
