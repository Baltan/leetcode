package leetcode.algorithms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * Description: 1467. Probability of a Two Boxes Having The Same Number of Distinct Balls
 *
 * @author Baltan
 * @date 2023/3/28 21:46
 */
public class GetProbability {
    public static void main(String[] args) {
        System.out.println(getProbability(new int[]{1, 1}));
        System.out.println(getProbability(new int[]{2, 1, 1}));
        System.out.println(getProbability(new int[]{1, 2, 1, 2}));
        System.out.println(getProbability(new int[]{6, 6, 6, 6, 6, 6, 6, 6}));
    }

    /**
     * 两个盒子中球的个数相同并且球的颜色数相同的方案数
     */
    private static BigDecimal valid;
    /**
     * 两个盒子中球的个数相同的方案数
     */
    private static BigDecimal total;

    public static double getProbability(int[] balls) {
        valid = BigDecimal.valueOf(0);
        total = BigDecimal.valueOf(0);
        /**
         * boxA[i]表示第一个盒子中颜色为i的球的个数
         */
        int[] boxA = new int[balls.length];
        /**
         * boxB[i]表示第二个盒子中颜色为i的球的个数
         */
        int[] boxB = new int[balls.length];
        /**
         * 每个盒子中球的总个数
         */
        int half = Arrays.stream(balls).sum() / 2;
        dfs(balls, boxA, boxB, 0, 0, half, 0);
        /**
         * 四舍五入保留7位小数
         */
        return valid.divide(total, 7, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 回溯计算所有令每个盒子中球的总个数为half的方案
     *
     * @param balls
     * @param boxA
     * @param boxB
     * @param countA
     * @param countB
     * @param half
     * @param index
     */
    public static void dfs(int[] balls, int[] boxA, int[] boxB, int countA, int countB, int half, int index) {
        if (index == balls.length) {
            if (countA == half) {
                /**
                 * 每个盒子中的球可以通过排列得到不同的方案
                 */
                BigDecimal permutation = BigDecimal.valueOf(permute(boxA, half)).multiply(BigDecimal.valueOf(permute(boxB, half)));
                total = total.add(permutation);
                /**
                 * 两个盒子中球的颜色数相同，得到permutation种满足题意的分配方案
                 */
                if (getColors(boxA) == getColors(boxB)) {
                    valid = valid.add(permutation);
                }
            }
            return;
        }
        /**
         * 给第一个盒子分配i个颜色为index的球
         */
        for (int i = 0; i <= balls[index]; i++) {
            boxA[index] = i;
            boxB[index] = balls[index] - boxA[index];
            countA += boxA[index];
            countB += boxB[index];
            /**
             * 如果第一个盒子中球的总个数已经超过了half个，则后续的所有方案都不符合题意，结束
             */
            if (countA > half) {
                break;
            }
            /**
             * 如果第二个盒子中球的总个数已经超过了half个，则应当给第一个盒子分配更多颜色为index的球，跳过当前情况
             */
            if (countB > half) {
                /**
                 * 还原状态
                 */
                countA -= boxA[index];
                countB -= boxB[index];
                boxA[index] = 0;
                boxB[index] = 0;
                continue;
            }
            /**
             * 递归对下一种颜色的球进行分配
             */
            dfs(balls, boxA, boxB, countA, countB, half, index + 1);
            /**
             * 还原状态
             */
            countA -= boxA[index];
            countB -= boxB[index];
            boxA[index] = 0;
            boxB[index] = 0;
        }
    }

    /**
     * 计算一个盒子中球的颜色数
     *
     * @param box
     * @return
     */
    public static long getColors(int[] box) {
        return Arrays.stream(box).filter(x -> x > 0).count();
    }

    /**
     * 将盒子中所有球通过排列可以得到的不同方案数
     *
     * @param box
     * @param blank
     * @return
     */
    public static long permute(int[] box, int blank) {
        long result = 1L;

        for (int num : box) {
            /**
             * 盒子中不存在当前颜色的球，跳过
             */
            if (num == 0) {
                continue;
            }
            /**
             * 从剩余的blank个位置中任意选择num个位置放当前颜色的球
             */
            result *= combine(blank, num);
            /**
             * 剩余的位子扣除num个
             */
            blank -= num;
        }
        return result;
    }

    /**
     * 从m个位置中任意选择n个位置，计算选择的方案数
     *
     * @param m
     * @param n
     * @return
     */
    public static long combine(int m, int n) {
        long result = 1L;
        /**
         * C(m,n)=[m*(m-1)*……*(m+1-n)]/(1*2*……*n)=(m/n)*[(m-1)/(n-1)]*……*[(m+1-n)/1]
         */
        for (int i = 1; i <= n; i++) {
            result *= (i - n + m);
            result /= i;
        }
        return result;
    }
}
