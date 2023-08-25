package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 2824. Count Pairs Whose Sum is Less than Target
 *
 * @author baltan
 * @date 2023/8/23 14:35
 */
public class CountPairs4 {
    public static void main(String[] args) {
        System.out.println(countPairs(Arrays.asList(-1, 1, 2, 3, 1), 2));
        System.out.println(countPairs(Arrays.asList(-6, 2, 5, -2, -7, -1, 3), -2));
    }

    public static int countPairs(List<Integer> nums, int target) {
        int result = 0;
        int n = nums.size();
        /**
         * 将数组nums中的不同元素两两组合相加，判断和是否小于target
         */
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    result++;
                }
            }
        }
        return result;
    }
}
