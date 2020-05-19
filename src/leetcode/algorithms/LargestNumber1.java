package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1449. Form Largest Integer With Digits That Add up to Target
 *
 * @author Baltan
 * @date 2020-05-18 16:58
 */
public class LargestNumber1 {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5}, 9));
        System.out.println(largestNumber(new int[]{7, 6, 5, 5, 5, 6, 8, 7, 8}, 12));
        System.out.println(largestNumber(new int[]{2, 4, 6, 2, 4, 6, 4, 4, 4}, 5));
        System.out.println(largestNumber(new int[]{6, 10, 15, 40, 40, 40, 40, 40, 40}, 47));
        System.out.println(largestNumber(new int[]{6, 10, 15, 40, 40, 40, 40, 40, 40}, 5000));
    }

    public static String largestNumber(int[] cost, int target) {
        /**
         * 成本 -> 该成本可以获得的最大数字
         */
        Map<Integer, Integer> map = new HashMap<>();
        /**
         * dp[i]为总成本为i时，可以得到的数位个数最多时的数位集合
         */
        List<Character>[] dp = new List[target + 1];
        /**
         * 当总成本为0时，无法得到任何整数
         */
        dp[0] = new ArrayList<>(0);

        for (int i = 0; i < cost.length; i++) {
            map.put(cost[i], i + 1);
        }

        for (int i = 1; i <= target; i++) {
            /**
             * 最坏情况无法得到任何整数，此时数位个数为0
             */
            dp[i] = new ArrayList<>(0);

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                /**
                 * 除去当前数位entry.getValue()的成本entry.getKey()后，剩下的成本
                 */
                int leftCost = i - entry.getKey();
                /**
                 * 只有在当前数位entry.getValue()的成本entry.getKey()的成本为i，或者除去当前数位
                 * entry.getValue()的成本entry.getKey()后，剩下的成本仍旧可以得到整数的情况下才继续判断
                 */
                if (leftCost == 0 || (leftCost > 0 && !dp[leftCost].isEmpty())) {
                    /**
                     * 如果可以得到更多的数位，则最后得到的整数一定更大，更新dp[i]
                     */
                    if (dp[leftCost].size() + 1 > dp[i].size()) {
                        dp[i] = new ArrayList<>(dp[leftCost]);
                        dp[i].add((char) (entry.getValue() + '0'));
                        Collections.sort(dp[i], (x, y) -> y - x);
                        /**
                         * 如果得到的数位相同，则需要比较两种情况最后得到的整数的大小，取较大整数的那种情况
                         */
                    } else if (dp[leftCost].size() + 1 == dp[i].size()) {
                        List<Character> temp = new ArrayList<>(dp[leftCost]);
                        temp.add((char) (entry.getValue() + '0'));
                        Collections.sort(temp, (x, y) -> y - x);
                        /**
                         * 逐位比较dp[i]和temp的每一位上的数字，得到dp[i]和temp中的较大值
                         */
                        for (int j = 0; j < temp.size(); j++) {
                            if (dp[i].get(j) > temp.get(j)) {
                                break;
                            } else if (dp[i].get(j) < temp.get(j)) {
                                dp[i] = temp;
                                break;
                            }
                        }
                    }
                }
            }
        }
        /**
         * 如果dp[target]为空数组，说明总成本为target时，得不到任何整数，返回"0"
         */
        if (dp[target].isEmpty()) {
            return "0";
        } else {
            /**
             * 将dp[target]中所有数位拼接成最大整数字符串
             */
            int index = 0;
            char[] charArray = new char[dp[target].size()];

            for (char c : dp[target]) {
                charArray[index++] = c;
            }
            return String.valueOf(charArray);
        }
    }
}
