package leetcode.algorithms;

/**
 * Description: 1975. Maximum Matrix Sum
 *
 * @author Baltan
 * @date 2022/1/22 21:44
 */
public class MaxMatrixSum {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, -1}, {-1, 1}};
        System.out.println(maxMatrixSum(matrix1));

        int[][] matrix2 = {{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}};
        System.out.println(maxMatrixSum(matrix2));

        int[][] matrix3 = {{2, 9, 3}, {5, 4, -4}, {1, 7, 1}};
        System.out.println(maxMatrixSum(matrix3));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/maximum-matrix-sum/solution/zui-da-fang-zhen-he-by-leetcode-solution-5xnx/"></a>
     * 对于matrix中的任意两个数x和y，总能找到一条以x和y作为两个端点的路径，在这条路径上，将每个相邻的数对都进行一次"乘以-1"的操
     * 作，这样一来，x和y被乘了一次-1变成了相反数，其他数都被乘了两次-1值不变。
     * 1、当matrix中有0时，总可以找到一条路径，一端为0，另一端为一个负数，进行以上操作，从而使得所有非0值都变为正数；
     * 2、当matrix中不包含0，但是负数个数为偶数时，总可以找到若干条路径，两端都为负数，进行以上操作，从而使得所有数都变为正数；
     * 3、当matrix中不包含0，但是负数个数为奇数时，总可以找到若干条路径，进行以上操作，使得最后matrix中只有一个负数，但是这个负
     * 数是matrix中可能得到的最大的负数（可能是原来就有的负数，也可能是原来的正数通过一次"乘以-1"的操作得到）
     *
     * @param matrix
     * @return
     */
    public static long maxMatrixSum(int[][] matrix) {
        /**
         * matrix中所有元素的绝对值之和
         */
        long absoluteSum = 0L;
        /**
         * matrix中是否含有元素0
         */
        boolean hasZero = false;
        /**
         * matrix中通过变换可能得到的最大负数
         */
        int maxNegative = Integer.MIN_VALUE;
        /**
         * matrix中负数的个数
         */
        int negativeCount = 0;

        for (int[] row : matrix) {
            for (int num : row) {
                absoluteSum += Math.abs(num);

                if (num == 0) {
                    hasZero = true;
                } else if (num < 0) {
                    negativeCount++;
                    maxNegative = Math.max(maxNegative, num);
                } else {
                    /**
                     * 原来的正数通过一次"乘以-1"的操作得到尽可能大的负数
                     */
                    maxNegative = Math.max(maxNegative, -num);
                }
            }
        }

        if (hasZero || negativeCount % 2 == 0) {
            return absoluteSum;
        } else {
            /**
             * 唯一的负数被取绝对值加入了absoluteSum中，所以需要双倍扣除
             */
            return absoluteSum + 2 * maxNegative;
        }
    }
}
