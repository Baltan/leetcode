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
        boolean[] isMarked = new boolean[length];
        Integer[] indexes = IntStream.range(0, length).boxed().toArray(Integer[]::new);
        Arrays.sort(indexes, (x, y) -> nums[x] == nums[y] ? x - y : nums[x] - nums[y]);

        for (int index : indexes) {
            if (isMarked[index]) {
                continue;
            }
            result += nums[index];
            isMarked[index] = true;

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
