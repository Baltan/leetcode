package leetcode.algorithms;

/**
 * Description: 650. 2 Keys Keyboard
 *
 * @author Baltan
 * @date 2019-10-24 09:47
 */
public class MinSteps1 {
    public static void main(String[] args) {
        System.out.println(minSteps(1));
        System.out.println(minSteps(2));
        System.out.println(minSteps(3));
        System.out.println(minSteps(4));
        System.out.println(minSteps(5));
        System.out.println(minSteps(6));
        System.out.println(minSteps(7));
        System.out.println(minSteps(8));
        System.out.println(minSteps(9));
        System.out.println(minSteps(10));
        System.out.println(minSteps(25));
        System.out.println(minSteps(50));
        System.out.println(minSteps(97));
        System.out.println(minSteps(100));
        System.out.println(minSteps(499));
        System.out.println(minSteps(500));
        System.out.println(minSteps(1000));
    }

    public static int minSteps(int n) {
        int result = 0;
        int factor = 2;

        while (n != 1) {
            /**
             * 如果n有因数factor，那么n可以通过n/factor复制1次，再粘贴factor-1次获得，即factor次操作，为了让factor
             * 尽可能小，将factor从2开始依次递增循环
             */
            while (n % factor == 0) {
                result += factor;
                n /= factor;
            }
            factor++;
        }
        return result;
    }
}
