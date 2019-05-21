package leetcode.algorithms;

/**
 * Description: 633. Sum of Square Numbers
 *
 * @author Baltan
 * @date 2018/1/8 14:00
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(0));
        System.out.println(judgeSquareSum(4));
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(3));
    }

    public static boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        for (int i = 0; i <= Math.sqrt(c / 2); i++) {
            if (Math.sqrt(c - i * i) % 1 == 0) {
                return true;
            }
        }
        return false;
    }
}
