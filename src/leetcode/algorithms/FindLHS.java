package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 594. Longest Harmonious Subsequence
 *
 * @author Baltan
 * @date 2018/1/4 21:50
 */
public class FindLHS {
    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        System.out.println(findLHS(new int[]{1}));
        System.out.println(findLHS(new int[]{1, 3}));
        System.out.println(findLHS(new int[]{1, 2}));
        System.out.println(findLHS(new int[]{1, 1, 1, 1}));
        System.out.println(findLHS(new int[]{1, 1, 3, 3}));
    }

    public static int findLHS(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.get(nums[i]) == null) {
                numsMap.put(nums[i], 1);
            } else {
                numsMap.put(nums[i], numsMap.get(nums[i]) + 1);
            }
        }
        for (int num : numsMap.keySet()) {
            if (numsMap.containsKey(num + 1)) {
                maxLength =
                        maxLength > numsMap.get(num + 1) + numsMap.get(num) ? maxLength : numsMap.get(num + 1) + numsMap.get(num);
            }
        }
        return maxLength;
    }
}
