package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Description: 2659. Make Array Empty
 *
 * @author Baltan
 * @date 2023/5/3 14:08
 */
public class CountOperationsToEmptyArray {
    public static void main(String[] args) {
        System.out.println(countOperationsToEmptyArray(new int[]{-15, -19, 5}));
        System.out.println(countOperationsToEmptyArray(new int[]{3, 4, -1}));
        System.out.println(countOperationsToEmptyArray(new int[]{1, 2, 4, 3}));
        System.out.println(countOperationsToEmptyArray(new int[]{1, 2, 3}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/make-array-empty/solutions/2250783/shu-zhuang-shu-zu-mo-ni-pythonjavacgo-by-ygvb/"></a>
     *
     * @param nums
     * @return
     */
    public static long countOperationsToEmptyArray(int[] nums) {
        int length = nums.length;
        /**
         * 删除操作共length次
         */
        long result = length;
        /**
         * 数组nums中所有元素的索引，并且将所有索引按照其对应在nums中的元素升序排列
         */
        Integer[] indexes = IntStream.range(0, length).boxed().toArray(Integer[]::new);
        Arrays.sort(indexes, Comparator.comparingInt(x -> nums[x]));

        for (int i = 1; i < length; i++) {
            /**
             * 例如：nums=[1,2,4,3]，则indexes=[0,1,3,2]
             * 如果indexes[i]小于indexes[i-1]，说明想要删除元素nums[indexes[i-1]]，必须先将nums[indexes[i-1]]移动到最后，等到删除了
             * nums[indexes[i]]，再绕一圈回来删nums[indexes[i-1]]。如果不考虑此前已被删除的数字，则绕一圈要进行length次移动操作，但是此
             * 时其实已经删除了数组nums中索引值在[indexes[0],indexes[i-1]]范围内的i个数字，所以实际只需要length-i次移动操作
             */
            if (indexes[i] < indexes[i - 1]) {
                result += length - i;
            }
        }
        return result;
    }
}
