package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 2032. Two Out of Three
 *
 * @author Baltan
 * @date 2021/11/24 22:10
 */
public class TwoOutOfThree {
    public static void main(String[] args) {
        int[] nums11 = {1, 1, 3, 2};
        int[] nums21 = {2, 3};
        int[] nums31 = {3};
        System.out.println(twoOutOfThree(nums11, nums21, nums31));

        int[] nums12 = {3, 1};
        int[] nums22 = {2, 3};
        int[] nums32 = {1, 2};
        System.out.println(twoOutOfThree(nums12, nums22, nums32));

        int[] nums13 = {1, 2, 2};
        int[] nums23 = {4, 3, 3};
        int[] nums33 = {5};
        System.out.println(twoOutOfThree(nums13, nums23, nums33));
    }

    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> result = new ArrayList<>();
        /**
         * 数字num -> 0b×××，值为一个二进制数，如果num在nums1中出现过，则最低位为1，否则为0，以此类推
         */
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) | 0b1);
        }

        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) | 0b10);
        }

        for (int num : nums3) {
            map.put(num, map.getOrDefault(num, 0) | 0b100);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            /**
             * 判断num是否在三个数组中出现三次或两次
             */
            if (entry.getValue() == 0b111 || entry.getValue() == 0b110 || entry.getValue() == 0b101 ||
                    entry.getValue() == 0b11) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
