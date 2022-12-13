package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2438. Range Product Queries of Powers
 *
 * @author Baltan
 * @date 2022/12/8 09:43
 */
public class ProductQueries {
    public static void main(String[] args) {
        int[][] queries1 = {{0, 1}, {2, 2}, {0, 3}};
        OutputUtils.print1DIntegerArray(productQueries(15, queries1));

        int[][] queries2 = {{0, 0}};
        OutputUtils.print1DIntegerArray(productQueries(2, queries2));
    }

    public static int[] productQueries(int n, int[][] queries) {
        int length = queries.length;
        int[] result = new int[length];
        int mod = 1000000007;
        List<Integer> moves = new ArrayList<>();
        /**
         * query如果要乘以一个2的幂，等同于乘以1左移move位得到的值
         */
        int move = 0;

        while (n > 0) {
            /**
             * 判断n的二进制值从低位到高位的每一位是否为1，如果为1，则可以得到一个2的幂（1左移move位），将左移位数move加入到数组moves中
             */
            if ((n & 1) == 1) {
                moves.add(move);
            }
            move++;
            n >>= 1;
        }
        /**
         * prefixSums[i]表示列表moves前i个值的和
         */
        int[] prefixSums = new int[moves.size() + 1];

        for (int i = 0; i < moves.size(); i++) {
            prefixSums[i + 1] = prefixSums[i] + moves.get(i);
        }

        for (int i = 0; i < length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int totalMoves = prefixSums[right + 1] - prefixSums[left];
            /**
             * 1先左移totalMoves位，再对mod取余
             */
            result[i] = BigInteger.valueOf(1).shiftLeft(totalMoves).remainder(BigInteger.valueOf(mod)).intValue();
        }
        return result;
    }
}
