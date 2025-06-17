package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3568. Minimum Moves to Clean the Classroom
 *
 * @author baltan
 * @date 2025/6/17 16:32
 */
public class MinMoves5 {
    public static void main(String[] args) {
        System.out.println(minMoves(new String[]{"SR"}, 1));
        System.out.println(minMoves(new String[]{"S.", "XL"}, 2));
        System.out.println(minMoves(new String[]{"LS", "RL"}, 4));
        System.out.println(minMoves(new String[]{"L.S", "RXL"}, 3));
    }

    public static int minMoves(String[] classroom, int energy) {
        int rows = classroom.length;
        int cols = classroom[0].length();
        int startRow = -1;
        int startCol = -1;
        int[][] litters = new int[rows][cols];
        int litterIndex = 0;
        int maxLitterStatus = 0;
        Queue<Status> queue = new LinkedList<>();
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Set<Status> isVisited = new HashSet<>();

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
        Status status = new Status(startRow, startCol, energy, 0, 0);
        queue.offer(status);
        isVisited.add(status);

        while (!queue.isEmpty()) {
            Status currStatus = queue.poll();

            if (currStatus.litterStatus == maxLitterStatus) {
                return currStatus.step;
            }

            if (currStatus.energy == 0 && classroom[currStatus.row].charAt(currStatus.col) != 'R') {
                continue;
            }

            for (int[] direction : directions) {
                int nextRow = currStatus.row + direction[0];
                int nextCol = currStatus.col + direction[1];

                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || classroom[nextRow].charAt(nextCol) == 'X') {
                    continue;
                }
                int nextLitterStatus = classroom[nextRow].charAt(nextCol) == 'L' ? currStatus.litterStatus | (1 << litters[nextRow][nextCol]) : currStatus.litterStatus;
                int nextEnergy = classroom[nextRow].charAt(nextCol) == 'R' ? energy : currStatus.energy - 1;
                Status nextStatus = new Status(nextRow, nextCol, nextEnergy, nextLitterStatus, currStatus.step + 1);

                if (!isVisited.contains(nextStatus)) {
                    queue.offer(nextStatus);
                    isVisited.add(nextStatus);
                }
            }
        }
        return -1;
    }

    public static class Status {
        private int row;
        private int col;
        private int energy;
        private int litterStatus;
        private int step;

        public Status(int row, int col, int energy, int litterStatus, int step) {
            this.row = row;
            this.col = col;
            this.energy = energy;
            this.litterStatus = litterStatus;
            this.step = step;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Status status = (Status) o;
            return row == status.row && col == status.col && energy == status.energy && litterStatus == status.litterStatus;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col, energy, litterStatus);
        }
    }
}
