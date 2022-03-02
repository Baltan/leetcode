package leetcode.algorithms;

/**
 * Description: 1925. Count Square Sum Triples
 *
 * @author Baltan
 * @date 2022/3/2 09:27
 */
public class CountTriples {
    public static void main(String[] args) {
        System.out.println(countTriples(5));
        System.out.println(countTriples(10));
    }

    public static int countTriples(int n) {
        int result = 0;
        /**
         * 在[2,n]范围内枚举c
         */
        for (int c = 2; c <= n; c++) {
            /**
             * 在[1,c]范围内枚举a
             */
            for (int a = 1; a < c; a++) {
                int value = c * c - a * a;
                /**
                 * 判断value是否是平方数
                 */
                if (Math.sqrt(value) % 1 == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
