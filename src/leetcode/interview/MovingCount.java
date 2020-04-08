package leetcode.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 面试题13. 机器人的运动范围
 *
 * @author Baltan
 * @date 2020-04-08 08:10
 */
public class MovingCount {
    public static int result;

    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
        System.out.println(movingCount(3, 1, 0));
        System.out.println(movingCount(40, 50, 18));
        System.out.println(movingCount(100, 100, 20));
    }

    public static int movingCount(int m, int n, int k) {
        result = 0;
        int max = Math.max(m, n);
        /**
         * 行索引（列索引） -> 索引的各位数字之和
         */
        Map<Integer, Integer> map = new HashMap<>();
        /**
         * isVisited[i][j]标记第i行第j列（0-based）的格子是否到达过
         */
        boolean[][] isVisited = new boolean[m][n];

        for (int i = 0; i < max; i++) {
            map.put(i, bitsSum(i));
        }

        dfs(m, n, 0, 0, k, map, isVisited);
        return result;
    }

    /**
     * 计算num的个位数字之和
     *
     * @param num
     * @return
     */
    public static int bitsSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    /**
     * 深度优先搜索
     *
     * @param m
     * @param n
     * @param x
     * @param y
     * @param k
     * @param map
     * @param isVisited
     */
    public static void dfs(int m, int n, int x, int y, int k, Map<Integer, Integer> map,
                           boolean[][] isVisited) {
        if (x < 0 || x == m || y < 0 || y == n || isVisited[x][y] || map.get(x) + map.get(y) > k) {
            return;
        }
        /**
         * 标记第x行第y列（0-based）的格子已经到达过，后面不会再访问
         */
        isVisited[x][y] = true;
        result++;
        dfs(m, n, x - 1, y, k, map, isVisited);
        dfs(m, n, x + 1, y, k, map, isVisited);
        dfs(m, n, x, y - 1, k, map, isVisited);
        dfs(m, n, x, y + 1, k, map, isVisited);
    }
}
