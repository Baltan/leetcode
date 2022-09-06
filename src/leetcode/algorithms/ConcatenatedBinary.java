package leetcode.algorithms;

/**
 * Description: 1680. Concatenation of Consecutive Binary Numbers
 *
 * @author Baltan
 * @date 2022/9/3 12:14
 */
public class ConcatenatedBinary {
    public static void main(String[] args) {
        System.out.println(concatenatedBinary(1));
        System.out.println(concatenatedBinary(2));
        System.out.println(concatenatedBinary(3));
        System.out.println(concatenatedBinary(12));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/concatenation-of-consecutive-binary-numbers/solution/java-beat-100-by-civitas-gwad/"></a>
     *
     * @param n
     * @return
     */
    public static int concatenatedBinary(int n) {
        long result = 0L;
        int mod = 1000000007;
        int offset = 0;

        for (int i = 1; i <= n; i++) {
            /**
             * 此时，i为2的幂，i的二进制表示位数比i-1的二进制表示位数多一位
             */
            if ((i & (i - 1)) == 0) {
                offset++;
            }
            /**
             * 当i为2时，得到的二进制表示字符串为"110"，相当于把i为1时的二进制字符串"1"左移offset=2位后再加上"10"，对应十进
             * 制表示即(1<<2)+2=6；
             * 当i为3时，得到的二进制表示字符串为"11011"，相当于把i为2时的二进制字符串"110"左移offset=2位后再加上"11"，对应
             * 十进制表示即(6<<2)+3=27；
             * 以此类推……
             */
            result = ((result << offset) + i) % mod;
        }
        return (int) result;
    }
}
