package leetcode.algorithms;

/**
 * Description: 3028. Ant on the Boundary
 *
 * @author Baltan
 * @date 2024/2/4 23:53
 */
public class ReturnToBoundaryCount {
    public static void main(String[] args) {
        System.out.println(returnToBoundaryCount(new int[]{2, 3, -5}));
        System.out.println(returnToBoundaryCount(new int[]{3, 2, -3, -4}));
    }

    public static int returnToBoundaryCount(int[] nums) {
        int result = 0;
        /**
         * 蚂蚁当前所在的位置
         */
        int position = 0;

        for (int num : nums) {
            position += num;
            result += position == 0 ? 1 : 0;
        }
        return result;
    }
}
