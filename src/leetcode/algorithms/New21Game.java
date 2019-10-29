package leetcode.algorithms;

/**
 * Description: 837. New 21 Game
 *
 * @author Baltan
 * @date 2019-10-29 08:45
 */
public class New21Game {
    public static void main(String[] args) {
        System.out.println(new21Game(10, 1, 10));
        System.out.println(new21Game(6, 1, 10));
        System.out.println(new21Game(21, 17, 10));
        System.out.println(new21Game(0, 0, 1));
        System.out.println(new21Game(421, 400, 47));
    }

    public static double new21Game(int N, int K, int W) {
        double result = 0.0;

        if (K == 0) {
            return 1.0;
        }

        for (int i = 1; i <= W; i++) {
            double p = 1.0 / W;

            if (i >= K) {
                if (i <= N) {
                    result += p;
                }
            } else {
                result += new21Game(N - i, K - i, W) * p;
            }
        }
        return result;
    }
}
