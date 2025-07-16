package leetcode.algorithms;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Description: 3589. Count Prime-Gap Balanced Subarrays
 *
 * @author baltan
 * @date 2025/7/14 17:09
 */
public class PrimeSubarray {
    public static void main(String[] args) {
        System.out.println(primeSubarray(new int[]{17844, 48463}, 37295));
        System.out.println(primeSubarray(new int[]{1, 2, 3}, 1));
        System.out.println(primeSubarray(new int[]{2, 3, 5, 7}, 3));
    }

    /**
     * 根据题意，nums[i]∈[1,50000]
     */
    private static final int MAX = 50000;
    /**
     * NOT_PRIME[i]表示i是否不是质数
     */
    private static final boolean[] NOT_PRIME = new boolean[MAX + 1];

    /**
     * 初始化计算[1,50000]中的各个元素是否是质数
     */
    static {
        NOT_PRIME[1] = true;

        for (int i = 4; i <= MAX; i++) {
            for (int j = 2; j * j <= i; j++) {
                if (!NOT_PRIME[j] && i % j == 0) {
                    NOT_PRIME[i] = true;
                    break;
                }
            }
        }
    }

    public static int primeSubarray(int[] nums, int k) {
        int result = 0;
        /**
         * 滑动窗口左端点的最小值
         */
        int left = 0;
        /**
         * 滑动窗口中的质数个数
         */
        int primeCount = 0;
        /**
         * 按顺序保存数组nums中质数的索引
         */
        TreeSet<Integer> primeIndexes = new TreeSet<>();
        /**
         * 保存滑动窗口中不同质数的个数
         */
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int right = 0; right < nums.length; right++) {
            /**
             * 判断nums[right]是否是质数
             */
            if (!NOT_PRIME[nums[right]]) {
                primeCount++;
                map.merge(nums[right], 1, Integer::sum);
                primeIndexes.add(right);
            }
            /**
             * 如果滑动窗口中最大质数和最小质数之差大于k，则需要向右移动当前窗口的左端点，直到滑动窗口中最大质数和最小质数之差不大于k未知
             */
            while (!map.isEmpty() && map.lastKey() - map.firstKey() > k) {
                if (!NOT_PRIME[nums[left]]) {
                    int count = map.get(nums[left]);

                    if (count == 1) {
                        map.remove(nums[left]);
                    } else {
                        map.put(nums[left], count - 1);
                    }
                    primeCount--;
                }
                left++;
            }

            if (primeCount >= 2) {
                /**
                 * 数组nums中，nums[right]之前的最后一个质数的索引
                 */
                int lastPrimeIndex = primeIndexes.floor(right);
                /**
                 * 数组nums中，nums[right]之前的倒数第二个质数的索引为primeIndexes.floor(lastPrimeIndex-1)，假设为x，因为质数间隔
                 * 平衡子数组中至少要有2个质数，所以当滑动窗口的右端点为right时，左端点可以为[left,x]
                 */
                result += primeIndexes.floor(lastPrimeIndex - 1) - left + 1;
            }
        }
        return result;
    }
}
