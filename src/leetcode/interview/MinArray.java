package leetcode.interview;

/**
 * Description: 剑指 Offer 11. 旋转数组的最小数字
 *
 * @author Baltan
 * @date 2020-07-22 22:14
 * @see leetcode.algorithms.FindMin
 * @see leetcode.algorithms.FindMin1
 */
public class MinArray {
    public static void main(String[] args) {
        System.out.println(minArray(new int[]{3, 3, 1, 3}));
        System.out.println(minArray(new int[]{3, 1}));
        System.out.println(minArray(new int[]{1, 3, 5}));
        System.out.println(minArray(new int[]{2, 2, 2, 0, 1}));
        System.out.println(minArray(new int[]{5, 5, 5, 6, 7, 8, 1, 2, 3, 4, 5, 5}));
        System.out.println(minArray(new int[]{5, 5, 5, 5, 5, 6, 7, 8, 1, 2, 3, 4}));
        System.out.println(minArray(new int[]{6, 7, 8, 1, 2, 3, 4, 5, 5, 5, 5, 5}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/"></a>
     *
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        int length = numbers.length;
        int lo = 0;
        int hi = length - 1;
        /**
         * 如果nums[mid]小于nums[hi]，则nums[mid]右侧的元素都大于它，数组最小值在nums[mid]及其左侧的元素中，
         * 所以在mid左侧的子数组中（含nums[mid]）继续查找；如果nums[mid]大于nums[hi]，则nums[mid]一定在旋转
         * 前数组的右半部分中，并且nums[mid]左侧的所有元素也都在旋转前数组的右半部分中，旋转后最小值在nums[mid]
         * 的右侧，所以在mid右侧的子数组中（不含nums[mid]）继续查找；如果nums[mid]等于nums[hi]，排除nums[hi]
         * 后在剩下的元素中继续查找
         */
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (numbers[mid] < numbers[hi]) {
                hi = mid;
            } else if (numbers[mid] > numbers[hi]) {
                lo = mid + 1;
            } else {
                hi--;
            }
        }
        return numbers[lo];
    }
}
