package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2580. Count Ways to Group Overlapping Ranges
 *
 * @author Baltan
 * @date 2023/3/5 11:02
 */
public class CountWays {
    public static void main(String[] args) {
        System.out.println(countWays(new int[][]{{6, 10}, {5, 15}}));
        System.out.println(countWays(new int[][]{{1, 3}, {10, 20}, {2, 5}, {4, 8}}));
    }

    public static int countWays(int[][] ranges) {
        long result = 1L;
        int mod = 1000000007;
        /**
         * 分组的数量
         */
        int groups = 0;
        /**
         * 将所有区间按照左端点坐标升序排列，左端点坐标相等时按照右端点坐标升序排列
         */
        Arrays.sort(ranges, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        /**
         * 前一个分组的最右坐标，假设最左边有个虚拟区间[-1,-1]，则前一个分组的最右坐标为-1
         */
        int hi = -1;

        for (int[] range : ranges) {
            if (range[0] > hi) {
                /**
                 * 如果当前区间的左端点坐标大于前一个分组的最右坐标，则当前区间可以不加入前一个分组，得到了一个新的分组
                 */
                groups++;
                hi = range[1];
            } else {
                /**
                 * 判断当前分组的最右坐标是否被扩大
                 */
                hi = Math.max(hi, range[1]);
            }
        }
        /**
         * 所有分组要被划分为两个部分，则第一个部分可以从中选择[0,groups]个分组，剩下的分组都属于另一部分
         * C(groups,0)+C(groups,1)+C(groups,2)+……+C(groups,groups)
         * =2^groups
         */
        for (int i = 0; i < groups; i++) {
            result = (result << 1) % mod;
        }
        return (int) result;
    }
}
