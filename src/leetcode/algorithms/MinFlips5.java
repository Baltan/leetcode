package leetcode.algorithms;

/**
 * Description: 3240. Minimum Number of Flips to Make Binary Grid Palindromic II
 *
 * @author baltan
 * @date 2024/8/5 09:22
 * @see MinFlips4
 */
public class MinFlips5 {
    public static void main(String[] args) {
        System.out.println(minFlips(new int[][]{{1}, {1}, {1}, {0}}));
        System.out.println(minFlips(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        System.out.println(minFlips(new int[][]{{0, 1}, {0, 1}, {0, 0}}));
        System.out.println(minFlips(new int[][]{{1}, {1}}));
    }

    public static int minFlips(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 对称轴上已成对的1的个数
         */
        int axisPairedOnes = 0;
        /**
         * 对称轴上未构成回文的数字对数
         */
        int axisNonPairs = 0;
        /**
         * 不在对称轴上未构成回文的的数字个数
         */
        int quadrantDiffs = 0;
        /**
         * 因为最终矩阵grid中1的个数是4的倍数，并且所有行和列都是回文的，所以对于不在对称轴上的4个网格grid[i][j]、grid[i][cols-1-j]、
         * grid[rows-1-i][j]、grid[rows-1-i][cols-1-j]最终的值是相同的。如果这4个网格初始时全为0或1，则不需要进行翻转操作；如果初始时
         * 有1个0和3个1，则将0变为1共需1次翻转操作；如果初始时有2个0和2个1，则将0变为1或1变为0共需2次翻转操作；如果初始时有3个0和1个1，则
         * 将1变为0共需1次翻转操作
         */
        for (int i = 0; i < rows / 2; i++) {
            for (int j = 0; j < cols / 2; j++) {
                int total = grid[i][j] + grid[i][cols - 1 - j] + grid[rows - 1 - i][j] + grid[rows - 1 - i][cols - 1 - j];
                quadrantDiffs += switch (total) {
                    case 1, 3 -> 1;
                    case 2 -> 2;
                    default -> 0;
                };
            }
        }
        /**
         * 如果矩阵grid的总行数为奇数，则最中间这行视为矩阵grid的对称轴，统计对称轴上已成对的1的个数、对称轴上未构成回文的数字对数
         */
        if (rows % 2 == 1) {
            for (int i = 0; i < cols / 2; i++) {
                if (grid[rows / 2][i] == grid[rows / 2][cols - 1 - i]) {
                    if (grid[rows / 2][i] == 1) {
                        axisPairedOnes += 2;
                    }
                } else {
                    axisNonPairs++;
                }
            }
        }
        /**
         * 如果矩阵grid的总列数为奇数，则最中间这行列视为矩阵grid的对称轴，统计对称轴上已成对的1的个数、对称轴上未构成回文的数字对数
         */
        if (cols % 2 == 1) {
            for (int i = 0; i < rows / 2; i++) {
                if (grid[i][cols / 2] == grid[rows - 1 - i][cols / 2]) {
                    if (grid[i][cols / 2] == 1) {
                        axisPairedOnes += 2;
                    }
                } else {
                    axisNonPairs++;
                }
            }
        }
        /**
         * 如果矩阵grid的总行数和总列数都为奇数，因为最终矩阵grid中1的个数是4的倍数，并且所有行和列都是回文的，则矩阵正中间的网格最终为0
         *
         * 如果矩阵grid的对称轴上已成对的1的个数除以4余2，则可以通过将某一对对称轴上未构成回文的数字对数都变为1，使得对称轴上1的个数为4的倍
         * 数，否则只能将这多余的2个1变为0。而对于所有对称轴上未构成回文的数对而言，每个数对需要修改一个数字使得构成回文形式
         */
        return quadrantDiffs + (rows % 2 == 1 && cols % 2 == 1 && grid[rows / 2][cols / 2] == 1 ? 1 : 0)
                + (axisPairedOnes % 4 == 2 && axisNonPairs == 0 ? 2 : 0) + axisNonPairs;
    }
}
