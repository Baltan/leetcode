package leetcode.algorithms;

/**
 * Description: 2202. Maximize the Topmost Element After K Moves
 *
 * @author Baltan
 * @date 2022/3/13 18:53
 */
public class MaximumTop {
    public static void main(String[] args) {
        System.out.println(maximumTop(
                new int[]{91, 98, 17, 79, 15, 55, 47, 86, 4, 5, 17, 79, 68, 60, 60, 31, 72, 85, 25, 77, 8, 78,
                        40, 96, 76, 69, 95, 2, 42, 87, 48, 72, 45, 25, 40, 60, 21, 91, 32, 79, 2, 87, 80, 97,
                        82, 94, 69, 43, 18, 19, 21, 36, 44, 81, 99}, 2));
        System.out.println(maximumTop(new int[]{5, 2, 2, 4, 0, 6}, 4));
        System.out.println(maximumTop(new int[]{2}, 1));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/maximize-the-topmost-element-after-k-moves/solution/fen-lei-tao-lun-ji-ke-by-newhar-lba3/"></a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maximumTop(int[] nums, int k) {
        /**
         * 如果数组nums中只有一个元素，如果操作次数为奇数次，则最后数组中没有元素
         */
        if (nums.length == 1 && k % 2 == 1) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        /**
         * 数组nums中的前k-1个元素都有可能成为最后栈顶的元素
         */
        for (int i = 0; i < nums.length && i < k - 1; i++) {
            max = Math.max(max, nums[i]);
        }
        /**
         * 数组的第k+1个元素可能成为最后栈顶的元素，此时就是执行了k次出栈操作
         */
        if (k < nums.length) {
            max = Math.max(max, nums[k]);
        }
        return max;
    }
}
