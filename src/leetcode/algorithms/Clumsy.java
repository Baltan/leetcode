package leetcode.algorithms;

/**
 * Description: 1006. Clumsy Factorial
 *
 * @author Baltan
 * @date 2019-04-26 09:31
 */
public class Clumsy {
    public static void main(String[] args) {
        System.out.println(clumsy(1));
        System.out.println(clumsy(2));
        System.out.println(clumsy(3));
        System.out.println(clumsy(4));
        System.out.println(clumsy(5));
        System.out.println(clumsy(6));
        System.out.println(clumsy(7));
        System.out.println(clumsy(8));
        System.out.println(clumsy(9));
        System.out.println(clumsy(10));
        System.out.println(clumsy(11));
    }

    public static int clumsy(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2 * 1;
        } else if (N == 3) {
            return 3 * 2 / 1;
        } else if (N == 4) {
            return 4 * 3 / 2 + 1;
        } else {
            int result = N * (N - 1) / (N - 2) + (N - 3);
            N -= 4;
            while (N >= 4) {
                result -= N * (N - 1) / (N - 2);
                result += (N - 3);
                N -= 4;
            }
            if (N == 3) {
                result -= N * (N - 1) / (N - 2);
            } else if (N == 2) {
                result -= N * (N - 1);
            } else if (N == 1) {
                result -= N;
            }
            return result;
        }
    }
}
