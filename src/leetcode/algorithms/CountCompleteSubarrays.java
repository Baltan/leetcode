package leetcode.algorithms;

/**
 * Description: 2799. Count Complete Subarrays in an Array
 *
 * @author Baltan
 * @date 2023/7/30 14:49
 */
public class CountCompleteSubarrays {
    public static void main(String[] args) {
        System.out.println(countCompleteSubarrays(new int[]{1, 3, 1, 2, 2}));
        System.out.println(countCompleteSubarrays(new int[]{5, 5, 5, 5}));
    }

    public static int countCompleteSubarrays(int[] nums) {
        int result = 0;
        int length = nums.length;
        /**
         * 数组nums中不同元素的个数
         */
        int totalCount = 0;
        /**
         * 数组nums中最大元素的值
         */
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }
        /**
         * isVisited[i]表示元素i是否在数组nums中出现过
         */
        boolean[] isVisited = new boolean[max + 1];

        for (int num : nums) {
            /**
             * 遍历过程中每出现一个新的元素就将totalCount加1
             */
            if (!isVisited[num]) {
                totalCount++;
                isVisited[num] = true;
            }
        }

        for (int i = 0; i < length; i++) {
            /**
             * 以nums[i]作为第一个元素的子数组中不同元素的个数
             */
            int count = 0;
            /**
             * isVisited[i]表示元素i是否在以nums[i]作为第一个元素的子数组中出现过
             */
            isVisited = new boolean[max + 1];

            for (int j = i; j < length; j++) {
                /**
                 * 遍历子数组的过程中每出现一个新的元素就将totalCount加1
                 */
                if (!isVisited[nums[j]]) {
                    count++;
                    isVisited[nums[j]] = true;
                }

                if (count == totalCount) {
                    result++;
                } else if (count > totalCount) {
                    /**
                     * 如果当前子数组中的不同元素个数已大于totalCount，则后续子数组中不同元素的个数一定也大于totalCount
                     */
                    break;
                }
            }
        }
        return result;
    }
}
