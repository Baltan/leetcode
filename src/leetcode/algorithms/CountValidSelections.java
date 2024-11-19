package leetcode.algorithms;

/**
 * Description: 3354. Make Array Elements Equal to Zero
 *
 * @author Baltan
 * @date 2024/11/19 23:16
 */
public class CountValidSelections {
    public static void main(String[] args) {
        System.out.println(countValidSelections(new int[]{1, 0, 2, 0, 3}));
        System.out.println(countValidSelections(new int[]{2, 3, 4, 0, 4, 1, 0}));
    }

    public static int countValidSelections(int[] nums) {
        int result = 0;
        /**
         * 数组nums中所有元素的和
         */
        int sum = 0;
        /**
         * 数组nums的前缀和
         */
        int prefixSum = 0;

        for (int num : nums) {
            sum += num;
        }

        for (int num : nums) {
            if (num == 0) {
                /**
                 * 数组nums中元素num左边所有元素之和为prefixSum，右边所有元素之和为sum-prefixSum，两边元素和之差为diff
                 */
                int diff = Math.abs(prefixSum - (sum - prefixSum));
                /**
                 * 如果最终数组nums中所有元素都为0，说明最终可以沿着一个方向移出数组。如果移出数组的方向和初始方向相反，则起点位置两边元素
                 * 和之差为0，初始方向向左或向右最终都能移出数组；如果移出数组的方向和初始方向相同，则起点位置两边元素和之差为1，并且初始方
                 * 向只能向着元素和较大的一边
                 */
                if (diff == 0) {
                    result += 2;
                } else if (diff == 1) {
                    result += 1;
                }
            }
            prefixSum += num;
        }
        return result;
    }
}
