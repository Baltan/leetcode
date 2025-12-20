package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3668. Restore Finishing Order
 *
 * @author baltan
 * @date 2025/12/10 17:01
 */
public class RecoverOrder {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(recoverOrder(new int[]{3, 1, 2, 5, 4}, new int[]{1, 3, 4}));
        OutputUtils.print1DIntegerArray(recoverOrder(new int[]{1, 4, 5, 3, 2}, new int[]{2, 5}));
    }

    public static int[] recoverOrder(int[] order, int[] friends) {
        int[] result = new int[friends.length];
        int index = 0;
        /**
         * isFriend[i]表示id为i的人是否是朋友
         */
        boolean[] isFriend = new boolean[order.length + 1];

        for (int friend : friends) {
            isFriend[friend] = true;
        }

        for (int num : order) {
            if (isFriend[num]) {
                result[index++] = num;
            }
        }
        return result;
    }
}
