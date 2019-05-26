package leetcode.algorithms;

/**
 * Description: 1052. Grumpy Bookstore Owner
 *
 * @author Baltan
 * @date 2019-05-26 12:35
 */
public class MaxSatisfied {
    public static void main(String[] args) {
        int[] customers1 = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy1 = {0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println(maxSatisfied(customers1, grumpy1, 3));

        int[] customers2 = {4, 10, 10};
        int[] grumpy2 = {1, 1, 0};
        System.out.println(maxSatisfied(customers2, grumpy2, 2));

        int[] customers3 = {4};
        int[] grumpy3 = {1};
        System.out.println(maxSatisfied(customers3, grumpy3, 1));

        int[] customers4 = {4, 5, 6};
        int[] grumpy4 = {1, 1, 1};
        System.out.println(maxSatisfied(customers4, grumpy4, 3));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int result = 0;
        int length = customers.length;

        for (int i = 0; i < X; i++) {
            result += customers[i];
        }

        for (int i = X; i < length; i++) {
            if (grumpy[i] == 0) {
                result += customers[i];
            }
        }

        int temp = result;
        length = customers.length - X;

        for (int i = 1; i <= length; i++) {
            if (grumpy[i + X - 1] == 1) {
                temp += customers[i + X - 1];
            }

            if (grumpy[i - 1] == 1) {
                temp -= customers[i - 1];
            }
            result = Math.max(temp, result);
        }
        return result;
    }
}
