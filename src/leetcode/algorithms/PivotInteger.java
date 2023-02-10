package leetcode.algorithms;

/**
 * Description: 2485. Find the Pivot Integer
 *
 * @author Baltan
 * @date 2023/2/6 14:40
 */
public class PivotInteger {
    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
        System.out.println(pivotInteger(1));
        System.out.println(pivotInteger(4));
    }

    public static int pivotInteger(int n) {
        /**
         * 1+2+……+x=x+(x+1)+……+n
         * => 1+2+……+(x-1)=(x+1)+(x+2)+……+n
         * => (1+x-1)(x-1)/2=(x+1+n)(n-x)/2
         * => x(x-1)=(x+1+n)(n-x)
         * => 2(x^2)=n^2+n
         */
        double result = Math.sqrt((n * n + n) / 2);
        /**
         * 判断result是否是整数
         */
        return result % 1 == 0 ? (int) result : -1;
    }
}
