package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 810. Chalkboard XOR Game
 *
 * @author Baltan
 * @date 2023/10/28 19:35
 */
public class XorGame {
    public static void main(String[] args) {
        System.out.println(xorGame(new int[]{1, 1, 2}));
        System.out.println(xorGame(new int[]{0, 1}));
        System.out.println(xorGame(new int[]{1, 2, 3}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/chalkboard-xor-game/solutions/789745/gong-shui-san-xie-noxiang-xin-ke-xue-xi-ges7k/"></a>
     *
     * @param nums
     * @return
     */
    public static boolean xorGame(int[] nums) {
        /**
         * 1、当数组nums中所有数字按位异或为0时，先手直接获胜。
         * 2、当数组nums中所有数字按位异或不为0时，假设nums中元素个数为2k，根据异或运算性质，这2k个数一定不完全相等，因此对于先手来说，选择
         * 某一个数后剩余数字按位异或的结果至少有2种可能，因此一定可以保证结果不为0，即先手保证不败。
         * 3、当数组nums中所有数字按位异或不为0时，假设nums中元素个数为2k+1，则先手不论选择什么数都会使得情况变为1或者2，此时先手变后手，
         * 先手必败
         */
        return Arrays.stream(nums).reduce(0, (x, y) -> x ^ y) == 0 || nums.length % 2 == 0;
    }
}
