package leetcode.algorithms;

/**
 * Description: 1752. Check if Array Is Sorted and Rotated
 *
 * @author Baltan
 * @date 2022/7/24 13:38
 */
public class Check {
    public static void main(String[] args) {
        System.out.println(check(new int[]{3, 4, 5, 1, 2}));
        System.out.println(check(new int[]{2, 1, 3, 4}));
        System.out.println(check(new int[]{1, 2, 3}));
    }

    public static boolean check(int[] nums) {
        int length = nums.length;
        /**
         * nums中的第一个倒序排列的相邻数对中右边数字的索引位置
         */
        int axis = -1;
        /**
         * 从左向右找到nums中的第一个倒序排列的相邻数对
         */
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i - 1]) {
                axis = i;
                break;
            }
        }
        /**
         * 如果数组nums能通过轮转得到，则nums[axis]、nums[axis+1]、nums[axis+2]、……、nums[length-1]、nums[0]、
         * nums[1]、……、nums[axis-1]应该是按照非递减顺序排列的，校验是否满足这个条件即可
         */
        if (axis != -1) {
            /**
             * 判断nums[axis]、nums[axis+1]、nums[axis+2]、……、nums[length-1]是否按照非递减顺序排列
             */
            for (int i = axis + 1; i < length; i++) {
                if (nums[i] < nums[i - 1]) {
                    return false;
                }
            }
            /**
             * 判断nums[length-1]、nums[0]是否按照非递减顺序排列
             */
            if (nums[0] < nums[length - 1]) {
                return false;
            }
            /**
             * 判断nums[0]、nums[1]、……、nums[axis-1]是否按照非递减顺序排列
             */
            for (int i = 1; i < axis; i++) {
                if (nums[i] < nums[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
