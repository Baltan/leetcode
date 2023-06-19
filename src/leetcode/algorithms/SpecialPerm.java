package leetcode.algorithms;

/**
 * Description: 2741. Special Permutations
 *
 * @author Baltan
 * @date 2023/6/18 13:02
 */
public class SpecialPerm {
    public static void main(String[] args) {
        System.out.println(specialPerm(new int[]{25, 50, 100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600, 51200, 102400, 204800}));
        System.out.println(specialPerm(new int[]{729601550, 178917494, 645601033, 35036397, 300692687, 794152595, 147715133, 879904543, 99825091, 290263962, 780606641, 440611307, 69288947, 736483629}));
        System.out.println(specialPerm(new int[]{796909853, 900651589, 400110526, 510646317, 656809382, 801502156, 341071164, 43457457, 52619339, 750640702, 381760281, 115068876, 426962915, 730041370}));
        System.out.println(specialPerm(new int[]{2, 3, 6}));
        System.out.println(specialPerm(new int[]{1, 4, 3}));
        System.out.println(specialPerm(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192}));
    }

    public static int specialPerm(int[] nums) {
        long result = 0L;
        int mod = 1000000007;
        int length = nums.length;
        /**
         * 数组nums中剩余数字的状态，其二进制值从低位到高位第i位为1则表示nums[i]还没有被使用
         */
        int status = (1 << length) - 1;
        /**
         * isDivisible[i][j]表示数字nums[i]和nums[j]是否存在整除关系
         */
        boolean[][] isDivisible = new boolean[length][length];
        /**
         * dp[i][j][k]表示第i个数字为nums[j]，且剩余数字的状态为k的情况数
         */
        long[][][] dp = new long[length][length][status + 1];

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                boolean bool = isDivisible(nums, i, j);
                isDivisible[i][j] = bool;
                isDivisible[j][i] = bool;
            }
        }
        /**
         * 一组特殊排列的第一个数字为nums[0]，则剩余数字的状态为0b11……110
         * 一组特殊排列的第一个数字为nums[1]，则剩余数字的状态为0b11……101
         * 一组特殊排列的第一个数字为nums[2]，则剩余数字的状态为0b11……011
         * ……
         * 一组特殊排列的第一个数字为nums[length-1]，则剩余数字的状态为0b01……111
         */
        for (int i = 0; i < length; i++) {
            /**
             * status^(1<<i)表示将status二进制值从低位到高位第i位变为0
             */
            dp[0][i][status ^ (1 << i)] = 1L;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                /**
                 * 是否找到符合条件的数字nums[k]
                 */
                boolean find = false;

                for (int k = 0; k < length; k++) {
                    /**
                     * 如果特殊排列中的第i个数字为nums[j]，第i-1个数字为nums[k]，则nums[j]和nums[k]不为同一个数字，且存在整除关系
                     */
                    if (j == k || !isDivisible[j][k]) {
                        continue;
                    }
                    find = true;
                    /**
                     * 如果特殊排列中的第i个数字为nums[j]，则剩余数字的状态l即为第i-1个数字之后的状态从低位到高位第j位由1变为0，
                     */
                    for (int l = 0; l <= status; l++) {
                        /**
                         * l>>j&1可以判断状态l的二进制值从低位到高位第j位是否为1，因为特殊排列中第i个数字为nums[j]，所以必须为0
                         */
                        if ((l >> j & 1) == 1) {
                            continue;
                        }
                        /**
                         * l|(1<<j)表示将状态l的二进制值从低位到高位第j位变为1，由此得到特殊排列子i-1个数字后的状态
                         */
                        dp[i][j][l] = (dp[i][j][l] + dp[i - 1][k][l | (1 << j)]) % mod;
                    }
                }

                if (!find) {
                    return 0;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= status; j++) {
                result = (result + dp[length - 1][i][j]) % mod;
            }
        }
        return (int) result;
    }

    /**
     * 判断数组nums中nums[i]和nums[j]是否存在整除关系
     *
     * @param nums
     * @param i
     * @param j
     * @return
     */
    public static boolean isDivisible(int[] nums, int i, int j) {
        return nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0;
    }
}
