package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1310. XOR Queries of a Subarray
 *
 * @author Baltan
 * @date 2020-01-06 12:06
 */
public class XorQueries {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 8};
        int[][] queries1 = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        OutputUtils.print1DIntegerArray(xorQueries(arr1, queries1));

        int[] arr2 = {4, 8, 2, 10};
        int[][] queries2 = {{2, 3}, {1, 3}, {0, 0}, {0, 3}};
        OutputUtils.print1DIntegerArray(xorQueries(arr2, queries2));
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int length = arr.length;
        /**
         * prefixXor[i]表示arr[0]、arr[1]、arr[2]……arr[i-1]求异或的值
         */
        int[] prefixXor = new int[length + 1];

        for (int i = 1; i <= length; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i - 1];
        }
        /**
         * arr[m]、arr[m+1]、arr[m+2]……arr[n]求异或的值等于prefixXor[n+1]和prefixXor[m]求异或的值
         * 证明：
         * prefixXor[n+1]^prefixXor[m]
         * =(arr[0]^arr[1]^……^arr[n])^(arr[0]^arr[1]^……^arr[m-1])
         * =(arr[0]^arr[0])^(arr[1]^arr[1])^……^(arr[m-1]^arr[m-1])^arr[m]^arr[m+1]^……^arr[n]
         * =0^0^……^0^arr[m]^arr[m+1]^……^arr[n]
         * =arr[m]^arr[m+1]^……^arr[n]
         */
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            result[i] = prefixXor[start] ^ prefixXor[end + 1];
        }
        return result;
    }
}
