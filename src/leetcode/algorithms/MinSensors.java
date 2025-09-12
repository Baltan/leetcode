package leetcode.algorithms;

/**
 * Description: 3648. Minimum Sensors to Cover Grid
 *
 * @author baltan
 * @date 2025/9/11 15:14
 */
public class MinSensors {
    public static void main(String[] args) {
        System.out.println(minSensors(6, 5, 1));
        System.out.println(minSensors(5, 5, 1));
        System.out.println(minSensors(2, 2, 2));
    }

    public static int minSensors(int n, int m, int k) {
        /**
         * 当传感器的坐标为(i,j)时，可以覆盖网格grid[i-k……i+k][j-k……j+k]，即(2k+1)*(2k+1)的正方形。相当于求(2k+1)*(2k+1)的正方形完
         * 全覆盖n*m的矩形时的最小数量
         */
        int length = 2 * k + 1;
        return ((n - 1) / length + 1) * ((m - 1) / length + 1);
    }
}
