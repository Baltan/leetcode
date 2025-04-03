package leetcode.algorithms;

/**
 * Description: 3235. Check if the Rectangle Corner Is Reachable
 *
 * @author baltan
 * @date 2025/3/11 09:08
 */
public class CanReachCorner {
    public static void main(String[] args) {
        System.out.println(canReachCorner(15, 15, new int[][]{{2, 20, 13}, {20, 2, 13}}));
        System.out.println(canReachCorner(15, 15, new int[][]{{1, 99, 85}, {99, 1, 85}}));
        System.out.println(canReachCorner(3, 3, new int[][]{{2, 1000, 997}, {1000, 2, 997}}));
        System.out.println(canReachCorner(3, 4, new int[][]{{2, 1, 1}}));
        System.out.println(canReachCorner(3, 3, new int[][]{{1, 1, 2}}));
        System.out.println(canReachCorner(3, 3, new int[][]{{2, 1, 1}, {1, 2, 1}}));
        System.out.println(canReachCorner(4, 4, new int[][]{{5, 5, 1}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/check-if-the-rectangle-corner-is-reachable/solutions/2860214/deng-jie-zhuan-huan-bing-cha-ji-pythonja-yf9y/"></a>
     *
     * @param xCorner
     * @param yCorner
     * @param circles
     * @return
     */
    public static boolean canReachCorner(int xCorner, int yCorner, int[][] circles) {
        boolean[] isVisited = new boolean[circles.length];

        for (int i = 0; i < circles.length; i++) {
            int[] circle = circles[i];
            /**
             * 1、如果起点(0,0)在圆circle内或circle上，则无法从圆的左下角到达右上角
             * 2、如果终点(xCorner,yCorner)在圆circle内或circle上，则无法从圆的左下角到达右上角
             * 3、如果圆circle和矩形左侧边或上侧边相交，则从圆circle开始递归查找与其相交的其他圆，如果其他圆和矩形右侧边或下侧边相交，则无
             * 法从圆的左下角到达右上角；如果其他圆和矩形右侧边或下侧边不相交，则判断点((m1*r2+m2*r1)/(r1+r2),(n1*r2+n2*r1)/(r1+r2))
             * 是否严格在矩形内，是的话继续递归查找下一个圆，直到递归完所有圆或者存在一个圆和矩形右侧边或下侧边相交为止
             */
            if (isInCircle(circle, 0, 0) ||
                    isInCircle(circle, xCorner, yCorner) ||
                    !isVisited[i] && isTouchedWithTopLeft(circle, xCorner, yCorner) && dfs(i, xCorner, yCorner, circles, isVisited)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归查找和圆circles[i]相交的其他圆，直到递归完所有圆或者存在一个圆和矩形右侧边或下侧边相交为止，如果能找到一个圆和矩形右侧边或下侧边相
     * 交，则说明无法从圆的左下角到达右上角
     *
     * @param i
     * @param xCorner
     * @param yCorner
     * @param circles
     * @param isVisited
     * @return
     */
    private static boolean dfs(int i, int xCorner, int yCorner, int[][] circles, boolean[] isVisited) {
        /**
         * 圆circle1的圆心为(m1,n1)，半径为r1
         */
        int[] circle1 = circles[i];
        long m1 = circle1[0];
        long n1 = circle1[1];
        long r1 = circle1[2];

        if (isTouchedWithBottomRight(circle1, xCorner, yCorner)) {
            return true;
        }
        isVisited[i] = true;

        for (int j = 0; j < circles.length; j++) {
            /**
             * 圆circle2的圆心为(m2,n2)，半径为r2
             */
            int[] circle2 = circles[j];
            long m2 = circle2[0];
            long n2 = circle2[1];
            long r2 = circle2[2];

            if (!isVisited[j] && isTwoCircleTouched(circle1, circle2) &&
                    /**
                     * 判断点((m1*r2+m2*r1)/(r1+r2),(n1*r2+n2*r1)/(r1+r2))是否严格在矩形内，如果是，则两个圆可以看成一个整体
                     */
                    m1 * r2 + m2 * r1 < (r1 + r2) * xCorner &&
                    n1 * r2 + n2 * r1 < (r1 + r2) * yCorner &&
                    dfs(j, xCorner, yCorner, circles, isVisited)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断点(x,y)是否在圆circle内或circle上
     *
     * @param circle
     * @param x
     * @param y
     * @return
     */
    private static boolean isInCircle(int[] circle, long x, long y) {
        /**
         * 圆circle的圆心为(m,n)，半径为r
         */
        long m = circle[0];
        long n = circle[1];
        long r = circle[2];
        return (x - m) * (x - m) + (y - n) * (y - n) <= r * r;
    }

    /**
     * 判断圆circle是否和矩形左侧边或上侧边相交
     *
     * @param circle
     * @param xCorner
     * @param yCorner
     * @return
     */
    private static boolean isTouchedWithTopLeft(int[] circle, int xCorner, int yCorner) {
        /**
         * 圆circle的圆心为(m,n)，半径为r
         */
        long m = circle[0];
        long n = circle[1];
        long r = circle[2];
        /**
         * 如果m∈[-r,r]，并且n∈[0,yCorner]，则圆和矩形左侧边有交点
         */
        if (Math.abs(m) <= r && n >= 0 && n <= yCorner) {
            return true;
        }
        /**
         * 如果m∈[0,xCorner]，并且n∈[yCorner-r,yCorner+r]，则圆和矩形上侧边有交点
         */
        return Math.abs(n - yCorner) <= r && m <= xCorner && m >= 0;
    }

    /**
     * 判断圆circle是否和矩形右侧边或下侧边相交
     *
     * @param circle
     * @param xCorner
     * @param yCorner
     * @return
     */
    private static boolean isTouchedWithBottomRight(int[] circle, int xCorner, int yCorner) {
        /**
         * 圆circle的圆心为(m,n)，半径为r
         */
        long m = circle[0];
        long n = circle[1];
        long r = circle[2];
        /**
         * 如果m∈[xCorner-r,xCorner+r]，并且n∈[0,yCorner]，则圆和矩形右侧边有交点
         */
        if (Math.abs(m - xCorner) <= r && n >= 0 && n <= yCorner) {
            return true;
        }
        /**
         * 如果m∈[0,xCorner]，并且n∈[-r,r]，则圆和矩形下侧边有交点
         */
        return Math.abs(n) <= r && m <= xCorner && m >= 0;
    }

    /**
     * 判断圆circle1和circle2是否相交
     *
     * @param circle1
     * @param circle2
     * @return
     */
    private static boolean isTwoCircleTouched(int[] circle1, int[] circle2) {
        /**
         * 圆circle的圆心为(m,n)，半径为r
         */
        long m1 = circle1[0];
        long n1 = circle1[1];
        long r1 = circle1[2];
        /**
         * 圆circle2的圆心为(m2,n2)，半径为r2
         */
        long m2 = circle2[0];
        long n2 = circle2[1];
        long r2 = circle2[2];
        return (m1 - m2) * (m1 - m2) + (n1 - n2) * (n1 - n2) <= (r1 + r2) * (r1 + r2);
    }
}
