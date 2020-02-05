package leetcode.algorithms;

/**
 * Description: 456. 132 Pattern
 *
 * @author Baltan
 * @date 2020-02-05 15:42
 */
public class Find132pattern {
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(find132pattern(new int[]{-1, 3, 2, 0}));
    }

    public static boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int length = nums.length;
        int leftMin = Integer.MAX_VALUE;

        for (int i = 1; i < length - 1; i++) {
            /**
             * nums[i]左侧的所有数字中最小的数字
             */
            leftMin = Math.min(leftMin, nums[i - 1]);
            /**
             * 如果nums[i]大于leftMin，则"132"模式中"13"已经保证了，在nums[i]右侧的所有数字中查
             * 找是否存在使得leftMin、nums[i]、nums[j]三个数构成"132"模式的数字nums[j]
             */
            if (nums[i] > leftMin) {
                for (int j = length - 1; j > i; j--) {
                    /**
                     * leftMin、nums[i]、nums[j]三个数构成"132"模式
                     */
                    if (leftMin < nums[j] && nums[j] < nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
