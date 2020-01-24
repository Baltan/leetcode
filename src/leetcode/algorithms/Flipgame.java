package leetcode.algorithms;

/**
 * Description: 822. Card Flipping Game
 *
 * @author Baltan
 * @date 2020-01-24 11:07
 */
public class Flipgame {
    public static void main(String[] args) {
        int[] fronts1 = {1, 2, 4, 4, 7};
        int[] backs1 = {1, 3, 4, 1, 3};
        System.out.println(flipgame(fronts1, backs1));

        int[] fronts2 = {1};
        int[] backs2 = {2000};
        System.out.println(flipgame(fronts2, backs2));

        int[] fronts3 = {1, 2};
        int[] backs3 = {1, 2};
        System.out.println(flipgame(fronts3, backs3));
    }

    public static int flipgame(int[] fronts, int[] backs) {
        int result = Integer.MAX_VALUE;
        int length = fronts.length;
        /**
         * book[i]标记是否有卡片正反面同时为数字i，显然i不可能是我们想要的数字
         */
        boolean[] book = new boolean[2001];

        for (int i = 0; i < length; i++) {
            if (fronts[i] == backs[i]) {
                book[fronts[i]] = true;
            }
        }

        for (int i = 0; i < length; i++) {
            /**
             * 对于每一张正反面不同的卡片，如果上面的数字没有同时出现在某一张卡片的正反面上并且这个
             * 数字比当前result更小，就更新result
             */
            if (fronts[i] != backs[i]) {
                int min = Math.min(fronts[i], backs[i]);
                int max = Math.max(fronts[i], backs[i]);

                if (!book[min]) {
                    result = Math.min(result, min);
                } else if (!book[max]) {
                    result = Math.min(result, max);
                }
            }
        }
        /**
         * 如果result仍旧为Integer.MAX_VALUE，说明没有一个数字是符合要求的
         */
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
