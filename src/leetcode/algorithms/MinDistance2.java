package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1478. Allocate Mailboxes
 *
 * @author Baltan
 * @date 2024/6/6 22:04
 */
public class MinDistance2 {
    public static void main(String[] args) {
        System.out.println(minDistance(new int[]{1, 4, 8, 10, 20}, 3));
        System.out.println(minDistance(new int[]{2, 3, 5, 12, 18}, 2));
        System.out.println(minDistance(new int[]{7, 4, 6, 1}, 1));
        System.out.println(minDistance(new int[]{3, 6, 14, 10}, 4));
    }

    public static int minDistance(int[] houses, int k) {
        int length = houses.length;
        /**
         * dp[i][j]表示在最左边的i栋房子中安排j个邮筒的最小总距离，所求即为dp[length][k]
         */
        int[][] dp = new int[length + 1][k + 1];
        /**
         * prefixSums[i]表示最左边的i栋房子的坐标之和
         */
        int[] prefixSums = new int[length + 1];
        Arrays.sort(houses);
        /**
         * 当在i栋房子中只安排一个邮筒时，为了使得所有房子到邮筒的总距离之和最小，显然邮筒不可能在第1栋房子的左侧和第i栋房子的右侧，即必然在
         * 坐标[houses[0],houses[i-1]]中的某个坐标处。因此，第1栋和第i栋房子到邮筒的距离之和总是为houses[i-1]-houses[0]。同理，对于
         * 剩下中间的i-2栋房子而言，为了使得这些房子到邮筒的总距离之和最小，邮筒不可能在第2栋房子的左侧和第i-1栋房子的右侧，即必然在坐标
         * [houses[1],houses[i-2]]中的某个坐标处。因此，第2栋和第i-1栋房子到邮筒的距离之和总是为houses[i-2]-houses[1]。以此类推，如
         * 果房子的总数为奇数，则邮筒应该放在最中间的第(i+1)/2栋房子的坐标houses[i/2]处；如果房子的总数为偶数，则邮筒最终应该放在最中间的
         * 第(i/2)栋房子和第(i/2+1)栋房子之间的任意一个坐标处，即[houses[i/2-1],houses[i/2]]。此时所有房子到邮筒的总距离为栋房子中的
         * 最右侧i/2栋房子的坐标之和减去最左侧i/2栋房子的坐标之和，即(prefixSums[i]-prefixSums[i-i/2])-prefixSums[i/2]
         */
        for (int i = 1; i <= length; i++) {
            prefixSums[i] = prefixSums[i - 1] + houses[i - 1];
            dp[i][1] = (prefixSums[i] - prefixSums[i - i / 2]) - prefixSums[i / 2];
        }
        /**
         * 计算在最左边的i栋房子中安排j个邮筒的最小总距离
         */
        for (int i = 1; i <= length; i++) {
            /**
             * 邮筒总数不可能大于i，因为i栋房子安排i个邮筒已经使得总距离为0，多余的邮筒应该都安排到其他的房子之间使得它们到邮筒的总距离更小
             */
            for (int j = 2; j <= Math.min(k, i); j++) {
                dp[i][j] = Integer.MAX_VALUE;
                /**
                 * 假设最左边的l栋房子之间安排j-1个邮筒，接下去的i-l栋房子之间安排1个邮筒，即在[houses[l],houses[i-1]]之间安排1个邮筒，
                 * 根据之前的结论，如果剩余的i-l栋房子的总数为奇数，则邮筒应该放在它们最中间的房子的坐标处；如果房子的总数为偶数，则邮筒最
                 * 终应该放在最中间的两栋房子之间的任意一个坐标处
                 */
                for (int l = j - 1; l < i; l++) {
                    dp[i][j] = Math.min(dp[i][j], dp[l][j - 1] + (prefixSums[i] - prefixSums[i - (i - l) / 2]) - (prefixSums[l + (i - l) / 2] - prefixSums[l]));
                }
            }
        }
        return dp[length][k];
    }
}
