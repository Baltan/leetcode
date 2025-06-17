package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 3568. Minimum Moves to Clean the Classroom
 *
 * @author baltan
 * @date 2025/6/17 16:32
 */
public class MinMoves5 {
    public static void main(String[] args) {
        System.out.println(minMoves(new String[]{"S...................", "....................", "....................", "....................", ".....RL........RR...", "....................", "......L....R..L.....", ".....L..............", ".........L........LL", "....................", "....................", "....................", "........L...........", "....................", "....................", "....................", "....L...............", "....................", ".....R..............", "..............L....."}, 20));
        System.out.println(minMoves(new String[]{"SR"}, 1));
        System.out.println(minMoves(new String[]{"S.", "XL"}, 2));
        System.out.println(minMoves(new String[]{"LS", "RL"}, 4));
        System.out.println(minMoves(new String[]{"L.S", "RXL"}, 3));
    }

    public static int minMoves(String[] classroom, int energy) {
        int rows = classroom.length;
        int cols = classroom[0].length();
        /**
         * 起始位置的行数
         */
        int startRow = -1;
        /**
         * 起始位置的列数
         */
        int startCol = -1;
        /**
         * litters[i][j]表示单元格classroom[i][j]为垃圾时，该垃圾的索引值
         */
        int[][] litters = new int[rows][cols];
        int litterIndex = 0;
        /**
         * 收集完所有垃圾时的状态，当收集了索引为x的垃圾时，将maxLitterStatus的二进制值从低到高第x位设为1
         */
        int maxLitterStatus = 0;
        /**
         * 保存学生的状态
         */
        Queue<Status> queue = new LinkedList<>();
        /**
         * 上下左右四个相邻的格子
         */
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        /**
         * 查找起始位置，并将网格中的所有垃圾依次编上索引，同时计算收集完所有垃圾时的状态
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (classroom[i].charAt(j) == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (classroom[i].charAt(j) == 'L') {
                    litters[i][j] = litterIndex;
                    maxLitterStatus |= (1 << litterIndex);
                    litterIndex++;
                }
            }
        }
        /**
         * isVisited[i][j][k][l]表示是否出现过学生位于单元格(i,j)时，能量为k，已收集垃圾的状态为l的情况
         */
        boolean[][][][] isVisited = new boolean[rows][cols][energy + 1][maxLitterStatus + 1];
        /**
         * 起始状态
         */
        Status status = new Status(startRow, startCol, energy, 0, 0);
        queue.offer(status);
        isVisited[startRow][startCol][energy][0] = true;

        while (!queue.isEmpty()) {
            Status currStatus = queue.poll();
            /**
             * 当前状态下已收集完所有垃圾，直接返回当前状态下已移动的次数
             */
            if (currStatus.litterStatus == maxLitterStatus) {
                return currStatus.step;
            }
            /**
             * 当前状态下能量值为0，并且当前所在单元格不是重置区域，不能继续移动
             */
            if (currStatus.energy == 0 && classroom[currStatus.row].charAt(currStatus.col) != 'R') {
                continue;
            }
            /**
             * 向上下左右四个方向移动
             */
            for (int[] direction : directions) {
                int nextRow = currStatus.row + direction[0];
                int nextCol = currStatus.col + direction[1];
                /**
                 * 单元格(nextRow,nextCol)位于网格外，或单元格中是障碍物，无法到达
                 */
                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || classroom[nextRow].charAt(nextCol) == 'X') {
                    continue;
                }
                /**
                 * 如果单元格(nextRow,nextCol)中是垃圾，则从当前状态到达单元格(nextRow,nextCol)时，已收集垃圾的状态变为
                 * currStatus.litterStatus|(1<<litters[nextRow][nextCol])，否则仍为currStatus.litterStatus
                 */
                int nextLitterStatus = classroom[nextRow].charAt(nextCol) == 'L' ? currStatus.litterStatus | (1 << litters[nextRow][nextCol]) : currStatus.litterStatus;
                /**
                 * 如果单元格(nextRow,nextCol)是重置区域，则从当前状态到达单元格(nextRow,nextCol)时，能量值恢复为energy，否则为
                 * currStatus.energy-1
                 */
                int nextEnergy = classroom[nextRow].charAt(nextCol) == 'R' ? energy : currStatus.energy - 1;
                /**
                 * 到达单元格(nextRow,nextCol)时的状态
                 */
                Status nextStatus = new Status(nextRow, nextCol, nextEnergy, nextLitterStatus, currStatus.step + 1);

                if (!isVisited[nextStatus.row][nextStatus.col][nextStatus.energy][nextStatus.litterStatus]) {
                    queue.offer(nextStatus);
                    isVisited[nextStatus.row][nextStatus.col][nextStatus.energy][nextStatus.litterStatus] = true;
                }
            }
        }
        return -1;
    }

    /**
     * 学生的状态
     */
    public static class Status {
        /**
         * 当前所在单元格的行数
         */
        private int row;
        /**
         * 当前所在单元格的列数
         */
        private int col;
        /**
         * 当前的能量值
         */
        private int energy;
        /**
         * 当前已收集垃圾的状态
         */
        private int litterStatus;
        /**
         * 当前已移动的次数
         */
        private int step;

        public Status(int row, int col, int energy, int litterStatus, int step) {
            this.row = row;
            this.col = col;
            this.energy = energy;
            this.litterStatus = litterStatus;
            this.step = step;
        }
    }
}
