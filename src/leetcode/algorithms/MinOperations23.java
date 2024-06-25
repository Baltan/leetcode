package leetcode.algorithms;

/**
 * Description: 3191. Minimum Operations to Make Binary Array Elements Equal to One I
 *
 * @author baltan
 * @date 2024/6/24 09:21
 */
public class MinOperations23 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{0, 1, 1, 1, 0, 0}));
        System.out.println(minOperations(new int[]{0, 1, 1, 1}));
    }

    public static int minOperations(int[] nums) {
        int result = 0;
        int length = nums.length;
        /**
         * 从头开始滑动一个长度为3的窗口，如果窗口中第一个元素为0，则窗口中的三个元素都要变化
         */
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] == 0) {
                /**
                 * 将数字从0变为1或从1变为0
                 */
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                result++;
            }
        }
        /**
         * 如果数组nums中最后两个元素最终也是1，则完成了操作
         */
        return nums[length - 2] == 1 && nums[length - 1] == 1 ? result : -1;
    }
}
