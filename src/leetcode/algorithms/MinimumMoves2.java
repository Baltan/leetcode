package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2850. Minimum Moves to Spread Stones Over Grid
 *
 * @author Baltan
 * @date 2023/9/10 15:14
 */
public class MinimumMoves2 {
    public static void main(String[] args) {
        System.out.println(minimumMoves(new int[][]{{1, 1, 0}, {1, 1, 1}, {1, 2, 1}}));
        System.out.println(minimumMoves(new int[][]{{1, 3, 0}, {1, 0, 0}, {1, 0, 3}}));
    }

    private static int result;

    public static int minimumMoves(int[][] grid) {
        result = Integer.MAX_VALUE;
        /**
         * 记录初始时所有没有石头的格子
         */
        List<Grid> empties = new ArrayList<>();
        /**
         * 记录初始时所有石头个数大于1的格子
         */
        List<Grid> multiples = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    empties.add(new Grid(i, j, 0));
                } else if (grid[i][j] > 1) {
                    multiples.add(new Grid(i, j, grid[i][j]));
                }
            }
        }

        for (int i = 0; i < empties.size(); i++) {
            dfs(0, empties, new ArrayList<>(multiples), new boolean[empties.size()], i, 0);
        }
        return result;
    }

    /**
     * 将multiples[multipleIndex]的一块石头移动到empties[emptyIndex]
     *
     * @param moves         当前已经移动的总次数
     * @param empties       没有石头的格子的列表
     * @param multiples     石头个数大于1的格子的列表
     * @param isVisited     isVisited[i]表示empties[i]是否已被放石头
     * @param emptyIndex    将要填充的空格子empties[emptyIndex]
     * @param multipleIndex 将要用multiples[multipleIndex]的石头填充空格子
     */
    public static void dfs(int moves, List<Grid> empties, List<Grid> multiples, boolean[] isVisited, int emptyIndex, int multipleIndex) {
        if (multipleIndex == multiples.size()) {
            result = Math.min(result, moves);
            return;
        }

        if (isVisited[emptyIndex]) {
            return;
        }
        /**
         * 格子multiples[multipleIndex]的坐标
         */
        int fromX = multiples.get(multipleIndex).x;
        int fromY = multiples.get(multipleIndex).y;
        /**
         * 格子empties[emptyIndex]的坐标
         */
        int toX = empties.get(emptyIndex).x;
        int toY = empties.get(emptyIndex).y;
        /**
         * 从(fromX,fromY)到(toX,toY)的曼哈顿距离
         */
        moves += Math.abs(fromX - toX) + Math.abs(fromY - toY);
        isVisited[emptyIndex] = true;
        /**
         * 将格子multiples[multipleIndex]中的石头数减1
         */
        multiples.get(multipleIndex).count--;
        /**
         * 如果格子multiples[multipleIndex]中的剩余石头数量为1，则下一步用multiples[multipleIndex+1]中的石头填充
         */
        int nextMultipleIndex = multiples.get(multipleIndex).count == 1 ? multipleIndex + 1 : multipleIndex;

        for (int i = 0; i < empties.size(); i++) {
            dfs(moves, empties, multiples, isVisited, i, nextMultipleIndex);
        }
        /**
         * 还原到之前的状态
         */
        multiples.get(multipleIndex).count++;
        isVisited[emptyIndex] = false;
    }

    /**
     * 某个格子的坐标和格子中石头的数量
     */
    public static class Grid {
        private int x;
        private int y;
        private int count;

        public Grid(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
