package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 2845. Count of Interesting Subarrays
 *
 * @author baltan
 * @date 2023/9/5 10:00
 */
public class CountInterestingSubarrays {
    public static void main(String[] args) {
        System.out.println(countInterestingSubarrays(Arrays.asList(1, 100000), 1000000000, 1));
        System.out.println(countInterestingSubarrays(Arrays.asList(1, 2, 1, 2, 1, 2), 2, 1));
        System.out.println(countInterestingSubarrays(Arrays.asList(7, 2), 7, 0));
        System.out.println(countInterestingSubarrays(Arrays.asList(3, 2, 4), 2, 1));
        System.out.println(countInterestingSubarrays(Arrays.asList(3, 1, 9, 6), 3, 0));
    }

    public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long result = 0L;
        int interval = 0;
        List<Integer> selections = new ArrayList<>();

        for (int num : nums) {
            if (num % modulo == k) {
                selections.add(interval + 1);
                interval = 0;
            } else {
                interval++;
            }
        }
        selections.add(interval + 1);
        int[][] prefixSumsMatrix = new int[modulo][selections.size() + 1];

        for (int i = 0; i < selections.size(); i++) {
            int row = i % modulo;
            int col = i / modulo;
            prefixSumsMatrix[row][col + 1] = prefixSumsMatrix[row][col] + selections.get(i);
        }

        for (int i = 0; i < selections.size(); i++) {
            if (k == 0) {
                int count = selections.get(i) - 1;
                result += (long) (count + 1) * count / 2;
            }
            int first = i + (k == 0 ? modulo : k);

            if (first >= selections.size()) {
                continue;
            }
            int remainder = first % modulo;
            int last = (selections.size() - 1 - remainder) / modulo * modulo + remainder;
            int row = (i + k) % modulo;
            result += (long) selections.get(i) * (prefixSumsMatrix[row][last / modulo + 1] - prefixSumsMatrix[row][first / modulo]);
        }
        return result;
    }
}
