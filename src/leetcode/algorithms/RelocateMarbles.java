package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2766. Relocate Marbles
 *
 * @author Baltan
 * @date 2023/7/9 16:43
 */
public class RelocateMarbles {
    public static void main(String[] args) {
        int[] nums1 = {1, 6, 7, 8};
        int[] moveFrom1 = {1, 7, 2};
        int[] moveTo1 = {2, 9, 5};
        System.out.println(relocateMarbles(nums1, moveFrom1, moveTo1));

        int[] nums2 = {1, 1, 3, 3};
        int[] moveFrom2 = {1, 3};
        int[] moveTo2 = {2, 2};
        System.out.println(relocateMarbles(nums2, moveFrom2, moveTo2));
    }

    public static List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> result = new TreeSet<>();
        /**
         * 后续会被移除大理石的位置集合
         */
        Set<Integer> movedSet = new HashSet<>();

        for (int i = moveFrom.length - 1; i >= 0; i--) {
            /**
             * 从最后的操作向前逆推，如果某个位置的大理石后续不会被移除，则最终这个位置会留下大理石
             */
            if (!movedSet.contains(moveTo[i])) {
                result.add(moveTo[i]);
            }
            movedSet.add(moveFrom[i]);
        }

        for (int num : nums) {
            /**
             * 初始位置的大理石如果后续不会被移除，则最终这个位置会留下大理石
             */
            if (!movedSet.contains(num)) {
                result.add(num);
            }
        }
        return new ArrayList<>(result);
    }
}
