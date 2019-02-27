package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:Range Sum Query - Immutable
 *
 * @author Baltan
 * @date 2018/1/8 14:09
 */
public class NumArray {
    private int[] nums;
    private Map<Integer, Integer> map = new HashMap<>();

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (map.get(i) != null && map.get(j) != null) {
            return map.get(j) - map.get(i) + nums[i];
        } else if (map.get(i) == null && map.get(j) != null) {
            int sum = 0;
            for (int k = 0; k <= i; k++) {
                sum += nums[k];
            }
            map.put(i, sum);
            return map.get(j) - sum + nums[i];
        } else if (map.get(j) == null && map.get(i) != null) {
            int sum = 0;
            for (int k = 0; k <= j; k++) {
                sum += nums[k];
            }
            map.put(j, sum);
            return sum - map.get(i) + nums[i];
        } else {
            int sumI = 0;
            for (int k = 0; k <= i; k++) {
                sumI += nums[k];
            }
            int sumJ = sumI;
            for (int k = i + 1; k <= j; k++) {
                sumJ += nums[k];
            }
            map.put(i, sumI);
            map.put(j, sumJ);
            return sumJ - sumI + nums[i];
        }
    }

    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}
