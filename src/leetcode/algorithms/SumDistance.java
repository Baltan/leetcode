package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2731. Movement of Robots
 *
 * @author Baltan
 * @date 2023/6/11 18:47
 */
public class SumDistance {
    public static void main(String[] args) {
        System.out.println(sumDistance(new int[]{-2, 0, 2}, "RLL", 3));
        System.out.println(sumDistance(new int[]{1, 0}, "RL", 2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/movement-of-robots/solutions/2304680/nao-jin-ji-zhuan-wan-pai-xu-tong-ji-pyth-we55/"></a>
     *
     * @param nums
     * @param s
     * @param d
     * @return
     */
    public static int sumDistance(int[] nums, String s, int d) {
        long result = 0L;
        int mod = 1000000007;
        int length = nums.length;
        /**
         * positions[i]表示开始时在nums[i]处的机器人向着s[i]方向移动d秒后的位置
         */
        long[] positions = new long[length];
        /**
         * 因为最后需要将所有机器人两两配对计算距离之和，所以最终位置上的所有机器人相互之间交换位置是不影响结果的，因此可以将所有机器人看成是
         * 一样。在这个前提下，两个机器人相遇之后各自反向运动等同于两个机器人相互穿过之后各自继续向前运动，因而可以得到每个机器人在向某个方向
         * 运动了d个单位距离后的最终位置
         */
        for (int i = 0; i < length; i++) {
            positions[i] = s.charAt(i) == 'L' ? (long) nums[i] - d : (long) nums[i] + d;
        }
        Arrays.sort(positions);
        /**
         * 对某个机器人而言，所有在其左侧的机器人的坐标之和
         */
        long sum = positions[0];
        /**
         * 假设所有机器人的最终位置升序排列之后为[x1,x2,x3,……xm,xn]（n=m+1），则所有机器人两两配对距离之和为：
         * (x2-x1)+[(x3-x1)+(x3-x2)]+……+[(xn-x1)+(xn-x2)+(xn-x3)+……(xn-xm)]
         * =(x2*1-x1)+[x3*2-(x1+x2)]+……+[xn*(n-1)-(x1+x2+x3+……+xm)]
         */
        for (int i = 1; i < length; i++) {
            result = (result + positions[i] * i - sum) % mod;
            sum += positions[i];
        }
        return (int) result;
    }
}
