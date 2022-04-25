package leetcode.algorithms;

/**
 * Description: 2249. Count Lattice Points Inside a Circle
 *
 * @author Baltan
 * @date 2022/4/24 22:00
 */
public class CountLatticePoints {
    public static void main(String[] args) {
        int[][] circles1 = {{2, 2, 1}};
        System.out.println(countLatticePoints(circles1));

        int[][] circles2 = {{2, 2, 2}, {3, 4, 1}};
        System.out.println(countLatticePoints(circles2));

        int[][] circles3 =
                {{34, 70, 10}, {28, 89, 6}, {36, 95, 18}, {51, 93, 48}, {13, 50, 8}, {52, 20, 14}, {64, 1, 1},
                        {45, 90, 17}, {94, 47, 3}, {12, 20, 4}, {46, 1, 1}, {60, 59, 54}, {32, 86, 25},
                        {41, 51, 15}, {26, 66, 20}, {76, 60, 31}, {95, 56, 27}, {67, 51, 13}, {18, 70, 9},
                        {87, 63, 32}, {84, 6, 6}, {25, 55, 14}, {11, 74, 2}, {47, 21, 7}, {57, 88, 56},
                        {60, 4, 1}, {34, 14, 14}, {51, 61, 16}, {39, 38, 1}, {23, 69, 14}, {79, 75, 70},
                        {95, 80, 10}, {14, 66, 4}, {69, 91, 67}, {95, 18, 11}, {35, 84, 7}, {9, 48, 6},
                        {13, 72, 3}, {76, 11, 5}, {14, 75, 11}, {8, 94, 1}, {34, 80, 21}, {53, 86, 49},
                        {32, 15, 3}, {64, 61, 58}, {62, 28, 10}, {67, 22, 20}, {87, 48, 46}, {3, 5, 2},
                        {7, 48, 4}, {75, 88, 68}, {81, 55, 52}, {95, 74, 63}, {73, 18, 17}, {17, 7, 4},
                        {57, 38, 23}, {81, 22, 10}, {47, 33, 29}, {58, 33, 31}, {48, 77, 15}, {56, 55, 36},
                        {45, 77, 11}, {82, 93, 22}, {61, 8, 1}, {97, 58, 38}, {97, 93, 92}, {53, 39, 24},
                        {65, 25, 23}, {32, 90, 4}, {17, 22, 15}, {40, 98, 32}, {65, 17, 4}, {10, 28, 10},
                        {10, 65, 6}, {23, 94, 3}, {43, 19, 10}, {33, 90, 5}, {2, 28, 2}, {96, 26, 9},
                        {99, 98, 32}};
        System.out.println(countLatticePoints(circles3));
    }

    public static int countLatticePoints(int[][] circles) {
        int result = 0;
        /**
         * 根据题意，圆心横坐标、纵坐标的范围都为[1,100]，所以圆周上可能的最大整数坐标为200，即圆心为(100,100)，半径为100时，
         * isVisited[i][j]表示点(i,j)是否已被计数过
         */
        boolean[][] isVisited = new boolean[201][201];

        for (int[] circle : circles) {
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];
            /**
             * 圆内（包含圆周上）的点的很坐标范围为[x-r,x+r]，依次遍历查找当横坐标为i时，圆内符合条件的点
             */
            for (int i = x - r; i <= x + r; i++) {
                /**
                 * 以A(i,y)为垂足做垂线垂直x轴，交圆于点B，根据勾股定理，则AB长度的平方为square
                 */
                int square = r * r - (x - i) * (x - i);
                /**
                 * 依次判断(i,y)、(i,y-1)、(i,y+1)、(i,y-2)、(i,y+2)……是否在圆内，直到找到圆外为止
                 */
                for (int j = 0; j * j <= square; j++) {
                    if (!isVisited[i][y - j]) {
                        isVisited[i][y - j] = true;
                        result++;
                    }

                    if (!isVisited[i][y + j]) {
                        isVisited[i][y + j] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
