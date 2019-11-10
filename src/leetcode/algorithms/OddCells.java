package leetcode.algorithms;

/**
 * Description: 1252. Cells with Odd Values in a Matrix
 *
 * @author Baltan
 * @date 2019-11-10 14:57
 */
public class OddCells {
    public static void main(String[] args) {
        int[][] indices1 = {{0, 1}, {1, 1}};
        System.out.println(oddCells(2, 3, indices1));

        int[][] indices2 = {{1, 1}, {0, 0}};
        System.out.println(oddCells(2, 2, indices2));
    }

    public static int oddCells(int n, int m, int[][] indices) {
        int result = 0;
        /**
         * 保存每一行加1的次数
         */
        int[] rowCount = new int[n];
        /**
         * 保存每一列加1的次数
         */
        int[] colCount = new int[m];

        for (int[] index : indices) {
            rowCount[index[0]]++;
            colCount[index[1]]++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                /**
                 * 该元素所在行加1的次数和所在列加1的次数之和即为该元素最终的值
                 */
                int count = rowCount[i] + colCount[j];

                if ((count & 1) == 1) {
                    result++;
                }
            }
        }
        return result;
    }
}
