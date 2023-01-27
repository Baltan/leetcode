package leetcode.algorithms;

/**
 * Description: 1997. First Day Where You Have Been in All the Rooms
 *
 * @author Baltan
 * @date 2023/1/26 15:45
 */
public class FirstDayBeenInAllRooms {
    public static void main(String[] args) {
        System.out.println(firstDayBeenInAllRooms(new int[]{0, 0}));
        System.out.println(firstDayBeenInAllRooms(new int[]{0, 0, 2}));
        System.out.println(firstDayBeenInAllRooms(new int[]{0, 1, 2, 0}));
        System.out.println(firstDayBeenInAllRooms(new int[]{0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26, 27, 27, 28, 28, 29, 29, 30, 30, 31, 31, 32, 32, 33, 33, 34, 34, 35, 35, 36, 36, 37, 37, 38, 38, 39, 39, 40, 40, 41, 41, 42, 42, 43, 43, 44, 44, 45, 45, 46, 46, 47, 47, 48}))
        ;
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/first-day-where-you-have-been-in-all-the-rooms/solutions/1940779/by-wanglongjiang-9stt/"></a>
     *
     * @param nextVisit
     * @return
     */
    public static int firstDayBeenInAllRooms(int[] nextVisit) {
        int mod = 1000000007;
        int length = nextVisit.length;
        /**
         * dp[i][0]表示第一次访问房间i的日期，dp[i][1]表示第二次访问房间i的日期
         */
        long[][] dp = new long[length][2];
        dp[0][0] = 0L;

        for (int i = 0; i < length; i++) {
            if (i > 0) {
                /**
                 * 第一次访问房间i总是在第二次访问房间i-1后一天，因为奇数次访问某个房间i后，后一天只可能访问编号不大于i的房间nextVisit[i]，
                 * 所以只可能通过第二种情况偶数次访问房间i后后一天访问房间(i+1)%length
                 */
                dp[i][0] = (dp[i - 1][1] + 1) % mod;
            }
            /**
             * dp[i][0]-dp[nextVisit[i]][0]表示第一次访问房间nextVisit[i]到第一次访问房间i间隔的天数
             * 第一次访问房间i后，下一天访问房间nextVisit[i]，再间隔dp[i][0]-dp[nextVisit[i]][0]天可以再次访问房间i
             * 为了防止出现负数，多加一个mod
             */
            dp[i][1] = (dp[i][0] + 1 + dp[i][0] - dp[nextVisit[i]][0] + mod) % mod;
        }
        /**
         * 第一次访问房间i总是确保房间i-1已被访问过，所以第一次访问房间length-1的时候所有房间都已经访问完了
         */
        return (int) dp[length - 1][0];
    }
}
