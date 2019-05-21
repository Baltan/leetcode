package leetcode.algorithms;

/**
 * Description: 598. Range Addition II
 *
 * @author Baltan
 * @date 2018/1/2 10:28
 */
public class MaxCount {
    public static void main(String[] args) {
        System.out.println(maxCount(3, 3, new int[][]{new int[]{2, 2}, new int[]{3, 3}}));
        System.out.println(maxCount(3, 3, new int[][]{}));
        System.out.println(maxCount(3, 3, new int[][]{new int[]{1}}));
    }

    public static int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0 || ops[0].length < 2) {
            return m * n;
        }
        int aMin = ops[0][0];
        int bMin = ops[0][1];
        for (int i = 1; i < ops.length; i++) {
            if (ops[i][0] < aMin) {
                aMin = ops[i][0];
            }
            if (ops[i][1] < bMin) {
                bMin = ops[i][1];
            }
        }
        if (m >= aMin && n >= bMin) {
            return aMin * bMin;
        } else if (m >= aMin && n < bMin) {
            return aMin * n;
        } else if (m < aMin && n >= bMin) {
            return m * bMin;
        } else {
            return m * n;
        }
    }
}
