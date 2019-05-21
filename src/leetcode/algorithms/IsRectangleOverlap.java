package leetcode.algorithms;

/**
 * Description: 836. Rectangle Overlap
 *
 * @author Baltan
 * @date 2018/8/8 10:38
 */
public class IsRectangleOverlap {
    public static void main(String[] args) {
        System.out.println(isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        System.out.println(isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
        System.out.println(isRectangleOverlap(new int[]{0, 0, 3, 3}, new int[]{1, 1, 2, 2}));
        System.out.println(isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{-1, 1, 1, 3}));
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[1] >= rec2[3] || rec2[1] >= rec1[3]) {
            return false;
        }
        if (rec1[0] >= rec2[2] || rec2[0] >= rec1[2]) {
            return false;
        }
        return true;
    }
}
