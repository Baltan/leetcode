package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1248. Count Number of Nice Subarrays
 *
 * @author Baltan
 * @date 2019-11-06 08:46
 */
public class NumberOfSubarrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 1, 1};
        System.out.println(numberOfSubarrays(nums1, 3));

        int[] nums2 = {2, 4, 6};
        System.out.println(numberOfSubarrays(nums2, 1));

        int[] nums3 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        System.out.println(numberOfSubarrays(nums3, 2));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        /**
         * 按顺序保存数组中每个奇数所在位置的索引
         */
        List<Integer> oddNumIndexList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if ((nums[i] & 1) == 1) {
                oddNumIndexList.add(i);
            }
        }

        int size = oddNumIndexList.size();
        /**
         * 首先确定oddNumIndexList中的连续的k个值，这k个索引即数组nums中的k个奇数，在第1个的奇数的左边和第k个奇数
         * 的右边添加数组中的偶数或者不添加数字，构成的子数组即为优美子数组
         */
        for (int i = 0; i <= size - k; i++) {
            /**
             * 第1个奇数在数组中的索引位置
             */
            int leftIndex = oddNumIndexList.get(i);
            /**
             * 第k个奇数在数组中的索引位置
             */
            int rightIndex = oddNumIndexList.get(i + k - 1);
            /**
             * 在第1个奇数的左边添加数组中的偶数或者不添加数字，有leftChoices种操作
             */
            int leftChoices = i == 0 ? leftIndex + 1 : leftIndex - oddNumIndexList.get(i - 1);
            /**
             * 在第k个奇数的右边添加数组中的偶数或者不添加数字，有rightChoices种操作
             */
            int rightChoices =
                    i + k - 1 == size - 1 ? length - rightIndex : oddNumIndexList.get(i + k) - rightIndex;
            /**
             * 对于这k个连续奇数，可以构成leftChoices*rightChoices个完美子数组
             */
            result += leftChoices * rightChoices;
        }
        return result;
    }
}
