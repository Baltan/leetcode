package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1991. Find the Middle Index in Array
 *
 * @author Baltan
 * @date 2022/1/20 09:13
 */
public class FindMiddleIndex {
    public static void main(String[] args) {
        System.out.println(findMiddleIndex(new int[]{2, 3, -1, 8, 4}));
        System.out.println(findMiddleIndex(new int[]{1, -1, 4}));
        System.out.println(findMiddleIndex(new int[]{2, 5}));
    }

    public static int findMiddleIndex(int[] nums) {
        /**
         * 初始状态（假设middleIndex=0）下middleIndex左边所有数的和
         */
        int rightSum = Arrays.stream(nums).sum() - nums[0];
        /**
         * 初始状态（假设middleIndex=0）下middleIndex右边所有数的和
         */
        int leftSum = 0;
        int index = 0;
        /**
         * 从左向右遍历查找第一个符合要求的index，即为所求middleIndex
         */
        while (leftSum != rightSum && index < nums.length - 1) {
            leftSum += nums[index];
            index++;
            rightSum -= nums[index];
        }
        /**
         * 判断最终是否使得index左边所有数的和等于右边所有数的和，没有的话返回-1
         */
        return leftSum == rightSum ? index : -1;
    }
}
