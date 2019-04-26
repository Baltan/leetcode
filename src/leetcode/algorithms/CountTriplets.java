package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Triples with Bitwise AND Equal To Zero
 *
 * @author Baltan
 * @date 2019-04-26 14:13
 */
public class CountTriplets {
    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2, 1, 3}));
    }

    public static int countTriplets(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int i : A) {
            for (int j : A) {
                map.put(i & j, map.getOrDefault(i & j, 0) + 1);
            }
        }

        for (int i : map.keySet()) {
            for (int j : A) {
                if ((i & j) == 0) {
                    result += map.get(i);
                }
            }
        }
        return result;
    }
}
