package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 496. Next Greater Element I
 *
 * @author Baltan
 * @date 2018/1/2 09:58
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
        OutputUtils.print1DIntegerArray(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4}));
        OutputUtils.print1DIntegerArray(nextGreaterElement(new int[]{}, new int[]{1}));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        Map<Integer, Integer> nums2Map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            nums2Map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int index = nums2Map.get(nums1[i]);
            arr[i] = -1;
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    arr[i] = nums2[j];
                    break;
                }
            }
        }
        return arr;
    }
}
