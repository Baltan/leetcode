package leetcode.algorithms;

import leetcode.entity.MountainArray;
import leetcode.entity.MountainArrayImpl;

/**
 * Description: 1095. Find in Mountain Array
 *
 * @author Baltan
 * @date 2019-08-01 17:00
 */
public class Solution7 {
    public static void main(String[] args) {
        MountainArrayImpl mountainArray1 = new MountainArrayImpl(new int[]{1, 2, 3, 4, 5, 3, 1});
        System.out.println(findInMountainArray(3, mountainArray1));

        MountainArrayImpl mountainArray2 = new MountainArrayImpl(new int[]{0, 1, 2, 4, 2, 1});
        System.out.println(findInMountainArray(3, mountainArray2));
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int lo = 0;
        int hi = mountainArr.length();
        int peakIndex = 0;
        /**
         * 二分查找山顶位置的索引
         */
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int midValue = mountainArr.get(mid);

            if (midValue > mountainArr.get(mid - 1) && midValue > mountainArr.get(mid + 1)) {
                peakIndex = mid;
                break;
            } else if (midValue > mountainArr.get(mid - 1)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        lo = 0;
        hi = peakIndex;
        /**
         * 在上坡阶段查找是否有目标值
         */
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int midValue = mountainArr.get(mid);

            if (midValue == target) {
                return mid;
            } else if (midValue > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        lo = peakIndex;
        hi = mountainArr.length() - 1;
        /**
         * 在下坡阶段查找是否有目标值
         */
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int midValue = mountainArr.get(mid);

            if (midValue == target) {
                return mid;
            } else if (midValue > target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
