package leetcode.interview;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 面试题 16.03. 交点
 *
 * @author Baltan
 * @date 2020-03-19 16:25
 */
public class Intersection {
    public static void main(String[] args) {
        OutputUtils.print1DDouleArray(
                intersection(new int[]{0, 0}, new int[]{1, 0}, new int[]{1, 1}, new int[]{0, -1}));
        OutputUtils.print1DDouleArray(
                intersection(new int[]{0, 0}, new int[]{3, 3}, new int[]{1, 1}, new int[]{2, 2}));
        OutputUtils.print1DDouleArray(
                intersection(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{2, 1}));
    }

    public static double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        /**
         * 线段1的斜率
         */
        double k1 = start1[0] == end1[0] ? Double.POSITIVE_INFINITY :
                1.0 * (end1[1] - start1[1]) / (end1[0] - start1[0]);
        /**
         * 线段2的斜率
         */
        double k2 = start2[0] == end2[0] ? Double.POSITIVE_INFINITY :
                1.0 * (end2[1] - start2[1]) / (end2[0] - start2[0]);

        if (k1 == Double.POSITIVE_INFINITY && k2 == Double.POSITIVE_INFINITY) {
            /**
             * 两线段都垂直于x轴时，并且两线段x坐标相同
             */
            if (start1[0] == start2[0]) {
                /**
                 * 线段1整体在线段2上方，两线段无交点
                 */
                if (start1[1] > end2[1] && start1[1] > start2[1] && end1[1] > end2[1] &&
                        end1[1] > start2[1]) {
                    return new double[]{};
                    /**
                     * 线段2整体在线段1上方，两线段无交点
                     */
                } else if (start2[1] > end1[1] && start2[1] > start1[1] && end2[1] > end1[1] &&
                        end2[1] > start1[1]) {
                    return new double[]{};
                } else {
                    /**
                     * 当两线段有交点时，两线段四个端点的y坐标第二小的即为交点y坐标
                     *   *            *         *       *
                     *   *  *      *  *      *  *       *  *
                     *   #  *      *  #      *  *       *  *
                     *      *      *         #  *       *  #
                     *                          *       *
                     */
                    int[] help = {start1[1], end1[1], start2[1], end2[1]};
                    Arrays.sort(help);
                    return new double[]{start1[0], help[1]};
                }
                /**
                 * 两线段都垂直于x轴时，并且两线段x坐标不同，两线段无交点
                 */
            } else {
                return new double[]{};
            }
            /**
             * 线段1垂直于x轴
             */
        } else if (k1 == Double.POSITIVE_INFINITY) {
            /**
             * 线段1整体在线段2右方，两线段无交点
             */
            if (start1[0] > start2[0] && start1[0] > end2[0] && end1[0] > start2[0] && end1[0] > end2[0]) {
                return new double[]{};
                /**
                 * 线段1整体在线段2左方，两线段无交点
                 */
            } else if (start1[0] < start2[0] && start1[0] < end2[0] && end1[0] < start2[0] &&
                    end1[0] < end2[0]) {
                return new double[]{};
            }
            /**
             * ∵ start2[1]=k2*start2[0]+b
             * ∴ b=start2[1]-k2*start2[0]
             * ∴ 直线2的表达式为：y=k2*x+(start2[1]-k2*start2[0])
             * 代入x=start1[0]时，得到直线1和直线2的交点y坐标
             */
            double y = k2 * (start1[0] - start2[0]) + start2[1];
            /**
             * 两直线交点在线段1上，两线段有交点
             */
            if (y >= start1[1] && y <= end1[1]) {
                return new double[]{start1[0], y};
            } else {
                return new double[]{};
            }
            /**
             * 线段2垂直于x轴
             */
        } else if (k2 == Double.POSITIVE_INFINITY) {
            /**
             * 线段2整体在线段1右方，两线段无交点
             */
            if (start2[0] > start1[0] && start2[0] > end1[0] && end2[0] > start1[0] && end2[0] > end1[0]) {
                return new double[]{};
                /**
                 * 线段2整体在线段1左方，两线段无交点
                 */
            } else if (start2[0] < start1[0] && start2[0] < end1[0] && end2[0] < start1[0] &&
                    end2[0] < end1[0]) {
                return new double[]{};
            }
            /**
             * ∵ start1[1]=k1*start1[0]+b
             * ∴ b=start1[1]-k1*start1[0]
             * ∴ 直线1的表达式为：y=k1*x+(start1[1]-k1*start1[0])
             * 代入x=start2[0]时，得到直线1和直线2的交点y坐标
             */
            double y = k1 * (start2[0] - start1[0]) + start1[1];
            /**
             * 两直线交点在线段2上，两线段有交点
             */
            if (y >= start2[1] && y <= end2[1]) {
                return new double[]{start2[0], y};
            } else {
                return new double[]{};
            }
            /**
             * 两线段斜率相同但都不垂直于x轴
             */
        } else if (k1 == k2) {
            /**
             * ∵ 直线1的表达式为：y=k1*x+(start1[1]-k1*start1[0])
             * ∴ 直线1截距为start1[1]-k1*start1[0]
             * ∵ 直线2的表达式为：y=k2*x+(start2[1]-k2*start2[0])
             * ∴ 直线2截距为start2[1]-k2*start2[0]
             * 如果两条直线截距不相等，则两线段平行，没有交点
             */
            if (start1[1] - k1 * start1[0] != start2[1] - k2 * start2[0]) {
                return new double[]{};
            } else {
                /**
                 * 线段1整体在线段2右方，两线段无交点
                 */
                if (start1[0] > start2[0] && start1[0] > end2[0] && end1[0] > start2[0] &&
                        end1[0] > end2[0]) {
                    return new double[]{};
                    /**
                     * 线段1整体在线段2左方，两线段无交点
                     */
                } else if (start1[0] < start2[0] && start1[0] < end2[0] && end1[0] < start2[0] &&
                        end1[0] < end2[0]) {
                    return new double[]{};
                } else {
                    /**
                     * 当两线段有交点时，两线段四个端点的x坐标第二小的即为交点x坐标
                     *   ****        #***     #***      ******
                     *     #***    ****      ******      #***
                     */
                    int[] help = {start1[0], end1[0], start2[0], end2[0]};
                    Arrays.sort(help);
                    return new double[]{help[1], k1 * (help[1] - start1[0]) + start1[1]};
                }
            }
            /**
             * 两线段斜率不同
             */
        } else {
            /**
             * ∵ 直线1的表达式为：y=k1*x+(start1[1]-k1*start1[0])
             *   直线2的表达式为：y=k2*x+(start2[1]-k2*start2[0])
             * ∴ 两直线交点x坐标为[(start2[1]-k2*start2[0])-(start1[1]-k1*start1[0])]/(k1-k2)
             */
            double x = (start2[1] - k2 * start2[0] - start1[1] + k1 * start1[0]) / (k1 - k2);

            if ((start1[0] - x) * (end1[0] - x) <= 0 && (start2[0] - x) * (end2[0] - x) <= 0) {
                double y =
                        (k1 * (start2[1] - k2 * start2[0]) - k2 * (start1[1] - k1 * start1[0])) / (k1 - k2);
                return new double[]{x, y};
            } else {
                return new double[]{};
            }
        }
    }
}
