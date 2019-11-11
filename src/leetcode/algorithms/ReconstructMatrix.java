package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1253. Reconstruct a 2-Row Binary Matrix
 *
 * @author Baltan
 * @date 2019-11-11 09:45
 */
public class ReconstructMatrix {
    public static void main(String[] args) {
        int[] colsum1 = {1, 1, 1};
        System.out.println(reconstructMatrix(2, 1, colsum1));

        int[] colsum2 = {2, 2, 1, 1};
        System.out.println(reconstructMatrix(2, 3, colsum2));

        int[] colsum3 = {2, 1, 2, 0, 1, 0, 1, 2, 0, 1};
        System.out.println(reconstructMatrix(5, 5, colsum3));

        int[] colsum4 = {0, 1, 2, 0, 0, 0, 0, 0, 2, 1, 2, 1, 2};
        System.out.println(reconstructMatrix(9, 2, colsum4));
    }

    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new LinkedList<>();
        /**
         * 所有列的和
         */
        int sum = 0;
        int length = colsum.length;
        /**
         * 保存和为1的列的索引
         */
        List<Integer> oneList = new LinkedList<>();
        /**
         * 保存和为2的列的索引
         */
        List<Integer> twoList = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            sum += colsum[i];

            if (colsum[i] == 2) {
                twoList.add(i);
            } else if (colsum[i] == 1) {
                oneList.add(i);
            }
        }
        /**
         * 如果所有列的和与两行元素之和不相等，一定无法构造符合要求的矩阵
         */
        if (upper + lower != sum) {
            return result;
        }

        int[] upperArray = new int[length];
        int[] lowerArray = new int[length];
        List<Integer> upperList = new LinkedList<>();
        List<Integer> lowerList = new LinkedList<>();
        /**
         * 对于和为2的列，矩阵第0行和第1行在该列的值都为1
         */
        for (int index : twoList) {
            upperArray[index] = 1;
            lowerArray[index] = 1;
            upper--;
            lower--;
        }
        /**
         * 对于和为1的列，优先考虑将矩阵第0行在该列的值设为1，如果第0行的和已经达到upper了，就将矩阵第1行在该列
         * 的值设为1
         */
        for (int index : oneList) {
            if (upper > 0) {
                upperArray[index] = 1;
                upper--;
            } else {
                lowerArray[index] = 1;
                lower--;
            }
        }

        for (int i = 0; i < length; i++) {
            upperList.add(upperArray[i]);
            lowerList.add(lowerArray[i]);
        }
        /**
         * 如果第0行或者第1行的和不符合要求，说明无法构造符合要求的矩阵
         */
        if (upper != 0 || lower != 0) {
            return result;
        }
        result.add(upperList);
        result.add(lowerList);
        return result;
    }
}
