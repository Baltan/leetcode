package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2965. Find Missing and Repeated Values
 *
 * @author baltan
 * @date 2023/12/21 16:13
 */
public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}}));
        OutputUtils.print1DIntegerArray(findMissingAndRepeatedValues(new int[][]{{9, 1, 7}, {8, 9, 2}, {3, 4, 6}}));
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        int length = grid.length;
        /**
         * isVisited[i]表示数字i是否在二维数组grid中出现过
         */
        boolean[] isVisited = new boolean[length * length + 1];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                /**
                 * 数字grid[i][j]之前已出现过一次，现在是第二次出现
                 */
                if (isVisited[grid[i][j]]) {
                    result[0] = grid[i][j];
                }
                isVisited[grid[i][j]] = true;
            }
        }
        /**
         * 查找[1,length*length]中没有出现过的数字
         */
        for (int i = length * length; i >= 0; i--) {
            if (!isVisited[i]) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
