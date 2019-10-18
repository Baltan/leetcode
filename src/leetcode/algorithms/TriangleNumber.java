package leetcode.algorithms;

/**
 * Description: 611. Valid Triangle Number
 *
 * @author Baltan
 * @date 2019-10-17 10:55
 */
public class TriangleNumber {
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
        System.out.println(triangleNumber(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}));
        System.out.println(triangleNumber(
                new int[]{2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6}));
    }

    public static int triangleNumber(int[] nums) {
        int result = 0;
        int maxLength = 0;
        /**
         * 计算给定的最长边的长度
         */
        for (int length : nums) {
            maxLength = Math.max(maxLength, length);
        }

        int[] count = new int[maxLength + 1];
        /**
         * 统计给出的长度为i的边的条数，保存为count[i]
         */
        for (int length : nums) {
            count[length]++;
        }

        int[] prefixSum = new int[maxLength + 1];
        /**
         * 统计给出的不大于长度为i的边的条数，保存为prefixSum[i]
         */
        for (int i = 1; i <= maxLength; i++) {
            prefixSum[i] = prefixSum[i - 1] + count[i];
        }
        /**
         * 先确定一条最短边的长度为i
         */
        for (int i = 1; i <= maxLength; i++) {
            /**
             * 如果给出的长度为i的边数count[i]不少于3条，则可以构造边长为i的等边三角形
             */
            if (count[i] >= 3) {
                /**
                 * 三条长度为i的边的可选种数
                 */
                int select3Numbers = (count[i] * (count[i] - 1) * (count[i] - 2)) / 6;
                result += select3Numbers;
            }
            /**
             * 如果给出的长度为i的边数count[i]不少于2条，则可以构造两条边长为i，第三条边长不为i的等腰三角形
             */
            if (count[i] >= 2) {
                /**
                 * 两条长度为i的边的可选种数
                 */
                int select2Numbers = count[i] * (count[i] - 1) / 2;
                /**
                 * 第三条边最短为1，最长为i+i-1和maxLength的较小值（三角形两边之和不小于第三条边的长，两边之差不大于
                 * 第三条边的长），且长度不为i
                 */
                int minEdgeLength = 1;
                int maxEdgeLength = Math.min(i + i - 1, maxLength);
                /**
                 * 用前缀和计算第三条边的可选种数，即如下循环：
                 *
                 * for (int j = minEdgeLength; j <= maxEdgeLength; j++) {
                 *      if (j != i) {
                 *           result += (select2Numbers * count[j]);
                 *      }
                 * }
                 */
                result +=
                        (prefixSum[maxEdgeLength] - prefixSum[minEdgeLength - 1] - count[i]) * select2Numbers;
            }
            /**
             * 如果给出的长度为i的边数count[i]不少于1条，则可以构造最短边长为i，另两条边长度大于i且长度不等的三遍不等
             * 三角形
             */
            if (count[i] >= 1) {
                for (int j = i + 1; j <= maxLength; j++) {
                    if (count[j] == 0) {
                        continue;
                    }
                    /**
                     * 如果第二条边长度为j（j>i），第三条边最短为j + 1，最长为i+j-1和maxLength的较小值（三角形两边
                     * 之和不小于第三条边的长，两边之差不大于第三条边的长）
                     */
                    int minEdgeLength = j + 1;
                    int maxEdgeLength = Math.min(j + i - 1, maxLength);
                    /**
                     * 用前缀和计算第三条边的可选种数，即如下循环：
                     *
                     * int edge3Num = 0;
                     *
                     * for (int k = minEdgeLength; k <= maxEdgeLength; k++) {
                     *       edge3Num += count[k];
                     * }
                     * result += count[i] * count[j] * edge3Num;
                     */
                    result += (prefixSum[maxEdgeLength] - prefixSum[minEdgeLength - 1]) * count[i] * count[j];
                }
            }
        }
        return result;
    }
}
