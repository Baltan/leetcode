package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2121. Intervals Between Identical Elements
 *
 * @author Baltan
 * @date 2021/12/30 09:57
 */
public class GetDistances {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getDistances(new int[]{2, 1, 3, 1, 2, 3, 3})));
        System.out.println(Arrays.toString(getDistances(new int[]{10, 5, 10, 10})));
    }

    public static long[] getDistances(int[] arr) {
        int length = arr.length;
        long[] result = new long[length];
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int value = arr[i];
            List<Integer> indexList = indexMap.computeIfAbsent(value, x -> new ArrayList<>());
            indexList.add(i);
        }

        for (int i = 0; i < length; i++) {
            int value = arr[i];
            long interval = 0L;

            for (int index : indexMap.get(value)) {
                interval += Math.abs(index - i);
            }
            result[i] = interval;
        }
        return result;
    }
}
