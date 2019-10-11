package leetcode.algorithms;

/**
 * Description: 995. Minimum Number of K Consecutive Bit Flips
 *
 * @author Baltan
 * @date 2019-10-11 08:54
 */
public class MinKBitFlips {
    public static void main(String[] args) {
        int[] A1 = {0, 1, 0};
        System.out.println(minKBitFlips(A1, 1));

        int[] A2 = {1, 1, 0};
        System.out.println(minKBitFlips(A2, 2));

        int[] A3 = {0, 0, 0, 1, 0, 1, 1, 0};
        System.out.println(minKBitFlips(A3, 3));

        int[] A4 =
                {0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1,
                        1, 0, 0, 0, 1, 1, 0};
        System.out.println(minKBitFlips(A4, 3));
    }

    public static int minKBitFlips(int[] A, int K) {
        int result = 0;
        int length = A.length;
        /**
         * 找到当前的第一个0，将以当前数字开始的连续K个数字翻转
         */
        for (int i = 0; i < length; i++) {
            if (A[i] == 0) {
                result++;
                /**
                 * 如果最后数组中还有0，但是后面不足K个数字了，说明这个0无法翻转成1了，返回-1
                 */
                if (i + K > length) {
                    return -1;
                }
                /**
                 * 将以当前数字开始的连续K个数字翻转
                 */
                for (int j = i; j < i + K; j++) {
                    A[j] = 1 - A[j];
                }
            }
        }
        return result;
    }
}
