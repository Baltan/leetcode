package leetcode.algorithms;

/**
 * Description: 1014. Best Sightseeing Pair
 *
 * @author Baltan
 * @date 2019-04-28 10:41
 */
public class MaxScoreSightseeingPair {
    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/best-sightseeing-pair/solution/zui-jia-guan-guang-zu-he-by-leetcode-solution/"></a>
     *
     * @param A
     * @return
     */
    public static int maxScoreSightseeingPair(int[] A) {
        int length = A.length;
        int maxI = 0 + A[0];
        int result = Integer.MIN_VALUE;

        for (int i = 1; i < length; i++) {
            /**
             * 到第i个景点为止一对观光景点可以取得的最高分
             */
            result = Math.max(A[i] - i + maxI, result);
            /**
             * 到第i个景点为止，x+A[x]的最高分
             */
            maxI = Math.max(maxI, i + A[i]);
        }
        return result;
    }
}
