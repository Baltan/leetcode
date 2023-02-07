package leetcode.algorithms;

/**
 * Description: 2549. Count Distinct Numbers on Board
 *
 * @author Baltan
 * @date 2023/2/1 09:59
 */
public class DistinctIntegers {
    public static void main(String[] args) {
        System.out.println(distinctIntegers(5));
        System.out.println(distinctIntegers(3));
    }

    public static int distinctIntegers(int n) {
        /**
         * 当n为1或2时，不存在其他数字使得n%i==1，黑板上只有数字n自身
         */
        if (n == 1 || n == 2) {
            return 1;
        }
        /**
         * 每天被写上黑板的数字肯定有n-1，由于n∈[1,100]，而操作的天数有10^9天，可以确保n、n-1、n-2、……、2最终都被写上黑板
         */
        return n - 1;
    }
}
