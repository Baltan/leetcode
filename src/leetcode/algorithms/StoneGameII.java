package leetcode.algorithms;

/**
 * Description: 1140. Stone Game II
 *
 * @author Baltan
 * @date 2020-03-05 12:52
 */
public class StoneGameII {
    public static void main(String[] args) {
        System.out.println(stoneGameII(new int[]{2, 7, 9, 4, 4}));
        System.out.println(stoneGameII(
                new int[]{3111, 4303, 2722, 2183, 6351, 5227, 8964, 7167, 9286, 6626, 2347, 1465, 5201, 7240,
                        5463, 8523, 8163, 9391, 8616, 5063, 7837, 7050, 1246, 9579, 7744, 6932, 7704, 9841,
                        6163, 4829, 7324, 6006, 4689, 8781, 621}));
    }

    public static int stoneGameII(int[] piles) {
        return help(piles, 0, 1);
    }

    /**
     * 先手从第startIndex堆石头开始拿，可以拿[1,2M]堆时，可以得到最大的石头数量
     *
     * @param piles
     * @param startIndex
     * @param M
     * @return
     */
    public static int help(int[] piles, int startIndex, int M) {
        if (startIndex == piles.length) {
            return 0;
        }

        int max = 0;
        int endIndex = Math.min(startIndex + 2 * M - 1, piles.length - 1);
        int currCount = 0;

        for (int i = startIndex; i <= endIndex; i++) {
            currCount += piles[i];
            int total = 0;

            for (int j = i + 1; j < piles.length; j++) {
                total += piles[j];
            }

            int totalCount = currCount + (total - help(piles, i + 1, Math.max(M, i - startIndex + 1)));
            max = Math.max(max, totalCount);
        }
        return max;
    }
}
