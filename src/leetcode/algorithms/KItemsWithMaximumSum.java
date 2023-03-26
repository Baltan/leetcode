package leetcode.algorithms;

/**
 * Description: 2600. K Items With the Maximum Sum
 *
 * @author Baltan
 * @date 2023/3/26 14:35
 */
public class KItemsWithMaximumSum {
    public static void main(String[] args) {
        System.out.println(kItemsWithMaximumSum(3, 3, 5, 11));
        System.out.println(kItemsWithMaximumSum(3, 2, 0, 2));
        System.out.println(kItemsWithMaximumSum(3, 2, 0, 4));
    }

    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k) {
            /**
             * 取k个1
             */
            return k;
        } else if (numOnes + numZeros >= k) {
            /**
             * 取numOnes个1和k-numOnes个0
             */
            return numOnes;
        } else {
            /**
             * 取numOnes个1、numZeros个0和k-numOnes-numZeros个负1
             */
            return numOnes - (k - numOnes - numZeros);
        }
    }
}
