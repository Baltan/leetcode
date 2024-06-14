package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3179. Find the N-th Value After K Seconds
 *
 * @author baltan
 * @date 2024/6/14 09:06
 */
public class ValueAfterKSeconds {
    public static void main(String[] args) {
        System.out.println(valueAfterKSeconds(4, 5));
        System.out.println(valueAfterKSeconds(5, 3));
    }

    public static int valueAfterKSeconds(int n, int k) {
        int mod = 1000000007;
        long[] nums = new long[n];
        Arrays.fill(nums, 1L);
        /**
         * 模拟k秒后的情况
         */
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                nums[j] = (nums[j] + nums[j - 1]) % mod;
            }
        }
        return (int) (nums[n - 1] % mod);
    }
}
