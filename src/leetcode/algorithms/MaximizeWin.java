package leetcode.algorithms;

/**
 * Description: 2555. Maximize Win From Two Segments
 *
 * @author Baltan
 * @date 2023/2/5 12:56
 */
public class MaximizeWin {
    public static void main(String[] args) {
        System.out.println(maximizeWin(new int[]{1, 1, 2, 2, 3, 3, 5}, 2));
        System.out.println(maximizeWin(new int[]{1, 2, 3, 4}, 0));
    }

    public static int maximizeWin(int[] prizePositions, int k) {
        int result = 0;
        int length = prizePositions.length;
        /**
         * lefts[i]表示当一条线段的左端点在索引i处时，这条线段能得到的最多奖品数量
         */
        int[] lefts = new int[length];
        /**
         * rights[i]表示当一条线段的右端点在索引i处时，这条线段能得到的最多奖品数量
         */
        int[] rights = new int[length];
        /**
         * 从左向右遍历过程中，首先固定第二条线段左端点的索引i，此时第一条线段右端点最远在i-1时，第一条线段能得到的最多奖品数量
         */
        int max = 0;

        for (int i = 0; i < length; i++) {
            int right = getRight(prizePositions, i, prizePositions[i] + k);
            lefts[i] = right - i + 1;
        }

        for (int i = length - 1; i >= 0; i--) {
            int left = getLeft(prizePositions, i, prizePositions[i] - k);
            rights[i] = i - left + 1;
        }
        /**
         * 固定第二条线段左端点的索引i，此时第一条线段的右端点最远能到i-1
         */
        for (int i = 0; i < length; i++) {
            /**
             * 右端点不超过i-1的第一条线段能得到的最多奖品数量
             */
            if (i - 1 >= 0) {
                max = Math.max(max, rights[i - 1]);
            }
            result = Math.max(result, lefts[i] + max);
        }
        return result;
    }

    /**
     * 当线段的右端点在索引right处时，二分查找这条线段左端点的最小可能索引，即找到一个最小索引x使得prizePositions[x]>=target
     *
     * @param prizePositions
     * @param right
     * @param target
     * @return
     */
    public static int getLeft(int[] prizePositions, int right, int target) {
        int lo = 0;
        int hi = right;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (prizePositions[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 当线段的左端点在索引left处时，二分查找这条线段右端点的最大可能索引，即找到一个最大索引x使得prizePositions[x]<=target
     *
     * @param prizePositions
     * @param left
     * @param target
     * @return
     */
    public static int getRight(int[] prizePositions, int left, int target) {
        int lo = left;
        int hi = prizePositions.length - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (prizePositions[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
