package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2055. Plates Between Candles
 *
 * @author Baltan
 * @date 2021/11/18 09:11
 */
public class PlatesBetweenCandles {
    public static void main(String[] args) {
        String s1 = "**|**|***|";
        int[][] queries1 = {{2, 5}, {5, 9}};
        OutputUtils.print1DIntegerArray(platesBetweenCandles(s1, queries1));

        String s2 = "***|**|*****|**||**|*";
        int[][] queries2 = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        OutputUtils.print1DIntegerArray(platesBetweenCandles(s2, queries2));

        String s3 = "***";
        int[][] queries3 = {{2, 2}};
        OutputUtils.print1DIntegerArray(platesBetweenCandles(s3, queries3));
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] result = new int[queries.length];
        int length = s.length();
        /**
         * 字符串s的前缀和，将"*"计为1，将"|"计为0
         */
        int[] prefixSum = new int[length + 1];
        /**
         * 保存蜡烛的索引位置
         */
        List<Integer> candleIndexList = new ArrayList<>();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < length; i++) {
            prefixSum[i + 1] = prefixSum[i] + (charArray[i] == '*' ? 1 : 0);

            if (charArray[i] == '|') {
                candleIndexList.add(i);
            }
        }
        /**
         * 如果蜡烛的个数不足2根，则所有盘子都不在两根蜡烛之间
         */
        if (candleIndexList.size() < 2) {
            return result;
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            /**
             * query[0]右侧的第一根蜡烛（包括query[0]）的索引位置，不存在为-1
             */
            int leftmostCandle = binarySearchLeftmost(query[0], query[1], candleIndexList);

            if (leftmostCandle == -1) {
                result[i] = 0;
                continue;
            }
            /**
             * query[1]左侧的第一根蜡烛（包括query[1]）的索引位置，不存在为-1
             */
            int rightmostCandle = binarySearchRightmost(query[0], query[1], candleIndexList);

            if (rightmostCandle == -1) {
                result[i] = 0;
                continue;
            }
            result[i] = prefixSum[rightmostCandle] - prefixSum[leftmostCandle];
        }
        return result;
    }

    /**
     * 在candleIndexList中查找大于等于left且小于等于right的最小值，不存在则返回-1
     *
     * @param left
     * @param right
     * @param candleIndexList
     * @return
     */
    public static int binarySearchLeftmost(int left, int right, List<Integer> candleIndexList) {
        int lo = 0;
        int hi = candleIndexList.size() - 1;

        while (lo <= hi) {
            if (lo == hi) {
                break;
            }

            int mid = (lo + hi) / 2;

            if (candleIndexList.get(mid) < left) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        if (candleIndexList.get(lo) < left) {
            return -1;
        } else {
            return candleIndexList.get(lo) <= right ? candleIndexList.get(lo) : -1;
        }
    }

    /**
     * 在candleIndexList中查找小于等于right且大于等于left的最大值，不存在则返回-1
     *
     * @param left
     * @param right
     * @param candleIndexList
     * @return
     */
    public static int binarySearchRightmost(int left, int right, List<Integer> candleIndexList) {
        int lo = 0;
        int hi = candleIndexList.size() - 1;

        while (lo <= hi) {
            if (lo == hi) {
                break;
            }

            int mid = (int) Math.ceil((lo + hi) / 2.0);

            if (candleIndexList.get(mid) > right) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }

        if (candleIndexList.get(lo) > right) {
            return -1;
        } else {
            return candleIndexList.get(lo) >= left ? candleIndexList.get(lo) : -1;
        }
    }
}
