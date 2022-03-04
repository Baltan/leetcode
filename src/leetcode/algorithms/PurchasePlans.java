package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: LCP 28. 采购方案
 *
 * @author Baltan
 * @date 2022/3/4 17:22
 * @see PurchasePlans1
 */
public class PurchasePlans {
    public static void main(String[] args) {
        System.out.println(purchasePlans(new int[]{2, 5, 3, 5}, 6));
        System.out.println(purchasePlans(new int[]{2, 2, 1, 9}, 10));
    }

    public static int purchasePlans(int[] nums, int target) {
        int mod = 1000000007;
        long result = 0L;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int index = binarySearch(nums, target - nums[i], i + 1);
            result += (index == -1 ? 0 : index - i);
        }
        return (int) (result % mod);
    }

    /**
     * 在数组nums中startIndex索引位置开始查找值小于等于value的最大索引位置
     *
     * @param nums
     * @param value
     * @param startIndex
     * @return
     */
    public static int binarySearch(int[] nums, int value, int startIndex) {
        if (nums[startIndex] > value) {
            return -1;
        }

        int lo = startIndex;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (int) Math.ceil((lo + hi) / 2.0);

            if (nums[mid] > value) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
