package leetcode.algorithms;

/**
 * Description: 2769. Find the Maximum Achievable Number
 *
 * @author Baltan
 * @date 2023/7/10 23:10
 */
public class TheMaximumAchievableX {
    public static void main(String[] args) {
        System.out.println(theMaximumAchievableX(4, 1));
        System.out.println(theMaximumAchievableX(3, 2));
    }

    public static int theMaximumAchievableX(int num, int t) {
        /**
         * 每次操作总是令num加1，令x减1，最终在t次操作后使得num等于x
         */
        return num + 2 * t;
    }
}
