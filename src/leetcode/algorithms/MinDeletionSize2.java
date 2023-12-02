package leetcode.algorithms;

/**
 * Description: 960. Delete Columns to Make Sorted III
 *
 * @author Baltan
 * @date 2023/11/12 19:35
 */
public class MinDeletionSize2 {
    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"babca", "bbazb"}));
        System.out.println(minDeletionSize(new String[]{"edcba"}));
        System.out.println(minDeletionSize(new String[]{"ghi", "def", "abc"}));
    }

    public static int minDeletionSize(String[] strs) {
        int result = Integer.MAX_VALUE;
        int length = strs[0].length();
        /**
         * dp[i]表示数组strs中的每个字符串以第i个字符结尾的递增子序列的最大长度
         */
        int[] dp = new int[length];
        dp[0] = 1;

        for (int i = 1; i < length; i++) {
            /**
             * 假设不是所有字符串str的第i个字符前都能有其他字符
             */
            dp[i] = 1;
            loop:
            /**
             * 依次判断第i个字符能不能跟在以第j个字符结尾的递增子序列后
             */
            for (int j = i - 1; j >= 0; j--) {
                for (String str : strs) {
                    if (str.charAt(i) < str.charAt(j)) {
                        continue loop;
                    }
                }
                /**
                 * 第i个字符可以跟在以第j个字符结尾的递增子序列后，更新以第i个字符结尾的递增子序列的最大长度
                 */
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        /**
         * 查找所有可能的递增子序列中长度最大的序列，字符串的原始长度length减去这个序列的长度即为删除索引序列的最小长度
         */
        for (int i = 0; i < length; i++) {
            result = Math.min(result, length - dp[i]);
        }
        return result;
    }
}
