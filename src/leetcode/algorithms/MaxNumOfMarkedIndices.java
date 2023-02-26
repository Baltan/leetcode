package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2576. Find the Maximum Number of Marked Indices
 *
 * @author Baltan
 * @date 2023/2/26 12:25
 */
public class MaxNumOfMarkedIndices {
    public static void main(String[] args) {
        System.out.println(maxNumOfMarkedIndices(new int[]{42, 83, 48, 10, 24, 55, 9, 100, 10, 17, 17, 99, 51, 32, 16, 98, 99, 31, 28, 68, 71, 14, 64, 29, 15, 40}));
        System.out.println(maxNumOfMarkedIndices(new int[]{3, 5, 2, 4}));
        System.out.println(maxNumOfMarkedIndices(new int[]{9, 2, 5, 4}));
        System.out.println(maxNumOfMarkedIndices(new int[]{7, 6, 8}));
    }

    public static int maxNumOfMarkedIndices(int[] nums) {
        int result = 0;
        int length = nums.length;
        /**
         * 在对数组nums升序排列后，最理想的情况是(0,length/2)、(1,length/2+1)、(length/2-1,length-1)刚好构成length-2个数对，于是可
         * 以把数组nums分成前后两部分，从前后两部分中各取一个数，判断可以组成多少数对
         */
        int hi = length - 1;
        int lo = length / 2 - 1;
        Arrays.sort(nums);

        while (hi >= length / 2) {
            /**
             * 从数组nums前半部分中找到最大的索引lo，使得2*nums[lo]<=nums[hi]
             */
            while (lo >= 0 && 2 * nums[lo] > nums[hi]) {
                lo--;
            }
            /**
             * 说明已经不存在某个数字x使得2x<=nums[hi]了，对于更小的nums[hi]也不需要继续判断
             */
            if (lo < 0) {
                break;
            }
            result += 2;
            hi--;
            lo--;
        }
        return result;
    }
}
