package leetcode.algorithms;

/**
 * Description: 1025. Divisor Game
 *
 * @author Baltan
 * @date 2019-04-15 09:51
 */
public class DivisorGame {
    public static void main(String[] args) {
        System.out.println(divisorGame(2));
        System.out.println(divisorGame(3));
    }

    /**
     * 如果初始值为偶数，那么先手Alice选择1，轮到后手Bob的时候，N变为N-1是个奇数。
     * 奇数的因数只有奇数，所以不论后手Bob选择x为几，轮到先手Alice的时候N变为N-x是个偶数。
     * 先手Alice继续选择1，轮到后手Bob又是奇数，以此类推，最终当N=1时时会轮到后手Bob。
     * 所以当初始值N为偶数时，Alice必胜。
     * <p>
     * 如果初始值为奇数，不管先手Alice选择x为几，轮到后手Bob的时候N变为N-x是个偶数。后续操作同上，后手Bob必胜。
     *
     * @param N
     * @return
     */
    public static boolean divisorGame(int N) {
        return (N & 1) == 0;
    }
}
