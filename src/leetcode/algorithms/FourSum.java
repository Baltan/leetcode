package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 4Sum
 *
 * @author Baltan
 * @date 2018/8/30 11:15
 */
public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(
                fourSum(new int[]{1, 0, -1, 0, 0, -1, 2, 1, -1, 2, -1, 1, 1, -1, -2, -2, 2, 0, -2, 2}, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        int length = nums.length;
        if (nums[0] + nums[1] + nums[2] + nums[3] > target ||
                nums[length - 1] + nums[length - 2] + nums[length -
                        3] + nums[length - 4] < target) {
            return res;
        }

        for (int i = 0; i < length - 3 && nums[i] <= target / 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (nums[i] + nums[j] * 3 > target) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int newTarget = target - nums[i] - nums[j];
                int firstIndex = j + 1;
                int lastIndex = length - 1;
                while (firstIndex < lastIndex) {
                    if (nums[firstIndex] + nums[lastIndex] == newTarget) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[firstIndex],
                                nums[lastIndex]);
                        res.add(list);
                        do {
                            firstIndex++;
                        } while (nums[firstIndex] == nums[firstIndex - 1] && firstIndex < lastIndex);
                        do {
                            lastIndex--;
                        } while (nums[lastIndex] == nums[lastIndex + 1] && firstIndex < lastIndex);
                    } else if (nums[firstIndex] + nums[lastIndex] < newTarget) {
                        firstIndex++;
                    } else {
                        lastIndex--;
                    }
                }
            }
        }
        return res;
    }
}
