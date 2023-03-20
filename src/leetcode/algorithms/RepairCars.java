package leetcode.algorithms;

/**
 * Description: 2594. Minimum Time to Repair Cars
 *
 * @author Baltan
 * @date 2023/3/19 12:51
 */
public class RepairCars {
    public static void main(String[] args) {
        System.out.println(repairCars(new int[]{4, 2, 3, 1}, 10));
        System.out.println(repairCars(new int[]{5, 1, 8}, 6));
    }

    public static long repairCars(int[] ranks, int cars) {
        long lo = 0L;
        long hi = Long.MAX_VALUE;
        /**
         * 二分查找修理完所有汽车的最小用时
         */
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            /**
             * 所有技工在时间mid内可以修理的汽车总量
             */
            long total = 0L;

            for (int rank : ranks) {
                total += Math.sqrt(mid / rank);
            }

            if (total < cars) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
