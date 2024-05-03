package leetcode.algorithms;

/**
 * Description: 3133. Minimum Array End
 *
 * @author Baltan
 * @date 2024/5/3 16:33
 */
public class MinEnd {
    public static void main(String[] args) {
        System.out.println(minEnd(6715154, 7193485));
        System.out.println(minEnd(3, 4));
        System.out.println(minEnd(2, 7));
    }

    public static long minEnd(int n, int x) {
        /**
         * 因为数组中的n个元素逐一按位与运算后的值为x，所以如果x的二进制值的某一位上为1，则这n个数的二进制值的这一位上必须都为1。为了使得n个
         * 数中的最大值尽可能小，将[0,n-1]中每个元素的二进制值从低位到高位逐一填在x值为0的二进制位上即可。例如：
         * n-1=6715153，二进制值为11001100111011100010001
         * x=7193485，二进制值为11011011100001110001101
         * 保持x中值为1的二进制位不动，从低位到高位，在值为0的二进制位上逐一填进n-1的二进制位
         * x    0000000000000011011011100001110001101
         *      11001100111011     1   0001   000  1
         * 得到  1100110011101111011111100011110001111
         */
        long result = x;
        int offset = 0;
        n--;

        while (n > 0) {
            /**
             * 找到x的二进制值从低位到高位下一个值为0的二进制值的位置，如果不将x转换为Long类型，当offset大于32时会溢出
             */
            while (((long) x >> offset & 1) == 1) {
                offset++;
            }
            /**
             * 要填入x中的二进制位
             */
            long bit = n & 1;
            result |= (bit << offset);
            n >>= 1;
            offset++;
        }
        return result;
    }
}
