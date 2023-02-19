package leetcode.algorithms;

/**
 * Description: 2571. Minimum Operations to Reduce an Integer to 0
 *
 * @author Baltan
 * @date 2023/2/19 15:45
 */
public class MinOperations11 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(57410));
        System.out.println(minOperations(57410));
        System.out.println(minOperations(39));
        System.out.println(minOperations(54));
    }

    public static int minOperations(int n) {
        /**
         * 假设n不加任何2的幂，只进行减操作，则需要的次数就是n的二进制值中1的个数
         */
        int result = oneBitCount(n);
        /**
         * 假设n的二进制值为0bxxxxx，则m的值为0b1xxxxx，即在更高位再补充一个1
         */
        int m = 1;

        while (m < n) {
            m <<= 1;
        }
        m |= n;
        /**
         * 现将n增加到i，再将i减到0需要的总操作数为oneBitCount(i-n)+oneBitCount(i)
         */
        for (int i = n + 1; i <= m; i++) {
            result = Math.min(result, oneBitCount(i - n) + oneBitCount(i));
        }
        return result;
    }

    /**
     * 数字num的二进制表示中1的个数
     *
     * @param num
     * @return
     */
    public static int oneBitCount(int num) {
        int count = 0;

        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }
}
