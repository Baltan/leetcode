package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 2289. Steps to Make Array Non-decreasing
 *
 * @author Baltan
 * @date 2023/1/21 13:39
 */
public class TotalSteps {
    public static void main(String[] args) {
        System.out.println(totalSteps(new int[]{5, 14, 15, 2, 11, 5, 13, 15}));
        System.out.println(totalSteps(new int[]{10, 1, 2, 3, 4, 5, 6, 1, 2, 3}));
        System.out.println(totalSteps(new int[]{7, 11, 1}));
        System.out.println(totalSteps(new int[]{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11}));
        System.out.println(totalSteps(new int[]{4, 5, 7, 7, 13}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/steps-to-make-array-non-decreasing/solutions/1524614/by-endlesscheng-s2yc/"></a>
     *
     * @param nums
     * @return
     */
    public static int totalSteps(int[] nums) {
        int result = 0;
        /**
         * 单调栈deque中的每个数组元素[num,step]保存数组nums中的每个数字num以及数字num被移除的操作数step，并且始终保证栈中顶层元素的数字
         * num小于等于底层元素的数字num
         */
        Deque<int[]> deque = new ArrayDeque<>();

        for (int num : nums) {
            /**
             * 数字num被移除的操作数
             */
            int step = 0;
            /**
             * 如果deque栈顶存在小于等于num的数字x，说明如果num可以被其他数字消除，必须先等x被消除，计算所有满足情况的x被消除的最大操作数
             */
            while (!deque.isEmpty() && deque.peekFirst()[0] <= num) {
                step = Math.max(step, deque.pop()[1]);
            }
            /**
             * 如果deque为空说明数组nums左边不存在大于num的数字，数字num不会被消除。否则就要等num左边那些小于等于num的数字x在step次操作后，
             * 才可以再多一步操作消除num
             */
            step = deque.isEmpty() ? 0 : step + 1;
            result = Math.max(result, step);
            /**
             * 将数组num和其操作数step入栈
             */
            deque.offerFirst(new int[]{num, step});
        }
        return result;
    }
}
