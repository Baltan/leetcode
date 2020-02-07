package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * Description: 503. Next Greater Element II
 *
 * @author Baltan
 * @date 2020-02-07 12:30
 */
public class NextGreaterElements {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1};
        OutputUtils.print1DIntegerArray(nextGreaterElements(nums1));

        int[] nums2 = {1, 2, 3, 4, 3};
        OutputUtils.print1DIntegerArray(nextGreaterElements(nums2));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/next-greater-element-ii/solution/xia-yi-ge-geng-da-yuan-su-ii-by-leetcode/"></a>
     *
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        /**
         * 保存元素的索引，并且栈中的索引对应的元素是非严格递增的
         */
        Stack<Integer> stack = new Stack<>();
        /**
         * 先将所有位置都初始化为-1，当找到比这个位置的元素更大的元素时会覆盖"-1"这个值
         */
        Arrays.fill(result, -1);
        /**
         * 因为是环形数组，所以数组最后的一些元素，可能需要在第二次遍历中才能判断是否有比它大的元素
         */
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < length; j++) {
                /**
                 * 如果栈顶索引对应的元素小于当前索引对应的元素，则栈顶索引对应的元素的下一个更大
                 * 的元素就是当前索引对应的元素，将栈顶索引出栈并且更新result数组，循环这个操作直
                 * 到栈顶索引对应的元素不小于当前元素。最后将当前索引入栈，保持栈中的索引对应的元
                 * 素始终是是非严格递增的
                 */
                while (!stack.isEmpty() && nums[stack.peek()] < nums[j]) {
                    result[stack.pop()] = nums[j];
                }
                stack.push(j);
            }
        }
        return result;
    }
}
