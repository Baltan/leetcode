package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 506. Relative Ranks
 *
 * @author Baltan
 * @date 2018/1/3 13:25
 */
public class FindRelativeRanks {
    public static void main(String[] args) {
        OutputUtils.print1DStringArray(findRelativeRanks(new int[]{5, 4, 3, 2, 1}));
        OutputUtils.print1DStringArray(findRelativeRanks(new int[]{2, 4}));
        OutputUtils.print1DStringArray(findRelativeRanks(new int[]{5, 2, 6, 9, 1, 7}));
    }

    public static String[] findRelativeRanks(int[] nums) {
        String[] rankArray = new String[nums.length];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        if (nums.length >= 3) {
            rankArray[map.get(nums[nums.length - 1])] = "Gold Medal";
            rankArray[map.get(nums[nums.length - 2])] = "Silver Medal";
            rankArray[map.get(nums[nums.length - 3])] = "Bronze Medal";
        } else if (nums.length == 2) {
            rankArray[map.get(nums[nums.length - 1])] = "Gold Medal";
            rankArray[map.get(nums[nums.length - 2])] = "Silver Medal";
        } else if (nums.length == 1) {
            rankArray[map.get(nums[nums.length - 1])] = "Gold Medal";
        }
        for (int i = nums.length - 4; i >= 0; i--) {
            rankArray[map.get(nums[i])] = String.valueOf(nums.length - i);
        }
        return rankArray;
    }
}
