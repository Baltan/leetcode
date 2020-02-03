package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 372. Super Pow
 *
 * @author Baltan
 * @date 2020-02-03 14:10
 */
public class SuperPow {
    public static void main(String[] args) {
        System.out.println(superPow(2, new int[]{3}));
        System.out.println(superPow(2, new int[]{1, 0}));
        System.out.println(superPow(1336, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(superPow(1336,
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    public static int superPow(int a, int[] b) {
        int mod = 1337;
        int length = b.length;

        if (length == 1) {
            return myMod(a, b[0], mod);
        }

        /**
         * 设b=10x+y，
         * 则(a^(10x+y))%m
         * =((a^10x)·(a^y))%m
         * =(((a^10x)%m)·((a^y)%m))%m
         * =((((a^x)%m)^10)%m·((a^y)%m))%m
         *
         * 递归计算(a^x)%m，其中x就是b.subarray(0,length-1)
         */
        int[] c = Arrays.copyOfRange(b, 0, length - 1);
        return (myMod(superPow(a, c), 10, mod) * myMod(a, b[length - 1], mod)) % mod;
    }

    /**
     * 计算(a^b)%mod的值（b∈[0,9]）
     *
     * @param a
     * @param b
     * @param mod
     * @return
     */
    public static int myMod(int a, int b, int mod) {
        if (b == 0) {
            return 1;
        }

        if (b == 1) {
            return a % mod;
        }
        /**
         * (a^b)%m
         * =((a%m)·(a^(b-1))%m)%m
         *
         * 递归计算a^(b-1))%m
         */
        return ((a % mod) * myMod(a, b - 1, mod)) % mod;
    }
}
