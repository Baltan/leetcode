package leetcode.algorithms;

/**
 * Description: 1904. The Number of Full Rounds You Have Played
 *
 * @author Baltan
 * @date 2022/3/13 13:12
 */
public class NumberOfRounds {
    public static void main(String[] args) {
        System.out.println(numberOfRounds("00:47", "00:57"));
        System.out.println(numberOfRounds("00:00", "23:59"));
        System.out.println(numberOfRounds("09:31", "10:14"));
        System.out.println(numberOfRounds("21:30", "03:00"));
    }

    public static int numberOfRounds(String loginTime, String logoutTime) {
        int loginHour = Integer.valueOf(loginTime.substring(0, 2));
        int loginMinute = Integer.valueOf(loginTime.substring(3));
        int logoutHour = Integer.valueOf(logoutTime.substring(0, 2));
        int logoutMinute = Integer.valueOf(logoutTime.substring(3));

        if (loginHour == logoutHour) {
            /**
             * 如果开始小时和结束小时相同，但是结束分钟比开始分钟大不到15分钟，无法完成一局游戏，例如：00:47-00:57
             */
            if (logoutMinute >= loginMinute && logoutMinute - loginMinute < 15) {
                return 0;
            }
            /**
             * 如果开始小时和结束小时相同，并且结束分钟比开始分钟大15分钟，但是开始时间不是游戏开始的时间点，无法完成一局游戏，
             * 例如：00:23-00:38
             */
            if (logoutMinute - loginMinute == 15 && loginMinute % 15 != 0) {
                return 0;
            }
        }
        /**
         * 调整开始时间为当前时间之后最早的游戏开始时间
         */
        if (loginMinute == 0) {
            loginMinute = 0;
        } else if (loginMinute <= 15) {
            loginMinute = 15;
        } else if (loginMinute <= 30) {
            loginMinute = 30;
        } else if (loginMinute <= 45) {
            loginMinute = 45;
        } else {
            loginMinute = 0;

            if (loginHour == 23) {
                loginHour = 0;
            } else {
                loginHour++;
            }
        }
        /**
         * 调整结束时间为当前时间之前最晚的游戏结束时间
         */
        if (logoutMinute < 15) {
            logoutMinute = 0;
        } else if (logoutMinute < 30) {
            logoutMinute = 15;
        } else if (logoutMinute < 45) {
            logoutMinute = 30;
        } else {
            logoutMinute = 45;
        }

        if (loginHour < logoutHour || (loginHour == logoutHour && loginMinute < logoutMinute)) {
            /**
             * 如果开始时间比结束时间小，则总游戏时间为loginHour:loginMinute到logoutHour:loginMinute的分钟数，加上或减去
             * logoutHour:loginMinute到logoutHour:logoutMinute的分钟数
             */
            int totalMinutes = (logoutHour - loginHour) * 60 + (logoutMinute - loginMinute);
            return totalMinutes / 15;
        } else if (loginHour > logoutHour || ((loginHour == logoutHour && loginMinute > logoutMinute))) {
            /**
             * 如果开始时间比结束时间小，则总游戏时间为loginHour:loginMinute到00:loginMinute的分钟数，减去00:00到
             * 00:loginMinute的分钟数，加上00:00到logoutHour:00的分钟数，加上logoutHour:00到logoutHour:logoutMinute
             * 的分钟数
             */
            int totalMinutes = (24 - loginHour) * 60 - loginMinute + logoutHour * 60 + logoutMinute;
            return totalMinutes / 15;
        }
        return 0;
    }
}
