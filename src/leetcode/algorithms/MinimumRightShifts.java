package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 2855. Minimum Right Shifts to Sort the Array
 *
 * @author baltan
 * @date 2023/9/20 14:01
 */
public class MinimumRightShifts {
    public static void main(String[] args) {
        System.out.println(minimumRightShifts(Arrays.asList(3, 4, 5, 1, 2)));
        System.out.println(minimumRightShifts(Arrays.asList(1, 3, 5)));
        System.out.println(minimumRightShifts(Arrays.asList(2, 1, 4)));
    }

    public static int minimumRightShifts(List<Integer> nums) {
        /**
         * 从后往前找到第一个索引index，使得nums[index]<nums[index-1]，如果要使数组nums有序，必须要将数组中从索引index开始到最后的数字
         * 移动头部
         */
        int index = 0;

        for (int i = nums.size() - 1; i > 0; i--) {
            if (nums.get(i) < nums.get(i - 1)) {
                index = i;
                break;
            }
        }
        /**
         * 没有找到逆序对，说明数组nums本来就是有序的
         */
        if (index == 0) {
            return 0;
        }
        /**
         * 将数组后半部分移动到数组头部后判断新数组是否是有序的。假设初始时数组中最后一个元素为x，由于子数组[nums[index],nums[index+1],
         * ……x]已经确定是有序的，只需判断[x,nums[0],nums[1]……,nums[index-1]]是否有序即可，prev为相邻数字比较时，在新数组中索引值较小
         * 的数字
         */
        int prev = nums.get(nums.size() - 1);

        for (int i = 0; i < index; i++) {
            /**
             * 新数组中仍存在逆序对，不能通过一次右移使得数组nums有序
             */
            if (nums.get(i) < prev) {
                return -1;
            }
            prev = nums.get(i);
        }
        /**
         * 数组nusm中从索引index开始到最后的数字要被移动到数组头部
         */
        return nums.size() - index;
    }
}
