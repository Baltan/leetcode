package leetcode.algorithms;

/**
 * Description: 875. Koko Eating Bananas
 *
 * @author Baltan
 * @date 2019-09-07 18:49
 */
public class MinEatingSpeed {
    public static void main(String[] args) {
        int[] piles1 = {3, 6, 7, 11};
        System.out.println(minEatingSpeed(piles1, 8));

        int[] piles2 = {30, 11, 23, 4, 20};
        System.out.println(minEatingSpeed(piles2, 5));

        int[] piles3 = {30, 11, 23, 4, 20};
        System.out.println(minEatingSpeed(piles3, 6));
    }

    public static int minEatingSpeed(int[] piles, int H) {
        int result = 0;
        double total = 0;
        int max = 0;

        for (int pile : piles) {
            total += pile;
            /**
             * 因为根据题意H>piles.length，所以如果每小时吃的香蕉根数达到最多的那堆香蕉的根数，
             * 可以保证在H小时内吃完所有香蕉
             */
            max = Math.max(max, pile);
        }
        /**
         * 如果香蕉分布理想，每堆香蕉都能尽可能的吃得多，至少需要每小时吃Math.ceil(total / H)
         * 根香蕉
         */
        int min = (int) Math.ceil(total / H);
        /**
         * 二分查找可以保证在H小时内吃完所有香蕉的最小速度
         */
        while (min <= max) {
            int middle = (min + max) / 2;

            if (!help(piles, H, middle)) {
                min = middle + 1;
            } else {
                /**
                 * 如果每小时吃middle根香蕉可以保证在H小时内吃完所有香蕉，现将该速度记录，继续
                 * 判断更小的速度是否可以在H小时内吃完所有香蕉
                 */
                result = middle;
                max = middle - 1;
            }
        }
        return result;
    }

    /**
     * 判断如果每小时吃K根香蕉，能否在H小时内吃完所有香蕉
     *
     * @param piles
     * @param H
     * @param K
     * @return
     */
    public static boolean help(int[] piles, int H, int K) {
        int time = 0;

        for (int pile : piles) {
            time += Math.ceil(pile * 1.0 / K);
        }
        return time <= H;
    }
}
