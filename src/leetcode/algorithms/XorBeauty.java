package leetcode.algorithms;

/**
 * Description: 2527. Find Xor-Beauty of Array
 *
 * @author Baltan
 * @date 2023/1/8 13:21
 */
public class XorBeauty {
    public static void main(String[] args) {
        System.out.println(xorBeauty(new int[]{1, 4}));
        System.out.println(xorBeauty(new int[]{15, 45, 20, 2, 34, 35, 5, 44, 32, 30}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/find-xor-beauty-of-array/solutions/2050337/no6289-cha-xun-shu-zu-xor-mei-li-zhi-by-d5ylk/"></a>
     *
     * @param nums
     * @return
     */
    public static int xorBeauty(int[] nums) {
        int result = 0;
        /**
         * 对于nums中的任何三个数字a、b、c，共有27种组合方式：
         *
         * (a|a)&a     (b|a)&a     (c|a)&a
         * (a|a)&b     (b|a)&b     (c|a)&b
         * (a|a)&c     (b|a)&c     (c|a)&c
         *
         * (a|b)&a     (b|b)&a     (c|b)&a
         * (a|b)&b     (b|b)&b     (c|b)&b
         * (a|b)&c     (b|b)&c     (c|b)&c
         *
         * (a|c)&a     (b|c)&a     (c|c)&a
         * (a|c)&b     (b|c)&b     (c|c)&b
         * (a|c)&c     (b|c)&c     (c|c)&c
         *
         * 这9个小矩阵关于主对角线对称，例如左下角的小矩阵和右上角的小矩阵
         *
         * (a|c)&a     (c|a)&a
         * (a|c)&b     (c|a)&b
         * (a|c)&c     (c|a)&c
         *
         * 这6个值按位异或的结果为0，所以最后只需要计算主对角线上的3个小矩阵
         *
         * (a|a)&a     (b|b)&a     (c|c)&a
         * (a|a)&b     (b|b)&b     (c|c)&b
         * (a|a)&c     (b|b)&c     (c|c)&c
         *
         * 简化这三个小矩阵后得到：
         *
         *  a      b&a     c&a
         * a&b      b      c&b
         * a&c     b&c      c
         *
         * 同样，这9个值关于主对角线对称，例如左下角的值和右上角的值
         *
         * a&c     c&a
         *
         * 这2个值按位异或的结果为0，所以最后只需要计算主对角线上的3个值
         *
         * a        b       c
         *
         * 最终得到的结果为a^b^c
         *
         * 当nums中有四个数字a、b、c、d时，结果为：
         * (b^c^d)^(a^c^d)^(a^b^d)^(a^b^c)=a^b^c^d
         * ……
         */
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
