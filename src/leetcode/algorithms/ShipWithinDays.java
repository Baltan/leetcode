package leetcode.algorithms;

/**
 * Description: Capacity To Ship Packages Within D Days
 *
 * @author Baltan
 * @date 2019-05-12 12:07
 */
public class ShipWithinDays {
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    public static int shipWithinDays(int[] weights, int D) {
        int result = 0;
        int maxWeight = 0;
        int sumWeight = 0;
        int length = weights.length;

        for (int i = 0; i < length; i++) {
            sumWeight += weights[i];
            maxWeight = Math.max(maxWeight, weights[i]);
        }

        int lo = maxWeight;
        int hi = sumWeight;
        int mid;

        while (lo <= hi) {
            mid = (lo + hi) / 2;
            int sum = 0;
            int days = 1;

            for (int i = 0; i < length; i++) {
                sum += weights[i];
                if (sum > mid) {
                    days++;
                    i--;
                    sum = 0;
                }
            }

            if (days > D) {
                lo = mid + 1;
            } else {
                result = mid;
                hi = mid - 1;
            }
        }
        return result;
    }
}
