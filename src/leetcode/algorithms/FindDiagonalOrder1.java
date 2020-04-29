package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

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
    }

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        /**
         * nums中各个List中数字的总个数
         */
        int totalLength = nums.stream().map(l -> l.size()).reduce(0, (value, item) -> value += item);
        int[] result = new int[totalLength];
        int index = 0;
        /**
         * 将nums中的每个List转换为Queue，其中的数字顺序不变
         */
        List<Queue<Integer>> numsList = new ArrayList<>();
        /**
         * 当前对角线从numsList剩下的第startRowIndex（0-based）个Queue开始取元素
         */
        int startRowIndex = 0;

        for (List<Integer> numList : nums) {
            Queue<Integer> queue = new LinkedList<>();

            for (int num : numList) {
                queue.offer(num);
            }
            numsList.add(queue);
        }

        /**
         * 1 2 3    2 3      3        6
         * 4 5 6 -> 4 5 6 -> 5 6   -> 8 9 -> 9
         * 7 8 9    7 8 9    7 8 9
         *
         * 1        4 2      7 5 3    8 6    9
         *
         *
         * 1 2 3      2 3        3          6 7        7          10 11   11
         * 4          4          5 6 7      8          9 10 11
         * 5 6 7   -> 5 6 7   -> 8       -> 9 10 11 ->         ->      ->
         * 8          8          9 10 11
         * 9 10 11    9 10 11
         *
         * 1          4 2        5 3        8 6        9 7        10      11
         */
        while (totalLength > 0) {
            /**
             * 如果当前对角线的第一个元素所在的队列已经是numsList的最后一个队列了，那么之后的所有对角线
             * 的第一个元素所在的队列都是numsList的最后一个队列
             */
            int rowIndex = Math.min(startRowIndex, numsList.size() - 1);
            /**
             * 从第startRowIndex（0-based）个Queue开始向前遍历依次取出所有Queue中队首的元素
             */
            for (int i = rowIndex; i >= 0; i--) {
                result[index++] = numsList.get(i).poll();
                totalLength--;
                /**
                 * 如果当前队列队首的元素取出后，队列中没有元素了，就将队列从numsList中移除
                 */
                if (numsList.get(i).isEmpty()) {
                    numsList.remove(i);
                    /**
                     * 因为numsList中少了一个队列，下一条对角线第一个元素所在的队列索引要减1
                     */
                    startRowIndex--;
                }
            }
            startRowIndex++;
        }
        return result;
    }
}
