package leetcode.algorithms;

/**
 * Description: 779. K-th Symbol in Grammar
 *
 * @author Baltan
 * @date 2020-01-29 12:20
 */
public class KthGrammar {
    public static void main(String[] args) {
        System.out.println(kthGrammar(1, 1));
        System.out.println(kthGrammar(2, 1));
        System.out.println(kthGrammar(2, 2));
        System.out.println(kthGrammar(4, 5));
        System.out.println(kthGrammar(30, 1000));
        System.out.println(kthGrammar(10, 100));
    }

    public static int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        /**
         * 第N层的第K（1-based）个数只与第N-1层的第(K+1)/2个数有关
         * 第N层     第N-1层
         * 1，2        1
         * 3，4        2
         * 5，6        3
         * ……          ……
         * K，K+1      (K+1)/2
         */
        int prev = kthGrammar(N - 1, (K + 1) / 2);

        if (prev == 0) {
            if ((K & 1) == 1) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if ((K & 1) == 1) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
