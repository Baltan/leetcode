package leetcode.algorithms;

import java.util.ArrayList;

/**
 * Description:K-diff Pairs in an Array
 * @author Baltan
 *
 * @date 2017/11/16 13:59
 */
public class FindPairs {
    public static void main(String[] args) {
        int[] nums1 = {3, 1, 4, 1, 5};
        int[] nums2 = {1, 2, 3, 4, 5};
        int[] nums3 = {1, 3, 1, 5, 4};
        int k1 = 2;
        int k2 = 1;
        int k3 = 0;
        System.out.println(findPairs(nums1, k1));
        System.out.println(findPairs(nums2, k2));
        System.out.println(findPairs(nums3, k3));
    }

    public static int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        ArrayList<Integer> al = new ArrayList();
        int pairsNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!al.contains(nums[i])) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[i] - nums[j] == k && i != j) {
                        pairsNum++;
                        al.add(nums[i]);
                        break;
                    }
                }
            }
        }
        return pairsNum;
    }
}
