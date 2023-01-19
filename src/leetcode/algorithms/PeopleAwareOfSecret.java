package leetcode.algorithms;

/**
 * Description: 2327. Number of People Aware of a Secret
 *
 * @author Baltan
 * @date 2023/1/18 15:09
 */
public class PeopleAwareOfSecret {
    public static void main(String[] args) {
        System.out.println(peopleAwareOfSecret(6, 2, 4));
        System.out.println(peopleAwareOfSecret(4, 1, 3));
    }

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * peoples[i]表示第i天新知道秘密的人数
         */
        long[] peoples = new long[n + 1];
        peoples[1] = 1;
        /**
         * 计算从第二天开始每天新知道秘密的人数
         */
        for (int i = 2; i <= n; i++) {
            /**
             * 第Math.max(1, i-forget+1)天至第i-1天间知道秘密的人可能会在第i天把秘密分享给别人
             */
            for (int j = i - 1; j >= Math.max(1, i - forget + 1); j--) {
                if (i >= j + delay) {
                    peoples[i] = (peoples[i] + peoples[j]) % mod;
                }
            }
        }
        /**
         * 第Math.max(1, n-forget+1)天至第n天间知道秘密的人在第n天时仍知道秘密
         */
        for (int i = n; i >= Math.max(1, n - forget + 1); i--) {
            result = (result + peoples[i]) % mod;
        }
        return (int) result;
    }
}
