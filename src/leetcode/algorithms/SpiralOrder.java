package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Spiral Matrix
 *
 * @author Baltan
 * @date 2018/9/14 11:34
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix1));

        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix2));

        int[][] matrix3 = {};
        System.out.println(spiralOrder(matrix3));

        int[][] matrix4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(spiralOrder(matrix4));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int length = matrix.length;
        int width = matrix[0].length;
        int size = length * width;

        boolean[][] mark = new boolean[length][width];
        int[][] nextStep = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] currCoordinate = {0, 0};
        res.add(matrix[currCoordinate[0]][currCoordinate[1]]);
        mark[currCoordinate[0]][currCoordinate[1]] = true;
        int[] currDirection = {0, 1};
        while (res.size() != size) {
            if (currCoordinate[0] + currDirection[0] >= 0 && currCoordinate[0] + currDirection[0] < length &&
                    currCoordinate[1] +
                            currDirection[1] >= 0 && currCoordinate[1] +
                    currDirection[1] < width &&
                    !mark[currCoordinate[0] + currDirection[0]][currCoordinate[1] +
                            currDirection[1]]) {
                currCoordinate[0] = currCoordinate[0] + currDirection[0];
                currCoordinate[1] = currCoordinate[1] + currDirection[1];
                res.add(matrix[currCoordinate[0]][currCoordinate[1]]);
                mark[currCoordinate[0]][currCoordinate[1]] = true;
            } else {
                for (int i = 0; i < nextStep.length; i++) {
                    int[] move = nextStep[i];
                    if (currCoordinate[0] + move[0] >= 0 && currCoordinate[0] + move[0] < length &&
                            currCoordinate[1] +
                                    move[1] >= 0 && currCoordinate[1] +
                            move[1] < width && !mark[currCoordinate[0] + move[0]][currCoordinate[1] +
                            move[1]]) {
                        currCoordinate[0] = currCoordinate[0] + move[0];
                        currCoordinate[1] = currCoordinate[1] + move[1];
                        res.add(matrix[currCoordinate[0]][currCoordinate[1]]);
                        mark[currCoordinate[0]][currCoordinate[1]] = true;
                        currDirection[0] = move[0];
                        currDirection[1] = move[1];
                        break;
                    }
                }
            }
        }
        return res;
    }
}
