package leetcode.algorithms;

/**
 * Description: 3375. Minimum Operations to Make Array Values Equal to K
 *
 * @author Baltan
 * @date 2024/12/9 22:35
 */
public class MinOperations26 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{5, 2, 5, 4, 5}, 2));
        System.out.println(minOperations(new int[]{2, 1, 2}, 2));
        System.out.println(minOperations(new int[]{9, 7, 5, 3}, 1));
    }

    public static int minOperations(int[] nums, int k) {
        int result = 0;
        /**
         * counts[i]表示数组nums中元素i的个数
         */
        int[] counts = new int[101];
        /**
         * 假设数组中存在元素k<x<y<z，则依次操作令合法数为y、x、k即可
         */
        for (int num : nums) {
            /**
             * 因为每次操作总是使数组nums中指定的元素变小，所以小于k的数不可能变为k
             */
            if (num < k) {
                return -1;
            }

            if (num > k && counts[num] == 0) {
                result++;
            }
            counts[num]++;
        }
        return result;
    }
}
