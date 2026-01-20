package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3738. Longest Non-Decreasing Subarray After Replacing at Most One Element
 *
 * @author baltan
 * @date 2026/1/19 17:35
 */
public class LongestSubarray4 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 2, 3, 1, 2}));
        System.out.println(longestSubarray(new int[]{2, 2, 2, 2, 2}));
    }

    public static int longestSubarray(int[] nums) {
        int result = 0;
        /**
         * 当前非递减子数组的起始索引
         */
        int startIndex = 0;
        /**
         * 按序保存所有非递减子数组
         */
        List<int[]> startIndexes = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                startIndexes.add(new int[]{startIndex, i - 1});
                startIndex = i;
            }
        }
        startIndexes.add(new int[]{startIndex, nums.length - 1});
        /**
         * 数组nums本身就是一个非递减子数组，直接返回数组长度即可
         */
        if (startIndexes.size() == 1) {
            return nums.length;
        }

        for (int i = 0; i < startIndexes.size(); i++) {
            /**
             * 对于非递减子数组nums[startIndexes.get(i)[0]……startIndexes.get(i)[1]]，至少可以将nums[startIndexes.get(i)[0]-1]
             * 或nums[startIndexes.get(i)[1]+1]的其中之一元素修改后构成长度为startIndexes.get(i)[1]-startIndexes.get(i)[0]+2的
             * 新的非递减子数组
             */
            result = Math.max(startIndexes.get(i)[1] - startIndexes.get(i)[0] + 2, result);

            if (i - 1 >= 0 && isConnectable(nums, startIndexes.get(i - 1), startIndexes.get(i))) {
                result = Math.max(result, startIndexes.get(i)[1] - startIndexes.get(i - 1)[0] + 1);
            }
        }
        return result;
    }

    /**
     * 修改非递减子数组nums[first[0],first[1]]中的一个元素或nums[second[0],second[1]]中的一个元素后，判断它们是否能够连接构成一个新的
     * 非递减子数组
     *
     * @param nums
     * @param first
     * @param second
     * @return
     */
    public static boolean isConnectable(int[] nums, int[] first, int[] second) {
        /**
         * 子数组nums[first[0],first[1]]或nums[second[0],second[1]]的长度为1，则它们一定能够连接构成一个新的非递减子数组
         */
        if (first[0] == first[1] || second[0] == second[1]) {
            return true;
        }
        /**
         * 如果nums[first[1]-1]<=nums[first[1]]>nums[second[0]]并且nums[first[1]-1]<=nums[second[0]]，将nums[first[1]]修改
         * 为[nums[first[1]-1],nums[second[0]]]中的任意一个数即可
         * 如果nums[first[1]]>nums[second[0]]<=nums[second[0]+1]并且nums[second[0]+1]>=nums[first[1]]，nums[second[0]]修改
         * 为[nums[first[1]],nums[second[0]+1]]中的任意一个数即可
         */
        return nums[first[1] - 1] <= nums[second[0]] || nums[second[0] + 1] >= nums[first[1]];
    }
}
