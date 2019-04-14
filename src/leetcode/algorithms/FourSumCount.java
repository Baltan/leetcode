package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 4Sum II
 *
 * @author Baltan
 * @date 2019-04-14 13:40
 */
public class FourSumCount {
    public static void main(String[] args) {
        int[] A1 = {1, 2};
        int[] B1 = {-2, -1};
        int[] C1 = {-1, 2};
        int[] D1 = {0, 2};
        System.out.println(fourSumCount(A1, B1, C1, D1));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int result = 0;

        for (int a : A) {
            for (int b : B) {
                sumMap.put(a + b, sumMap.getOrDefault(a + b, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                result += sumMap.getOrDefault(-c - d, 0);
            }
        }
        return result;
    }
}
