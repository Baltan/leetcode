package leetcode.interview;

import java.util.Arrays;

/**
 * Description: 面试题 16.06. 最小差
 *
 * @author Baltan
 * @date 2020-03-29 16:03
 */
public class SmallestDifference {
    public static void main(String[] args) {
        int[] a1 = {1, 3, 15, 11, 2};
        int[] b1 = {23, 127, 235, 19, 8};
        System.out.println(smallestDifference(a1, b1));

        int[] a2 = {-2147483648, 1};
        int[] b2 = {2147483647, 0};
        System.out.println(smallestDifference(a2, b2));
    }

    public static int smallestDifference(int[] a, int[] b) {
        int result = Integer.MAX_VALUE;
        /**
         * 将数组a中的元素升序排列
         */
        Arrays.sort(a);
        /**
         * 将数组b中的元素升序排列
         */
        Arrays.sort(b);

        for (int target : a) {
            int lo = 0;
            int hi = b.length - 1;
            /**
             * 在数组b中二分查找大于等于target的最小值
             */
            while (lo < hi) {
                int mid = (lo + hi) / 2;

                if (b[mid] == target) {
                    return 0;
                } else if (b[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            /**
             * 当target和b[lo]两者之差的绝对值不大于Integer.MAX_VALUE，才更新result，否则会溢出
             */
            if (target - b[lo] > Integer.MIN_VALUE && b[lo] - target > Integer.MIN_VALUE) {
                result = Math.min(result, Math.abs(target - b[lo]));
            }

            lo = 0;
            hi = b.length - 1;
            /**
             * 在数组b中二分查找小于等于target的最大值
             */
            while (lo < hi) {
                int mid = (int) Math.ceil((lo + hi) / 2.0);

                if (b[mid] == target) {
                    return 0;
                } else if (b[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }
            /**
             * 当target和b[lo]两者之差的绝对值不大于Integer.MAX_VALUE，才更新result，否则会溢出
             */
            if (target - b[lo] > Integer.MIN_VALUE && b[lo] - target > Integer.MIN_VALUE) {
                result = Math.min(result, Math.abs(target - b[lo]));
            }
        }
        return result;
    }
}
