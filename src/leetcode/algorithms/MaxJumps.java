package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Description: 1340. Jump Game V
 *
 * @author baltan
 * @date 2023/3/17 10:28
 */
public class MaxJumps {
    public static void main(String[] args) {
        System.out.println(maxJumps(new int[]{6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12}, 2));
        System.out.println(maxJumps(new int[]{3, 3, 3, 3, 3}, 3));
        System.out.println(maxJumps(new int[]{7, 6, 5, 4, 3, 2, 1}, 1));
        System.out.println(maxJumps(new int[]{7, 1, 7, 1, 7, 1}, 2));
        System.out.println(maxJumps(new int[]{66}, 1));
    }

    public static int maxJumps(int[] arr, int d) {
        int result = 1;
        int length = arr.length;
        /**
         * dp[i]表示从arr[i]出发最多可以访问的下标的个数
         */
        int[] dp = new int[length];
        /**
         * 下标数组[0,1,2,……,length-1]
         */
        Integer[] indexes = IntStream.range(0, length).boxed().toArray(Integer[]::new);
        /**
         * 将下标数组indexes重新排列，使得arr[i]是升序排列的
         */
        Arrays.sort(indexes, Comparator.comparingInt(x -> arr[x]));
        /**
         * 初始化所有dp[i]为-1，表示还未尝试从arr[i]出发过
         */
        Arrays.fill(dp, -1);
        /**
         * 从arr[i]最小的下标出发肯定不能跳到任何其他下标，所以只能访问自己下标
         */
        dp[indexes[0]] = 1;

        for (int i = 1; i < indexes.length; i++) {
            /**
             * 从index下标出发
             */
            int index = indexes[i];
            dp[index] = 1;
            /**
             * 向左跳最远可能到达的下标
             */
            int leftmost = Math.max(0, index - d);
            /**
             * 向右跳最远可能到达的下标
             */
            int rightmost = Math.min(length - 1, index + d);

            for (int j = index - 1; j >= leftmost; j--) {
                /**
                 * 向左跳遇到大于等于arr[index]的下标，结束
                 */
                if (dp[j] == -1 || arr[j] == arr[index]) {
                    break;
                }
                dp[index] = Math.max(dp[index], dp[j] + 1);
            }

            for (int j = index + 1; j <= rightmost; j++) {
                /**
                 * 向右跳遇到大于等于arr[index]的下标，结束
                 */
                if (dp[j] == -1 || arr[j] == arr[index]) {
                    break;
                }
                dp[index] = Math.max(dp[index], dp[j] + 1);
            }
            result = Math.max(result, dp[index]);
        }
        return result;
    }
}
