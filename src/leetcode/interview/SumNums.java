package leetcode.interview;

/**
 * Description: 面试题64. 求1+2+…+n
 *
 * @author Baltan
 * @date 2020-05-22 22:10
 */
public class SumNums {
    public static void main(String[] args) {
        System.out.println(sumNums(3));
        System.out.println(sumNums(9));
        System.out.println(sumNums(10000));
    }

    public static int sumNums(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }
}
