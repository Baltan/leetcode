package leetcode.algorithms;

/**
 * Description: 3151. Special Array I
 *
 * @author Baltan
 * @date 2024/5/19 16:59
 * @see IsArraySpecial1
 */
public class IsArraySpecial {
    public static void main(String[] args) {
        System.out.println(isArraySpecial(new int[]{1}));
        System.out.println(isArraySpecial(new int[]{2, 1, 4}));
        System.out.println(isArraySpecial(new int[]{4, 3, 1, 6}));
    }

    public static boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            /**
             * 如果相邻两数奇偶性相同，直接返回false
             */
            if ((nums[i - 1] & 1) == (nums[i] & 1)) {
                return false;
            }
        }
        return true;
    }
}
