package leetcode.algorithms;

/**
 * Description: 3021. Alice and Bob Playing Flower Game
 *
 * @author Baltan
 * @date 2024/1/28 19:37
 */
public class FlowerGame {
    public static void main(String[] args) {
        System.out.println(flowerGame(3, 2));
        System.out.println(flowerGame(1, 1));
    }

    public static long flowerGame(int n, int m) {
        /**
         * 对于同一侧来说，如果花的数量是奇数，则两人交替在这一侧摘花，先手一定会摘得最后一朵花。所以如果可以使得后手的Bob每次摘花时，两侧花
         * 的数量都为偶数，则不论他选择哪一侧的花，Alice都继续选择同侧的花，直到这一侧最后一朵花被Alice摘走，这样就可以使Bob在这一侧无花可
         * 摘。对于另一侧的花用同样的策略。所以只要开始时两侧花的数量为一奇一偶，先手Alice总是先摘数量为奇数侧花，就一定能获胜
         */
        return (long) ((n + 1) / 2) * (m / 2) + (long) ((m + 1) / 2) * (n / 2);
    }
}
