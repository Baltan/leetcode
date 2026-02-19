package leetcode.algorithms;

/**
 * Description: 3810. Minimum Operations to Reach Target Array
 *
 * @author baltan
 * @date 2026/2/19 12:08
 */
public class MinOperations34 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 2, 3}, new int[]{2, 1, 3}));
        System.out.println(minOperations(new int[]{4, 1, 4}, new int[]{5, 1, 4}));
        System.out.println(minOperations(new int[]{7, 3, 7}, new int[]{5, 5, 9}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-operations-to-reach-target-array/solutions/"></a>
     *
     * @param nums
     * @param target
     * @return
     */
    public static int minOperations(int[] nums, int[] target) {
        int result = 0;
        boolean[] isVisited = new boolean[100001];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (!isVisited[num] && num != target[i]) {
                result++;
                isVisited[num] = true;
            }
        }
        return result;
    }
}
