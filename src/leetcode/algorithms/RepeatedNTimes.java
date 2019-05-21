package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 961. N-Repeated Element in Size 2N Array
 *
 * @author Baltan
 * @date 2019-03-12 09:45
 */
public class RepeatedNTimes {
    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

    public static int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        int oldSize = 0;

        for (int num : A) {
            set.add(num);
            if (set.size() == oldSize) {
                return num;
            } else {
                oldSize = set.size();
            }
        }
        return -1;
    }
}
