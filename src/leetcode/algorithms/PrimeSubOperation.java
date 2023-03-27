package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2601. Prime Subtraction Operation
 *
 * @author Baltan
 * @date 2023/3/26 14:05
 */
public class PrimeSubOperation {
    public static void main(String[] args) {
        System.out.println(primeSubOperation(new int[]{4, 9, 6, 10}));
        System.out.println(primeSubOperation(new int[]{6, 8, 11, 12}));
        System.out.println(primeSubOperation(new int[]{5, 8, 3}));
    }

    public static boolean primeSubOperation(int[] nums) {
        /**
         * 根据题意，nums[i]∈[1,1000]，从小到大查找[1,1000]范围内所有的质数
         */
        List<Integer> primes = getPrimes();
        /**
         * 因为最终希望得到的数组是严格递增的，因此索引越大的数字应该尽可能大，所以最后一个元素不需要进行任何操作。从倒数第二个元素开始，如果这个
         * 元素已经小于后一个元素了，则这个元素不需要进行任何操作；否则将这个元素减去一个小于它的质数使其恰好小于后一个元素，因此需要找到一个质数
         * 恰好大于这个元素和后一个元素之差且小于这个元素
         */
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                continue;
            }
            int floorIndex = getFloorIndex(primes, nums[i] - nums[i + 1]);
            /**
             * 不存在大于nums[i]-nums[i+1]并且小于nums[i]的质数
             */
            if (floorIndex == -1 || primes.get(floorIndex) >= nums[i]) {
                return false;
            }
            /**
             * nums[i]减去质数后变成小于nums[i+1]
             */
            nums[i] -= primes.get(floorIndex);
        }
        return true;
    }

    /**
     * 在质数数组primes中二分查找大于diff的最小质数的索引
     *
     * @param primes
     * @param diff
     * @return
     */
    public static int getFloorIndex(List<Integer> primes, int diff) {
        /**
         * 如果质数数组primes不存在大于diff的质数，返回-1
         */
        if (primes.get(primes.size() - 1) <= diff) {
            return -1;
        }
        int lo = 0;
        int hi = primes.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (primes.get(mid) <= diff) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 从小到大查找[1,1000]范围内所有的质数
     *
     * @return
     */
    public static List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i < 1000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    /**
     * 判断num是不是质数
     *
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
