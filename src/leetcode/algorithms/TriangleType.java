package leetcode.algorithms;

/**
 * Description: 3024. Type of Triangle II
 *
 * @author Baltan
 * @date 2024/2/7 00:18
 */
public class TriangleType {
    public static void main(String[] args) {
        System.out.println(triangleType(new int[]{3, 3, 3}));
        System.out.println(triangleType(new int[]{3, 4, 5}));
    }

    public static String triangleType(int[] nums) {
        int x = nums[0];
        int y = nums[1];
        int z = nums[2];

        if (x + y <= z || x + z <= y || y + z <= x) {
            return "none";
        }

        if (x == y && y == z) {
            return "equilateral";
        }

        if (x == y || x == z || y == z) {
            return "isosceles";
        }
        return "scalene";
    }
}
