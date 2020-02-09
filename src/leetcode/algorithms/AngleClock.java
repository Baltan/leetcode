package leetcode.algorithms;

/**
 * Description: 1344. Angle Between Hands of a Clock
 *
 * @author Baltan
 * @date 2020-02-09 11:10
 */
public class AngleClock {
    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
        System.out.println(angleClock(3, 30));
        System.out.println(angleClock(3, 15));
        System.out.println(angleClock(4, 50));
        System.out.println(angleClock(12, 0));
        System.out.println(angleClock(11, 3));
    }

    public static double angleClock(int hour, int minutes) {
        /**
         * 时钟上每一分钟走过1格，这一格的角度
         */
        int degreePerMinute = 360 / 60;
        /**
         * hour点整时，时针和分针夹角的格数
         */
        double initDistance = 1.0 * (hour % 12) * 5;
        /**
         * minutes分钟分针走过的格数
         */
        double minuteHandDistance = minutes;
        /**
         * minutes分钟时针走过的格数
         */
        double hourHandDistance = 1.0 * minutes / 60 * 5;
        /**
         * hour时minutes分时时针和分针夹角的格数
         */
        double distance = Math.abs(initDistance + hourHandDistance - minuteHandDistance);
        /**
         * hour时minutes分时时针和分针夹角的度数
         */
        double degree = distance * degreePerMinute;
        /**
         * degree如果是一个优角（大于180°），则返回360°-degree
         */
        return degree > 180 ? 360 - degree : degree;
    }
}
