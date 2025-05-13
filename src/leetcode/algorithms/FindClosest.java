package leetcode.algorithms;

/**
 * Description: 3516. Find Closest Person
 *
 * @author baltan
 * @date 2025/4/27 09:43
 */
public class FindClosest {
    public static void main(String[] args) {
        System.out.println(findClosest(2, 7, 4));
        System.out.println(findClosest(2, 5, 6));
        System.out.println(findClosest(1, 5, 3));
    }

    public static int findClosest(int x, int y, int z) {
        /**
         * Person1和Person3的距离
         */
        int distance1 = Math.abs(x - z);
        /**
         * Person2和Person3的距离
         */
        int distance2 = Math.abs(y - z);
        return distance1 == distance2 ? 0 : distance1 < distance2 ? 1 : 2;
    }
}
