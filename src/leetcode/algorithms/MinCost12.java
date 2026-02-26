package leetcode.algorithms;

/**
 * Description: 3784. Minimum Deletion Cost to Make All Characters Equal
 *
 * @author baltan
 * @date 2026/2/10 10:57
 */
public class MinCost12 {
    public static void main(String[] args) {
        System.out.println(minCost("aabaac", new int[]{1, 2, 3, 4, 1, 10}));
        System.out.println(minCost("abc", new int[]{10, 5, 8}));
        System.out.println(minCost("zzzzz", new int[]{67, 67, 67, 67, 67}));
    }

    public static long minCost(String s, int[] cost) {
        long result = Long.MAX_VALUE;
        /**
         * 删除字符串s中所有字符的总代价
         */
        long sum = 0L;
        /**
         * costs[0]-costs[25]依次表示删除字符串s中所有字符a-z的总代价
         */
        long[] costs = new long[26];

        for (int i = 0; i < s.length(); i++) {
            sum += cost[i];
            costs[s.charAt(i) - 'a'] += cost[i];
        }
        /**
         * 依次计算最终字符串s中只保留字符a-z的情况下，删除其余字符的总代价
         */
        for (long c : costs) {
            result = Math.min(result, sum - c);
        }
        return result;
    }
}
