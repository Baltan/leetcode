package leetcode.algorithms;

/**
 * Description: 2087. Minimum Cost Homecoming of a Robot in a Grid
 *
 * @author Baltan
 * @date 2021/11/29 09:33
 */
public class MinCost1 {
    public static void main(String[] args) {
        int[] startPos1 = {1, 0};
        int[] homePos1 = {2, 3};
        int[] rowCosts1 = {5, 4, 3};
        int[] colCosts1 = {8, 2, 6, 7};
        System.out.println(minCost(startPos1, homePos1, rowCosts1, colCosts1));

        int[] startPos2 = {0, 0};
        int[] homePos2 = {0, 0};
        int[] rowCosts2 = {5};
        int[] colCosts2 = {26};
        System.out.println(minCost(startPos2, homePos2, rowCosts2, colCosts2));
    }

    public static int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int result = 0;
        /**
         * 因为rowCosts[r] ∈ [0,10^4]，colCosts[c] ∈ [0,10^4]，所以机器人不可能向反方向走
         */
        if (startPos[0] < homePos[0]) {
            /**
             * 机器人从上向下需要经过的行
             */
            for (int i = homePos[0]; i > startPos[0]; i--) {
                result += rowCosts[i];
            }
        } else if (startPos[0] > homePos[0]) {
            /**
             * 机器人从下向上需要经过的行
             */
            for (int i = homePos[0]; i < startPos[0]; i++) {
                result += rowCosts[i];
            }
        }

        if (startPos[1] < homePos[1]) {
            /**
             * 机器人从左向右需要经过的列
             */
            for (int i = homePos[1]; i > startPos[1]; i--) {
                result += colCosts[i];
            }
        } else if (startPos[1] > homePos[1]) {
            /**
             * 机器人从右向左需要经过的列
             */
            for (int i = homePos[1]; i < startPos[1]; i++) {
                result += colCosts[i];
            }
        }
        return result;
    }
}
