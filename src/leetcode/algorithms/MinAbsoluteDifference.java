package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 2817. Minimum Absolute Difference Between Elements With Constraint
 *
 * @author baltan
 * @date 2023/8/15 22:37
 */
public class MinAbsoluteDifference {
    public static void main(String[] args) {
        System.out.println(minAbsoluteDifference(Arrays.asList(9, 113, 136), 1));
        System.out.println(minAbsoluteDifference(Arrays.asList(4, 3, 2, 4), 2));
        System.out.println(minAbsoluteDifference(Arrays.asList(5, 3, 2, 10, 15), 1));
        System.out.println(minAbsoluteDifference(Arrays.asList(1, 2, 3, 4), 3));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-absolute-difference-between-elements-with-constraint/solutions/2386621/java-shou-xie-er-fen-by-hust_wei-gw6d/"></a>
     *
     * @param nums
     * @param x
     * @return
     */
    public static int minAbsoluteDifference(List<Integer> nums, int x) {
        int result = Integer.MAX_VALUE;
        int size = nums.size();
        /**
         * 保存列表nums前缀的所有元素，并且始终保持list中的元素升序排列
         */
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            /**
             * 列表list中第一个大于等于nums.get(i)的元素的索引，将数字nums.get(i)放在list的索引index处，原来索引值大于等于index的所有
             * 元素都向后移动一个位置，保证list中加入数字nums.get(i)后，所有元素依然升序排列
             */
            int index = ceiling(list, nums.get(i));
            list.add(index, nums.get(i));

            if (i + x < size) {
                /**
                 * 列表nums中索引值为i+x的元素target和list中的所有数字索引之差都大于等于x
                 */
                int target = nums.get(i + x);
                /**
                 * 如果列表list中所有元素都小于等于target，则target和list中的最后一个数字差值的绝对值最小；如果列表list中所有元素都大于
                 * 等于target，则target和list中的第一个数字差值的绝对值最小；在list中找到第一个大于等于target的元素的索引位置right，则
                 * 比较list.get(right)和list.get(right-1)两个元素和target的差值的绝对值，取较小值
                 */
                if (target >= list.get(list.size() - 1)) {
                    result = Math.min(result, target - list.get(list.size() - 1));
                } else if (target <= list.get(0)) {
                    result = Math.min(result, list.get(0) - target);
                } else {
                    int right = ceiling(list, target);
                    result = Math.min(result, list.get(right) - target);
                    result = Math.min(result, target - list.get(right - 1));
                }
            }
        }
        return result;
    }

    /**
     * 在列表list中二分查找第一个大于等于target的元素的索引位置
     *
     * @param list
     * @param target
     * @return
     */
    public static int ceiling(List<Integer> list, int target) {
        /**
         * 列表list中没有元素，则假设索引为0的数字大于等于target
         */
        if (list.isEmpty()) {
            return 0;
        }
        /**
         * 列表list中所有元素都小于target，则假设索引为list.size()的数字大于等于target
         */
        if (target > list.get(list.size() - 1)) {
            return list.size();
        }
        int lo = 0;
        int hi = list.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
