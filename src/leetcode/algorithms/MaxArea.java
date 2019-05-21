package leetcode.algorithms;

/**
 * Description: 11. Container With Most Water
 *
 * @author Baltan
 * @date 2018/8/28 18:09
 */
public class MaxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int area = 0;
        int firstIndex = 0;
        int lastIndex = height.length - 1;
        while (firstIndex < lastIndex) {
            int width = Math.min(height[firstIndex], height[lastIndex]);
            int length = lastIndex - firstIndex;
            area = Math.max(area, width * length);
            if (height[firstIndex] < height[lastIndex]) {
                firstIndex++;
            } else {
                lastIndex--;
            }
        }
        return area;
    }
}
