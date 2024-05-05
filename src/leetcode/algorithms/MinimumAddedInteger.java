package leetcode.algorithms;

/**
 * Description: 3132. Find the Integer Added to Array II
 *
 * @author Baltan
 * @date 2024/5/4 15:27
 * @see AddedInteger
 */
public class MinimumAddedInteger {
    public static void main(String[] args) {
        System.out.println(minimumAddedInteger(new int[]{4, 20, 16, 12, 8}, new int[]{14, 18, 10}));
        System.out.println(minimumAddedInteger(new int[]{3, 5, 5, 3}, new int[]{7, 7}));
    }

    public static int minimumAddedInteger(int[] nums1, int[] nums2) {
        /**
         * counts1[i]表示数组nums1中元素i的个数
         */
        int[] counts1 = new int[1001];
        /**
         * counts2[i]表示数组nums2中元素i的个数
         */
        int[] counts2 = new int[1001];
        int index1 = 1000;

        for (int num : nums1) {
            counts1[num]++;
        }

        for (int num : nums2) {
            counts2[num]++;
        }
        /**
         * 因为数组nums1中删除两个元素后，剩余的每个元素加上diff后都能在nums2中得到一个一一对应的元素，所以只有三种可能：
         * 1、nums1中最大的元素最终对应nums2中最大的元素
         * 2、nums1中第二大的元素最终对应nums2中最大的元素
         * 2、nums1中第三大的元素最终对应nums2中最大的元素
         */
        outer:
        for (int i = 0; i < 3; i++) {
            /**
             * 在数组nums1中找到对应nums2中最大元素的元素
             */
            while (counts1[index1] == 0) {
                index1--;
            }
            int index2 = 1000;
            /**
             * 找到数组nums2中最大的元素
             */
            while (counts2[index2] == 0) {
                index2--;
            }
            int diff = index2 - index1;
            int delete = 0;
            /**
             * 判断能否通过在数组nums1中删除两个元素后，剩余的每个元素加上diff后都能在nums2中得到一个一一对应的元素
             */
            for (int j = index2; j >= 0; j--) {
                if (counts2[j] > 0) {
                    if (counts1[j - diff] < counts2[j]) {
                        /**
                         * 数组nums1中的元素j-diff不足以和nums2中的元素j一一对应，说明与数组nums1相加的整数不是diff
                         */
                        index1--;
                        continue outer;
                    } else {
                        /**
                         * 使数组nums1中的元素j-diff和nums2中的元素j一一对应，删除nums1中多余的元素j-diff
                         */
                        delete += counts1[j - diff] - counts2[j];

                        if (delete > 2) {
                            continue outer;
                        }
                    }
                }
            }
            return diff;
        }
        return 0;
    }
}
