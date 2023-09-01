package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 1547. Minimum Cost to Cut a Stick
 *
 * @author Baltan
 * @date 2023/8/31 22:28
 */
public class MinCost5 {
    public static void main(String[] args) {
        System.out.println(minCost(20, new int[]{1, 14, 18, 6, 17, 8, 10, 4, 13, 16, 7}));
        System.out.println(minCost(7, new int[]{1, 3, 4, 5}));
        System.out.println(minCost(9, new int[]{5, 6, 1, 4, 2}));
    }

    public static int minCost(int n, int[] cuts) {
        /**
         * 将木棍的刻度0和刻度n也当做两个切割点，升序排列木棍中所有切割点的刻度
         */
        Arrays.sort(cuts);
        List<Integer> splits = new ArrayList<>(cuts.length + 2);
        splits.add(0);
        Arrays.stream(cuts).forEach(splits::add);
        splits.add(n);
        /**
         * 木棍最终可以被分成maxSegments小段
         */
        int maxSegments = splits.size() - 1;
        /**
         * 从第[0,startUnits]个切割点开始的小段木棍可能被继续切割
         */
        int startUnits = splits.size() - 1;
        /**
         * dp[i][j]表示从第j个切割点到第i+j个切割点中间的小段木棍被切割的最小成本，所求即为dp[maxSegments][0]
         */
        int[][] dp = new int[maxSegments + 1][startUnits + 1];

        for (int i = 0; i <= startUnits; i++) {
            /**
             * 不存在第i+2个刻度，结束计算
             */
            if (i + 2 > startUnits) {
                break;
            }
            /**
             * 从第i个切割点到第i+2个切割点中间的小段木棍，只能在第i+1个切割点处被切开，成本为小段木棍的长度splits[i+2]-splits[i]
             */
            dp[2][i] = splits.get(i + 2) - splits.get(i);
        }
        /**
         * 计算从第j个切割点到第i+j个切割点中间的小段木棍被切割的最小成本，即当前小段木棍最终会被切割为i小段
         */
        for (int i = 3; i <= maxSegments; i++) {
            for (int j = 0; j <= startUnits; j++) {
                /**
                 * 初始化当前小段木棍的切割最小成本为一个较大值用于后期比较缩减成本
                 */
                dp[i][j] = Integer.MAX_VALUE >> 1;
                /**
                 * 不存在第i+j个刻度，结束计算
                 */
                if (j + i > startUnits) {
                    break;
                }
                /**
                 * 当前小段木棍的总长度，第一次切割花费的成本即为total
                 */
                int total = splits.get(j + i) - splits.get(j);
                /**
                 * 当前小段木棍在第一次切割后会被分为左边最终含k小段，右边最终含i-k小段的两部分，其中左边小段从第j个切割点到第j+k个切割点，
                 * 右边小段从第j+k个切割点到第i+j个切割点
                 */
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], total + dp[k][j] + dp[i - k][j + k]);
                }
            }
        }
        return dp[maxSegments][0];
    }
}
