package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 525. Contiguous Array
 *
 * @author Baltan
 * @date 2019-09-15 12:00
 */
public class FindMaxLength {
    public static void main(String[] args) {
        int[] nums1 = {0, 1};
        System.out.println(findMaxLength(nums1));

        int[] nums2 = {0, 1, 0};
        System.out.println(findMaxLength(nums2));

        int[] nums3 = {0, 1, 0, 0, 1, 1, 0};
        System.out.println(findMaxLength(nums3));
    }

    public static int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int result = 0;
        /**
         * 保存第一次出现1比0多x（x可能为0、±1、±2……）个时的位置
         */
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        /**
         * 到当前位置为止，1比0多的个数
         */
        int currentDifference = 0;
        /**
         * 初始值，用于判定当数组的第一个元素是0时的情况
         */
        map.put(0, -1);

        for (int i = 0; i < length; i++) {
            currentDifference = nums[i] == 1 ? currentDifference + 1 : currentDifference - 1;
            /**
             * 到当前位置为止，1比0多currentDifference个，如果之前也存在某个位置1比0多currentDifference个，
             * 则两个位置的索引之间的这段子数组0和1的个数相等，更新符合条件的子数组的最大长度；如果之前不存在某
             * 个位置1比0多currentDifference个，将该索引保存在map中，作为第一次出现1比0多currentDifference
             * 个的位置的记录，继续后面的遍历
             */
            if (map.containsKey(currentDifference)) {
                result = Math.max(result, i - map.get(currentDifference));
            } else {
                map.put(currentDifference, i);
            }
        }
        return result;
    }
}
