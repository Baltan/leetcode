package leetcode.algorithms;

import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Description: 1267. Count Servers that Communicate
 *
 * @author Baltan
 * @date 2019-11-26 08:55
 */
public class CountServers {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 0}, {0, 1}};
        System.out.println(countServers(grid1));

        int[][] grid2 = {{1, 0}, {1, 1}};
        System.out.println(countServers(grid2));

        int[][] grid3 = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        System.out.println(countServers(grid3));
    }

    public static int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 保存所有可以与至少一台其他服务器进行通信的服务器的点坐标
         */
        Set<Point> set = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            List<Point> list = new LinkedList<>();
            /**
             * 将第i行所有服务器加入list
             */
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    list.add(new Point(i, j));
                }
            }
            /**
             * 如果第i行的服务器至少有2台，则这些服务器之间可以进行通信，将这些服务器加入set
             */
            if (list.size() > 1) {
                set.addAll(list);
            }
        }

        for (int i = 0; i < cols; i++) {
            List<Point> list = new LinkedList<>();
            /**
             * 将第i列所有服务器加入list
             */
            for (int j = 0; j < rows; j++) {
                if (grid[j][i] == 1) {
                    list.add(new Point(j, i));
                }
            }
            /**
             * 如果第i列的服务器至少有2台，则这些服务器之间可以进行通信，将这些服务器加入set
             */
            if (list.size() > 1) {
                set.addAll(list);
            }
        }
        return set.size();
    }
}
