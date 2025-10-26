package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 3676. Count Bowl Subarrays
 *
 * @author baltan
 * @date 2025/10/10 15:40
 */
public class BowlSubarrays {
    public static void main(String[] args) {
        System.out.println(bowlSubarrays(new int[]{2, 5, 3, 1, 4}));
        System.out.println(bowlSubarrays(new int[]{5, 1, 2, 3, 4}));
        System.out.println(bowlSubarrays(new int[]{1000000000, 999999999, 999999998}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/count-bowl-subarrays/solutions/3774499/dan-diao-zhan-pythonjavacgo-by-endlessch-y64n/"></a>
     *
     * @param nums
     * @return
     */
    public static long bowlSubarrays(int[] nums) {
        int result = 0;
        /**
         * 单调栈，栈顶到栈底索引单调递增，并且它们对应的元素单调递减
         */
        Deque<Integer> deque = new ArrayDeque<>();
        /**
         * 当nums[i]作为碗子数组的右端点时，通过单调栈查找并判断其左侧所有小于nums[i]的元素能否作为碗子数组的左端点
         */
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i]) {
                int left = deque.pop();
                /**
                 * 只有当子数组的长度至少为3时，才是碗子数组
                 */
                if (i - left > 1) {
                    result++;
                }
            }
            /**
             * 如果当前单调栈不为空，说明栈顶元素大于nums[i]，此时如果子数组长度至少为3，则得到一个左端点大于右端点nums[i]的碗子数组
             */
            if (!deque.isEmpty() && i - deque.peek() > 1) {
                result++;
            }
            deque.push(i);
        }
        return result;
    }
}
