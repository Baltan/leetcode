package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 478. Generate Random Point in a Circle
 *
 * @author Baltan
 * @date 2020-02-05 16:38
 */
public class Solution10 {
    private double radius;
    private double xCenter;
    private double yCenter;

    public Solution10(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/generate-random-point-in-a-circle/solution/zai-yuan-nei-sui-ji-sheng-cheng-dian-by-leetcode/"></a>
     *
     * @return
     */
    public double[] randPoint() {
        /**
         * 用一个边长为2r的正方形正好覆盖圆，在正方形中随机产生点，如果产生的点到圆心的距离不大于r
         * 即可，否则继续产生新的随机点
         */
        double leftBottomX = xCenter - radius;
        double leftBottomY = yCenter - radius;

        while (true) {
            double x = leftBottomX + Math.random() * 2 * radius;
            double y = leftBottomY + Math.random() * 2 * radius;

            if ((x - xCenter) * (x - xCenter) + (y - yCenter) * (y - yCenter) < radius * radius) {
                return new double[]{x, y};
            }
        }
    }

    public static void main(String[] args) {
        Solution10 solution101 = new Solution10(1, 0, 0);

        for (int i = 0; i < 10; i++) {
            OutputUtils.print1DDouleArray(solution101.randPoint());
        }

        System.out.println();

        Solution10 solution102 = new Solution10(10, 5, -7.5);

        for (int i = 0; i < 10; i++) {
            OutputUtils.print1DDouleArray(solution102.randPoint());
        }
    }
}
