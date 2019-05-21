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
        double rowNum = 0;
        while (n - (rowNum + 1) / 2 * rowNum >= rowNum + 1) {
            rowNum++;
        }
        return (int) rowNum;
    }
}
