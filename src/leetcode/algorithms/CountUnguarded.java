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
         * book[0]表示网格未被保卫，book[1]表示网格被保卫了，book[2]表示网格里是警卫，book[3]表示网格里是墙
         */
        int[][] book = new int[m][n];
        /**
         * 标记所有墙所在的网格
         */
        for (int[] wall : walls) {
            int x = wall[0];
            int y = wall[1];
            book[x][y] = 3;
        }
        /**
         * 标记所有警卫所在的网格
         */
        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            book[x][y] = 2;
        }

        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            /**
             * 从当前警卫所在的网格(x,y)开始向上查找所有可以被保卫的网格，直到遇到警卫或墙
             */
            while (x > 0) {
                if (book[x - 1][y] == 2 || book[x - 1][y] == 3) {
                    break;
                }
                book[x - 1][y] = 1;
                x--;
            }

            x = guard[0];
            y = guard[1];
            /**
             * 当前警卫所在的网格(x,y)开始向下查找所有可以被保卫的网格，直到遇到警卫或墙
             */
            while (x < m - 1) {
                if (book[x + 1][y] == 2 || book[x + 1][y] == 3) {
                    break;
                }
                book[x + 1][y] = 1;
                x++;
            }

            x = guard[0];
            y = guard[1];
            /**
             * 当前警卫所在的网格(x,y)开始向右查找所有可以被保卫的网格，直到遇到警卫或墙
             */
            while (y > 0) {
                if (book[x][y - 1] == 2 || book[x][y - 1] == 3) {
                    break;
                }
                book[x][y - 1] = 1;
                y--;
            }

            x = guard[0];
            y = guard[1];
            /**
             * 当前警卫所在的网格(x,y)开始向左查找所有可以被保卫的网格，直到遇到警卫或墙
             */
            while (y < n - 1) {
                if (book[x][y + 1] == 2 || book[x][y + 1] == 3) {
                    break;
                }
                book[x][y + 1] = 1;
                y++;
            }
        }
        /**
         * 计数所有未被保卫的网格
         */
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
