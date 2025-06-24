package leetcode.algorithms;

/**
 * Description: 3576. Transform Array to All Equal Elements
 *
 * @author baltan
 * @date 2025/6/24 16:47
 */
public class CanMakeEqual {
    public static void main(String[] args) {
        System.out.println(canMakeEqual(new int[]{1, -1, 1}, 2));
        System.out.println(canMakeEqual(new int[]{-1, -1, 1, -1, -1, -1, 1, -1, 1}, 9));
        System.out.println(canMakeEqual(new int[]{1, -1, 1, -1, 1}, 3));
        System.out.println(canMakeEqual(new int[]{-1, -1, -1, 1, 1, 1}, 5));
    }

    public static boolean canMakeEqual(int[] nums, int k) {
        if (nums.length == 1) {
            return true;
        }
        int[] clone = nums.clone();
        /**
         * 先将clone[0]取相反数，同时也会将clone[1]取相反数
         */
        clone[0] = -clone[0];
        clone[1] = -clone[1];
        int kk = k - 1;
        return help(nums, k) || help(clone, kk);
    }

    public static boolean help(int[] nums, int k) {
        for (int i = 1; i < nums.length && k > 0; i++) {
            /**
             * 如果nums[i]和nums[i-1]不同，就将nums[i]取相反数，同时也会将nums[i+1]取相反数
             */
            if (nums[i] != nums[i - 1] && i != nums.length - 1) {
                nums[i] = -nums[i];
                nums[i + 1] = -nums[i + 1];
                k--;
            }
        }
        /**
         * 判断数组nums中的元素是否都相等
         */
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
