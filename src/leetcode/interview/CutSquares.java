package leetcode.interview;

import leetcode.util.OutputUtils;

/**
 * Description: 面试题 16.13. 平分正方形
 *
 * @author Baltan
 * @date 2020-03-30 18:01
 */
public class CutSquares {
    public static void main(String[] args) {
        int[] square11 = {-1, -1, 2};
        int[] square12 = {0, -1, 2};
        OutputUtils.print1DDouleArray(cutSquares(square11, square12));

        int[] square21 = {-105, -99, 54};
        int[] square22 = {-199, 255, 1};
        OutputUtils.print1DDouleArray(cutSquares(square21, square22));
    }

    public static double[] cutSquares(int[] square1, int[] square2) {
        /**
         * square1的中心
         */
        double[] center1 = {square1[0] + square1[2] / 2.0, square1[1] + square1[2] / 2.0};
        /**
         * square2的中心
         */
        double[] center2 = {square2[0] + square2[2] / 2.0, square2[1] + square2[2] / 2.0};
        /**
         * 如果两个正方形的中心x坐标相同，则直线平行于y轴，找到直线与两个正方形的所有交点中y坐标的
         * 最大值和最小值
         */
        if (center1[0] == center2[0]) {
            /**
             * 两个正方形的底边的y坐标的较小值
             */
            double yMin = Math.min(square1[1], square2[1]);
            /**
             * 两个正方形的顶边的y坐标的较大值
             */
            double yMax = Math.max(square1[1] + square1[2], square2[1] + square2[2]);
            double x = center1[0];
            return new double[]{x, yMin, x, yMax};
            /**
             * 如果两个正方形的中心y坐标相同，则直线平行于x轴，找到直线与两个正方形的所有交点中x坐
             * 标的最大值和最小值
             */
        } else if (center1[1] == center2[1]) {
            double minX = Double.MAX_VALUE;
            double maxX = Double.MIN_VALUE;
            /**
             * 两个正方形的左边的x坐标的较小值
             */
            minX = Math.min(minX, square1[0]);
            minX = Math.min(minX, square2[0]);
            /**
             * 两个正方形右边的x坐标的较大值
             */
            maxX = Math.max(maxX, square1[0] + square1[2]);
            maxX = Math.max(maxX, square2[0] + square2[2]);
            return new double[]{minX, center1[1], maxX, center1[1]};
            /**
             * 两个正方形中点的连线就是平分两个正方形的直线
             */
        } else {
            double[] result = {Double.MAX_VALUE, 0, -Double.MAX_VALUE, 0};
            /**
             * 直线斜率
             */
            double k = (center2[1] - center1[1]) / (center2[0] - center1[0]);
            /**
             * 直线截距
             */
            double b = (center1[1] * center2[0] - center1[0] * center2[1]) / (center2[0] - center1[0]);
            /**
             * 直线和square1左边直线的交点的y坐标
             */
            double leftY1 = square1[0] * k + b;
            /**
             * 直线和square1右边直线的交点的y坐标
             */
            double rightY1 = (square1[0] + square1[2]) * k + b;
            /**
             * 直线和square1底边直线的交点的x坐标
             */
            double bottomX1 = (square1[1] - b) / k;
            /**
             * 直线和square1顶边直线的交点的x坐标
             */
            double topX1 = (square1[1] + square1[2] - b) / k;
            /**
             * 直线和square2左边直线的交点的y坐标
             */
            double leftY2 = square2[0] * k + b;
            /**
             * 直线和square2右边直线的交点的y坐标
             */
            double rightY2 = (square2[0] + square2[2]) * k + b;
            /**
             * 直线和square2底边直线的交点的x坐标
             */
            double bottomX2 = (square2[1] - b) / k;
            /**
             * 直线和square2顶边直线的交点的x坐标
             */
            double topX2 = (square2[1] + square2[2] - b) / k;
            /**
             * 判断直线和square1左边直线的交点在不在square1左边上
             */
            if (leftY1 >= square1[1] && leftY1 <= square1[1] + square1[2]) {
                if (square1[0] < result[0]) {
                    result[0] = square1[0];
                    result[1] = leftY1;
                }
            }
            /**
             * 判断直线和square1右边直线的交点在不在square1右边上
             */
            if (rightY1 >= square1[1] && rightY1 <= square1[1] + square1[2]) {
                if (square1[0] + square1[2] > result[2]) {
                    result[2] = square1[0] + square1[2];
                    result[3] = rightY1;
                }
            }
            /**
             * 判断直线和square1底边直线的交点在不在square1底边上
             */
            if (bottomX1 >= square1[0] && bottomX1 <= square1[0] + square1[2]) {
                if (bottomX1 < result[0]) {
                    result[0] = bottomX1;
                    result[1] = square1[1];
                }

                if (bottomX1 > result[2]) {
                    result[2] = bottomX1;
                    result[3] = square1[1];
                }
            }
            /**
             * 判断直线和square1顶边直线的交点在不在square1顶边上
             */
            if (topX1 >= square1[0] && topX1 <= square1[0] + square1[2]) {
                if (topX1 < result[0]) {
                    result[0] = topX1;
                    result[1] = square1[1] + square1[2];
                }

                if (topX1 > result[2]) {
                    result[2] = topX1;
                    result[3] = square1[1] + square1[2];
                }
            }
            /**
             * 判断直线和square2左边直线的交点在不在square2左边上
             */
            if (leftY2 >= square2[1] && leftY2 <= square2[1] + square2[2]) {
                if (square2[0] < result[0]) {
                    result[0] = square2[0];
                    result[1] = leftY2;
                }
            }
            /**
             * 判断直线和square2右边直线的交点在不在square2右边上
             */
            if (rightY2 >= square2[1] && rightY2 <= square2[1] + square2[2]) {
                if (square2[0] + square2[2] > result[2]) {
                    result[2] = square2[0] + square2[2];
                    result[3] = rightY2;
                }
            }
            /**
             * 判断直线和square2底边直线的交点在不在square2底边上
             */
            if (bottomX2 >= square2[0] && bottomX2 <= square2[0] + square2[2]) {
                if (bottomX2 < result[0]) {
                    result[0] = bottomX2;
                    result[1] = square2[1];
                }

                if (bottomX2 > result[2]) {
                    result[2] = bottomX2;
                    result[3] = square2[1];
                }
            }
            /**
             * 判断直线和square2顶边直线的交点在不在square2顶边上
             */
            if (topX2 >= square2[0] && topX2 <= square2[0] + square2[2]) {
                if (topX2 < result[0]) {
                    result[0] = topX2;
                    result[1] = square2[1] + square2[2];
                }

                if (topX2 > result[2]) {
                    result[2] = topX2;
                    result[3] = square2[1] + square2[2];
                }
            }
            return result;
        }
    }
}
