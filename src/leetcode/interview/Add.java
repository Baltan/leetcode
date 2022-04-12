package leetcode.interview;

/**
 * Description: 面试题 17.01. 不用加号的加法
 *
 * @author Baltan
 * @date 2020-04-13 14:02
 * @see leetcode.algorithms.GetSum
 * @see leetcode.algorithms.Sum
 */
public class Add {
    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(add(-2, 3));
    }

    public static int add(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }
        /**
         * a^b为a和b无进位相加之和，(a&b)<<1为a和b进位部分相加之和
         */
        return add(a ^ b, (a & b) << 1);
    }
}
