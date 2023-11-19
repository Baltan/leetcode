package leetcode.algorithms;

/**
 * Description: 2939. Maximum Xor Product
 *
 * @author Baltan
 * @date 2023/11/19 19:58
 */
public class MaximumXorProduct {
    public static void main(String[] args) {
        System.out.println(maximumXorProduct(12, 5, 4));
        System.out.println(maximumXorProduct(6, 7, 5));
        System.out.println(maximumXorProduct(1, 6, 3));
        System.out.println(maximumXorProduct(57546, 798746, 4));
    }

    public static int maximumXorProduct(long a, long b, int n) {
        int mod = 1000000007;
        /**
         * a的二进制值减去最低n位后的值
         */
        long a1 = a >> n << n;
        /**
         * b的二进制值减去最低n位后的值
         */
        long b1 = b >> n << n;
        /**
         * 根据题意，可以将a和b变为a^x和b^x，其中x∈[1,1<<n)，说明a和b的二进制值只有最低n位上的数字可能更改。因为(a^x)^(b^x)=a^b，所以
         * 对于同样是由低到高第i个比特位上的数字a_i和b_i，更改之后满足[(a^x)_i]^[(b^x)_i]=a_i^b_1。为了使得最终的乘积(a^x)*(b^x)尽可
         * 能大，当a_i=b_i时，因为0^0=0=1^1，可以令a和b由低到高第i个比特位上的数字都变为1。当a_i≠b_i时，不论是a_i为1并且b_i为0，还是
         * a_i为0并且b_i为1，最终a+b的值都不变。因为两数之和恒定时，它们的差越小，则它们的乘积越大，所以可以令当前较小的数字在该比特位上的
         * 值变为1，另一个数字在该比特位上的值变为0
         */
        for (int i = n - 1; i >= 0; i--) {
            /**
             * a由低到高第i个比特位上的数字
             */
            long ai = a >> i & 1;
            /**
             * b由低到高第i个比特位上的数字
             */
            long bi = b >> i & 1;

            if (ai == bi) {
                /**
                 * 令a和b由低到高第i个比特位上的数字都变为1
                 */
                a1 += 1L << i;
                b1 += 1L << i;
            } else if (a1 < b1) {
                a1 += 1L << i;
            } else {
                b1 += 1L << i;
            }
        }
        return (int) ((a1 % mod) * (b1 % mod) % mod);
    }
}
