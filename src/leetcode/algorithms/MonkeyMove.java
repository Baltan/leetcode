package leetcode.algorithms;

/**
 * Description: 2550. Count Collisions of Monkeys on a Polygon
 *
 * @author Baltan
 * @date 2023/1/31 13:13
 */
public class MonkeyMove {
    public static void main(String[] args) {
        System.out.println(monkeyMove(3));
        System.out.println(monkeyMove(4));
        System.out.println(monkeyMove(1000000000));
    }

    public static int monkeyMove(int n) {
        int mod = 1000000007;
        /**
         * 只有所有猴子都向同一个方向移动才不会发生碰撞，共有顺时针运动和逆时针移动2种可能，而每个猴子各自可以向顺时针或逆时针移动，所有猴子共有
         * 2^n中移动方法，所以至少发生一次碰撞的移动方法数为2^n-2。根据题意，n∈[3,1000000000]，逐一将n个2相乘可能会超时，可以将n逐次折半递
         * 归求解
         * @see MyPow
         */
        long pow = pow(n, mod);
        /**
         * 防止pow为1时，计算的余数为负数，需要先加一个mod保证结果为非负数
         */
        return (int) ((pow + mod - 2) % mod);
    }

    public static long pow(int n, int mod) {
        if (n == 1) {
            return 2L;
        }
        long pow = pow(n / 2, mod);

        if (n % 2 == 0) {
            return (pow * pow) % mod;
        } else {
            return (((pow * pow) % mod) * 2) % mod;
        }
    }
}
