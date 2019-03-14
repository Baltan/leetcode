package leetcode.algorithms;

/**
 * Description: Fibonacci Number
 *
 * @author Baltan
 * @date 2019-03-14 14:01
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(30));
    }

    public static int fib(int N) {
        int[] array = new int[31];
        array[1] = 1;

        for (int i = 2; i <= N; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[N];
    }
}