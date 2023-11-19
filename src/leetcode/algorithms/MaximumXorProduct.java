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
         * 对于同一比特位上的数字a_i和b_i，更改之后满足(a^x)_i^(b^x)_i
         */
        for (int i = n - 1; i >= 0; i--) {
            long ai = a >> i & 1;
            long bi = b >> i & 1;

            if (ai == bi) {
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
