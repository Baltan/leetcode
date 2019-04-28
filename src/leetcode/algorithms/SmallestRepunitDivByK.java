package leetcode.algorithms;

/**
 * Description: Smallest Integer Divisible by K
 *
 * @author Baltan
 * @date 2019-04-28 09:45
 */
public class SmallestRepunitDivByK {
    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(1));
        System.out.println(smallestRepunitDivByK(2));
        System.out.println(smallestRepunitDivByK(3));
        System.out.println(smallestRepunitDivByK(17));
        System.out.println(smallestRepunitDivByK(7773));
    }

    public static int smallestRepunitDivByK(int K) {
        if ((K & 1) == 0 || K % 5 == 0) {
            return -1;
        } else {
            int length = 1;
            int remainder = 0;
            while (length <= K) {
                remainder = (remainder * 10 + 1) % K;
                if (remainder == 0) {
                    return length;
                }
                length++;
            }
            return -1;
        }
    }
}
