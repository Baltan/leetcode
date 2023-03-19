package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2592. Maximize Greatness of an Array
 *
 * @author Baltan
 * @date 2023/3/19 12:10
 */
public class MaximizeGreatness {
    public static void main(String[] args) {
        System.out.println(maximizeGreatness(new int[]{1, 3, 5, 2, 1, 3, 1}));
        System.out.println(maximizeGreatness(new int[]{1, 2, 3, 4}));
    }

    public static int maximizeGreatness(int[] nums) {
        int result = 0;
        int length = nums.length;
        int index = 0;
        Arrays.sort(nums);
        int[] clone = nums.clone();
        /**
         * 田忌赛马原则，从小到大依次为数组nums中的每个元素num匹配刚好大于num的另一个元素
         */
        for (int num : nums) {
            /**
             * 从clone[index]开始从小到大查找大于num的第一个元素
             */
            while (index < length && clone[index] <= num) {
                index++;
            }
            /**
             * 数组clone中没有元素大于num，则也肯定没有元素大于数组nums中剩余的元素，直接结束
             */
            if (index == length) {
                break;
            }
            result++;
            /**
             * clone[index]已被用来匹配元素num，要跳过
             */
            index++;
        }
        return result;
    }
}
