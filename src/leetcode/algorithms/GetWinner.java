package leetcode.algorithms;

/**
 * Description: 1535. Find the Winner of an Array Game
 *
 * @author Baltan
 * @date 2020-08-09 22:30
 */
public class GetWinner {
    public static void main(String[] args) {
        System.out.println(getWinner(new int[]{1, 25, 35, 42, 68, 70}, 1));
        System.out.println(getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
        System.out.println(getWinner(new int[]{3, 2, 1}, 10));
        System.out.println(getWinner(new int[]{1, 9, 8, 2, 3, 7, 6, 4, 5}, 7));
        System.out.println(getWinner(new int[]{1, 11, 22, 33, 44, 55, 66, 77, 88, 99}, 1000000000));
    }

    public static int getWinner(int[] arr, int k) {
        /**
         * 上一轮赢得回合的整数
         */
        int winner = arr[0];
        int length = arr.length;
        /**
         * 当前某个整数赢得连续回合的次数
         */
        int count = 0;

        for (int i = 1; i < length; i++) {
            if (arr[i] < winner) {
                count++;

                if (count == k) {
                    return winner;
                }
            } else {
                /**
                 * 变更赢得回合的整数，连续赢得的回合数变为1
                 */
                winner = arr[i];
                count = 1;

                if (k == 1) {
                    return winner;
                }
            }
        }
        return winner;
    }
}
