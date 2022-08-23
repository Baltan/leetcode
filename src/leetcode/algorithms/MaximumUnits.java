package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1710. Maximum Units on a Truck
 *
 * @author Baltan
 * @date 2022/8/17 09:20
 */
public class MaximumUnits {
    public static void main(String[] args) {
        int[][] boxTypes1 = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize1 = 4;
        System.out.println(maximumUnits(boxTypes1, truckSize1));

        int[][] boxTypes2 = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize2 = 10;
        System.out.println(maximumUnits(boxTypes2, truckSize2));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        /**
         * 按照每个箱子可以装载的单元数量倒序排列
         */
        Arrays.sort(boxTypes, (x, y) -> y[1] - x[1]);
        /**
         * 为了装载尽可能多的单元数量，总是优先选择装载的单元数量大的箱子，直到卡车装满
         */
        for (int[] boxType : boxTypes) {
            int count = Math.min(truckSize, boxType[0]);
            result += count * boxType[1];
            truckSize -= count;

            if (truckSize == 0) {
                break;
            }
        }
        return result;
    }
}
