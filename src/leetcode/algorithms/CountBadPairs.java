package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2364. Count Number of Bad Pairs
 *
 * @author Baltan
 * @date 2023/1/12 09:44
 */
public class CountBadPairs {
    public static void main(String[] args) {
        System.out.println(countBadPairs(new int[]{4, 1, 3, 3}));
        System.out.println(countBadPairs(new int[]{1, 2, 3, 4, 5}));
    }

    public static long countBadPairs(int[] nums) {
        long result = 0L;
        /**
         * nums[i]-i的差 -> 数量
         */
        Map<Integer, Integer> diffMap = new HashMap<>();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int diff = nums[i] - i;
            /**
             * 已遍历的数字中nums[i]-i的差为diff的个数
             */
            int diffCount = diffMap.getOrDefault(diff, 0);
            /**
             * 当前数字和已遍历的数字中nums[i]-i的差不为diff的数字都构成坏数对
             */
            result += i - diffCount;
            diffMap.put(diff, diffCount + 1);
        }
        return result;
    }
}
