package leetcode.algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Description: 2593. Find Score of an Array After Marking All Elements
 *
 * @author Baltan
 * @date 2023/3/19 12:28
 */
public class FindScore {
    public static void main(String[] args) {
        System.out.println(findScore(new int[]{2, 1, 3, 4, 5, 2}));
        System.out.println(findScore(new int[]{2, 3, 5, 1, 3, 2}));
    }

    public static long findScore(int[] nums) {
        long result = 0L;
        int length = nums.length;
        /**
         * isMarked[i]表示元素nums[i]是否被标记过
         */
        boolean[] isMarked = new boolean[length];
        /**
         * 索引数组[0,1,2,……,length-1]
         */
        Integer[] indexes = IntStream.range(0, length).boxed().toArray(Integer[]::new);
        /**
         * 将索引数组indexes按照索引对应数组nums中的元素升序排列，如果对应元素相等则按照索引大小升序排列
         */
        Arrays.sort(indexes, (x, y) -> nums[x] == nums[y] ? x - y : nums[x] - nums[y]);

        for (int index : indexes) {
            if (isMarked[index]) {
                continue;
            }
            /**
             * 剩余索引中第一个未被标记的
             */
            result += nums[index];
            isMarked[index] = true;
            /**
             * 标记相邻索引
             */
            if (index - 1 >= 0) {
                isMarked[index - 1] = true;
            }

            if (index + 1 < length) {
                isMarked[index + 1] = true;
            }
        }
        return result;
    }
}
