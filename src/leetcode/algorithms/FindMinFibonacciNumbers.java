package leetcode.algorithms;

import java.util.LinkedList;

/**
 * Description: 1414. Find the Minimum Number of Fibonacci Numbers Whose Sum Is K
 *
 * @author Baltan
 * @date 2020-04-20 21:40
 */
public class FindMinFibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(findMinFibonacciNumbers(7));
        System.out.println(findMinFibonacciNumbers(10));
        System.out.println(findMinFibonacciNumbers(19));
    }

    /**
     * 证明参考：
     * <a href="https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/solution/tan-xin-jian-dan-zheng-ming-by-wyjoutstanding/"></a>
     *
     * @param k
     * @return
     */
    public static int findMinFibonacciNumbers(int k) {
        int result = 0;
        /**
         * 顺序保存斐波那契数列的每一项
         */
        LinkedList<Integer> list = new LinkedList<>();
        int x = 1;
        int y = 1;
        int z;
        /**
         * 依照题意，k∈[1,1000000000]，所以找到所有不大于1000000000的斐波那契数列项即可
         */
        int threshold = 1000000000;
        list.offerLast(x);
        list.offerLast(y);

        while ((z = x + y) < threshold) {
            list.offerLast(z);
            x = y;
            y = z;
        }
        /**
         * 从list中最大的斐波那契数列项开始逐一抵扣k值，直到k变为0为止
         */
        while (!list.isEmpty()) {
            if (list.peekLast() <= k) {
                k -= list.peekLast();
                result++;
            } else {
                list.pollLast();
            }

            if (k == 0) {
                break;
            }
        }
        return result;
    }
}
