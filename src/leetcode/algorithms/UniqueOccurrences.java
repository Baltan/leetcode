package leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: 1207. Unique Number of Occurrences
 *
 * @author Baltan
 * @date 2019-09-30 09:16
 */
public class UniqueOccurrences {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr1));

        int[] arr2 = {1, 2};
        System.out.println(uniqueOccurrences(arr2));

        int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println(uniqueOccurrences(arr3));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        Set<Integer> occurrences = new HashSet<>();
        /**
         * 统计每个数字出现的频数
         */
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        /**
         * 将所有数字的出现的频数加入到一个Set中
         */
        for (int value : count.values()) {
            occurrences.add(value);
        }
        return count.size() == occurrences.size();
    }
}
