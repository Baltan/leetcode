package leetcode.algorithms;

/**
 * Description: 3360. Stone Removal Game
 *
 * @author Baltan
 * @date 2024/11/28 23:10
 */
public class CanAliceWin1 {
    public static void main(String[] args) {
        System.out.println(canAliceWin(12));
        System.out.println(canAliceWin(1));
    }

    public static boolean canAliceWin(int n) {
        /**
         * 每一轮当前选手需要拿走的石头个数
         */
        int count = 10;

        while (n >= count) {
            n -= count;
            count--;
        }
        /**
         * 因为Alice每轮总是拿走偶数个石头，Bob每轮总是拿走奇数个石头，所以最后一轮如果本该取走偶数个石头，则Alice负，否则Bob负
         */
        return count % 2 == 1;
    }
}
