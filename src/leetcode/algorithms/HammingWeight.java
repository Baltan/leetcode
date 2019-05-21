package leetcode.algorithms;

/**
 * Description: 191. Number of 1 Bits
 *
 * @author Baltan
 * @date 2018/1/9 16:09
 */
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(00000000000000000000000000000001 & 00000000000000000000000000001011);
        System.out.println(00000000000000000000000000000100 & 00000000000000000000000000001011);
        System.out.println(00000000000000000000000000001000 & 00000000000000000000000000001011);
    }

    public static int hammingWeight(int n) {
        return Integer.bitCount(n);

        /*int bits = 0;
         int mask = 1;
         for (int i = 0; i < 32; i++) {
         if ((n & mask) != 0) {
         bits++;
         }
         mask <<= 1;
         }
         return bits;
         */
    }
}
