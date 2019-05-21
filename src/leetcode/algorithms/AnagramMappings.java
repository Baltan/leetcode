package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 760. Find Anagram Mappings
 *
 * @author Baltan
 * @date 2018/1/9 16:55
 */
public class AnagramMappings {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(
                anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28}));
    }

    public static int[] anagramMappings(int[] A, int[] B) {
        int[] mappings = new int[A.length];
        Map<Integer, Integer> bMap = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            bMap.put(B[i], i);
        }
        for (int i = 0; i < A.length; i++) {
            mappings[i] = bMap.get(A[i]);
        }
        return mappings;
    }
}
