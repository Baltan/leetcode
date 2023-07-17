package leetcode.algorithms;

/**
 * Description: 2779. Maximum Beauty of an Array After Applying Operation
 *
 * @author Baltan
 * @date 2023/7/16 17:40
 */
public class MaximumBeauty1 {
    public static void main(String[] args) {
        System.out.println(maximumBeauty(new int[]{4, 6, 1, 2}, 2));
        System.out.println(maximumBeauty(new int[]{1, 1, 1, 1}, 10));
    }

    public static int maximumBeauty(int[] nums, int k) {
        /**
         * 根据题意，nums[i]-k∈[-100000,100000]，nums[i]-k∈[0,200000]，取并集的[-100000,200000]。
         * diffs[0]+diffs[1]+diffs[2]+……+diffs[i]表示最终能变为数字i-100000的元素的个数，即假设存在数组arr，arr[i]表示最终能变为数
         * 字i-100000的元素的个数，则数组diff为数组arr对应的差分数组
         */
        int[] diffs = new int[300002];
        int offset = 100000;
        /**
         * 计算差分数组
         */
        for (int num : nums) {
            /**
             * 元素num可能变为的最小数字
             */
            int min = num - k;
            /**
             * 元素num可能变为的最大数字
             */
            int max = num + k;
            diffs[min + offset]++;
            diffs[max + offset + 1]--;
        }
        int result = diffs[0];
        int sum = diffs[0];
        /**
         * 由差分数组还原得到数组arr，从而得到最终可能出现最多的次数
         */
        for (int i = 1; i < 300002; i++) {
            sum += diffs[i];
            result = Math.max(result, sum);
        }
        return result;
    }
}
