package leetcode.algorithms;

/**
 * Description: 2240. Number of Ways to Buy Pens and Pencils
 *
 * @author Baltan
 * @date 2022/4/18 14:07
 */
public class WaysToBuyPensPencils {
    public static void main(String[] args) {
        System.out.println(waysToBuyPensPencils(20, 10, 5));
        System.out.println(waysToBuyPensPencils(5, 10, 10));
    }

    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long result = 0;
        /**
         * 钢笔的最大购买支数
         */
        int max = total / cost1;

        for (int i = 0; i <= max; i++) {
            /**
             * 除去买钢笔的支出，还剩total-i*cost1，可以狗买铅笔的支数为[0,(total-i*cost1)/cost2]
             */
            result += (total - i * cost1) / cost2 + 1;
        }
        return result;
    }
}
