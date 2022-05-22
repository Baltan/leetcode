package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 2271. Maximum White Tiles Covered by a Carpet
 *
 * @author Baltan
 * @date 2022/5/20 09:33
 */
public class MaximumWhiteTiles {
    public static void main(String[] args) {
        int[][] tiles1 = {{1, 5}, {10, 11}, {12, 18}, {20, 25}, {30, 32}};
        int carpetLen1 = 10;
        System.out.println(maximumWhiteTiles(tiles1, carpetLen1));

        int[][] tiles2 = {{10, 11}, {1, 1}};
        int carpetLen2 = 2;
        System.out.println(maximumWhiteTiles(tiles2, carpetLen2));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/maximum-white-tiles-covered-by-a-carpet/solution/by-hu-li-hu-wai-48y7/"></a>
     *
     * @param tiles
     * @param carpetLen
     * @return
     */
    public static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int result = 0;
        int total = 0;
        int rangeCount = tiles.length;
        int leftRange = 0;
        int rightRange = 0;
        Arrays.sort(tiles, Comparator.comparingInt(x -> x[0]));
        /**
         * leftRange表示地毯覆盖的最左边的瓷砖区间索引，rightRange表示地毯覆盖的最右边的瓷砖区间索引
         */
        while (leftRange <= rightRange && rightRange < rangeCount) {
            int start = tiles[leftRange][0];
            int end = start + carpetLen - 1;

            if (tiles[rightRange][1] <= end) {
                /**
                 * 最右边的瓷砖区间被完全覆盖时，累加这个区间的所有瓷砖
                 */
                total += (tiles[rightRange][1] - tiles[rightRange][0] + 1);
                /**
                 * 继续判断更右边一个瓷砖区间被覆盖的情况
                 */
                rightRange++;
                result = Math.max(total, result);
            } else {
                if (tiles[rightRange][0] <= end) {
                    /**
                     * 最右边的瓷砖区间被完全覆盖时，累加这个区间的被覆盖的部分瓷砖
                     */
                    result = Math.max(total + (end - tiles[rightRange][0] + 1), result);
                }
                /**
                 * 此时以leftRange作为起始瓷砖区间情况下，所有可以被覆盖的瓷砖都已累计，继续判断以更右边一个瓷砖区间起始时，可
                 * 以被覆盖的瓷砖块数，同时将区间leftRange的所有瓷砖数量剔除
                 */
                total -= (tiles[leftRange][1] - tiles[leftRange][0] + 1);
                leftRange++;
            }
        }
        return result;
    }
}
