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
        /**
         * 双指针
         */
        while (firstIndex < lastIndex) {
            int width = Math.min(height[firstIndex], height[lastIndex]);
            int length = lastIndex - firstIndex;
            /**
             * 左右指针所指向的两条垂线和x轴围成的面积
             */
            area = Math.max(area, width * length);
            /**
             * 如果左指针指向的垂线较短，就右移左指针，否则就左移右指针
             */
            if (height[firstIndex] < height[lastIndex]) {
                firstIndex++;
            } else {
                lastIndex--;
            }
        }
        return area;
    }
}
