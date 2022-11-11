package leetcode.algorithms;

import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * Description: 947. Most Stones Removed with Same Row or Column
 *
 * @author Baltan
 * @date 2022/11/11 09:27
 */
public class RemoveStones {
    public static void main(String[] args) {
        int[][] stones1 = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        System.out.println(removeStones(stones1));

        int[][] stones2 = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
        System.out.println(removeStones(stones2));

        int[][] stones3 = {{0, 0}};
        System.out.println(removeStones(stones3));
    }

    /**
     * 思路参考：
     * <a href="https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/solution/947-yi-chu-zui-duo-de-tong-xing-huo-tong-ezha/"></a>
     * 假设两块石头x坐标相同或y坐标相同，则它们就在同一个连通图中。通过深度优先搜索遍历一个连通图，一定可以把一个连通图里的石头移出到
     * 只剩下最后一块
     *
     * @param stones
     * @return
     */
    public static int removeStones(int[][] stones) {
        int result = 0;
        Point[] points = new Point[stones.length];
        /**
         * x坐标 -> 同为x坐标的所有石头的y坐标集合
         */
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        /**
         * y坐标 -> 同为y坐标的所有石头的x坐标集合
         */
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        /**
         * 已访问过的所有石头的坐标
         */
        Set<Point> isVisited = new HashSet<>();

        for (int i = 0; i < stones.length; i++) {
            int[] stone = stones[i];
            int x = stone[0];
            int y = stone[1];
            points[i] = new Point(x, y);
            List<Integer> yCoordinate = rowMap.computeIfAbsent(x, arg -> new ArrayList<>());
            yCoordinate.add(y);
            List<Integer> xCoordinate = colMap.computeIfAbsent(y, arg -> new ArrayList<>());
            xCoordinate.add(x);
        }

        for (Point point : points) {
            if (isVisited.contains(point)) {
                continue;
            }
            /**
             * stoneCount[0]保存当前连通图中的石头的数量
             */
            int[] stoneCount = {0};
            dfs(point, isVisited, rowMap, colMap, stoneCount);
            /**
             * 当前连通图中，除了深度优先搜索最后剩下的一块石头，其余的都能被移除
             */
            result += stoneCount[0] - 1;
        }
        return result;
    }

    /**
     * 深度优先搜索连通图中的所有石头
     *
     * @param point
     * @param isVisited
     * @param rowMap
     * @param colMap
     * @param stoneCount
     */
    public static void dfs(Point point, Set<Point> isVisited, Map<Integer, List<Integer>> rowMap,
                           Map<Integer, List<Integer>> colMap, int[] stoneCount) {
        /**
         * 当前连通图中的石头数量增加1块
         */
        stoneCount[0]++;
        /**
         * 标记当前石头的坐标已访问
         */
        isVisited.add(point);
        int x = point.x;
        int y = point.y;
        List<Integer> yCoordinates = rowMap.getOrDefault(x, Collections.emptyList());
        List<Integer> xCoordinates = colMap.getOrDefault(y, Collections.emptyList());

        for (Integer yCoordinate : yCoordinates) {
            Point otherPoint = new Point(x, yCoordinate);

            if (!isVisited.contains(otherPoint)) {
                dfs(otherPoint, isVisited, rowMap, colMap, stoneCount);
            }
        }

        for (Integer xCoordinate : xCoordinates) {
            Point otherPoint = new Point(xCoordinate, y);

            if (!isVisited.contains(otherPoint)) {
                dfs(otherPoint, isVisited, rowMap, colMap, stoneCount);
            }
        }
    }
}
