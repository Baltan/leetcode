package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 985. Sum of Even Numbers After Queries
 *
 * @author Baltan
 * @date 2019-03-13 11:25
 */
public class SumEvenAfterQueries {
    public static void main(String[] args) {
        int[] A1 = {1, 2, 3, 4};
        int[][] queries1 = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        OutputUtils.print1DIntegerArray(sumEvenAfterQueries(A1, queries1));
    }

    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int queriesLength = queries.length;
        int[] result = new int[queriesLength];
        int sum = Arrays.stream(A).filter(v -> (v & 1) == 0).sum();

        for (int i = 0; i < queriesLength; i++) {
            int oldVal = A[queries[i][1]];
            int val = queries[i][0];

            if ((oldVal & 1) == 0) {
                if ((val & 1) == 0) {
                    sum += val;
                } else {
                    sum -= oldVal;
                }
            } else {
                if ((val & 1) == 1) {
                    sum += (oldVal + val);
                }
            }
            result[i] = sum;
            A[queries[i][1]] = oldVal + val;
        }
        return result;
    }
}
