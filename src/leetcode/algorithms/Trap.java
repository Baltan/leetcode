package leetcode.algorithms;

/**
 * Description: 42. Trapping Rain Water
 *
 * @author Baltan
 * @date 2018/9/5 10:24
 */
public class Trap {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{3, 0, 2}));
        System.out.println(trap(new int[]{1, 3, 2}));
    }

    public static int trap(int[] height) {
        int totalWater = 0;
        int maxIndex = -1;
        int maxHeight = 0;
        int length = height.length;
        for (int i = 0; i < length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        if (maxIndex >= 2) {
            int maxLeftHeight = height[0];
            for (int i = 1; i < maxIndex; i++) {
                if (height[i] <= maxLeftHeight) {
                    totalWater += maxLeftHeight - height[i];
                } else {
                    maxLeftHeight = height[i];
                }
            }
        }
        if (maxIndex <= length - 3) {
            int maxRightHeight = height[length - 1];
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
