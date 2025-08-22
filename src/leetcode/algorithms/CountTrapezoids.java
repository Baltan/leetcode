package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3623. Count Number of Trapezoids I
 *
 * @author baltan
 * @date 2025/8/21 17:32
 */
public class CountTrapezoids {
    public static void main(String[] args) {
        System.out.println(countTrapezoids(new int[][]{{1, 0}, {2, 0}, {3, 0}, {2, 2}, {3, 2}}));
        System.out.println(countTrapezoids(new int[][]{{0, 0}, {1, 0}, {0, 1}, {2, 1}}));
    }

    public static int countTrapezoids(int[][] points) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * 当前顶点的纵坐标，根据题意，y∈[-100000000,100000000]，初始化pointY为一个不在此范围中的任意值
         */
        int pointY = Integer.MIN_VALUE;
        /**
         * 当前一排中顶点的数量
         */
        long rowCount = 0;
        /**
         * 此前已遍历过且不和当前顶点在同一排的所有顶点构成水平边的数量
         */
        long pairCount = 0;
        /**
         * 将所有顶点按照纵坐标降序排列（纵坐标相同时，同一排中所有顶点的横坐标排序任意）
         */
        Arrays.sort(points, (x, y) -> y[1] - x[1]);

        for (int[] point : points) {
            if (point[1] != pointY) {
                /**
                 * 前一排中顶点的数量为rowCount，则一共可以构成rowCount*(rowCount-1)/2条水平边，累加到此前已遍历过且不和当前顶点在同一
                 * 排的所有顶点构成水平边的数量中
                 */
                pairCount = (pairCount + rowCount * (rowCount - 1) / 2) % mod;
                rowCount = 1;
                pointY = point[1];
            } else {
                /**
                 * 当前节点可以和同一排中之前的rowCount歌顶点构成rowCount条水平边，它们和此前已遍历过且不和当前顶点在同一排的所有顶点构成
                 * 的pairCount条水平边两两组合，可以得到rowCount*pairCount个梯形
                 */
                result = (result + rowCount * pairCount) % mod;
                rowCount++;
            }
        }
        return (int) result;
    }
}
