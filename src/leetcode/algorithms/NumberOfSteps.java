package leetcode.algorithms;

/**
 * Description: 1342. Number of Steps to Reduce a Number to Zero
 *
 * @author Baltan
 * @date 2020-02-09 10:34
 */
public class NumberOfSteps {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfSteps(8));
        System.out.println(numberOfSteps(123));
        System.out.println(numberOfSteps(1000000));
        System.out.println(numberOfSteps(999997));
    }

    public static int numberOfSteps(int num) {
        /**
         * 操作步数
         */
        int result = 0;
        /**
         * 按照规则操作，直到num变为0，记录操作的步数
         */
        while (num != 0) {
            if ((num & 1) == 1) {
                num -= 1;
            } else {
                num >>= 1;
            }
            result++;
        }
        return result;
    }
}
