package leetcode.algorithms;

/**
 * Description: 2930. Number of Strings Which Can Be Rearranged to Contain Substring
 *
 * @author Baltan
 * @date 2023/11/13 23:23
 */
public class StringCount {
    public static void main(String[] args) {
        System.out.println(stringCount(1));
        System.out.println(stringCount(2));
        System.out.println(stringCount(3));
        System.out.println(stringCount(4));
        System.out.println(stringCount(10));
    }

    public static int stringCount(int n) {
        int mod = 1000000007;
        /**
         * n个字符可以为任意小写字母的情况数
         */
        long total = 1L;

        for (int i = 0; i < n; i++) {
            total = (total * 26) % mod;
        }
        /**
         * n个字符中，l、e、t都没有
         */
        long a = 1L;

        for (int i = 0; i < n; i++) {
            a = (a * 23) % mod;
        }
        /**
         * n个字符中，没有l、e且t的个数任意的情况数
         * n个字符中，没有l、t且e的个数任意的情况数
         * n个字符中，没有e、t且l的个数任意的情况数
         */
        long b = 1L;

        for (int i = 0; i < n; i++) {
            b = (b * 24) % mod;
        }
        /**
         * n个字符中，没有l且e和t的个数任意的情况数
         * n个字符中，没有e且l和t的个数任意的情况数
         * n个字符中，没有t且e和l的个数任意的情况数
         */
        long c = 1L;

        for (int i = 0; i < n; i++) {
            c = (c * 25) % mod;
        }
        /**
         * n个字符中，只有一个e且没有l和t的情况数
         */
        long d = n;

        for (int i = 1; i < n; i++) {
            d = (d * 23) % mod;
        }
        /**
         * n个字符中，只有一个e且没有l且t的个数任意的情况数
         * n个字符中，只有一个e且没有t且l的个数任意的情况数
         */
        long e = n;

        for (int i = 1; i < n; i++) {
            e = (e * 24) % mod;
        }
        /**
         * n个字符中，只有一个e且l和t的个数任意的情况数
         */
        long f = n;

        for (int i = 1; i < n; i++) {
            f = (f * 25) % mod;
        }
        /**
         * n个字符中，l、e、t各只有一个的情况数
         */
        long g = (f - (e * 2 - d) + 2 * mod) % mod;
        return (int) ((total - (c * 3 - b * 3 + a) - g + 5L * mod) % mod);
    }
}
