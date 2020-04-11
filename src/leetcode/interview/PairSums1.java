package leetcode.interview;

import java.util.*;

/**
 * Description: 面试题 16.24. 数对和
 *
 * @author Baltan
 * @date 2020-04-11 18:00
 * @see PairSums
 */
public class PairSums1 {
    public static void main(String[] args) {
        System.out.println(pairSums(new int[]{5, 6, 5}, 11));
        System.out.println(pairSums(new int[]{5, 6, 5, 6}, 11));
        System.out.println(pairSums(new int[]{5}, 1));
        System.out.println(pairSums(new int[]{-2, -1, 0, 3, 5, 6, 7, 9, 13, 14}, 12));
    }

    public static List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        /**
         * 从数组头部开始向后移动的指针，始终指向整数对中较小的数字
         */
        int lo = 0;
        /**
         * 从数组尾部开始向前移动的指针，始终指向整数对中较大的数字
         */
        int hi = nums.length - 1;

        while (lo < hi) {
            if (nums[lo] + nums[hi] < target) {
                /**
                 * 如果当前两个指针指向的数字小于target，就向后移动lo指针
                 */
                lo++;
            } else if (nums[lo] + nums[hi] > target) {
                /**
                 * 如果当前两个指针指向的数字大于target，就向前移动hi指针
                 */
                hi--;
            } else {
                result.add(Arrays.asList(nums[lo], nums[hi]));
                /**
                 * 当前两个数字都被使用过了，不能再被使用，向后移动lo指针并且向前移动hi指针
                 */
                lo++;
                hi--;
            }
        }
        return result;
    }
}
