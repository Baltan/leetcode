package leetcode.algorithms;

/**
 * Description: 3222. Find the Winning Player in Coin Game
 *
 * @author baltan
 * @date 2024/7/24 17:26
 */
public class LosingPlayer {
    public static void main(String[] args) {
        System.out.println(losingPlayer(2, 7));
        System.out.println(losingPlayer(4, 11));
    }

    public static String losingPlayer(int x, int y) {
        /**
         * 每一轮必须拿1个价值75的币和4个价值10的币才能凑到价值115，两人相加最多一共可以拿turns次
         */
        int turns = Math.min(x, y / 4);
        /**
         * 如果两人相加一共可以拿偶数次，则轮到Alice无法完成，否则轮到Bob无法完成
         */
        return turns % 2 == 0 ? "Bob" : "Alice";
    }
}
