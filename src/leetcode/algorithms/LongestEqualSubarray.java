package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 2831. Find the Longest Equal Subarray
 *
 * @author baltan
 * @date 2023/8/23 15:16
 */
public class LongestEqualSubarray {
    public static void main(String[] args) {
        System.out.println(longestEqualSubarray(Arrays.asList(3, 6, 7, 4, 8, 3, 6, 7, 1, 7, 6, 1, 7, 1), 2));
        System.out.println(longestEqualSubarray(Arrays.asList(4, 2, 7, 2, 1, 7, 2), 1));
        System.out.println(longestEqualSubarray(Arrays.asList(1, 3, 2, 3, 1, 3), 3));
        System.out.println(longestEqualSubarray(Arrays.asList(1, 1, 2, 2, 1, 1), 2));
    }

    public static int longestEqualSubarray(List<Integer> nums, int k) {
        int result = 0;
        int size = nums.size();
        /**
         * 根据题意，数组nums中元素∈[1,max]
         */
        int max = nums.size();
        /**
         * indexesList[i]中升序保存数组nums中所有元素i的索引值
         */
        List<Integer>[] indexesList = new List[max + 1];

        for (int i = 0; i < size; i++) {
            int num = nums.get(i);

            if (indexesList[num] == null) {
                indexesList[num] = new ArrayList<>();
            }
            indexesList[num].add(i);
        }

        for (List<Integer> indexes : indexesList) {
            if (indexes == null) {
                continue;
            }
            int length = indexes.size();

            for (int i = 0; i < length; i++) {
                /**
                 * 对于数组nums中索引值为indexes[i]的元素x，在数组indexes大于等于indexes[i]的元素中，找到最大值indexes[j]，使得数组
                 * nums中索引值为indexes[j]的元素y和元素x之间不等于x和y的元素个数不超过k个。在这种情况下，删除x和y之间的这部分元素就可以
                 * 得到一个等值子数组，子数组的长度为j-i+1
                 */
                int farthest = binarySearch(indexes, i, k);
                result = Math.max(result, farthest - i + 1);
            }
        }
        return result;
    }

    /**
     * 在数组indexes大于等于indexes[from]的元素中，找到最大值indexes[j]，使得原数组nums中索引值为indexes[from]和indexes[j]的元素x和
     * y之间不等于x和y的元素个数不超过k个
     *
     * @param indexes
     * @param from
     * @param k
     * @return
     */
    public static int binarySearch(List<Integer> indexes, int from, int k) {
        int lo = from;
        int hi = indexes.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            /**
             * 原数组nums中，假设索引值为indexes[from]和indexes[mid]的元素为x，索引值在[indexes[from],indexes[mid]]之间的元素一共
             * indexes[mid]-indexes[from]+1个，其中值等于x的元素一共mid-from+1个，所以需要被删除的元素一共indexes[mid]-
             * indexes[from]-(mid-from)个
             */
            if (indexes.get(mid) - indexes.get(from) - (mid - from) > k) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
