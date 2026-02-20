package leetcode.algorithms;

/**
 * Description: 3811. Number of Alternating XOR Partitions
 *
 * @author baltan
 * @date 2026/2/19 13:28
 */
public class AlternatingXOR {
    public static void main(String[] args) {
        System.out.println(alternatingXOR(new int[]{2, 3, 1, 4}, 1, 5));
        System.out.println(alternatingXOR(new int[]{1, 0, 0}, 1, 0));
        System.out.println(alternatingXOR(new int[]{7}, 1, 7));
    }

    public static int alternatingXOR(int[] nums, int target1, int target2) {
        int mod = 1000000007;
        int[] targets = {target1, target2};
        /**
         * memo[i][j]表示对后缀子数组nums[i……]进行分割，并且第一个分割块中所有元素按位异或的值为targets[j]的有效分割方案数
         */
        long[][] memo = new long[nums.length + 1][2];
        /**
         * 初始化memo[i][j]为-1，表示该种情况的有效分割方案数还未计算
         */
        for (int i = 0; i <= nums.length; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        dfs(nums, 0, targets, 0, memo, mod);
        return (int) memo[0][0];
    }

    /**
     * 递归计算对后缀子数组nums[start……]进行分割，并且第一个分割块中所有元素按位异或的值为targets[targetIndex]的有效分割方案数
     *
     * @param nums
     * @param start
     * @param targets
     * @param targetIndex
     * @param memo
     * @param mod
     */
    public static void dfs(int[] nums, int start, int[] targets, int targetIndex, long[][] memo, int mod) {
        /**
         * 计算过有效分割方案数的情况不需要重复计算
         */
        if (memo[start][targetIndex] != -1) {
            return;
        }
        /**
         * 已遍历到数组最后，空数组也视为一种有效分割方案
         */
        if (start == nums.length) {
            memo[start][targetIndex] = 1;
            return;
        }
        int xor = 0;
        /**
         * 假设不存在有效分割方案
         */
        memo[start][targetIndex] = 0;

        for (int i = start; i < nums.length; i++) {
            xor ^= nums[i];
            /**
             * 将nums[start……i]作为第一个分割块，继续对后续子数组进行分割
             */
            if (xor == targets[targetIndex]) {
                dfs(nums, i + 1, targets, 1 - targetIndex, memo, mod);
                memo[start][targetIndex] = (memo[start][targetIndex] + memo[i + 1][1 - targetIndex]) % mod;
            }
        }
    }
}
