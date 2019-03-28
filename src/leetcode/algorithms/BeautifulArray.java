package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: Beautiful Array
 *
 * @author Baltan
 * @date 2019-03-28 09:42
 */
public class BeautifulArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(beautifulArray(10));
        OutputUtils.print1DIntegerArray(beautifulArray(11));
    }

    public static int[] beautifulArray(int N) {
        int[] result = new int[N];

        if (N == 1) {
            result[0] = 1;
            return result;
        } else {
            if ((N & 1) == 1) {
                int M = N + 1;
                int[] temp = beautifulArray(M);
                int index = 0;
                for (int i = 0; i < N; i++) {
                    if (temp[index] != M) {
                        result[i] = temp[index++];
                    } else {
                        index++;
                        result[i] = temp[index++];
                    }
                }
            } else {
                int[] temp = beautifulArray(N / 2);
                for (int i = 0; i < N / 2; i++) {
                    result[i] = temp[i] * 2;
                    result[i + N / 2] = temp[i] * 2 - 1;
                }
            }
        }
        return result;
    }
}
