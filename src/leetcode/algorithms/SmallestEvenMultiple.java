package leetcode.algorithms;

/**
 * Description: 2413. Smallest Even Multiple
 *
 * @author Baltan
 * @date 2023/2/10 16:54
 */
public class SmallestEvenMultiple {
    public static void main(String[] args) {
        System.out.println(smallestEvenMultiple(5));
        System.out.println(smallestEvenMultiple(6));
    }

    public static int smallestEvenMultiple(int n) {
        /**
         * 如果n是偶数，2和n的最小公倍数就是n；如果n是奇数，2和n的最小公倍数是2n
         */
        return (n & 1) == 0 ? n : n << 1;
    }
}
