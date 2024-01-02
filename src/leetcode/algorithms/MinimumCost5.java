package leetcode.algorithms;

import java.util.*;

/**
 * 2977. Minimum Cost to Convert String II
 *
 * @author Baltan
 * @date 2023/12/31 21:37
 * @see MinimumCost4
 */
public class MinimumCost5 {
    public static void main(String[] args) {
        String[] original1 = {"a", "b", "c", "c", "e", "d"};
        String[] changed1 = {"b", "c", "b", "e", "b", "e"};
        int[] cost1 = {2, 5, 5, 1, 2, 20};
        System.out.println(minimumCost("abcd", "acbe", original1, changed1, cost1));

        String[] original2 = {"bcd", "fgh", "thh"};
        String[] changed2 = {"cde", "thh", "ghh"};
        int[] cost2 = {1, 3, 5};
        System.out.println(minimumCost("abcdefgh", "acdeeghh", original2, changed2, cost2));

        String[] original3 = {"bcd", "defgh"};
        String[] changed3 = {"ddd", "ddddd"};
        int[] cost3 = {100, 1578};
        System.out.println(minimumCost("abcdefgh", "addddddd", original3, changed3, cost3));

        String[] original4 = {"bg", "xr", "cc", "ip", "vq", "po", "ym", "rh", "vw", "lf", "lo", "ee", "qv", "yr", "f", "w", "i", "u", "g", "a", "e", "f", "s", "r", "p", "j", "o", "g", "i", "u"};
        String[] changed4 = {"xr", "cc", "ip", "vq", "po", "ym", "rh", "vw", "lf", "lo", "ee", "qv", "yr", "yt", "w", "i", "u", "g", "a", "e", "f", "s", "r", "p", "a", "o", "g", "i", "u", "p"};
        int[] cost4 = {97733, 90086, 87125, 85361, 75644, 46301, 21616, 79538, 52507, 95884, 79353, 61127, 58665, 96031, 95035, 12116, 41158, 91096, 47819, 88522, 25493, 80186, 66981, 87597, 56691, 86820, 89031, 99954, 41271, 39699};
        System.out.println("04:" + minimumCost("fjybg", "apyyt", original4, changed4, cost4));
    }

    public static long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        /**
         * i -> {j -> 从字符串i变为字符串j的最小代价}
         */
        Map<String, Map<String, Long>> minCosts = new HashMap<>();
        long[] dp = new long[source.length() + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0L;

        for (int i = 0; i < cost.length; i++) {
            Map<String, Long> map = minCosts.computeIfAbsent(original[i], x -> new HashMap<>());
            map.put(changed[i], Math.min(map.getOrDefault(changed[i], Long.MAX_VALUE), cost[i]));
        }
        /**
         * Floyd算法更新字符串original[j]变为字符串changed[k]的最小代价，判断将字符串original[j]先变为字符串changed[i]，再将字符串
         * changed[i]变为字符串changed[k]，是否可以减小字符串original[j]变为字符串changed[k]的最小代价
         */
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost.length; j++) {
                for (int k = 0; k < cost.length; k++) {
                    long jiCost = minCosts.getOrDefault(original[j], Collections.emptyMap()).getOrDefault(changed[i], Long.MAX_VALUE);
                    long ikCost = minCosts.getOrDefault(changed[i], Collections.emptyMap()).getOrDefault(changed[k], Long.MAX_VALUE);

                    if (jiCost != Long.MAX_VALUE && ikCost != Long.MAX_VALUE) {
                        long minCost = minCosts.computeIfAbsent(original[j], x -> new HashMap<>()).getOrDefault(changed[k], Long.MAX_VALUE);
                        minCosts.get(original[j]).put(changed[k], Math.min(minCost, jiCost + ikCost));
                    }
                }
            }
        }

        for (int i = 1; i <= source.length(); i++) {
            /**
             * 如果字符source[i-1]不被操作
             */
            if (Objects.equals(source.substring(i - 1, i), target.substring(i - 1, i)) && dp[i - 1] != Long.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }
            /**
             * 如果字符source[i-1]会被操作
             */
            for (Map.Entry<String, Map<String, Long>> entry : minCosts.entrySet()) {
                if (i < entry.getKey().length()) {
                    continue;
                }
                int length = entry.getKey().length();
                String from = source.substring(i - length, i);
                String to = target.substring(i - length, i);
                long minCost = Objects.equals(from, to) ? 0L : minCosts.getOrDefault(from, Collections.emptyMap()).getOrDefault(to, Long.MAX_VALUE);

                if (Objects.equals(from, entry.getKey()) && dp[i - length] != Long.MAX_VALUE && minCost != Long.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - length] + minCost);
                }
            }
        }
        return dp[source.length()] == Long.MAX_VALUE ? -1 : dp[source.length()];
    }
}
