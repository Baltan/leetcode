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
        System.out.println(countInterestingSubarrays(Arrays.asList(7, 2), 7, 0));
        System.out.println(countInterestingSubarrays(Arrays.asList(3, 2, 4), 2, 1));
        System.out.println(countInterestingSubarrays(Arrays.asList(3, 1, 9, 6), 3, 0));
    }

    public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long result = 0L;
        int size = nums.size();
        int total = 0;
        List<Integer> indexes = new ArrayList<>();
        indexes.add(-1);

        for (int i = 0; i < size; i++) {
            if (nums.get(i) % modulo == k) {
                indexes.add(i);
                total++;
            }
        }
        indexes.add(nums.size());

        for (int cnt = k; cnt <= total; cnt += modulo) {
            if (cnt == 0) {
                for (int i = 1; i < indexes.size(); i++) {
                    int interval = indexes.get(i) - indexes.get(i - 1) - 1;
                    result += (long) interval * (interval + 1) / 2;
                }
            } else {
                for (int j = 0; ; j++) {
                    int l = j + cnt - 1;

                    if (l >= indexes.size()) {
                        break;
                    }

                    if (l < 0) {
                        continue;
                    }
                    result += (long) (j - 1 >= 0 ? indexes.get(j) - indexes.get(j - 1) : indexes.get(j) + 1)
                            * (l + 1 < indexes.size() ? indexes.get(l + 1) - indexes.get(l) : size - indexes.get(l));
                }
            }
        }
        return result;
    }
}
