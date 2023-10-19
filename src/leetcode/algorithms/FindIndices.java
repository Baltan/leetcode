package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2905. Find Indices With Index and Value Difference II
 *
 * @author Baltan
 * @date 2023/10/18 23:57
 */
public class FindIndices {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(findIndices(new int[]{4, 3, 10, 5, 1, 2, 4, 4, 1, 2, 4}, 0, 7));
        OutputUtils.print1DIntegerArray(findIndices(new int[]{32, 3, 27, 12, 42, 48, 27, 30}, 1, 34));
        OutputUtils.print1DIntegerArray(findIndices(new int[]{15, 8}, 0, 6));
        OutputUtils.print1DIntegerArray(findIndices(new int[]{9, 5, 4}, 1, 0));
        OutputUtils.print1DIntegerArray(findIndices(new int[]{5, 1, 4, 1}, 2, 4));
        OutputUtils.print1DIntegerArray(findIndices(new int[]{2, 1}, 0, 0));
        OutputUtils.print1DIntegerArray(findIndices(new int[]{1, 2, 3}, 2, 4));
    }

    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        /**
         * 如果valueDifference为0，则在数组nums中任意选择两个数都满足条件2，为了满足条件1，最极端的情况可以选择nums[0]和
         * nums[nums.length-1]两个数，判断这两个数的索引之差是否不小于indexDifference即可
         */
        if (valueDifference == 0) {
            return nums.length - 1 >= indexDifference ? new int[]{0, nums.length - 1} : new int[]{-1, -1};
        }
        /**
         * 如果indexDifference为0，则在数组nums中任意选择两个数都满足条件1，为了满足条件2，最极端的情况可以选择数组中的最大值
         * nums[maxIndex]和最小值nums[minIndex]两个数，判断这两个数之差是否不小于valueDifference即可
         */
        if (indexDifference == 0) {
            int minIndex = 0;
            int maxIndex = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }

                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }
            return nums[maxIndex] - nums[minIndex] >= valueDifference ? new int[]{minIndex, maxIndex} : new int[]{-1, -1};
        }
        /**
         * prefixMinIndexes[i]表示数组nums的前缀子数组[nums[0],nums[1],……,nums[i]]中的最小值的索引
         */
        int[] prefixMinIndexes = new int[nums.length];
        /**
         * prefixMaxIndexes[i]表示数组nums的前缀子数组[nums[0],nums[1],……,nums[i]]中的最大值的索引
         */
        int[] prefixMaxIndexes = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            /**
             * 判断前缀子数组[nums[0],nums[1],……,nums[i-indexDifference]]中的最小值nums[prefixMinIndexes[i-indexDifference]]
             * 是否满足nums[i]-nums[prefixMinIndexes[i-indexDifference]]>=valueDifference
             */
            if (i >= indexDifference && nums[i] - nums[prefixMinIndexes[i - indexDifference]] >= valueDifference) {
                return new int[]{i, prefixMinIndexes[i - indexDifference]};
            }
            /**
             * 判断前缀子数组[nums[0],nums[1],……,nums[i-indexDifference]]中的最大值nums[prefixMaxIndexes[i-indexDifference]]
             * 是否满足nums[prefixMinIndexes[i-indexDifference]]-nums[i]>=valueDifference
             */
            if (i >= indexDifference && nums[prefixMaxIndexes[i - indexDifference]] - nums[i] >= valueDifference) {
                return new int[]{i, prefixMaxIndexes[i - indexDifference]};
            }
            /**
             * 如果nums[i]比前缀子数组[nums[0],nums[1],……,nums[i-1]]中的所有元素都小，则prefixMinIndexes[i]为i，否则
             * prefixMinIndexes[i]和prefixMinIndexes[i-1]一样
             */
            prefixMinIndexes[i] = nums[i] < nums[prefixMinIndexes[i - 1]] ? i : prefixMinIndexes[i - 1];
            /**
             * 如果nums[i]比前缀子数组[nums[0],nums[1],……,nums[i-1]]中的所有元素都大，则prefixMaxIndexes[i]为i，否则
             * prefixMaxIndexes[i]和prefixMaxIndexes[i-1]一样
             */
            prefixMaxIndexes[i] = nums[i] > nums[prefixMaxIndexes[i - 1]] ? i : prefixMaxIndexes[i - 1];
        }
        return new int[]{-1, -1};
    }
}
