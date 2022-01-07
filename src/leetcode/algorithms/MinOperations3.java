package leetcode.algorithms;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: 2009. Minimum Number of Operations to Make Array Continuous
 *
 * @author Baltan
 * @date 2022/1/7 09:20
 */
public class MinOperations3 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{8, 5, 9, 9, 8, 4}));
        System.out.println(minOperations(new int[]{4, 2, 5, 3}));
        System.out.println(minOperations(new int[]{1, 2, 3, 5, 6}));
        System.out.println(minOperations(new int[]{1, 10, 100, 1000}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/minimum-number-of-operations-to-make-array-continuous/solution/qu-zhong-pai-xu-by-faded828x-95k0/"></a>
     *
     * @param nums
     * @return
     */
    public static int minOperations(int[] nums) {
        int result = Integer.MAX_VALUE;
        /**
         * 对nums中的元素去重并排序
         */
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toCollection(TreeSet::new));
        List<Integer> numList = new ArrayList<>(numSet);
        int size = numList.size();
        /**
         * nums中重复的元素数量，这部分元素是一定要修改的
         */
        int duplicateCount = nums.length - numSet.size();

        for (int i = 0; i < size; i++) {
            /**
             * 假设最终连续数组中的最小值为start，则最大值为end
             */
            int start = numList.get(i);
            int end = start + nums.length - 1;
            /**
             * 在numList中查找不大于end的最大值的索引位置
             */
            int lastIndex = binarySearch(numList, i, end);
            /**
             * numList中大于end的值、nums中重复的值、numList中start之前的值都是要修改的
             */
            result = Math.min(result, size - lastIndex - 1 + duplicateCount + i);
        }
        return result;
    }

    /**
     * 在numList中查找不大于end的最大值的索引位置
     *
     * @param numList
     * @param startIndex
     * @param end
     * @return
     */
    public static int binarySearch(List<Integer> numList, int startIndex, int end) {
        int lo = startIndex;
        int hi = numList.size() - 1;

        while (lo < hi) {
            int mid = (int) Math.ceil((lo + hi) / 2.0);

            if (numList.get(mid) > end) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
