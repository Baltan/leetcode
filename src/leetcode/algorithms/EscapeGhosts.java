package leetcode.algorithms;

/**
 * Description: 789. Escape The Ghosts
 *
 * @author Baltan
 * @date 2019-05-08 10:11
 */
public class EscapeGhosts {
    public static void main(String[] args) {
        int[][] ghosts1 = {{1, 0}, {0, 3}};
        int[] target1 = {0, 1};
        System.out.println(escapeGhosts(ghosts1, target1));

        int[][] ghosts2 = {{1, 0}};
        int[] target2 = {2, 0};
        System.out.println(escapeGhosts(ghosts2, target2));

        int[][] ghosts3 = {{2, 0}};
        int[] target3 = {1, 0};
        System.out.println(escapeGhosts(ghosts3, target3));
    }

    public static boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = Math.abs(target[0]) + Math.abs(target[1]);

        for (int[] ghost : ghosts) {
            if (Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]) <= distance) {
                return false;
            }
        }
        return true;
    }
}
