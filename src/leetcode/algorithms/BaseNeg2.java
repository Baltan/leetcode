package leetcode.algorithms;

/**
 * Description: 1017. Convert to Base -2
 *
 * @author Baltan
 * @date 2023/1/30 15:22
 * @see BaseNeg21
 */
public class BaseNeg2 {
    public static void main(String[] args) {
        System.out.println(baseNeg2(2));
        System.out.println(baseNeg2(3));
        System.out.println(baseNeg2(4));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/convert-to-base-2/solutions/742393/java-san-xing-dai-ma-tong-guo-by-maple_7-mass/"></a>
     *
     * @param n
     * @return
     */
    public static String baseNeg2(int n) {
        /**
         * 大于等于n的最小的形式为……010101的负二进制数
         */
        int max = 1;
        /**
         * 负二进制数的最大值为……010101，因为从低到高奇数位（0-based）上的权重都为负数（-2的奇次幂），所以这些位上都为0
         */
        while (max < n) {
            max = (max << 2) + 1;
        }
        return Integer.toBinaryString(max ^ max - n);
    }
}
