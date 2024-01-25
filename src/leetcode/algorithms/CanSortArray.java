package leetcode.algorithms;

/**
 * Description: 3011. Find if Array Can Be Sorted
 *
 * @author Baltan
 * @date 2024/1/21 21:28
 */
public class CanSortArray {
    public static void main(String[] args) {
        System.out.println(canSortArray(new int[]{8, 4, 2, 30, 15}));
        System.out.println(canSortArray(new int[]{1, 2, 3, 4, 5}));
        System.out.println(canSortArray(new int[]{3, 16, 8, 4, 2}));
    }

    public static boolean canSortArray(int[] nums) {
        /**
         * elements[i]表示[元素nums[i]，元素nums[i]的设置位的个数]
         */
        int[][] elements = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            elements[i] = new int[]{nums[i], Integer.bitCount(nums[i])};
        }
        /**
         * 冒泡排序，按照elements[i][0]升序排列
         */
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (elements[j][0] > elements[j + 1][0]) {
                    /**
                     * 如果元素elements[j]和elements[j+1]无法交换，说明最终不能实现所有元素按照element[0]升序排列，直接返回false
                     */
                    if (elements[j][1] != elements[j + 1][1]) {
                        return false;
                    }
                    int[] temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
        return true;
    }
}
