package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: LCP 28. 采购方案
 *
 * @author Baltan
 * @date 2022/3/4 17:22
 * @see PurchasePlans
 */
public class PurchasePlans1 {
    public static void main(String[] args) {
        System.out.println(purchasePlans(new int[]{2, 5, 3, 5}, 6));
        System.out.println(purchasePlans(new int[]{2, 2, 1, 9}, 10));
    }

    public static int purchasePlans(int[] nums, int target) {
        int mod = 1000000007;
        long result = 0L;
        int lo = 0;
        int hi = nums.length - 1;
        Arrays.sort(nums);

        while (lo < hi) {
            if (nums[lo] + nums[hi] > target) {
                hi--;
            } else {
                /**
                 * [lo+1,hi]这个范围内的数字和nums[lo]相加都小于等于target，共hi-lo个组合
                 */
                result += (hi - lo);
                lo++;
            }
        }
        return (int) (result % mod);
    }
}
