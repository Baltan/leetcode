package leetcode.algorithms;

/**
 * Description: 371. Sum of Two Integers
 *
 * @author Baltan
 * @date 2019-03-15 14:41
 * @see leetcode.interview.Add
 * @see Sum
 */
public class GetSum {
    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
        System.out.println(getSum(-2, 3));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/sum-of-two-integers/solution/wu-jin-wei-lei-jia-zhi-jin-wei-zhi-shu-ju-by-zhi-h/"></a>
     *
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }
        /**
         * a^b为a和b无进位相加之和，(a&b)<<1为a和b进位部分相加之和
         */
        return getSum(a ^ b, (a & b) << 1);
    }
}
