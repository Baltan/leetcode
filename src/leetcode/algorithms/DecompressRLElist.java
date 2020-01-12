package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1313. Decompress Run-Length Encoded List
 *
 * @author Baltan
 * @date 2020-01-12 11:34
 */
public class DecompressRLElist {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(decompressRLElist(new int[]{1, 2, 3, 4}));
    }

    public static int[] decompressRLElist(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int length = nums.length;
        /**
         * 将解码后的数字加入list
         */
        for (int i = 0; i < length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i + 1]);
            }
        }

        int[] result = new int[list.size()];
        int index = 0;
        /**
         * 将list中的数字保存在数组中
         */
        for (int value : list) {
            result[index++] = value;
        }
        return result;
    }
}
