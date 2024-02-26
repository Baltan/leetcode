package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Description: 3047. Find the Largest Area of Square Inside Two Rectangles
 *
 * @author baltan
 * @date 2024/2/26 09:38
 */
public class LargestSquareArea {
    public static void main(String[] args) {
        System.out.println(largestSquareArea(new int[][]{{1, 1}, {2, 2}, {3, 1}}, new int[][]{{3, 3}, {4, 4}, {6, 6}}));
        System.out.println(largestSquareArea(new int[][]{{1, 1}, {2, 2}, {1, 2}}, new int[][]{{3, 3}, {4, 4}, {3, 4}}));
        System.out.println(largestSquareArea(new int[][]{{1, 1}, {3, 3}, {3, 1}}, new int[][]{{2, 2}, {4, 4}, {4, 2}}));
    }

    public static long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long result = 0L;
        Integer[] indexes = IntStream.range(0, bottomLeft.length).boxed().toArray(Integer[]::new);
        /**
         * 将所有矩形的索引按照矩形左下角x坐标的值升序排列
         */
        Arrays.sort(indexes, Comparator.comparingInt(x -> bottomLeft[x][0]));

        for (int i = 0; i < indexes.length; i++) {
            for (int j = i + 1; j < indexes.length; j++) {
                int[] bottomLeftI = bottomLeft[indexes[i]];
                int[] bottomLeftJ = bottomLeft[indexes[j]];
                int[] topRightI = topRight[indexes[i]];
                int[] topRightJ = topRight[indexes[j]];
                /**
                 * 如果矩形j的左下角x坐标不小于矩形i的右上角x坐标，说明矩形j以及后面的矩形在x轴方向上都不会和矩形i有重合部分，可以全部跳过
                 */
                if (bottomLeftJ[0] >= topRightI[0]) {
                    break;
                }
                /**
                 * 矩形i和矩形j在x轴方向上重合部分的长度
                 */
                int x = (topRightI[0] - bottomLeftI[0]) + (topRightJ[0] - bottomLeftJ[0]) -
                        (Math.max(topRightI[0], topRightJ[0]) - Math.min(bottomLeftI[0], bottomLeftJ[0]));
                /**
                 * 矩形i和矩形j在y轴方向上重合部分的长度
                 */
                int y = (topRightI[1] - bottomLeftI[1]) + (topRightJ[1] - bottomLeftJ[1]) -
                        (Math.max(topRightI[1], topRightJ[1]) - Math.min(bottomLeftI[1], bottomLeftJ[1]));
                /**
                 * 当矩形i和矩形j在x轴和y轴方向上都有重合部分时，两个矩形的交集部分可能容纳下正方形
                 */
                if (x > 0 && y > 0) {
                    int intersection = Math.min(x, y);
                    result = Math.max(result, (long) intersection * intersection);
                }
            }
        }
        return result;
    }
}
