package leetcode.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description: 2860. Happy Students
 *
 * @author baltan
 * @date 2023/9/19 13:44
 */
public class CountWays1 {
    public static void main(String[] args) {
        System.out.println(countWays(Arrays.asList(1, 1)));
        System.out.println(countWays(Arrays.asList(6, 0, 3, 3, 6, 7, 2, 7)));
    }

    public static int countWays(List<Integer> nums) {
        int result = 0;
        int size = nums.size();
        Collections.sort(nums);
        /**
         * 没有人被选中，则只要保证最小的nums[x]大于0即可
         */
        if (nums.get(0) > 0) {
            result++;
        }
        /**
         * 所有人都被选中，则只要保证最大的nums[x]小于总人数即可
         */
        if (size > nums.get(size - 1)) {
            result++;
        }
        /**
         * 假设被选中的人数为i，只要同时满足i大于这i个人中最大的nums[x]，i小于剩下的size-1个人中最小的nums[x]即可，所以被选中的i个人就是
         * 最小的i个nums[x]
         */
        for (int i = 1; i < size; i++) {
            /**
             * 因为数组nums已被升序排列，所以被选中的i个人中最大的nums[x]为nums[i-1]，剩下的size-i个未选中人中最小的nums[x]为nums[i]
             *
             */
            if (i > nums.get(i - 1) && i < nums.get(i)) {
                result++;
            }
        }
        return result;
    }
}
