package leetcode.algorithms;

/**
 * Description: 3175. Find The First Player to win K Games in a Row
 *
 * @author baltan
 * @date 2024/6/11 13:46
 */
public class FindWinningPlayer {
    public static void main(String[] args) {
        System.out.println(findWinningPlayer(new int[]{4, 18, 17, 20, 15, 12, 8, 5}, 1));
        System.out.println(findWinningPlayer(new int[]{4, 2, 6, 3, 9}, 2));
        System.out.println(findWinningPlayer(new int[]{2, 5, 4}, 3));
    }

    public static int findWinningPlayer(int[] skills, int k) {
        int result = 0;
        /**
         * 队列中的第一位选手的连胜次数
         */
        int count = 0;
        /**
         * 如果需要连胜的次数不小于选手总人数，说明需要把其余选手都赢下，只有能力值最大的选手才可能完成，直接查找到能力最大的选手即可
         */
        if (k >= skills.length) {
            for (int i = 1; i < skills.length; i++) {
                if (skills[i] > skills[result]) {
                    result = i;
                }
            }
            return result;
        }
        /**
         * 从队首选手开始逐一和后面的选手比较
         */
        for (int i = 1; i < skills.length; i++) {
            if (skills[i] < skills[result]) {
                /**
                 * 队首选手获胜，胜场加1
                 */
                count++;
            } else {
                /**
                 * 选手skills[i]成为新的队首选手，并且已赢下一场和原来队首选手的比赛
                 */
                result = i;
                count = 1;
            }
            /**
             * 当前队首选手已连续赢得k场比赛
             */
            if (count == k) {
                return result;
            }
        }
        /**
         * 因为每次能力值较小的选手都会被移到队尾，所以最终留在队首的选手能力值是所有选手中最大的，不需要再继续比较
         */
        return result;
    }
}
