package leetcode.algorithms;

/**
 * Description: 1764. Form Array by Concatenating Subarrays of Another Array
 *
 * @author Baltan
 * @date 2022/7/17 14:23
 */
public class CanChoose {
    public static void main(String[] args) {
        int[][] groups1 = {{1, -1, -1}, {3, -2, 0}};
        int[] nums1 = {1, -1, 0, 1, -1, -1, 3, -2, 0};
        System.out.println(canChoose(groups1, nums1));

        int[][] groups2 = {{10, -2}, {1, 2, 3, 4}};
        int[] nums2 = {1, 2, 3, 4, 10, -2};
        System.out.println(canChoose(groups2, nums2));

        int[][] groups3 = {{1, 2, 3}, {3, 4}};
        int[] nums3 = {7, 7, 1, 2, 3, 4, 7, 7};
        System.out.println(canChoose(groups3, nums3));
    }

    public static boolean canChoose(int[][] groups, int[] nums) {
        /**
         * nums查找子数组从nums[start]开始
         */
        int start = 0;

        for (int[] group : groups) {
            int length = group.length;
            /**
             * 数组nums剩余元素中，是否存在一个子数组和数组group完全相同
             */
            boolean isMatched = false;

            outer:
            /**
             * 如果数组nums剩余元素个数nums.length-start小于length个，就不用进行计算了
             */
            while (nums.length - start >= length) {
                for (int i = 0; i < length; i++) {
                    /**
                     * 数组nums中的子数组nums[start]、nums[start+1]、……、nums[start+length-1]和数组group不相同，继续
                     * 判断下一个子数组nums[start+1]、nums[start+2]、……、nums[start+length]的情况
                     */
                    if (group[i] != nums[start + i]) {
                        start++;
                        continue outer;
                    }
                }
                /**
                 * 数组nums中的子数组nums[start]、nums[start+1]、……、nums[start+length-1]和数组group完全相同，nums中
                 * 剩余元素从nums[start+length]开始
                 */
                isMatched = true;
                start += length;
                break;
            }

            if (!isMatched) {
                return false;
            }
        }
        return true;
    }
}
