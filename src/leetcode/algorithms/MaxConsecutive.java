package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2274. Maximum Consecutive Floors Without Special Floors
 *
 * @author Baltan
 * @date 2022/5/18 11:03
 */
public class MaxConsecutive {
    public static void main(String[] args) {
        System.out.println(maxConsecutive(2, 9, new int[]{4, 6}));
        System.out.println(maxConsecutive(6, 8, new int[]{7, 6, 8}));
    }

    public static int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int length = special.length;
        /**
         * 头尾两段特殊楼层
         */
        int result = Math.max(special[0] - bottom, top - special[length - 1]);
        /**
         * 中间的特殊楼层
         */
        for (int i = 1; i < length; i++) {
            result = Math.max(result, special[i] - special[i - 1] - 1);
        }
        return result;
    }
}
