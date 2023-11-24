package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 421. Maximum XOR of Two Numbers in an Array
 *
 * @author Baltan
 * @date 2023/1/31 15:56
 * @see MaximumStrongPairXor
 * @see MaximumStrongPairXor1
 */
public class FindMaximumXOR {
    public static void main(String[] args) {
        System.out.println(findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println(findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/solutions/9289/li-yong-yi-huo-yun-suan-de-xing-zhi-tan-xin-suan-f/"></a>
     *
     * @param nums
     * @return
     */
    public static int findMaximumXOR(int[] nums) {
        int result = 0;
        int mask = 0;

        for (int i = 30; i >= 0; i--) {
            /**
             * 每次循环依次得到掩码：
             * 1000000000000000000000000000000
             * 1100000000000000000000000000000
             * 1110000000000000000000000000000
             * ……
             * 1111111111111111111111111111111
             */
            mask = mask | (1 << i);
            /**
             * 保存数组nums中各个元素从高到低长度为31-i位的前缀的值
             */
            Set<Integer> prefixes = new HashSet<>();

            for (int num : nums) {
                prefixes.add(num & mask);
            }
            /**
             * 因为希望最终得到的两数按位异或值xor最大，所以尽可能地让xor二进制值的每一位都为1。假设result从低到高的i+1位为1，接下去判断数组
             * nums中是否存在某两个数x和y使得x^y的前缀部分和temp相同
             */
            int temp = result | (1 << i);
            /**
             * 假设其中一个数x的前缀部分为prefix，因为prefix^y的前缀部分和temp相同，所以prefix^temp的前缀部分也和y相同，只需判断是否存在
             * 符合这种前缀要求的y即可
             */
            for (int prefix : prefixes) {
                /**
                 * 存在符合前缀要求的y，说明result从低到高的i+1位可以为1
                 */
                if (prefixes.contains(prefix ^ temp)) {
                    result = temp;
                    break;
                }
            }
        }
        return result;
    }
}
