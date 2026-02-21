package leetcode.algorithms;

/**
 * Description: 3811. Number of Alternating XOR Partitions
 *
 * @author baltan
 * @date 2026/2/19 13:28
 * @see AlternatingXOR1
 */
public class AlternatingXOR {
    public static void main(String[] args) {
        System.out.println(alternatingXOR(new int[]{2, 3, 1, 4}, 1, 5));
        System.out.println(alternatingXOR(new int[]{1, 0, 0}, 1, 0));
        System.out.println(alternatingXOR(new int[]{7}, 1, 7));
    }

    /**
     * 看不懂！！！
     * 参考：<a href="https://leetcode.cn/problems/number-of-alternating-xor-partitions/solutions/3883090/di-tui-by-tsreaper-moug/"></a>
     *
     * @param nums
     * @param target1
     * @param target2
     * @return
     */
    public static int alternatingXOR(int[] nums, int target1, int target2) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * 数组nums的前缀数组中所有元素按位异或的值
         */
        int prefixXor = 0;
        /**
         * 因为数组nums分割后各子数组中元素按位异或的值依次为target1、target2、target1、target2……则这些分割点的前缀子数组按位异或的值依
         * 次为target1、target1^target2、target2、0（四个一组循环）
         */
        int[] targets = {target1, target1 ^ target2, target2, 0};
        /**
         * dp[i][j]表示数组nums的前i个元素构成的前缀子数组分割后，以元素nums[i-1]为分界点到循环的第j步的分割方案数
         */
        long[][] dp = new long[nums.length + 1][4];
        /**
         * 空数组中元素按位异或的值为0，可以视为是循环的第3步的一种分割方案
         */
        dp[0][3] = 1;

        for (int i = 0; i < nums.length; i++) {
            prefixXor ^= nums[i];

            for (int j = 0; j < targets.length; j++) {
                /**
                 * 以元素nums[i]为分界点到循环的第j步，可以由以元素nums[i-1]为分界点到循环的第j-1步这类分割方案转移而来
                 */
                if (prefixXor == targets[j]) {
                    dp[i + 1][j] = dp[i][(j + 3) % 4];
                }
            }

            for (int j = 0; j < targets.length; j++) {
                if (i == nums.length - 1) {
                    result = (result + dp[i + 1][j]) % mod;
                }
                /**
                 * 以元素nums[i]为分界点到循环的第j步，可以由以元素nums[i-1]为分界点到循环的第j步这类分割方案转移而来
                 */
                dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % mod;
            }
        }
        return (int) result;
    }
}
