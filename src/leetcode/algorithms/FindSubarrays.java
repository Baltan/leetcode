package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 2395. Find Subarrays With Equal Sum
 *
 * @author Baltan
 * @date 2023/2/11 20:03
 */
public class FindSubarrays {
    public static void main(String[] args) {
        System.out.println(findSubarrays(new int[]{4, 2, 4}));
        System.out.println(findSubarrays(new int[]{1, 2, 3, 4, 5}));
        System.out.println(findSubarrays(new int[]{0, 0, 0}));
    }

    public static boolean findSubarrays(int[] nums) {
        Set<Integer> sums = new HashSet<>();

        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i] + nums[i - 1];
            /**
             * 如果sum无法加入到集合sums中，说明此前已经有一个子数组元素的和也为sum，直接返回true
             */
            if (!sums.add(sum)) {
                return true;
            }
        }
        return false;
    }
}
