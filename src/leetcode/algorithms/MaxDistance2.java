package leetcode.algorithms;

/**
 * Description: 2078. Two Furthest Houses With Different Colors
 *
 * @author Baltan
 * @date 2021/11/22 22:43
 */
public class MaxDistance2 {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1, 1, 1, 6, 1, 1, 1}));
        System.out.println(maxDistance(new int[]{1, 8, 3, 8, 3}));
        System.out.println(maxDistance(new int[]{0, 1}));
    }

    public static int maxDistance(int[] colors) {
        int result = 0;
        int length = colors.length;
        int first = colors[0];
        int last = colors[length - 1];
        /**
         * 从后向前查找第一个和第一座房子不同颜色的房子
         */
        for (int i = 0; ; i++) {
            if (colors[i] != last) {
                result = Math.max(result, length - 1 - i);
                break;
            }
        }
        /**
         * 从前向后查找第一个和最后一座房子不同颜色的房子
         */
        for (int i = length - 1; ; i--) {
            if (colors[i] != first) {
                result = Math.max(result, i);
                break;
            }
        }
        return result;
    }
}
