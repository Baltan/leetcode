package leetcode.algorithms;

import java.util.stream.IntStream;

/**
 * Description: 2652. Sum Multiples
 *
 * @author Baltan
 * @date 2023/4/24 16:21
 */
public class SumOfMultiples {
    public static void main(String[] args) {
        System.out.println(sumOfMultiples(7));
        System.out.println(sumOfMultiples(10));
        System.out.println(sumOfMultiples(9));
    }

    public static int sumOfMultiples(int n) {
        return IntStream.rangeClosed(1, n)
                /**
                 * 过滤出所有3的倍数、5的倍数和7的倍数
                 */
                .filter(x -> x % 3 == 0 || x % 5 == 0 || x % 7 == 0)
                .sum();
    }
}
