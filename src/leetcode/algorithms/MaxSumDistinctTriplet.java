package leetcode.algorithms;

/**
 * Description: 3572. Maximize Y‑Sum by Picking a Triplet of Distinct X‑Values
 *
 * @author baltan
 * @date 2025/6/18 08:59
 */
public class MaxSumDistinctTriplet {
    public static void main(String[] args) {
        System.out.println(maxSumDistinctTriplet(new int[]{1, 2, 1, 3, 2}, new int[]{5, 3, 4, 6, 2}));
        System.out.println(maxSumDistinctTriplet(new int[]{1, 2, 1, 2}, new int[]{4, 5, 6, 7}));
    }

    public static int maxSumDistinctTriplet(int[] x, int[] y) {
        /**
         * max[i]表示如果选择数组x中的元素i，不同的元素i对应在数组y中的最大值
         */
        int[] max = new int[1000001];
        /**
         * first、second、third依次表示可以从数组y中选择的最大值、第二大值、第三大值
         */
        int first = 0;
        int second = 0;
        int third = 0;

        for (int i = 0; i < x.length; i++) {
            /**
             * 当从数组x中选择元素x[i]时，此时y数组中对应的元素为y[i]
             */
            max[x[i]] = Math.max(max[x[i]], y[i]);
        }

        for (int num : max) {
            if (num >= first) {
                third = second;
                second = first;
                first = num;
            } else if (num >= second) {
                third = second;
                second = num;
            } else if (num >= third) {
                third = num;
            }
        }
        /**
         * 当first、second、third都不为0时，说明可以从数组x中选择三个不同的元素
         */
        return first != 0 && second != 0 && third != 0 ? first + second + third : -1;
    }
}
