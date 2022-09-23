package leetcode.algorithms;

/**
 * Description: 1646. Get Maximum in Generated Array
 *
 * @author Baltan
 * @date 2022/9/16 20:48
 */
public class GetMaximumGenerated {
    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));
        System.out.println(getMaximumGenerated(2));
        System.out.println(getMaximumGenerated(3));
        System.out.println(getMaximumGenerated(100));
    }

    public static int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int result = nums[1];
        /**
         * 计算数组nums中的每个元素
         */
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            result = Math.max(result, nums[i]);
        }
        return result;
    }
}
