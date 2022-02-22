package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: 2178. Maximum Split of Positive Even Integers
 *
 * @author Baltan
 * @date 2022/2/21 21:51
 */
public class MaximumEvenSplit {
    public static void main(String[] args) {
        System.out.println(maximumEvenSplit(12L));
        System.out.println(maximumEvenSplit(7L));
        System.out.println(maximumEvenSplit(28L));
        System.out.println(maximumEvenSplit(10000000000L));
    }

    /**
     * @param finalSum
     * @return
     */
    public static List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) {
            return Collections.emptyList();
        }
        /**
         * 2+4+6+……+2n
         * =2*(1+2+3+……+n)
         * =2*(1+n)*n/2
         * =n*(1+n)
         * >n^2
         *
         * 按照题意，finalSum的最大值为10^10，所以n不超过10^5
         */
        int lo = 1;
        int hi = 100000;
        /**
         * 二分查找符合条件的最大的n
         */
        while (lo < hi) {
            int mid = (int) Math.ceil((lo + hi) / 2.0);
            long sum = 1L * mid * (mid + 1);

            if (sum > finalSum) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }

        long sum = 0L;
        List<Long> result = new ArrayList<>(lo);
        long max = lo - 1;

        for (long i = 1; i <= max; i++) {
            long num = i << 1;
            result.add(num);
            sum += num;
        }
        /**
         * finalSum还剩余的值都加进最后这个偶数里
         */
        result.add(finalSum - sum);
        return result;
    }
}
