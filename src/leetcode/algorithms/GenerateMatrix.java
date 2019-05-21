package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 59. Spiral Matrix II
 *
 * @author Baltan
 * @date 2018/9/19 09:15
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(generateMatrix(1));
        OutputUtils.print2DIntegerArray(generateMatrix(2));
        OutputUtils.print2DIntegerArray(generateMatrix(3));
        OutputUtils.print2DIntegerArray(generateMatrix(4));
    }

    public static int[][] generateMatrix(int n) {
        if (n < 1) {
            return null;
        }
        int[][] res = new int[n][n];
        boolean[][] mark = new boolean[n][n];
        int[][] nextStep = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currDirectionIndex = 0;
        int[] currCoordinate = {0, 0};
        int currNum = 1;
        res[currCoordinate[0]][currCoordinate[1]] = currNum;
        mark[currCoordinate[0]][currCoordinate[1]] = true;
        currNum++;
        while (currNum <= n * n) {
            if (currCoordinate[0] + nextStep[currDirectionIndex][0] >= 0 && currCoordinate[0] +
                    nextStep[currDirectionIndex][0] < n && currCoordinate[1] +
                    nextStep[currDirectionIndex][1] >= 0 && currCoordinate[1] +
                    nextStep[currDirectionIndex][1] < n && !mark[currCoordinate[0] +
                    nextStep[currDirectionIndex][0]][currCoordinate[1] + nextStep[currDirectionIndex][1]]) {
                currCoordinate[0] = currCoordinate[0] + nextStep[currDirectionIndex][0];
                currCoordinate[1] = currCoordinate[1] + nextStep[currDirectionIndex][1];
                res[currCoordinate[0]][currCoordinate[1]] = currNum;
                mark[currCoordinate[0]][currCoordinate[1]] = true;
                currNum++;
            } else {
                for (int i = currDirectionIndex + 1; i < currDirectionIndex + 4; i++) {
                    int index = i % 4;
                    if (currCoordinate[0] + nextStep[index][0] >= 0 && currCoordinate[0] +
                            nextStep[index][0] < n && currCoordinate[1] +
                            nextStep[index][1] >= 0 && currCoordinate[1] +
                            nextStep[index][1] < n && !mark[currCoordinate[0] +
                            nextStep[index][0]][currCoordinate[1] +
                            nextStep[index][1]]) {
                        currCoordinate[0] = currCoordinate[0] + nextStep[index][0];
                        currCoordinate[1] = currCoordinate[1] + nextStep[index][1];
                        res[currCoordinate[0]][currCoordinate[1]] = currNum;
                        mark[currCoordinate[0]][currCoordinate[1]] = true;
                        currNum++;
                        currDirectionIndex = index;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
