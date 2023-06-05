package leetcode.algorithms;

/**
 * Description: 2717. Semi-Ordered Permutation
 *
 * @author Baltan
 * @date 2023/6/4 18:07
 */
public class SemiOrderedPermutation {
    public static void main(String[] args) {
        System.out.println(semiOrderedPermutation(new int[]{2, 1, 4, 3}));
        System.out.println(semiOrderedPermutation(new int[]{2, 4, 1, 3}));
        System.out.println(semiOrderedPermutation(new int[]{1, 3, 4, 2, 5}));
    }

    public static int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        /**
         * 数字1最原始的索引位置
         */
        int x = -1;
        /**
         * 数字n最原始的索引位置
         */
        int y = -1;
        /**
         * 查找数字1和n在数组nums中最原始的索引位置
         */
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                x = i;
            } else if (nums[i] == n) {
                y = i;
            }
        }
        /**
         * 最终需要将数字1从索引x处移到索引0处，共需x次操作；将数字n从索引y处移到索引n-1处，共需n-1-y次操作。但是如果在移动的过程中两个数字
         * 会相遇，即x>y，则存在某一次操作就是交换数字1和数字n，此时只用了一次操作就使得两个数字都离目标位置更近了，所以要减1
         */
        return x < y ? x + (n - 1 - y) : x + (n - 1 - y) - 1;
    }
}
