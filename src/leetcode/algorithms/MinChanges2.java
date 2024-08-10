package leetcode.algorithms;

/**
 * Description: 3226. Number of Bit Changes to Make Two Integers Equal
 *
 * @author Baltan
 * @date 2024/7/27 15:39
 */
public class MinChanges2 {
    public static void main(String[] args) {
        System.out.println(minChanges(13, 4));
        System.out.println(minChanges(21, 21));
        System.out.println(minChanges(14, 13));
    }

    public static int minChanges(int n, int k) {
        int result = 0;
        /**
         * 对于n和k的二进制值，如果某一位上n为0且k为1，则n不可能变为k，直接返回-1；否则计算n为1且k为0的位数即可
         */
        while (n > 0 || k > 0) {
            int bitN = n & 1;
            int bitK = k & 1;

            if (bitN == 0 && bitK == 1) {
                return -1;
            } else if (bitN == 1 && bitK == 0) {
                result++;
            }
            n >>= 1;
            k >>= 1;
        }
        return result;
    }
}
