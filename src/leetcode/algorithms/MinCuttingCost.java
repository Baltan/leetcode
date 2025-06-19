package leetcode.algorithms;

/**
 * Description: 3560. Find Minimum Log Transportation Cost
 *
 * @author Baltan
 * @date 2025/6/19 23:22
 */
public class MinCuttingCost {
    public static void main(String[] args) {
        System.out.println(minCuttingCost(6, 5, 5));
        System.out.println(minCuttingCost(4, 4, 6));
    }

    public static long minCuttingCost(int n, int m, int k) {
        /**
         * 因为两根木材至多被三两卡车运输，所以至多只有一根木材被切割，且至多切割一次。对于长度为l的木材，如果被切割为长度都不大于k的两段，且
         * 这两段木材的长度之积最小，则一段木材长度为k，另一段位l-k
         */
        if (n > k) {
            return (long) (n - k) * k;
        } else if (m > k) {
            return (long) (m - k) * k;
        }
        return 0;
    }
}
