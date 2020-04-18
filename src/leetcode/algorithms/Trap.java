package leetcode.algorithms;

/**
 * Description: 42. Trapping Rain Water
 *
 * @author Baltan
 * @date 2018/9/5 10:24
 * @see leetcode.interview.Trap
 */
public class Trap {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{3, 0, 2}));
        System.out.println(trap(new int[]{1, 3, 2}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/"></a>
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int totalWater = 0;
        int maxIndex = -1;
        int maxHeight = 0;
        int length = height.length;
        /**
         * 查找最高柱子的索引位置和柱子高度
         */
        for (int i = 0; i < length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        /**
         * 如果最高的柱子索引为0或1，则该柱子左边无法接到雨水，如果为索引大于1，则柱子左边可能接到雨水，计算该柱子左边
         * 可以接到的雨水总量
         */
        if (maxIndex >= 2) {
            int maxLeftHeight = height[0];
            /**
             * 如果第i根柱子的高度height[i]不大于其左侧最高的柱子的高度maxLeftHeight，则索引i处可以接到的雨水量为
             * (maxLeftHeight-height[i])，左侧最高的柱子高度仍为maxLeftHeight;
             * 如果第i根柱子的高度height[i]大于其左侧最高的柱子的高度maxLeftHeight，则索引i处无法接到雨水，左侧最
             * 高的柱子高度更新为height[i];
             */
            for (int i = 1; i < maxIndex; i++) {
                if (height[i] <= maxLeftHeight) {
                    totalWater += maxLeftHeight - height[i];
                } else {
                    maxLeftHeight = height[i];
                }
            }
        }
        /**
         * 如果最高的柱子索引为length-1或length-2，则该柱子右边无法接到雨水，如果为索引小于length-2，则柱子右边可
         * 能接到雨水，计算该柱子右边可以接到的雨水总量
         */
        if (maxIndex <= length - 3) {
            int maxRightHeight = height[length - 1];
            /**
             * 如果第i根柱子的高度height[i]不大于其右侧最高的柱子的高度maxRightHeight，则索引i处可以接到的雨水量
             * 为(maxRightHeight-height[i])，右侧最高的柱子高度仍为maxRightHeight;
             * 如果第i根柱子的高度height[i]大于其右侧最高的柱子的高度maxRightHeight，则索引i处无法接到雨水，右侧
             * 最高的柱子高度更新为height[i];
             */
            for (int i = length - 2; i > maxIndex; i--) {
                if (height[i] <= maxRightHeight) {
                    totalWater += maxRightHeight - height[i];
                } else {
                    maxRightHeight = height[i];
                }
            }
        }
        return totalWater;
    }
}
