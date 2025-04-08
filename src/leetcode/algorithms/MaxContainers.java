package leetcode.algorithms;

/**
 * Description: 3492. Maximum Containers on a Ship
 *
 * @author Baltan
 * @date 2025/4/8 22:46
 */
public class MaxContainers {
    public static void main(String[] args) {
        System.out.println(maxContainers(2, 3, 15));
        System.out.println(maxContainers(3, 5, 20));
    }

    public static int maxContainers(int n, int w, int maxWeight) {
        return Math.min(n * n, maxWeight / w);
    }
}
