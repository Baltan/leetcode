package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1389. Create Target Array in the Given Order
 *
 * @author Baltan
 * @date 2020-03-27 10:13
 */
public class CreateTargetArray {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 3, 4};
        int[] index1 = {0, 1, 2, 2, 1};
        OutputUtils.print1DIntegerArray(createTargetArray(nums1, index1));

        int[] nums2 = {1, 2, 3, 4, 0};
        int[] index2 = {0, 1, 2, 3, 0};
        OutputUtils.print1DIntegerArray(createTargetArray(nums2, index2));

        int[] nums3 = {1};
        int[] index3 = {0};
        OutputUtils.print1DIntegerArray(createTargetArray(nums3, index3));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int length = index.length;
        int[] result = new int[length];
        /**
         * list模拟目标数组插入元素，最后再将list中的元素按序放入目标数组中
         */
        List<Integer> list = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            list.add(index[i], nums[i]);
        }

        for (int i = 0; i < length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
