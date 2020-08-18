package leetcode.algorithms;

/**
 * Description: 1545. Find Kth Bit in Nth Binary String
 *
 * @author Baltan
 * @date 2020-08-17 22:42
 */
public class FindKthBit {
    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1));
        System.out.println(findKthBit(4, 11));
        System.out.println(findKthBit(1, 1));
        System.out.println(findKthBit(2, 3));
    }

    public static char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int power = (int) Math.pow(2, n);

        if (k < power / 2) {
            /**
             * 如果k在二进制字符串的前半部分中，则在更短的二进制字符串中递归查找
             */
            return findKthBit(n - 1, k);
        } else if (k > power / 2) {
            /**
             * 如果k在二进制字符串的后半部分中，则找到前半部分上对称的位置power-k
             */
            return (char) ('0' + '1' - findKthBit(n - 1, power - k));
        } else {
            /**
             * 如果k为二进制字符串的正中间的字符，直接返回'1'即可
             */
            return '1';
        }
    }
}
