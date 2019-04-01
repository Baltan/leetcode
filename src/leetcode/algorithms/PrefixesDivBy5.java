package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Binary Prefix Divisible By 5
 *
 * @author Baltan
 * @date 2019-04-01 09:26
 */
public class PrefixesDivBy5 {
    public static void main(String[] args) {
        System.out.println(prefixesDivBy5(new int[]{1, 1, 1}));
        System.out.println(prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1}));
        System.out.println(prefixesDivBy5(new int[]{1, 1, 1, 0, 1}));
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        int length = A.length;
        List<Boolean> result = new ArrayList<>(length);
        int remainder = 0;

        for (int i = 0; i < length; i++) {
            remainder = ((remainder << 1) + A[i]) % 5;
            result.add(remainder == 0);
        }
        return result;
    }
}
