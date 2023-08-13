package leetcode.algorithms;

/**
 * Description: 2806. Account Balance After Rounded Purchase
 *
 * @author baltan
 * @date 2023/8/10 09:29
 */
public class AccountBalanceAfterPurchase {
    public static void main(String[] args) {
        System.out.println(accountBalanceAfterPurchase(9));
        System.out.println(accountBalanceAfterPurchase(15));
    }

    public static int accountBalanceAfterPurchase(int purchaseAmount) {
        /**
         * 小于等于purchaseAmount的最大的10的倍数
         */
        int floor = purchaseAmount / 10 * 10;
        /**
         * 大于purchaseAmount的最小的10的倍数
         */
        int ceiling = floor + 10;
        return 100 - (ceiling - purchaseAmount <= purchaseAmount - floor ? ceiling : floor);
    }
}
