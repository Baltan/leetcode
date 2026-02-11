package leetcode.algorithms;

/**
 * Description: 3790. Smallest All-Ones Multiple
 *
 * @author baltan
 * @date 2026/2/10 13:49
 * @see SmallestRepunitDivByK
 */
public class MinAllOneMultiple {
    public static void main(String[] args) {
        System.out.println(minAllOneMultiple(3));
        System.out.println(minAllOneMultiple(7));
        System.out.println(minAllOneMultiple(2));
    }

    public static int minAllOneMultiple(int k) {
        /**
         * 偶数或者5的倍数个位不可能为1，直接返回-1
         */
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        /**
         * 全1整数除以k的余数
         */
        int remainder = 0;
        /**
         * isVisited[i]表示是否已出现过除以k余数为i的全1整数
         */
        boolean[] isVisited = new boolean[k];

        for (int i = 1; ; i++) {
            remainder = (remainder * 10 + 1) % k;
            /**
             * 由i个1构成的全1整数除以k的余数为0，满足题意
             */
            if (remainder == 0) {
                return i;
            }
            /**
             * 此前已出现过除以k余数为remainder的全1整数，再次出现说明进入了循环，直接结束
             */
            if (isVisited[remainder]) {
                return -1;
            }
            isVisited[remainder] = true;
        }
    }
}
