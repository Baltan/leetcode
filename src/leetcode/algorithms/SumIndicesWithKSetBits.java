package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Description: 2859. Sum of Values at Indices With K Set Bits
 *
 * @author baltan
 * @date 2023/9/20 15:57
 */
public class SumIndicesWithKSetBits {
    public static void main(String[] args) {
        System.out.println(sumIndicesWithKSetBits(Arrays.asList(5, 10, 1, 5, 2), 1));
        System.out.println(sumIndicesWithKSetBits(Arrays.asList(4, 3, 2, 1), 2));
    }

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        return IntStream.range(0, nums.size())
                /**
                 * 过滤出索引值的二进制表示中刚好有k个1的索引
                 */
                .filter(x -> Integer.bitCount(x) == k)
                /**
                 * 根据索引找到数组nums中对应的元素
                 */
                .map(nums::get)
                .sum();
    }
}
