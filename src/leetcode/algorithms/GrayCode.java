package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 89. Gray Code
 *
 * @author Baltan
 * @date 2020-01-30 11:49
 */
public class GrayCode {
    public static void main(String[] args) {
        System.out.println(grayCode(0));
        System.out.println(grayCode(1));
        System.out.println(grayCode(2));
        System.out.println(grayCode(3));
        System.out.println(grayCode(4));
        System.out.println(grayCode(5));
        System.out.println(grayCode(6));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/gray-code/solution/gray-code-jing-xiang-fan-she-fa-by-jyd/"></a>
     *
     * @param n
     * @return
     */
    public static List<Integer> grayCode(int n) {
        /**
         * 编码总位数为n的格雷码序列一共有2**n个数字
         */
        List<Integer> result = new ArrayList<>((int) Math.pow(2, n));
        result.add(0);
        /**
         * 在二进制数字头部加1换算成十进制加的数字，n=k时，相当于十进制加2**(k-1)
         */
        int head = 1;
        /**
         * 当n=1时，格雷码序列为[0]
         * 当n=k（k>1）时，假设n=k-1时的格雷码序列为Seq(k-1)，将Seq(k-1)的每一个数字头部加一个0得到
         * 序列Seq(k)，再将Seq(k-1)倒序的每一个数字头部加一个1追加在Seq(k)后面即可，例如
         * n  Seq
         * 0   0
         * 1   0     1
         * 2   00    01    11    10
         * 3   000   001   011   010   110   111   101   100
         * 4   0000  0001  0011  0010  0110  0111  0101  0100  1100  1101  1111  1110  1010  1011  1001  1000
         */
        for (int i = 0; i < n; i++) {
            /**
             * 头部加一个0后的值不变，只需要处理倒序后每一个数字头部加一个1的值
             */
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(head + result.get(j));
            }
            /**
             * 下一轮循环头部加1换算成十进制加的数字要翻倍
             */
            head <<= 1;
        }
        return result;
    }
}
