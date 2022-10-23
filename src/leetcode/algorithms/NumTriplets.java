package leetcode.algorithms;

import java.util.stream.IntStream;

/**
 * Description: 1577. Number of Ways Where Square of Number Is Equal to Product of Two Numbers
 *
 * @author Baltan
 * @date 2022/10/21 21:51
 */
public class NumTriplets {
    public static void main(String[] args) {
        System.out.println(numTriplets(new int[]{7, 4}, new int[]{5, 2, 8, 9}));
        System.out.println(numTriplets(new int[]{1, 1}, new int[]{1, 1, 1}));
        System.out.println(numTriplets(new int[]{7, 7, 8, 3}, new int[]{1, 2, 9, 7}));
        System.out.println(numTriplets(new int[]{4, 7, 9, 11, 23}, new int[]{3, 5, 1024, 12, 18}));
    }

    public static int numTriplets(int[] nums1, int[] nums2) {
        int result = 0;
        /**
         * 根据题意数组nums1和nums2中所有数字∈[1,100000]
         */
        int max = 100000;
        /**
         * count1[i]表示数字i在数组nums1中出现的次数
         */
        int[] count1 = new int[max + 1];
        /**
         * count2[i]表示数字i在数组nums2中出现的次数
         */
        int[] count2 = new int[max + 1];

        for (int num : nums1) {
            count1[num]++;
        }

        for (int num : nums2) {
            count2[num]++;
        }
        /**
         * 数组nums1中出现过的所有不同的数字，并按照升序排列
         */
        nums1 = IntStream.rangeClosed(0, max).filter(x -> count1[x] > 0).sorted().toArray();
        /**
         * 数组nums2中出现过的所有不同的数字，并按照升序排列
         */
        nums2 = IntStream.rangeClosed(0, max).filter(x -> count2[x] > 0).sorted().toArray();
        /**
         * 计算类型1的三元组的数量
         */
        result += help(nums1, nums2, count1, count2);
        /**
         * 计算类型2的三元组的数量
         */
        result += help(nums2, nums1, count2, count1);
        return result;
    }

    /**
     * 计算符合题意的三元组的数量
     *
     * @param baseNums
     * @param otherNums
     * @param baseCount
     * @param otherCount
     * @return
     */
    public static int help(int[] baseNums, int[] otherNums, int[] baseCount, int[] otherCount) {
        int result = 0;
        /**
         * 对于baseNums[i]*baseNums[i]==otherNums[j]*otherNums[k]，枚举所有baseNums[i]可能的情况
         */
        for (int baseNum : baseNums) {
            int baseNumCount = baseCount[baseNum];
            /**
             * 三元组中三个索引代表的数字都相等的情况
             */
            if (otherCount[baseNum] >= 2) {
                result += otherCount[baseNum] * (otherCount[baseNum] - 1) / 2 * baseNumCount;
            }
            /**
             * 三元组中三个索引代表的数字都互不相等的情况，双指针查找符合条件的三元组
             */
            long baseProduct = 1L * baseNum * baseNum;
            int lo = 0;
            int hi = otherNums.length - 1;

            while (lo < hi) {
                long otherProduct = 1L * otherNums[lo] * otherNums[hi];

                if (otherProduct < baseProduct) {
                    lo++;
                } else if (otherProduct > baseProduct) {
                    hi--;
                } else {
                    result += otherCount[otherNums[lo]] * otherCount[otherNums[hi]] * baseNumCount;
                    lo++;
                    hi--;
                }
            }
        }
        return result;
    }
}
