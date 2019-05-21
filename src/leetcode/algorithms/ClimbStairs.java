package leetcode.algorithms;

/**
 * Description: 70. Climbing Stairs
 *
 * @author Baltan
 * @date 2018/1/5 11:23
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }

    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;
        for (int i = 2; i <= n - 1; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n - 1];
    }
}
