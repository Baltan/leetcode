package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Description: 2896. Apply Operations to Make Two Strings Equal
 *
 * @author Baltan
 * @date 2023/10/9 23:12
 */
public class MinOperations16 {
    public static void main(String[] args) {
        System.out.println(minOperations("00010", "00010", 9));
        System.out.println(minOperations("101101", "000000", 6));
        System.out.println(minOperations("11001011111", "01111000110", 2));
        System.out.println(minOperations("1100011000", "0101001010", 2));
        System.out.println(minOperations("10110", "00011", 4));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/apply-operations-to-make-two-strings-equal/description/comments/2143565"></a>
     *
     * @param s1
     * @param s2
     * @param x
     * @return
     */
    public static int minOperations(String s1, String s2, int x) {
        if (Objects.equals(s1, s2)) {
            return 0;
        }
        int length = s1.length();
        /**
         * 按顺序保存s1和s2中同一位置上字符不同的索引
         */
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                indexes.add(i);
            }
        }
        /**
         * 假设s1和s2中在x个索引位置上，s1的字符为0，s2的字符为1；在y个索引位置上，s1的字符为1，s2的字符为0，则x+y=indexes.size()。对于
         * s1来说，每次操作后可能的情况为x-2个0和y+2个1、x个0和y个1、x+2个0和y-2个1，即s1中0的个数的奇偶性和1的个数的奇偶性都不会变，而对
         * 于s2来说，0的个数为y，1的个数为x，因为x+y为奇数，所以x和y的奇偶性不同，因此s1和s2中0和1的个数的奇偶性都不同，无法做到最终使s1和
         * s2完全相同
         */
        if (indexes.size() % 2 == 1) {
            return -1;
        }
        int size = indexes.size();
        /**
         * 共需进行pairs次配对操作
         */
        int pairs = size / 2;
        /**
         * dp[i][j]表示令s1和s2中索引为indexes[i]……indexes[j]的j-i+1个位置上的字符最终一致需要的最小代价，题目所求即为dp[0][size-1]
         */
        int[][] dp = new int[size][size];
        /**
         * 计算令s1和s2中索引为indexes[i-1]和indexes[i]的字符最终一致需要的最小代价
         */
        for (int i = 1; i < size; i++) {
            dp[i - 1][i] = Math.min(x, indexes.get(i) - indexes.get(i - 1));
        }

        for (int i = 2; i <= pairs; i++) {
            /**
             * 计算令s1和s2中索引为indexes[k]……indexes[j]的j-k+1个位置上的字符最终一致需要的最小代价
             */
            for (int j = i * 2 - 1; j < size; j++) {
                int k = j + 1 - i * 2;
                dp[k][j] = Integer.MAX_VALUE;
                /**
                 * 令s1和s2中索引为indexes[k]和indexes[k+1]的字符相同，操作1的代价为x，操作2的代价为indexes[k+1]-indexes[k]，两者
                 * 取较小值
                 */
                dp[k][j] = Math.min(dp[k][j], Math.min(x, indexes.get(k + 1) - indexes.get(k)) + dp[k + 2][j]);
                /**
                 * 令s1和s2中索引为indexes[j]和indexes[j-1]的字符相同，操作1的代价为x，操作2的代价为indexes[j]-indexes[j-1]，两者
                 * 取较小值
                 */
                dp[k][j] = Math.min(dp[k][j], Math.min(x, indexes.get(j) - indexes.get(j - 1)) + dp[k][j - 2]);
                /**
                 * 令s1和s2中索引为indexes[k]和indexes[j]的字符相同，操作1的代价为x，操作2的代价为indexes[j]-indexes[k]，两者取较
                 * 小值
                 */
                dp[k][j] = Math.min(dp[k][j], Math.min(x, indexes.get(j) - indexes.get(k)) + dp[k + 1][j - 1]);
            }
        }
        return dp[0][size - 1];
    }
}
