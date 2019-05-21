package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 15. 3Sum
 *
 * @author Baltan
 * @date 2018/8/29 10:03
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-1, 0, 0, 0, 0, 1, 1, 2, 2, -1, 3, 5, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        int length = nums.length;
        if (nums[0] + nums[1] + nums[2] > 0 || nums[length - 1] + nums[length - 2] + nums[length - 3] < 0) {
            return res;
        }

        for (int i = 0; i < length && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = -nums[i];
            int firstIndex = i + 1;
            int lastIndex = length - 1;
            while (firstIndex < lastIndex) {
                if (nums[firstIndex] + nums[lastIndex] == sum) {
                    List<Integer> list = Arrays.asList(nums[i], nums[firstIndex], nums[lastIndex]);
                    res.add(list);
                    do {
                        firstIndex++;
                    } while (nums[firstIndex] == nums[firstIndex - 1] && firstIndex < lastIndex);
                    do {
                        lastIndex--;
                    } while (nums[lastIndex] == nums[lastIndex + 1] && firstIndex < lastIndex);
                } else if (nums[firstIndex] + nums[lastIndex] < sum) {
                    firstIndex++;
                } else {
                    lastIndex--;
                }
            }
        }
        return res;
    }
}
