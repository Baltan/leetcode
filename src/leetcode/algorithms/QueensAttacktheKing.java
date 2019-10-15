package leetcode.algorithms;

import java.awt.Point;
import java.util.*;

/**
 * Description: 1222. Queens That Can Attack the King
 *
 * @author Baltan
 * @date 2019-10-15 09:29
 */
public class QueensAttacktheKing {
    public static void main(String[] args) {
        int[][] queens1 = {{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
        int[] king1 = {0, 0};
        System.out.println(queensAttacktheKing(queens1, king1));

        int[][] queens2 = {{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}};
        int[] king2 = {3, 3};
        System.out.println(queensAttacktheKing(queens2, king2));

        int[][] queens3 =
                {{5, 6}, {7, 7}, {2, 1}, {0, 7}, {1, 6}, {5, 1}, {3, 7}, {0, 3}, {4, 0}, {1, 2}, {6, 3},
                        {5, 0}, {0, 4}, {2, 2}, {1, 1}, {6, 4}, {5, 4}, {0, 0}, {2, 6}, {4, 5}, {5, 2},
                        {1, 4}, {7, 5}, {2, 3}, {0, 5}, {4, 2}, {1, 0}, {2, 7}, {0, 1}, {4, 6}, {6, 1},
                        {0, 6}, {4, 3}, {1, 7}};
        int[] king3 = {3, 4};
        System.out.println(queensAttacktheKing(queens3, king3));
    }

    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new LinkedList<>();
        Set<Point> queenSet = new HashSet<>();
        int kingRow = king[0];
        int kingCol = king[1];
        int r1 = kingRow - 1;
        int r2 = kingRow + 1;
        int c1 = kingCol - 1;
        int c2 = kingCol + 1;
        int r3 = kingRow - 1;
        int c3 = kingCol - 1;
        int r4 = kingRow - 1;
        int c4 = kingCol + 1;
        int r5 = kingRow + 1;
        int c5 = kingCol - 1;
        int r6 = kingRow + 1;
        int c6 = kingCol + 1;

        for (int[] queen : queens) {
            Point p = new Point(queen[0], queen[1]);
            queenSet.add(p);
        }
        /**
         * 查找国王同行左侧有没有皇后
         */
        while (r1 >= 0) {
            if (queenSet.contains(new Point(r1, kingCol))) {
                result.add(Arrays.asList(r1, kingCol));
                break;
            }
            r1--;
        }
        /**
         * 查找国王同行右侧有没有皇后
         */
        while (r2 < 8) {
            if (queenSet.contains(new Point(r2, kingCol))) {
                result.add(Arrays.asList(r2, kingCol));
                break;
            }
            r2++;
        }
        /**
         * 查找国王同列上边有没有皇后
         */
        while (c1 >= 0) {
            if (queenSet.contains(new Point(kingRow, c1))) {
                result.add(Arrays.asList(kingRow, c1));
                break;
            }
            c1--;
        }
        /**
         * 查找国王同列下边有没有皇后
         */
        while (c2 < 8) {
            if (queenSet.contains(new Point(kingRow, c2))) {
                result.add(Arrays.asList(kingRow, c2));
                break;
            }
            c2++;
        }
        /**
         * 查找国王左上对角线有没有皇后
         */
        while (r3 >= 0 && c3 >= 0) {
            if (queenSet.contains(new Point(r3, c3))) {
                result.add(Arrays.asList(r3, c3));
                break;
            }
            r3--;
            c3--;
        }
        /**
         * 查找国王右上对角线有没有皇后
         */
        while (r4 >= 0 && c4 < 8) {
            if (queenSet.contains(new Point(r4, c4))) {
                result.add(Arrays.asList(r4, c4));
                break;
            }
            r4--;
            c4++;
        }
        /**
         * 查找国王左下对角线有没有皇后
         */
        while (r5 < 8 && c5 >= 0) {
            if (queenSet.contains(new Point(r5, c5))) {
                result.add(Arrays.asList(r5, c5));
                break;
            }
            r5++;
            c5--;
        }
        /**
         * 查找国王右下对角线有没有皇后
         */
        while (r6 < 8 && c6 < 8) {
            if (queenSet.contains(new Point(r6, c6))) {
                result.add(Arrays.asList(r6, c6));
                break;
            }
            r6++;
            c6++;
        }
        return result;
    }
}
