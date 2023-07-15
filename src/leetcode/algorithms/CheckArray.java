package leetcode.algorithms;

/**
 * Description: 2772. Apply Operations to Make All Array Elements Equal to Zero
 *
 * @author Baltan
 * @date 2023/7/14 19:59
 */
public class CheckArray {
    public static void main(String[] args) {
        System.out.println(checkArray(new int[]{60, 72, 87, 89, 63, 52, 64, 62, 31, 37, 57, 83, 98, 94, 92, 77, 94, 91, 87, 100, 91, 91, 50, 26}, 4));
        System.out.println(checkArray(new int[]{0, 45, 82, 98, 99}, 4));
        System.out.println(checkArray(new int[]{2, 2, 3, 1, 1, 0}, 3));
        System.out.println(checkArray(new int[]{1, 3, 1, 1}, 2));
    }

    public static boolean checkArray(int[] nums, int k) {
        int length = nums.length;
        /**
         * operations[i]表示以nums[i]为起点的长度为k的子数组被执行减1操作的次数
         */
        int[] operations = new int[length];
        /**
         * 第一个元素必须被执行nums[0]次减1操作才能变为0
         */
        operations[0] = nums[0];
        /**
         * 遍历过程中记录每个元素已被执行减1操作的次数
         */
        int total = nums[0];

        for (int i = 1; i <= length - k; i++) {
            /**
             * 以nums[i-k]为终点的长度为k的子数组的操作不会影响到元素operations[i]，所以要扣除这部分操作次数
             */
            if (i - k >= 0) {
                total -= operations[i - k];
            }
            /**
             * nums[i]已被之前的total次减1操作变为了负数，不可能再变为0，直接返回false
             */
            if (nums[i] < total) {
                return false;
            }
            operations[i] = nums[i] - total;
            /**
             * 对当前元素的操作还会作用在后续的元素上，要加上这些操作次数
             */
            total += operations[i];
        }
        /**
         * 考虑最后k-1个元素的情况，因为子数组的长度为k，所以对以nums[i]为起点的长度为k的子数组被执行减1操作，逐次将operations[i-k]这部
         * 分操作扣除即可
         */
        for (int i = length - k + 1; i < length; i++) {
            if (i - k >= 0) {
                total -= operations[i - k];
            }

            if (nums[i] != total) {
                return false;
            }
        }
        return true;
    }
}
