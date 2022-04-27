package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 2248. Intersection of Multiple Arrays
 *
 * @author Baltan
 * @date 2022/4/26 22:30
 */
public class Intersection1 {
    public static void main(String[] args) {
        int[][] nums1 = {{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}};
        System.out.println(intersection(nums1));

        int[][] nums2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(intersection(nums2));
    }

    public static List<Integer> intersection(int[][] nums) {
        List<Integer> result = new LinkedList<>();
        /**
         * countArray[i]表示数字i在所有数组中出现的次数，依据题意，数组中数字的范围为[1,1000]
         */
        int[] countArray = new int[1001];
        /**
         * 统计数组中每个数字出现的次数
         */
        for (int[] num : nums) {
            for (int value : num) {
                countArray[value]++;
            }
        }

        for (int i = 0; i < countArray.length; i++) {
            /**
             * 因为nums[i]中的数字互不相同，所以当某个数字出现的次数为nums.length时，说明它在nums中的所有数组中都出现过
             */
            if (countArray[i] == nums.length) {
                result.add(i);
            }
        }
        return result;
    }
}
