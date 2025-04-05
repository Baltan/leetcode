package leetcode.algorithms;

/**
 * Description: 3487. Maximum Unique Subarray Sum After Deletion
 *
 * @author baltan
 * @date 2025/4/4 23:51
 */
public class MaxSum5 {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxSum(new int[]{1, 1, 0, 1, 1}));
        System.out.println(maxSum(new int[]{1, 2, -1, -2, 1, 0, -1}));
    }

    public static int maxSum(int[] nums) {
        int result = 0;
        /**
         * 数组nums中的最大元素
         */
        int max = Integer.MIN_VALUE;
        /**
         * isVisited[i]表示正数i在数组nums中是否出现过，根据题意，i∈[1,100]
         */
        boolean[] isVisited = new boolean[101];

        for (int num : nums) {
            max = Math.max(max, num);

            if (num >= 0 && !isVisited[num]) {
                isVisited[num] = true;
                result += num;
            }
        }
        /**
         * 如果result为0，说明数组nums中不存在大于0的元素，为了使得子数组中元素和最大，子数组中只保留唯一一个数组nums中的最大元素即可
         */
        return result > 0 ? result : max;
    }
}
