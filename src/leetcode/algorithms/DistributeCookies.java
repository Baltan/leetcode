package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2305. Fair Distribution of Cookies
 *
 * @author Baltan
 * @date 2023/1/20 14:02
 */
public class DistributeCookies {
    public static void main(String[] args) {
        System.out.println(distributeCookies(new int[]{8, 15, 10, 20, 8}, 2));
        System.out.println(distributeCookies(new int[]{6, 1, 3, 2, 2, 4, 1, 2}, 3));
    }

    private static int result;

    /**
     * 参考：<a href="https://leetcode.cn/problems/fair-distribution-of-cookies/solutions/1597568/hui-su-by-keepal-edq2/"></a>
     *
     * @param cookies
     * @param k
     * @return
     */
    public static int distributeCookies(int[] cookies, int k) {
        result = Integer.MAX_VALUE;
        /**
         * counts[i]表示第i个孩子分到的饼干数量
         */
        int[] counts = new int[k];
        Arrays.sort(cookies);
        /**
         * 第0（0-based）个零食包分给谁都一样，就分给第0（0-based）个孩子好了，可以减少回溯次数
         */
        counts[0] = cookies[0];
        /**
         * 从第1（0-based）个零食包开始回溯
         */
        dfs(cookies, k, counts, 1);
        return result;
    }

    public static void dfs(int[] cookies, int k, int[] counts, int index) {
        if (index == cookies.length) {
            /**
             * 所有孩子中分到最多的饼干数量
             */
            int max = Arrays.stream(counts).max().getAsInt();
            result = Math.min(result, max);
            return;
        }

        for (int i = 0; i < k; i++) {
            /**
             * 如果当前零食包分给第i个孩子后，这个孩子的饼干数量比之前已经得到的最小不公平程度还多，肯定不可能优于之前的分配方法，直接跳过
             */
            if (counts[i] + cookies[index] >= result) {
                continue;
            }
            counts[i] += cookies[index];
            dfs(cookies, k, counts, index + 1);
            counts[i] -= cookies[index];
        }
    }
}
