package leetcode.algorithms;

/**
 * Description: 1893. Check if All the Integers in a Range Are Covered
 *
 * @author Baltan
 * @date 2022/3/20 20:38
 */
public class IsCovered {
    public static void main(String[] args) {
        int[][] ranges1 = {{1, 2}, {3, 4}, {5, 6}};
        int left1 = 2;
        int right1 = 5;
        System.out.println(isCovered(ranges1, left1, right1));

        int[][] ranges2 = {{1, 10}, {10, 20}};
        int left2 = 21;
        int right2 = 21;
        System.out.println(isCovered(ranges2, left2, right2));
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        outer:
        for (int i = left; i <= right; i++) {
            for (int[] range : ranges) {
                if (range[0] <= i && range[1] >= i) {
                    continue outer;
                }
            }
            return false;
        }
        return true;
    }
}
