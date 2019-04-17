package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: Sort an Array
 *
 * @author Baltan
 * @date 2019-04-17 09:47
 */
public class SortArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(sortArray(
                new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18,
                        23, 34, 15,
                        35, 25, 53, 51}));
    }

    public static int[] sortArray(int[] nums) {
        double distance = nums.length;
        int arrLength = nums.length;

        while (true) {
            distance = Math.ceil(distance / 2);
            int d = (int) distance;
            for (int i = 0; i < d; i++) {
                for (int j = i + d; j < arrLength; j += d) {
                    int currNum = nums[j];
                    int k;
                    for (k = j - d; k >= 0 && nums[k] > currNum; k -= d) {
                        nums[k + d] = nums[k];
                    }
                    nums[k + d] = currNum;
                }
            }
            if (d == 1) {
                break;
            }
        }
        return nums;
    }
}
