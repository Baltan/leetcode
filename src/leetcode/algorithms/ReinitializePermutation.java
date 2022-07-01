package leetcode.algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Description: 1806. Minimum Number of Operations to Reinitialize a Permutation
 *
 * @author Baltan
 * @date 2022/6/26 14:40
 */
public class ReinitializePermutation {
    public static void main(String[] args) {
        System.out.println(reinitializePermutation(2));
        System.out.println(reinitializePermutation(4));
        System.out.println(reinitializePermutation(6));
    }

    public static int reinitializePermutation(int n) {
        int result = 0;
        /**
         * [0,1,2,……,n-1]
         */
        int[] perm = IntStream.range(0, n).toArray();
        int[] copy = perm.clone();
        /**
         * 循环执行每步操作，直到perm回到排列初始值
         */
        do {
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = copy[i / 2];
                } else {
                    arr[i] = copy[n / 2 + (i - 1) / 2];
                }
            }
            copy = arr;
            result++;
        } while (!Arrays.equals(perm, copy));
        return result;
    }
}
