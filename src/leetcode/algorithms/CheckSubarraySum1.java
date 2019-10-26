package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 523. Continuous Subarray Sum
 *
 * @author Baltan
 * @date 2019-10-26 13:47
 */
public class CheckSubarraySum1 {
    public static void main(String[] args) {
        int[] nums1 = {23, 2, 4, 6, 7};
        System.out.println(checkSubarraySum(nums1, 6));

        int[] nums2 = {23, 2, 6, 4, 7};
        System.out.println(checkSubarraySum(nums2, 6));

        int[] nums3 = {0, 0};
        System.out.println(checkSubarraySum(nums3, 0));

        int[] nums4 = {0, 1, 0};
        System.out.println(checkSubarraySum(nums4, 0));

        int[] nums5 = {1, 0};
        System.out.println(checkSubarraySum(nums5, 2));

        int[] nums6 = {0, 0};
        System.out.println(checkSubarraySum(nums6, -1));

        int[] nums7 = {0, 1, 0};
        System.out.println(checkSubarraySum(nums7, -1));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        /**
         * 假设已经存在前缀和或余数为0的key，这样当前两个数的前缀和为0（此时余数也为0）时，即可以判定存在满足条件的子数组
         */
        map.put(0, -1);
        /**
         * 参考：
         * <a href="https://leetcode-cn.com/problems/continuous-subarray-sum/solution/lian-xu-de-zi-shu-zu-he-by-leetcode/"></a>
         *
         * 如果k为0，计算到数组nums当前索引为止的前缀和，如果前缀和key在map中存在，并且当前索引与对应的value值之差大于1，
         * 说明存在满足条件的子数组，否则，如果前缀和key在map中不存在，将该前缀和作为key，将该处索引作为value保存在map中
         * 如果k不为0，计算到数组nums当前索引为止的前缀和对k取模的值，如果余数key在map中存在，并且当前索引与对应的value
         * 值之差大于1，说明存在满足条件的子数组，否则，如果余数key在map中不存在，将该余数作为key，将该处索引作为value保
         * 存在map中
         */
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (k != 0) {
                sum = sum % k;
            }

            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
