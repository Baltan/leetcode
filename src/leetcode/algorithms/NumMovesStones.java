package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 1033. Moving Stones Until Consecutive
 *
 * @author Baltan
 * @date 2019-04-29 21:55
 * @see NumMovesStonesII
 */
public class NumMovesStones {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(numMovesStones(1, 2, 5));
        OutputUtils.print1DIntegerArray(numMovesStones(4, 3, 2));
        OutputUtils.print1DIntegerArray(numMovesStones(17, 1, 40));
        OutputUtils.print1DIntegerArray(numMovesStones(4, 1, 3));
        OutputUtils.print1DIntegerArray(numMovesStones(3, 5, 1));
        OutputUtils.print1DIntegerArray(numMovesStones(3, 15, 1));
        OutputUtils.print1DIntegerArray(numMovesStones(2, 15, 1));
    }

    public static int[] numMovesStones(int a, int b, int c) {
        int minMoves = 0;
        int maxMoves = 0;
        int[] maxArray = {a, b, c};

        Arrays.sort(maxArray);
        int[] minArray = maxArray.clone();

        while (maxArray[2] - maxArray[1] != 1 || maxArray[1] - maxArray[0] != 1) {
            if (maxArray[2] - maxArray[1] > 1) {
                maxArray[2]--;
            } else if (maxArray[1] - maxArray[0] > 1) {
                maxArray[0]++;
            }
            maxMoves++;
        }

        while (minArray[2] - minArray[1] != 1 || minArray[1] - minArray[0] != 1) {
            if (minArray[2] - minArray[1] >= minArray[1] - minArray[0]) {
                if (minArray[1] - minArray[0] == 1) {
                    minArray[2] = minArray[1] + 1;
                } else {
                    int temp = minArray[1] - 1;
                    minArray[2] = minArray[1];
                    minArray[1] = temp;
                }
            } else {
                if (minArray[2] - minArray[1] == 1) {
                    minArray[0] = minArray[1] - 1;
                } else {
                    int temp = minArray[1] + 1;
                    minArray[0] = minArray[1];
                    minArray[1] = temp;
                }
            }
            minMoves++;
        }
        return new int[]{minMoves, maxMoves};
    }
}
