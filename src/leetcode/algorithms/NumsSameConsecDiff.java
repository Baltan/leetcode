package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Description: 967. Numbers With Same Consecutive Differences
 *
 * @author Baltan
 * @date 2019-04-11 09:56
 */
public class NumsSameConsecDiff {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(numsSameConsecDiff(3, 7));
        OutputUtils.print1DIntegerArray(numsSameConsecDiff(2, 1));
        OutputUtils.print1DIntegerArray(numsSameConsecDiff(3, 0));
        OutputUtils.print1DIntegerArray(numsSameConsecDiff(6, 9));
        OutputUtils.print1DIntegerArray(numsSameConsecDiff(1, 1));
    }

    public static int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
            int[] result = new int[10];
            for (int i = 0; i < 10; i++) {
                result[i] = i;
            }
            return result;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= 9; i++) {
            set.add(i);
        }

        N--;

        while (N >= 1) {
            Iterator<Integer> it = set.iterator();
            Set<Integer> temp = new HashSet<>();
            while (it.hasNext()) {
                int num = it.next();
                int tail = num % 10;
                if (tail + K <= 9) {
                    temp.add(num * 10 + tail + K);
                }
                if (tail - K >= 0) {
                    temp.add(num * 10 + tail - K);
                }
            }
            set = temp;
            N--;
        }

        int[] result = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        int index = 0;

        while (it.hasNext()) {
            result[index++] = it.next();
        }
        return result;
    }
}
