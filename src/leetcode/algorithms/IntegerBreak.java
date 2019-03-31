package leetcode.algorithms;

/**
 * Description: Integer Break
 *
 * @author Baltan
 * @date 2019-03-31 09:32
 */
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(3));
        System.out.println(integerBreak(4));
        System.out.println(integerBreak(5));
        System.out.println(integerBreak(6));
        System.out.println(integerBreak(7));
        System.out.println(integerBreak(8));
        System.out.println(integerBreak(9));
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        if (n == 2) {
            return 1 * 1;
        } else if (n == 3) {
            return 1 * 2;
        } else if (n == 4) {
            return 2 * 2;
        } else if (n == 5) {
            return 2 * 3;
        }


        int countOf3 = n / 3;
        int countOf2 = (n - countOf3 * 3) / 2;

        int product1 = (int) (Math.pow(3, countOf3) * Math.pow(2, countOf2));
        int product2 = (int) (Math.pow(3, countOf3 - 1) * integerBreak(n - 3 * (countOf3 - 1)));

        return Math.max(product1, product2);
    }
}
