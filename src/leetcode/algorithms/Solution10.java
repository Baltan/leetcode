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

    public double[] randPoint() {
        /**
         * 在[0,2π)中随机产生一个角度
         */
        double angle = Math.random() * 2 * Math.PI;
        double distance;
        /**
         * 在[0,r]中随机产生一个距离，Math.random()产生在[0,1)中的随机数，Math.random()乘以一
         * 个略大于r的数（比如：r+r/1000）后，可以得到[0,r+r/1000)的随机数，循环产生随机数直到产
         * 生在[0,r]中的随机数为止
         */
        do {
            distance = Math.random() * (radius + radius / 1000);
        } while (distance > radius);
        /**
         * 将产生的点在x轴上平移xCenter距离，在y轴上平移yCenter距离即可
         */
        double x = distance * Math.cos(angle) + xCenter;
        double y = distance * Math.sin(angle) + yCenter;
        return new double[]{x, y};
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
