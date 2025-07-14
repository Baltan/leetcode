package leetcode.algorithms;

/**
 * Description: 3588. Find Maximum Area of a Triangle
 *
 * @author baltan
 * @date 2025/7/14 14:56
 */
public class MaxArea2 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[][]{{2, 9}, {2, 6}, {2, 5}}));
        System.out.println(maxArea(new int[][]{{1, 1}, {1, 2}, {3, 2}, {3, 3}}));
        System.out.println(maxArea(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
    }

    public static long maxArea(int[][] coords) {
        long result = -1;
        /**
         * 所有点中横坐标的最小值
         */
        int minX = Integer.MAX_VALUE;
        /**
         * 所有点中横坐标的最大值
         */
        int minY = Integer.MAX_VALUE;
        /**
         * 所有点中纵坐标的最小值
         */
        int maxX = Integer.MIN_VALUE;
        /**
         * 所有点中纵坐标的最大值
         */
        int maxY = Integer.MIN_VALUE;

        for (int[] coord : coords) {
            minX = Math.min(minX, coord[0]);
            maxX = Math.max(maxX, coord[0]);
            minY = Math.min(minY, coord[1]);
            maxY = Math.max(maxY, coord[1]);
        }
        /**
         * xMin[i]表示横坐标为i的所有点中纵坐标的最小值
         */
        int[] xMin = new int[maxX + 1];
        /**
         * xMax[i]表示横坐标为i的所有点中纵坐标的最大值
         */
        int[] xMax = new int[maxX + 1];
        /**
         * yMin[i]表示纵坐标为i的所有点中横坐标的最小值
         */
        int[] yMin = new int[maxY + 1];
        /**
         * yMax[i]表示纵坐标为i的所有点中横坐标的最大值
         */
        int[] yMax = new int[maxY + 1];

        for (int i = 0; i <= maxX; i++) {
            xMin[i] = Integer.MAX_VALUE;
            xMax[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i <= maxY; i++) {
            yMin[i] = Integer.MAX_VALUE;
            yMax[i] = Integer.MIN_VALUE;
        }

        for (int[] coord : coords) {
            int x = coord[0];
            int y = coord[1];
            xMin[x] = Math.min(xMin[x], y);
            xMax[x] = Math.max(xMax[x], y);
            yMin[y] = Math.min(yMin[y], x);
            yMax[y] = Math.max(yMax[y], x);
        }
        /**
         * 判断三角形中有一条边平行于y轴的情况
         */
        for (int i = 0; i < xMin.length; i++) {
            if (xMin[i] != Integer.MAX_VALUE && xMax[i] != Integer.MIN_VALUE && xMin[i] != xMax[i]) {
                /**
                 * 三角形底边长为xMax[i]-xMin[i]，最大高度为Math.max(i-minX,maxX-i)
                 */
                long area = (long) (xMax[i] - xMin[i]) * Math.max(i - minX, maxX - i);

                if (area > 0) {
                    result = Math.max(result, area);
                }
            }
        }
        /**
         * 判断三角形中有一条边平行于x轴的情况
         */
        for (int i = 0; i < yMin.length; i++) {
            if (yMin[i] != Integer.MAX_VALUE && yMax[i] != Integer.MIN_VALUE && yMin[i] != yMax[i]) {
                /**
                 * 三角形底边长为yMax[i]-yMin[i]，最大高度为Math.max(i-minY,maxY-i)
                 */
                long area = (long) (yMax[i] - yMin[i]) * Math.max(i - minY, maxY - i);

                if (area > 0) {
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }
}
