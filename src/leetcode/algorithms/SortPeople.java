package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Description: 2418. Sort the People
 *
 * @author Baltan
 * @date 2023/2/10 09:48
 */
public class SortPeople {
    public static void main(String[] args) {
        OutputUtils.print1DStringArray(sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170}));
        OutputUtils.print1DStringArray(sortPeople(new String[]{"Alice", "Bob", "Bob"}, new int[]{155, 185, 150}));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        int length = names.length;
        /**
         * 所有人的索引数组
         */
        Integer[] indexes = IntStream.range(0, length).boxed().toArray(Integer[]::new);
        /**
         * 将索引数组按照身高降序排列后，再映射到对应的人名
         */
        return Arrays.stream(indexes).sorted((x, y) -> heights[y] - heights[x]).map(x -> names[x]).toArray(String[]::new);
    }
}
