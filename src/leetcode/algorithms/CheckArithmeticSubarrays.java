package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 1630. Arithmetic Subarrays
 *
 * @author Baltan
 * @date 2022/9/25 14:02
 */
public class CheckArithmeticSubarrays {
    public static void main(String[] args) {
        int[] nums1 = {4, 6, 5, 9, 3, 7};
        int[] l1 = {0, 0, 2};
        int[] r1 = {2, 3, 5};
        System.out.println(checkArithmeticSubarrays(nums1, l1, r1));

        int[] nums2 = {-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10};
        int[] l2 = {0, 1, 6, 4, 8, 7};
        int[] r2 = {4, 4, 9, 7, 9, 10};
        System.out.println(checkArithmeticSubarrays(nums2, l2, r2));
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int length = l.length;
        List<Boolean> result = new ArrayList<>(length);

        outer:
        for (int i = 0; i < length; i++) {
            int start = l[i];
            int end = r[i];
            /**
             * 获取子数组[nums[start],nums[start+1],……,nums[end-1],nums[end]]
             */
            int[] subarray = Arrays.copyOfRange(nums, start, end + 1);
            Arrays.sort(subarray);
            int diff = subarray[1] - subarray[0];
            /**
             * 判断子数组subarray相邻两个元素之差是否都相等
             */
            for (int j = 2; j < subarray.length; j++) {
                if (subarray[j] - subarray[j - 1] != diff) {
                    result.add(false);
                    continue outer;
                }
            }
            result.add(true);
        }
        return result;
    }
}
