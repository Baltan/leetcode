package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1601. Maximum Number of Achievable Transfer Requests
 *
 * @author Baltan
 * @date 2023/7/19 22:26
 */
public class MaximumRequests {
    public static void main(String[] args) {
        int[][] requests1 = {{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}};
        System.out.println(maximumRequests(5, requests1));

        int[][] requests2 = {{0, 0}, {1, 2}, {2, 1}};
        System.out.println(maximumRequests(3, requests2));

        int[][] requests3 = {{0, 3}, {3, 1}, {1, 2}, {2, 0}};
        System.out.println(maximumRequests(4, requests3));
    }

    public static int maximumRequests(int n, int[][] requests) {
        int result = 0;
        /**
         * 假设用二进制数mask表示被满足请求的情况，当二进制数最低位为1时，表示requests[0]被满足；当二进制数次低位为1时，表示requests[1]
         * 被满足；……，当二进制数从低到高第requests.length位为1时，表示requests[requests.length-1]被满足。当所有请求都被满足时，mask
         * 可以取到最大值(1<<requests.length)-1
         */
        int maxMask = (1 << requests.length) - 1;
        /**
         * 遍历计算每一种请求被满足的情况
         */
        for (int mask = 1; mask <= maxMask; mask++) {
            /**
             * changes[i]表示第i栋楼的人数变化情况
             */
            int[] changes = new int[n];
            /**
             * 由x表示请求被满足的情况
             */
            int x = mask;
            /**
             * 表示当前判断的是x由低到高的第shift位（0-based）
             */
            int shift = 0;
            /**
             * x中为1的数位个数
             */
            int bit = 0;

            while (x > 0) {
                if ((x & 1) == 1) {
                    /**
                     * 此时requests[shift]被满足，则一位员工从第requests[shift][0]栋楼搬出，搬到第requests[shift][1]栋楼
                     */
                    changes[requests[shift][0]]--;
                    changes[requests[shift][1]]++;
                    bit++;
                }
                /**
                 * 继续计算x的更高一位
                 */
                shift++;
                x >>= 1;
            }
            /**
             * 当数组changes中的每一个元素都为0时，说明每栋楼员工数量净变化为0，是一种可行的请求列表
             */
            if (Arrays.stream(changes).allMatch(num -> num == 0)) {
                result = Math.max(result, bit);
            }
        }
        return result;
    }
}
