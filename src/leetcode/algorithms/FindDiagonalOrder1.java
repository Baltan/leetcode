package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 1424. Diagonal Traverse II
 *
 * @author Baltan
 * @date 2020-04-29 08:07
 * @see FindDiagonalOrder
 */
public class FindDiagonalOrder1 {
    public static void main(String[] args) {
        List<List<Integer>> nums1 =
                Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
        OutputUtils.print1DIntegerArray(findDiagonalOrder(nums1));

        List<List<Integer>> nums2 =
                Arrays.asList(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 7), Arrays.asList(8),
                        Arrays.asList(9, 10, 11), Arrays.asList(12, 13, 14, 15, 16));
        OutputUtils.print1DIntegerArray(findDiagonalOrder(nums2));

        List<List<Integer>> nums3 =
                Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4), Arrays.asList(5, 6, 7),
                        Arrays.asList(8), Arrays.asList(9, 10, 11));
        OutputUtils.print1DIntegerArray(findDiagonalOrder(nums3));

        List<List<Integer>> nums4 = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6));
        OutputUtils.print1DIntegerArray(findDiagonalOrder(nums4));

        List<List<Integer>> nums4 = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6));
        OutputUtils.print1DIntegerArray(findDiagonalOrder(nums4));
    }

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        int listCount = nums.size();
        int totalLength = nums.stream().map(l -> l.size()).reduce(0, (value, item) -> value += item);
        int[] result = new int[totalLength];
        int index = 0;
        int row = 0;

        while (totalLength > 0) {
            int currentRow = row;
            int currentCol = 0;

            while (currentRow >= 0) {
                if (currentRow < listCount && currentCol < nums.get(currentRow).size()) {
                    result[index++] = nums.get(currentRow).get(currentCol);
                    totalLength--;
                }
                currentRow--;
                currentCol++;
            }
            row++;
        }
        return result;
    }
}
