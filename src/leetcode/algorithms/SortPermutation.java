package leetcode.algorithms;

/**
 * Description: 3644. Maximum K to Sort a Permutation
 *
 * @author baltan
 * @date 2025/9/8 16:50
 */
public class SortPermutation {
    public static void main(String[] args) {
        System.out.println(sortPermutation(new int[]{0, 2, 3, 1}));
        System.out.println(sortPermutation(new int[]{0, 1}));
        System.out.println(sortPermutation(new int[]{0, 3, 2, 1}));
        System.out.println(sortPermutation(new int[]{0, 1, 3, 2}));
        System.out.println(sortPermutation(new int[]{3, 2, 1, 0}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-k-to-sort-a-permutation/solutions/3748592/gou-zao-ti-pythonjavacgo-by-endlesscheng-zq8z/"></a>
     *
     * @param nums
     * @return
     */
    public static int sortPermutation(int[] nums) {
        int result = (1 << 31) - 1;
        /**
         * 是否存在交换
         */
        boolean swap = false;
        /**
         * 因为最终得到排序后的数组为[0,1,2,……,n-1]，所以对于一开始i!=nums[i]的元素nums[i]必须要参与交换，所以所求的最大值k不大于这些数
         * 字按位与计算的结果。并且我们总能以元素k作为中间值，完成任意两个元素位置的交换
         */
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                result &= nums[i];
                swap = true;
            }
        }
        return swap ? result : 0;
    }
}
