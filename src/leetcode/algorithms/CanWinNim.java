package leetcode.algorithms;

/**
 * Description: 292. Nim Game
 *
 * @author Baltan
 * @date 2017/12/29 16:54
 */
public class CanWinNim {
    public static void main(String[] args) {
        System.out.println(canWinNim(4));
    }

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
