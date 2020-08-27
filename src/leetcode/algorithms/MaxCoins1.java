package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1561. Maximum Number of Coins You Can Get
 *
 * @author Baltan
 * @date 2020-08-26 23:12
 */
public class MaxCoins1 {
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
        System.out.println(maxCoins(new int[]{2, 4, 5}));
        System.out.println(maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}));
    }

    public static int maxCoins(int[] piles) {
        int result = 0;
        int lo = 0;
        int hi = piles.length - 1;
        Arrays.sort(piles);
        /**
         * Alice始终取剩下的硬币中最多的一堆，Bob始终取剩下的硬币中最少的一堆，"我"始终取剩下的硬币中第二多的
         * 一堆
         */
        while (lo < hi) {
            lo++;
            hi--;
            result += piles[hi];
            hi--;
        }
        return result;
    }
}
