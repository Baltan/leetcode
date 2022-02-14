package leetcode.algorithms;

/**
 * Description: 2169. Count Operations to Obtain Zero
 *
 * @author Baltan
 * @date 2022/2/14 09:07
 */
public class CountOperations {
    public static void main(String[] args) {
        System.out.println(countOperations(2, 3));
        System.out.println(countOperations(10, 10));
        System.out.println(countOperations(0, 100000));
        System.out.println(countOperations(99999, 100000));
        System.out.println(countOperations(3, 100000));
    }

    public static int countOperations(int num1, int num2) {
        int result = 0;

        while (num1 != 0 && num2 != 0) {
            /**
             * 较大数减去较小数
             */
            if (num1 > num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            result++;
        }
        return result;
    }
}
