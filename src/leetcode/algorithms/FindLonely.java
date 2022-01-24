package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2150. Find All Lonely Numbers in the Array
 *
 * @author Baltan
 * @date 2022/1/24 09:41
 */
public class FindLonely {
    public static void main(String[] args) {
        System.out.println(findLonely(new int[]{10, 6, 5, 8}));
        System.out.println(findLonely(new int[]{1, 3, 5, 3}));
    }

    public static List<Integer> findLonely(int[] nums) {
        List<Integer> result = new ArrayList<>();
        /**
         * 数组nums中的最小值
         */
        int max = Integer.MIN_VALUE;
        /**
         * 数组nums中的最大值
         */
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        /**
         * count[i]表示数组nums中数字i+min出现的次数
         */
        int[] count = new int[max - min + 1];
        /**
         * 统计数组nums中每个数字出现的次数
         */
        for (int num : nums) {
            count[num - min]++;
        }

        for (int num : nums) {
            /**
             * 如果数字num在数组nums中出现不止一次，不符合要求
             */
            if (count[num - min] != 1) {
                continue;
            }
            /**
             * 如果数组nums中存在数字num-1，不符合要求
             */
            if (num > min && count[num - min - 1] != 0) {
                continue;
            }
            /**
             * 如果数组nums中存在数字num+1，不符合要求
             */
            if (num < max && count[num - min + 1] != 0) {
                continue;
            }
            result.add(num);
        }
        return result;
    }
}
