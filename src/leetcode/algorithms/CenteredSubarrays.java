package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 3804. Number of Centered Subarrays
 *
 * @author baltan
 * @date 2026/2/16 13:55
 */
public class CenteredSubarrays {
    public static void main(String[] args) {
        System.out.println(centeredSubarrays(new int[]{-1, 1, 0}));
        System.out.println(centeredSubarrays(new int[]{2, -3}));
    }

    public static int centeredSubarrays(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            /**
             * 子数组nums[i……j]中所有元素的和
             */
            int sum = 0;
            /**
             * 子数组nums[i……j]中出现过的元素
             */
            Set<Integer> isVisited = new HashSet<>();

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                isVisited.add(nums[j]);

                if (isVisited.contains(sum)) {
                    result++;
                }
            }
        }
        return result;
    }
}
