package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 888. Fair Candy Swap
 *
 * @author Baltan
 * @date 2018/8/21 15:59
 */
public class FairCandySwap {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(fairCandySwap(new int[]{1, 1}, new int[]{2, 2}));
        OutputUtils.print1DIntegerArray(fairCandySwap(new int[]{1, 2}, new int[]{2, 3}));
        OutputUtils.print1DIntegerArray(fairCandySwap(new int[]{2}, new int[]{1, 3}));
        OutputUtils.print1DIntegerArray(fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4}));
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        int sumA = Arrays.stream(A).reduce(0, (x, y) -> x + y);
        int sumB = Arrays.stream(B).reduce(0, (x, y) -> x + y);
        int difference = sumA - sumB;
        for (int num : A) {
            if (Arrays.stream(B).anyMatch(x -> (num - x) * 2 == difference)) {
                res[0] = num;
                res[1] = num - difference / 2;
                return res;
            }
        }
        return res;
    }
}
