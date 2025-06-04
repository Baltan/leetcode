package leetcode.algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Description: 3551. Minimum Swaps to Sort by Digit Sum
 *
 * @author Baltan
 * @date 2025/6/2 16:28
 */
public class MinSwaps4 {
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{37, 100}));
        System.out.println(minSwaps(new int[]{22, 14, 33, 7}));
        System.out.println(minSwaps(new int[]{18, 43, 34, 16}));
    }

    public static int minSwaps(int[] nums) {
        int result = 0;
        /**
         * 数组nums的索引数组[0,1,2,……]
         */
        Integer[] indexes = IntStream.range(0, nums.length).boxed().toArray(Integer[]::new);
        int[] digitSums = Arrays.stream(nums)
                /**
                 * 将数组nums中的每个元素都映射为其各个数位上的数字之和
                 */
                .map(x -> {
                    int sum = 0;

                    while (x != 0) {
                        sum += x % 10;
                        x /= 10;
                    }
                    return sum;
                })
                .toArray();
        /**
         * 将索引数组indexes中的各个索引值按照其对应nums中的元素各个数位上之和升序排列，否则按照对应nums中的元素升序排列
         */
        Arrays.sort(indexes, (x, y) -> digitSums[x] != digitSums[y] ? digitSums[x] - digitSums[y] : nums[x] - nums[y]);
        /**
         * 遍历排序后的索引数组indexes，使其还原为最初的索引数组[0,1,2,……]
         */
        for (int i = 0; i < indexes.length; i++) {
            /**
             * 排序前，元素indexes[i]应当位于原始索引数组indexes[indexes[i]]处，所以将indexes[i]和indexes[indexes[i]]两处的索引值
             * 交换位置
             */
            while (i != indexes[i]) {
                int temp = indexes[indexes[i]];
                indexes[indexes[i]] = indexes[i];
                indexes[i] = temp;
                result++;
            }
        }
        return result;
    }
}
