package leetcode.algorithms;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Description: 2611. Mice and Cheese
 *
 * @author Baltan
 * @date 2023/4/2 18:41
 */
public class MiceAndCheese {
    public static void main(String[] args) {
        System.out.println(miceAndCheese(new int[]{1, 1, 3, 4}, new int[]{4, 4, 1, 1}, 2));
        System.out.println(miceAndCheese(new int[]{1, 1}, new int[]{1, 1}, 2));
    }

    public static int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int result = 0;
        int length = reward1.length;
        /**
         * 将所有奶酪的索引按照reward2[x]-reward1[x]的值升序排列。挑选出排序后的前k块奶酪给第一只老鼠吃，其余奶酪给第二只老鼠吃
         */
        Integer[] indexes = IntStream.range(0, length)
                .boxed()
                .sorted(Comparator.comparingInt(x -> (reward2[x] - reward1[x])))
                .toArray(Integer[]::new);
        /**
         * 前k块奶酪给第一只老鼠吃
         */
        for (int i = 0; i < k; i++) {
            result += reward1[indexes[i]];
        }
        /**
         * 其余奶酪给第二只老鼠吃
         */
        for (int i = k; i < length; i++) {
            result += reward2[indexes[i]];
        }
        return result;
    }
}
