package leetcode.algorithms;

/**
 * Description: 1401. Circle and Rectangle Overlapping
 *
 * @author Baltan
 * @date 2020-04-08 21:01
 */
public class CheckOverlap {
    public static void main(String[] args) {
        System.out.println(checkOverlap(1, 0, 0, 1, -1, 3, 1));
        System.out.println(checkOverlap(1, 0, 0, -1, 0, 0, 1));
        System.out.println(checkOverlap(1, 1, 1, -3, -3, 3, 3));
        System.out.println(checkOverlap(1, 1, 1, 1, -3, 2, -1));
    }

    public static boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2,
                                       int y2) {
        /**
         * 如果圆心在矩形内部，则两者有重合部分
         */
        if (x_center >= x1 && x_center <= x2 && y_center >= y1 && y_center <= y2) {
            return true;
        }
        /**
         * 如果圆心在矩形正上方并且圆心到矩形顶边的距离小于等于半径，则两者有重合部分；
         * 如果圆心在矩形正下方并且圆心到矩形底边的距离小于等于半径，则两者有重合部分
         */
        if (x_center >= x1 && x_center <= x2) {
            if (y_center < y1 && radius >= y1 - y_center) {
                return true;
            } else if (y_center > y2 && radius >= y_center - y2) {
                return true;
            }
        }
        /**
         * 如果圆心在矩形正左方并且圆心到矩形左边的距离小于等于半径，则两者有重合部分；
         * 如果圆心在矩形正右方并且圆心到矩形右边的距离小于等于半径，则两者有重合部分
         */
        if (y_center >= y1 && y_center <= y2) {
            if (x_center < x1 && radius >= x1 - x_center) {
                return true;
            } else if (x_center > x2 && radius >= x_center - x2) {
                return true;
            }
        }
        /**
         * 如果圆心在矩形左下方并且圆心到矩形左下顶点的距离小于等于半径，则两者有重合部分
         */
        if (x_center < x1 && y_center < y1) {
            if (radius >= distance(x1, y1, x_center, y_center)) {
                return true;
            }
        }
        /**
         * 如果圆心在矩形左上方并且圆心到矩形左上顶点的距离小于等于半径，则两者有重合部分
         */
        if (x_center < x1 && y_center > y2) {
            if (radius >= distance(x1, y2, x_center, y_center)) {
                return true;
            }
        }
        /**
         * 如果圆心在矩形右上方并且圆心到矩形右上顶点的距离小于等于半径，则两者有重合部分
         */
        if (x_center > x2 && y_center > y2) {
            if (radius >= distance(x2, y2, x_center, y_center)) {
                return true;
            }
        }
        /**
         * 如果圆心在矩形右下方并且圆心到矩形右下顶点的距离小于等于半径，则两者有重合部分
         */
        if (x_center > x2 && y_center < y1) {
            if (radius >= distance(x2, y1, x_center, y_center)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 计算(a1,b1)和(a2,b2)在平面直角坐标系上的距离
     *
     * @param a1
     * @param b1
     * @param a2
     * @param b2
     * @return
     */
    public static double distance(int a1, int b1, int a2, int b2) {
        return Math.sqrt((a1 - a2) * (a1 - a2) + (b1 - b2) * (b1 - b2));
    }
}
