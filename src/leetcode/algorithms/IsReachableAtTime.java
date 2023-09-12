package leetcode.algorithms;

/**
 * Description: 2849. Determine if a Cell Is Reachable at a Given Time
 *
 * @author Baltan
 * @date 2023/9/10 20:56
 */
public class IsReachableAtTime {
    public static void main(String[] args) {
        System.out.println(isReachableAtTime(2, 4, 7, 7, 6));
        System.out.println(isReachableAtTime(3, 1, 7, 3, 3));
    }

    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        /**
         * 如果起点和终点在同一个格子中，只要限制移动的次数t不为1，都可以从当前格子出去后再回来（因为从一个格子出去再回来至少需要两步，而我们
         * 总能将一次角方向的移动替换为两次边方向的移动或者将一次边方向的移动替换为一次边方向的移动和一次角方向的移动，即如果可以用x步从一个
         * 格子到另一个格子，则[x,+∞)步都可以）
         */
        if (sx == fx && sy == fy) {
            return t != 1;
        }
        /**
         * 从(sx,sy)到(fx,fy)的最短路径中移动的总次数
         */
        int minMoves = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
        /**
         * 只要限制移动的次数t不小于minMoves，都可以从(sx,sy)到达(fx,fy)
         */
        return t >= minMoves;
    }
}
