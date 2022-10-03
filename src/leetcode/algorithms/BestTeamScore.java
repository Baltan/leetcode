package leetcode.algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Description: 1626. Best Team With No Conflicts
 *
 * @author Baltan
 * @date 2022/10/2 14:50
 */
public class BestTeamScore {
    public static void main(String[] args) {
        System.out.println(bestTeamScore(new int[]{1, 3, 5, 10, 15}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1}));
        System.out.println(bestTeamScore(new int[]{1, 2, 3, 5}, new int[]{8, 9, 10, 1}));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/best-team-with-no-conflicts/solution/pai-xu-dong-tai-gui-hua-by-lucifer1004/"></a>
     *
     * @param scores
     * @param ages
     * @return
     */
    public static int bestTeamScore(int[] scores, int[] ages) {
        int result = 0;
        int length = scores.length;
        Integer[] indexes = IntStream.range(0, length).boxed().toArray(Integer[]::new);
        /**
         * 将所有球员优先按照年龄升序排列，如果年龄相同时，按照分数升序排列
         */
        Arrays.sort(indexes, (x, y) -> {
            if (ages[x] == ages[y]) {
                return scores[x] - scores[y];
            } else {
                return ages[x] - ages[y];
            }
        });
        /**
         * dp[i]表示以排序后的第i个人作为队伍中的最后一个人可以获得的最高分数
         */
        int[] dp = new int[length];

        for (int i = 0; i < length; ++i) {
            /**
             * 最后一个人的索引
             */
            int currIndex = indexes[i];
            dp[i] = scores[currIndex];
            /**
             * 枚举倒数第二个人的情况
             */
            for (int j = 0; j < i; ++j) {
                /**
                 * 倒数第二个人的索引
                 */
                int prevIndex = indexes[j];
                /**
                 * 如果最后一个人的分数小于倒数第二个人，说明最后一个人的年龄大于倒数第二个人，两个人会产生矛盾，此时不能选倒数
                 * 第二个人，反之两个人可以同时选中
                 */
                if (scores[prevIndex] <= scores[currIndex]) {
                    dp[i] = Math.max(dp[i], dp[j] + scores[currIndex]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
