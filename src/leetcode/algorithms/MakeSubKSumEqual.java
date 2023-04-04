package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: 2607. Make K-Subarray Sums Equal
 *
 * @author Baltan
 * @date 2023/4/3 09:42
 */
public class MakeSubKSumEqual {
    public static void main(String[] args) {
        System.out.println(makeSubKSumEqual(new int[]{6, 2, 8, 5, 7, 10}, 4));
        System.out.println(makeSubKSumEqual(new int[]{10, 3, 8}, 2));
        System.out.println(makeSubKSumEqual(new int[]{1, 4, 1, 3}, 2));
        System.out.println(makeSubKSumEqual(new int[]{2, 5, 5, 7}, 3));
    }

    public static long makeSubKSumEqual(int[] arr, int k) {
        long result = 0L;
        int length = arr.length;
        /**
         * 计算length和k的最大公约数
         */
        int gcd = gcd(length, k);
        /**
         * 数组arr中所有间隔步长为gcd的子序列中的元素最终都必须相等
         */
        for (int i = 0; i < gcd; i++) {
            /**
             * 保存子序列中的元素
             */
            List<Integer> nums = new ArrayList<>();

            for (int j = i; j < length; j += gcd) {
                nums.add(arr[j]);
            }
            Collections.sort(nums);
            int size = nums.size();
            /**
             * 为了保证操作次数最少，子序列中的元素最终都变成子序列的中位数
             */
            int mid = size % 2 == 0 ? (nums.get(size / 2) + nums.get(size / 2 - 1)) / 2 : nums.get(size / 2);
            /**
             * 计算所有num都变成mid需要的操作次数
             */
            for (int num : nums) {
                result += Math.abs(num - mid);
            }
        }
        return result;
    }

    /**
     * 求x和y的最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);

        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }
}
