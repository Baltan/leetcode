package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2037. Minimum Number of Moves to Seat Everyone
 *
 * @author Baltan
 * @date 2021/11/19 21:36
 */
public class MinMovesToSeat {
    public static void main(String[] args) {
        int[] seats1 = {3, 1, 5};
        int[] students1 = {2, 7, 4};
        System.out.println(minMovesToSeat(seats1, students1));

        int[] seats2 = {4, 1, 5, 9};
        int[] students2 = {1, 3, 2, 6};
        System.out.println(minMovesToSeat(seats2, students2));

        int[] seats3 = {2, 2, 6, 6};
        int[] students3 = {1, 3, 2, 6};
        System.out.println(minMovesToSeat(seats3, students3));

        int[] seats4 = {12, 14, 19, 19, 12};
        int[] students4 = {19, 2, 17, 20, 7};
        System.out.println(minMovesToSeat(seats4, students4));
    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        int result = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        /**
         * 将座位和学生都按照位置升序排列后，按顺序逐一将学生调整到对应的座位上
         */
        for (int i = 0; i < students.length; i++) {
            result += Math.abs(students[i] - seats[i]);
        }
        return result;
    }
}
