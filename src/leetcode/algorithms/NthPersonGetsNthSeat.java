package leetcode.algorithms;

/**
 * Description: 1227. Airplane Seat Assignment Probability
 *
 * @author Baltan
 * @date 2019-10-18 13:56
 */
public class NthPersonGetsNthSeat {
    public static void main(String[] args) {
        System.out.println(nthPersonGetsNthSeat(1));
        System.out.println(nthPersonGetsNthSeat(2));
        System.out.println(nthPersonGetsNthSeat(3));
        System.out.println(nthPersonGetsNthSeat(4));
        System.out.println(nthPersonGetsNthSeat(5));
        System.out.println(nthPersonGetsNthSeat(6));
        System.out.println(nthPersonGetsNthSeat(7));
        System.out.println(nthPersonGetsNthSeat(8));
        System.out.println(nthPersonGetsNthSeat(9));
        System.out.println(nthPersonGetsNthSeat(10));
    }

    public static double nthPersonGetsNthSeat(int n) {
        /**
         * 如果只有一个人一个座位，这个人一定坐在自己的座位上，返回1。如果是多个人多个位置，假设先不考虑第一个人坐了哪
         * 个位置，第二个人选完座位后，第二个座位一定有人了，因为如果第二个座位是空着的话第二个人就会选择第二个座位；第
         * 三个人选完座位后，第三个座位一定有人了，因为如果第三个座位是空着的话第三个人就会选择第三个座位；以此类推，第
         * n-1个人选完座位后，第n-1个座位一定有人了，因为如果第n-1个座位是空着的话第n-1个人就会选择第n-1个座位。此时
         * 考虑第一个人的选择情况，有两个座位仍旧空着，第一个座位和第n个座位，他有50%的可能选择第一个座位，此时第n个人
         * 也相应的有50%的可能选择第n个座位。
         */
        return n == 1 ? 1 : 0.5;
    }
}
