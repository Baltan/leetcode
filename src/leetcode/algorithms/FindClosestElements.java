package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 658. Find K Closest Elements
 *
 * @author Baltan
 * @date 2019-07-28 12:01
 */
public class FindClosestElements {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(findClosestElements(arr1, 4, 3));
        System.out.println(findClosestElements(arr1, 4, -1));

        int[] arr2 = {1, 4, 7, 9, 13, 16, 18, 23, 26};
        System.out.println(findClosestElements(arr2, 7, 2));
        System.out.println(findClosestElements(arr2, 7, 24));
        System.out.println(findClosestElements(arr2, 7, 14));
        System.out.println(findClosestElements(arr2, 7, 9));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> result = new LinkedList<>();
        int length = arr.length;

        if (length == 0) {
            return result;
        }

        if (x <= arr[0]) {
            /**
             * 如果x小于等于数组中最小的数，则取数组前k个数
             */
            for (int i = 0; i < k; i++) {
                result.addLast(arr[i]);
            }
        } else if (x >= arr[length - 1]) {
            /**
             * 如果x大于等于数组中最大的数，则取数组后k个数
             */
            for (int i = 0; i < k; i++) {
                result.addFirst(arr[length - 1 - i]);
            }
        } else {
            /**
             * 二分查找数组中距离x最近的数
             */
            int lo = 0;
            int hi = arr.length - 1;
            int mid = 0;

            while (lo < hi) {
                mid = (lo + hi) >> 1;

                if (arr[mid] == x) {
                    break;
                } else if (arr[mid] > x) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            /**
             * 维护两个指针，其中index1一直向前移动，且指向的数字都不大于x；index2一直向后移动，且指向的数字都不小于x，
             * 每轮循环比较下index1和index2指向的数字哪一个更接近x，加入结果集，并且移动对应指针，
             * 直到收集满k个数字
             */
            int index1 = mid;
            int index2 = mid + 1;

            for (int i = 0; i < k; i++) {
                if (index1 >= 0 && index2 < length) {
                    if (x - arr[index1] <= arr[index2] - x) {
                        result.addFirst(arr[index1]);
                        index1--;
                    } else {
                        result.addLast(arr[index2]);
                        index2++;
                    }
                } else if (index1 >= 0) {
                    result.addFirst(arr[index1]);
                    index1--;
                } else {
                    result.addLast(arr[index2]);
                    index2++;
                }
            }
        }
        return result;
    }
}
