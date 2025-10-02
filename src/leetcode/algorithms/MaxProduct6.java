package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Description: 3670. Maximum Product of Two Integers With No Common Bits
 *
 * @author Baltan
 * @date 2025/10/2 14:23
 */
public class MaxProduct6 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(maxProduct(new int[]{5, 6, 4}));
        System.out.println(maxProduct(new int[]{64, 8, 32}));
    }

    public static long maxProduct(int[] nums) {
        long result = 0L;
        TreeSet<Integer> numSet = new TreeSet<>();
        Set<Integer>[] sets = new Set[20];
        Arrays.setAll(sets, i -> new HashSet<>());

        for (int num : nums) {
            int value = num;
            int offset = 0;

            while (value > 0) {
                if ((value & 1) == 1) {
                    sets[offset].add(num);
                }
                value >>= 1;
                offset++;
            }
            numSet.add(num);
        }

        for (int num : numSet) {
            int value = num;
            int offset = 0;
            TreeSet<Integer> otherNumSet = new TreeSet<>(numSet.headSet(num));

            while (value > 0) {
                if ((value & 1) == 1) {
                    otherNumSet.removeAll(sets[offset]);
                }
                value >>= 1;
                offset++;
            }

            if (!otherNumSet.isEmpty()) {
                result = Math.max(result, (long) num * otherNumSet.last());
            }
        }
        return result;
    }
}
