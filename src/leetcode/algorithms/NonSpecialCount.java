package leetcode.algorithms;

/**
 * Description: 3233. Find the Count of Numbers Which Are Not Special
 *
 * @author baltan
 * @date 2024/7/29 09:16
 */
public class NonSpecialCount {
    public static void main(String[] args) {
        System.out.println(nonSpecialCount(1, 2));
        System.out.println(nonSpecialCount(5, 7));
        System.out.println(nonSpecialCount(4, 16));
        System.out.println(nonSpecialCount(1, 1000000000));
        System.out.println(nonSpecialCount(511518329, 717750954));
    }

    public static int nonSpecialCount(int l, int r) {
        /**
         * 假设[l,r]范围的内的所有正整数都不是特殊数字
         */
        int result = r - l + 1;
        /**
         * 因为特殊数字除了自身以外的因数个数为2个，再排除因数1，还剩1个因数，说明i必定是一个平方数，判断[4,r]中的所有平方数是否为特殊数字
         */
        outer:
        for (int i = 2; i * i <= r; i++) {
            if (i * i < l) {
                continue;
            }
            /**
             * 判断平方根i是否是质数
             */
            for (int j = 2; j * j <= i; j++) {
                /**
                 * 如果j能整除i，则也能整除i*i，说明数字i*i不是特殊数字
                 */
                if (i % j == 0) {
                    continue outer;
                }
            }
            result--;
        }
        return result;
    }
}
