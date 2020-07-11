package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 315. Count of Smaller Numbers After Self
 *
 * @author Baltan
 * @date 2020-07-11 21:40
 */
public class CountSmaller {
    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(countSmaller(new int[]{5, 5, 5, 5, 5}));
        System.out.println(countSmaller(
                new int[]{26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81,
                        32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41}));
    }

    public static List<Integer> countSmaller(int[] nums) {
        int length = nums.length;
        List<Integer> result = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            int[] copyArray = Arrays.copyOfRange(nums, i + 1, length);
            result.add(binarySearch(nums[i], copyArray));
        }
        return result;
    }

    public static int binarySearch(int value, int[] copyArray) {
        Arrays.sort(copyArray);

        if (copyArray.length == 0 || copyArray[0] >= value) {
            return 0;
        }

        if (copyArray[copyArray.length - 1] < value) {
            return copyArray.length;
        }

        int lo = 0;
        int hi = copyArray.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (copyArray[mid] < value) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
