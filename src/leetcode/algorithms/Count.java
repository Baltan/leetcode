package leetcode.algorithms;

/**
 * Description: 2719. Count of Integers
 *
 * @author Baltan
 * @date 2023/6/6 22:22
 */
public class Count {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        System.out.println(count("1", "69", 1, 4));
        System.out.println(count("8269", "8554", 10, 14));
        System.out.println(count("1", "999", 1, 200));
        System.out.println(count("1", "99", 8, 30));
        System.out.println(count("1", "100", 8, 16));
        System.out.println(count("4179205230", "7748704426", 8, 46));
        System.out.println(count("1", "12", 1, 8));
        System.out.println(count("1", "5", 1, 5));
    }

    public static int count(String num1, String num2, int minSum, int maxSum) {
        int mod = 1000000007;
        /**
         * dp[i][j]表示数字位数为i，数位和为j的整数个数
         */
        long[][] dp = help(num2.length(), maxSum);
        /**
         * [0,num2]中的好整数减去[0,num1]中的好整数，再考虑num1是否为好整数即可
         */
        return (int) ((count(num2, minSum, maxSum, dp) - count(num1, minSum, maxSum, dp) + (judge(num1, minSum, maxSum) ? 1 : 0) + mod) % mod);
    }

    /**
     * 计算数值范围为[0,num]，数位和范围为[minSum,maxSum]的整数个数
     *
     * @param num
     * @param minSum
     * @param maxSum
     * @return
     */
    public static long count(String num, int minSum, int maxSum, long[][] dp) {
        if (maxSum < 0) {
            return 0L;
        }
        /**
         * 递归过程中如果出现数位和最小值为负数的情况，将其重置为0
         */
        minSum = Math.max(minSum, 0);
        num = trimLeadingZeros(num);
        /**
         * 此时说明num为"000……000"
         */
        if (num.isEmpty()) {
            /**
             * 如果数位和可以为0，则存在唯一满足要求的整数0，否则不存在满足要求的整数
             */
            return minSum == 0 ? 1 : 0;
        }

        if (num.length() == 1) {
            /**
             * num为个位数且[0,num]中的所有数字数位和都小于minSum
             */
            if (num.charAt(0) - '0' < minSum) {
                return 0;
            }
            /**
             * 如果num为个位数，则符合条件的整数最小为minSum，最大不超过num和maxSum
             */
            return Math.min(maxSum, num.charAt(0) - '0') - minSum + 1;
        }
        long count = 0L;
        int mod = 1000000007;
        int length = num.length();
        /**
         * 计算数字位数为[1,length)、数位和范围为[minSum,maxSum]的整数个数，这部分数字肯定在[0,num]之间
         */
        for (int i = 1; i < length; i++) {
            for (int j = minSum; j <= maxSum; j++) {
                count = (count + dp[i][j]) % mod;
            }
        }
        /**
         * 计算数值范围为[0,num]、数字位数为length、数位和范围为[minSum,maxSum]的整数个数
         */
        return (count + dfs(num, minSum, maxSum, dp)) % mod;
    }

    /**
     * 计算数值范围为[0,num]、数字位数和num相同、数位和范围为[minSum,maxSum]的整数个数
     *
     * @param num
     * @param minSum
     * @param maxSum
     * @param dp
     * @return
     */
    public static long dfs(String num, int minSum, int maxSum, long[][] dp) {
        if (maxSum < 0) {
            return 0L;
        }
        /**
         * 递归过程中如果出现数位和最小值为负数的情况，将其重置为0
         */
        minSum = Math.max(minSum, 0);

        if (num.length() == 1) {
            /**
             * num为个位数且[0,num]中的所有数字数位和都小于minSum
             */
            if (num.charAt(0) - '0' < minSum) {
                return 0;
            }
            /**
             * 如果num为个位数，则符合条件的整数最小为minSum，最大不超过num和maxSum
             */
            return Math.min(maxSum, num.charAt(0) - '0') - minSum + 1;
        }
        long count = 0L;
        int mod = 1000000007;
        int length = num.length();
        int first = num.charAt(0) - '0';
        /**
         * 计算所有数字位数为length，最高位数字i范围为[1,first)，数位和范围为[minSum,maxSum]的整数个数，这部分数字肯定在[0,num]之间
         */
        for (int i = 1; i < first; i++) {
            /**
             * j表示除去最高位，剩余部分的数字位数（前缀0不计入位数），剩余部分数字位数在[1,length)之间时，构成的整数都在[0,num]之间
             */
            for (int j = 1; j < length; j++) {
                /**
                 * 只保留数位和范围为[minSum,maxSum]的整数
                 */
                for (int k = minSum; k <= maxSum; k++) {
                    if (k >= i) {
                        count = (count + dp[j][k - i]) % mod;
                    }
                }
            }
        }
        /**
         * 计算最高位数字为first，数位和范围为[minSum,maxSum]的整数个数，数值范围为[0,num]的整数个数，等同于计算数值范围为[0,num除去最
         * 高位剩余部分数字]，数位和范围为[minSum-first,maxSum-first]的整数个数
         */
        return (count + count(num.substring(1), minSum - first, maxSum - first, dp)) % mod;
    }

    /**
     * 计算数字位数为[1,length)，数位和为[0,maxSum]的整数个数
     *
     * @param length
     * @param maxSum
     * @return
     */
    public static long[][] help(int length, int maxSum) {
        int mod = 1000000007;
        /**
         * dp[i][j]表示数字位数为i，数位和为j的整数个数
         */
        long[][] dp = new long[length + 1][maxSum + 1];
        /**
         * 个位数的数位和只可能为[0,9]
         */
        for (int i = 0; i <= 9; i++) {
            if (i <= maxSum) {
                dp[1][i] = 1;
            }
        }
        /**
         * 数字位数为i的情况都可由数字位数为[0,i-1]的情况推得
         */
        for (int i = 2; i < length; i++) {
            for (int j = 0; j <= maxSum; j++) {
                /**
                 * k表示数字位数为i时，最高位的数字
                 */
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l < i; l++) {
                        if (j >= k) {
                            dp[i][j] = (dp[i][j] + dp[l][j - k]) % mod;
                        }
                    }
                }
            }
        }
        return dp;
    }

    /**
     * 判断数字num的数位和是否在[minSum,maxSum]之间
     *
     * @param num
     * @param minSum
     * @param maxSum
     * @return
     */
    public static boolean judge(String num, int minSum, int maxSum) {
        int digitSum = num.chars().map(x -> x - '0').sum();
        return digitSum >= minSum && digitSum <= maxSum;
    }

    /**
     * 删除数字num的所有前导0
     *
     * @param num
     * @return
     */
    public static String trimLeadingZeros(String num) {
        int index = 0;
        char[] charArray = num.toCharArray();
        /**
         * 删除num的所有前导0
         */
        while (index < charArray.length && charArray[index] == '0') {
            index++;
        }
        return new String(charArray, index, charArray.length - index);
    }
}
