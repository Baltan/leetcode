package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 646. Maximum Length of Pair Chain
 *
 * @author Baltan
 * @date 2020-02-11 11:45
 */
public class FindLongestChain {
    public static void main(String[] args) {
        int[][] pairs1 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(findLongestChain(pairs1));

        int[][] pairs2 = {{Integer.MIN_VALUE, Integer.MIN_VALUE + 1}, {Integer.MIN_VALUE + 2,
                Integer.MIN_VALUE + 3}};
        System.out.println(findLongestChain(pairs2));
    }

    public static int findLongestChain(int[][] pairs) {
        int result = 0;
        /**
         * 将所有数对按照第二个元素升序排列
         */
        Arrays.sort(pairs, Comparator.comparingInt(x -> x[1]));
        /**
         * 数对链最后一个数对的第二个元素的值，初始化该值为Long.MIN_VALUE，即使pairs[0][0]为
         * Integer.MIN_VALUE，也能保证判断结果为pair[0][0]>prev
         */
        long prev = Long.MIN_VALUE;
        /**
         * 如果当前数对第一个元素比数对链最后一个数对的第二个元素大，就将当前数对加到数对链最后，
         * 因为pairs是按照数对的第二个元素升序排列的，所以前面的数对加入到数对链中总是保证比后
         * 面的数对加入到数对链中后的prev值小，即可能得到更长的数对链
         */
        for (int[] pair : pairs) {
            if (pair[0] > prev) {
                result++;
                prev = pair[1];
            }
        }
        return result;
    }
}
