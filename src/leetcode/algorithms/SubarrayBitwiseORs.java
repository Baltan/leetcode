package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 898. Bitwise ORs of Subarrays
 *
 * @author Baltan
 * @date 2020-02-25 12:01
 */
public class SubarrayBitwiseORs {
    public static void main(String[] args) {
        System.out.println(subarrayBitwiseORs(new int[]{0}));
        System.out.println(subarrayBitwiseORs(new int[]{1, 1, 2}));
        System.out.println(subarrayBitwiseORs(new int[]{1, 2, 4}));
    }

    public static int subarrayBitwiseORs(int[] A) {
        Set<Integer> set = new HashSet<>();
        int length = A.length;

        for (int i = 0; i < length; i++) {
            int value = A[i];
            set.add(value);

            for (int j = i + 1; j < length; j++) {
                value |= A[j];
                set.add(value);
            }
        }
        return set.size();
    }
}
