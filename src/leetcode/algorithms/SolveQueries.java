package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 3488. Closest Equal Element Queries
 *
 * @author Baltan
 * @date 2025/4/2 23:30
 */
public class SolveQueries {
    public static void main(String[] args) {
        System.out.println(solveQueries(new int[]{15, 1, 10, 1, 20, 4, 6, 14, 4, 9, 4, 18}, new int[]{0, 2, 10, 6, 11, 8}));
        System.out.println(solveQueries(new int[]{1, 3, 1, 4, 1, 3, 2}, new int[]{0, 3, 5}));
        System.out.println(solveQueries(new int[]{1, 2, 3, 4}, new int[]{0, 1, 2, 3}));
    }

    public static List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> result = new ArrayList<>(queries.length);
        int max = Arrays.stream(nums).max().getAsInt();
        /**
         * indexesArray[i]升序保存数组nums中所有元素i的索引值，如果数组nums中不存在元素i，则indexesArray[i]为null
         */
        List<Integer>[] indexesArray = new List[max + 1];

        for (int i = 0; i < nums.length; i++) {
            if (indexesArray[nums[i]] == null) {
                indexesArray[nums[i]] = new ArrayList<>();
            }
            indexesArray[nums[i]].add(i);
        }

        for (int index : queries) {
            int num = nums[index];
            /**
             * 数组nums中只存在唯一的元素num，即元素nums[index]
             */
            if (indexesArray[num].size() == 1) {
                result.add(-1);
                continue;
            }
            List<Integer> indexes = indexesArray[num];
            int lo = 0;
            int hi = indexes.size() - 1;
            /**
             * 二分查找当前nums[index]在数组nums中的索引值在索引数组indexes中的索引位置
             */
            while (lo <= hi) {
                int mid = (lo + hi) / 2;

                if (indexes.get(mid) < index) {
                    lo = mid + 1;
                } else if (indexes.get(mid) > index) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                    break;
                }
            }

            if (lo == 0) {
                /**
                 * 元素nums[index]和数组nums中最后一个元素num的距离，元素nums[index]和数组nums中下一个元素num的距离，两者取较小值
                 */
                result.add(Math.min(index + nums.length - indexes.getLast(), indexes.get(lo + 1) - index));
            } else if (lo == indexes.size() - 1) {
                /**
                 * 元素nums[index]和数组nums中第一个元素num的距离，元素nums[index]和数组nums中上一个元素num的距离，两者取较小值
                 */
                result.add(Math.min(index - indexes.get(lo - 1), indexes.getFirst() + nums.length - index));
            } else {
                /**
                 * 元素nums[index]和数组nums中上一个元素num的距离，元素nums[index]和数组nums中下一个元素num的距离，两者取较小值
                 */
                result.add(Math.min(index - indexes.get(lo - 1), indexes.get(lo + 1) - index));
            }
        }
        return result;
    }
}
