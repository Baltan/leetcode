package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Longest Arithmetic Sequence
 *
 * @author Baltan
 * @date 2019-04-19 10:28
 */
public class LongestArithSeqLength {
    public static void main(String[] args) {
//        System.out.println(longestArithSeqLength(new int[]{3, 6, 9, 12}));
//        System.out.println(longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
        System.out.println(longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
        System.out.println(longestArithSeqLength(new int[]{83, 20, 17, 43, 52, 78, 68, 45}));
    }

    public static int longestArithSeqLength(int[] A) {
        int result = 0;
        int length = A.length;
        Map<Integer, Integer>[] array = new Map[length];

        for (int i = 0; i < length; i++) {
            array[i] = new HashMap<>();
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int difference = A[i] - A[j];
                int m = array[j].getOrDefault(difference, 1) + 1;
                int n = array[i].getOrDefault(difference, 0);
                array[i].put(difference, Math.max(m, n));
                result = Math.max(result, array[i].get(difference));
            }
        }
        return result;
    }
}
