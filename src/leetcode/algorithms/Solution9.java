package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Description: 519. Random Flip Matrix
 *
 * @author Baltan
 * @date 2019-12-01 11:30
 */
public class Solution9 {
    private Random rand;
    /**
     * 保存已经被翻转的格子对应的序号
     */
    private Set<Integer> isFlipped;
    /**
     * 格子的总数，每个格子对应的序号为0，1，2，……，total-1
     */
    private int total;
    /**
     * 矩阵的列数
     */
    private int cols;

    public Solution9(int n_rows, int n_cols) {
        rand = new Random();
        isFlipped = new HashSet<>();
        total = n_rows * n_cols;
        cols = n_cols;
    }

    public int[] flip() {
        /**
         * 如果所有格子都已经被翻转，无法获得新的可以被翻转的格子
         */
        if (isFlipped.size() == total) {
            return null;
        }

        while (true) {
            /**
             * 随机产生一个将要被翻转的格子的序号
             */
            int order = rand.nextInt(total);

            if (!isFlipped.contains(order)) {
                isFlipped.add(order);
                /**
                 * 该序号的格子在矩阵中的行索引
                 */
                int row = order / cols;
                /**
                 * 该序号的格子在矩阵中的列索引
                 */
                int col = order % cols;
                return new int[]{row, col};
            }
        }
    }

    public void reset() {
        /**
         * 将保存已经被翻转的格子对应的序号的集合清空
         */
        isFlipped.clear();
    }

    public static void main(String[] args) {
        Solution9 solution91 = new Solution9(2, 3);
        OutputUtils.print1DIntegerArray(solution91.flip());
        OutputUtils.print1DIntegerArray(solution91.flip());
        OutputUtils.print1DIntegerArray(solution91.flip());
        OutputUtils.print1DIntegerArray(solution91.flip());

        System.out.println("---------------------");

        Solution9 solution92 = new Solution9(1, 2);
        OutputUtils.print1DIntegerArray(solution92.flip());
        OutputUtils.print1DIntegerArray(solution92.flip());
        solution92.reset();
        OutputUtils.print1DIntegerArray(solution92.flip());
    }
}
