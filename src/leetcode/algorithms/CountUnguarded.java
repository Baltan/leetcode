package leetcode.algorithms;

/**
 * Description: 2257. Count Unguarded Cells in the Grid
 *
 * @author Baltan
 * @date 2022/5/7 17:30
 */
public class CountUnguarded {
    public static void main(String[] args) {
        int m1 = 4;
        int n1 = 6;
        int[][] guards1 = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls1 = {{0, 1}, {2, 2}, {1, 4}};
        System.out.println(countUnguarded(m1, n1, guards1, walls1));

        int m2 = 3;
        int n2 = 3;
        int[][] guards2 = {{1, 1}};
        int[][] walls2 = {{0, 1}, {1, 0}, {2, 1}, {1, 2}};
        System.out.println(countUnguarded(m2, n2, guards2, walls2));
    }

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int result = 0;
        /**
         * 0-未被保卫，1-被保卫，2-警卫，3-墙
         */
        int[][] book = new int[m][n];

        for (int[] wall : walls) {
            int x = wall[0];
            int y = wall[1];
            book[x][y] = 3;
        }

        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            book[x][y] = 2;

            while (x > 0 && (book[x - 1][y] == 0 || book[x - 1][y] == 1)) {
                book[x - 1][y] = 1;
                x--;
            }

            x = guard[0];
            y = guard[1];

            while (x < m - 1 && (book[x + 1][y] == 0 || book[x + 1][y] == 1)) {
                book[x + 1][y] = 1;
                x++;
            }

            x = guard[0];
            y = guard[1];

            while (y > 0 && (book[x][y - 1] == 0 || book[x][y - 1] == 1)) {
                book[x][y - 1] = 1;
                y--;
            }

            x = guard[0];
            y = guard[1];

            while (y < n - 1 && (book[x][y + 1] == 0 || book[x][y + 1] == 1)) {
                book[x][y + 1] = 1;
                y++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (book[i][j] == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
