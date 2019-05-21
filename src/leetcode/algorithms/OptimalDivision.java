package leetcode.algorithms;

/**
 * Description: 553. Optimal Division
 *
 * @author Baltan
 * @date 2018/1/11 15:21
 */
public class OptimalDivision {
    public static void main(String[] args) {
        System.out.println(optimalDivision(new int[]{3}));
        System.out.println(optimalDivision(new int[]{10, 2}));
        System.out.println(optimalDivision(new int[]{1000, 100, 10, 2}));
    }

    public static String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length - 1; i++) {
            sb.append(nums[i]).append("/");
            if (i == 0 && nums.length > 2) {
                sb.append("(");
            }
        }
        sb.append(nums[nums.length - 1]);
        if (nums.length > 2) {
            sb.append(")");
        }
        return sb.toString();
    }
}
