package leetcode.algorithms;

/**
 * Description: 2765. Longest Alternating Subarray
 *
 * @author Baltan
 * @date 2023/7/9 12:47
 */
public class AlternatingSubarray {
    public static void main(String[] args) {
        System.out.println(alternatingSubarray(new int[]{13, 14, 15, 14}));
        System.out.println(alternatingSubarray(new int[]{64, 65, 64, 65, 64, 65, 66, 65, 66, 65}));
        System.out.println(alternatingSubarray(new int[]{2, 3, 4, 3, 4}));
        System.out.println(alternatingSubarray(new int[]{4, 5, 6}));
    }

    public static int alternatingSubarray(int[] nums) {
        int result = -1;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            /**
             * 交替子数组中的元素和nums[i]之差
             */
            int diff = 1;
            /**
             * 计算以nums[i]作为第一个元素的交替子数组的最大长度
             */
            for (int j = i + 1; j < length && nums[j] - nums[i] == diff; j++) {
                result = Math.max(result, j - i + 1);
                /**
                 * 如果交替子数组中当前元素比nums[i]大1，则下一个元素应该和nums[i]相等，反之亦然。
                 */
                diff = 1 - diff;
            }
        }
        return result;
    }
}
