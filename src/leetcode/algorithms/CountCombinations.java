package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2056. Number of Valid Move Combinations On Chessboard
 *
 * @author Baltan
 * @date 2024/10/13 14:29
 */
public class CountCombinations {
    public static void main(String[] args) {
        String[] pieces1 = {"rook"};
        int[][] positions1 = {{1, 1}};
        System.out.println(countCombinations(pieces1, positions1));

        String[] pieces2 = {"queen"};
        int[][] positions2 = {{1, 1}};
        System.out.println(countCombinations(pieces2, positions2));

        String[] pieces3 = {"bishop"};
        int[][] positions3 = {{4, 3}};
        System.out.println(countCombinations(pieces3, positions3));

        String[] pieces4 = {"rook", "rook"};
        int[][] positions4 = {{1, 1}, {8, 8}};
        System.out.println(countCombinations(pieces4, positions4));

        String[] pieces5 = {"queen", "bishop"};
        int[][] positions5 = {{5, 7}, {3, 4}};
        System.out.println(countCombinations(pieces5, positions5));

        String[] pieces6 = {"bishop", "rook"};
        int[][] positions6 = {{8, 5}, {7, 7}};
        System.out.println(countCombinations(pieces6, positions6));
    }

    private static int result;
    /**
     * 车的移动方向（水平、竖直）
     */
    private static final int[][] ROOK_DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    /**
     * 后的移动方向（水平、竖直、对角线）
     */
    private static final int[][] QUEEN_DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    /**
     * 象的移动方向（对角线）
     */
    private static final int[][] BISHOP_DIRECTIONS = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static int countCombinations(String[] pieces, int[][] positions) {
        result = 0;
        /**
         * plansList[i]表示棋子pieces[i]可能到达的终点的方案集合
         */
        List<Plan>[] plansList = new List[pieces.length];
        Arrays.setAll(plansList, i -> new ArrayList<>());

        for (int i = 0; i < pieces.length; i++) {
            switch (pieces[i]) {
                case "rook" -> getPlans(plansList[i], positions[i], ROOK_DIRECTIONS);
                case "queen" -> getPlans(plansList[i], positions[i], QUEEN_DIRECTIONS);
                case "bishop" -> getPlans(plansList[i], positions[i], BISHOP_DIRECTIONS);
            }
        }
        /**
         * 递归模拟所有棋子可能的移动方案
         */
        dfs(0, pieces.length, plansList, new ArrayDeque<>());
        return result;
    }

    /**
     * 深度优先搜索递归模拟所有棋子可能的移动方案
     *
     * @param index
     * @param total      棋子总数
     * @param plansList  当前判断的棋子pieces[index]的所有可能的移动方案
     * @param otherPlans 此前已有的棋子的所有可能的移动方案
     */
    public static void dfs(int index, int total, List<Plan>[] plansList, Deque<Plan> otherPlans) {
        if (index == total) {
            result++;
            return;
        }
        /**
         * 判断当前棋子的移动方案plan是否和此前已有的棋子的方案otherPlan存在冲突
         */
        outer:
        for (Plan plan : plansList[index]) {
            for (Plan otherPlan : otherPlans) {
                if (!isValid(plan, otherPlan)) {
                    continue outer;
                }
            }
            /**
             * 当前棋子按照方案plan移动可行，继续判断后面的棋子
             */
            otherPlans.offerLast(plan);
            /**
             * 递归模拟后一个棋子可能的移动方案
             */
            dfs(index + 1, total, plansList, otherPlans);
            /**
             * 移除当前棋子按照方案plan，继续判断当前棋子的下一方案
             */
            otherPlans.pollLast();
        }
    }

    /**
     * 判断两个棋子分别按照方案planA和planB移动时，是否可行
     *
     * @param planA
     * @param planB
     * @return
     */
    public static boolean isValid(Plan planA, Plan planB) {
        /**
         * 遍历移动过程中每一秒钟的情况，直到两个棋子都到达自己的终点
         */
        for (int i = 0; i <= Math.max(planA.time, planB.time); i++) {
            /**
             * 如果某个棋子在第i秒之前已到达自己的终点，则后续时间都停留在终点处，否则向指定方向前进一步
             */
            int[] positionA = i <= planA.time ? new int[]{planA.start[0] + planA.direction[0] * i, planA.start[1] + planA.direction[1] * i} : planA.end;
            int[] positionB = i <= planB.time ? new int[]{planB.start[0] + planB.direction[0] * i, planB.start[1] + planB.direction[1] * i} : planB.end;
            /**
             * 如果第i秒时两个棋子到达同一个格子，则方案不可行
             */
            if (Arrays.equals(positionA, positionB)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算一个棋子从start位置出发，沿着directions中指定的方向，可能到达的终点的方案集合
     *
     * @param plans
     * @param start
     * @param directions
     */
    public static void getPlans(List<Plan> plans, int[] start, int[][] directions) {
        /**
         * 如果棋子不移动，则停留在起点位置
         */
        plans.add(new Plan(0, start, start, directions[0]));

        for (int[] direction : directions) {
            /**
             * 棋子移动过程中所在位置的横坐标
             */
            int x = start[0];
            /**
             * 棋子移动过程中所在位置的纵坐标
             */
            int y = start[1];
            /**
             * 从起点出发经过的时间
             */
            int time = 1;
            /**
             * 每秒钟棋子向前移动一步，直到棋盘的边界位置为止
             */
            do {
                x += direction[0];
                y += direction[1];

                if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
                    plans.add(new Plan(time++, start, new int[]{x, y}, direction));
                }
            } while (x >= 1 && x <= 8 && y >= 1 && y <= 8);
        }
    }

    /**
     * 棋子到达某个终点的方案
     */
    public static class Plan {
        /**
         * 从起点出发经过的时间
         */
        private int time;
        /**
         * 起点坐标
         */
        private int[] start;
        /**
         * 终点坐标
         */
        private int[] end;
        /**
         * 当前方法棋子的移动方向
         */
        private int[] direction;

        public Plan(int time, int[] start, int[] end, int[] direction) {
            this.time = time;
            this.start = start;
            this.end = end;
            this.direction = direction;
        }
    }
}
