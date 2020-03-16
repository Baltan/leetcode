package leetcode.algorithms;

/**
 * Description: 441. Arranging Coins
 *
 * @author Baltan
 * @date 2018/1/6 20:54
 */
public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(1));
        System.out.println(arrangeCoins(2));
        System.out.println(arrangeCoins(3));
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(6));
        System.out.println(arrangeCoins(8));
        System.out.println(arrangeCoins(1804289383));
    }

    public static int arrangeCoins(int n) {
        /**
         * 因为
         *  1+2+3+……+k
         * =(1+k)×k/2
         * ≤n
         * 所以
         * k^2+k-2n<=0
         * 由求根公式解得k^2+k-2n=0的正数解向下取整即可
         */
        return (int) Math.floor((Math.sqrt(1 + 8L * n) - 1) / 2);
    }
}
