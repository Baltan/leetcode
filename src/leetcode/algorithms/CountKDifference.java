package leetcode.algorithms;

/**
 * Description: 2006. Count Number of Pairs With Absolute Difference K
 *
 * @author Baltan
 * @date 2021/12/4 18:44
 */
public class CountKDifference {
    public static void main(String[] args) {
        System.out.println(countKDifference(new int[]{1, 2, 2, 1}, 1));
        System.out.println(countKDifference(new int[]{1, 3}, 3));
        System.out.println(countKDifference(new int[]{3, 2, 1, 5, 4}, 2));
    }

    public static int countKDifference(int[] nums, int k) {
        int result = 0;
        /**
         * count[i]表示数字i出现的次数，依据题意，nums[x]∈[1,100]
         */
        int[] count = new int[101];

        for (int num : nums) {
            if (num - k > 0) {
                result += count[num - k];
            }

            if (num + k <= 100) {
                result += count[num + k];
            }
            count[num]++;
        }
        return result;
    }
}
