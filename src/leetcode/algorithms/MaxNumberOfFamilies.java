package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1386. Cinema Seat Allocation
 *
 * @author Baltan
 * @date 2020-03-24 10:53
 */
public class MaxNumberOfFamilies {
    public static void main(String[] args) {
        int[][] reservedSeats1 = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        System.out.println(maxNumberOfFamilies(3, reservedSeats1));

        int[][] reservedSeats2 = {{2, 1}, {1, 8}, {2, 6}};
        System.out.println(maxNumberOfFamilies(2, reservedSeats2));

        int[][] reservedSeats3 = {{4, 3}, {1, 4}, {4, 6}, {1, 7}};
        System.out.println(maxNumberOfFamilies(4, reservedSeats3));
    }

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int result = 0;
        /**
         * 行号 -> 该行已经被占用的座位的集合
         */
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int col = reservedSeat[1];
            map.putIfAbsent(row, new LinkedList<>());
            map.get(row).add(col);
        }
        /**
         * 如果某一行的座位都没有被占用，则可以容纳两个家庭入座：2345和6789
         */
        result += (n - map.size()) * 2;

        for (List<Integer> seats : map.values()) {
            boolean[] isOccupied = new boolean[3];

            for (int col : seats) {
                /**
                 * 这种情况下2345这个四连坐无法安排家庭
                 */
                if (col >= 2 && col <= 5) {
                    isOccupied[0] = true;
                }
                /**
                 * 这种情况下4567这个四连坐无法安排家庭
                 */
                if (col >= 4 && col <= 7) {
                    isOccupied[1] = true;
                }
                /**
                 * 这种情况下6789这个四连坐无法安排家庭
                 */
                if (col >= 6 && col <= 9) {
                    isOccupied[2] = true;
                }
            }
            /**
             * 如果2345和6789都空着，则可以安排两个家庭；如果2345、4567、6789只有其中一个空着，则可以
             * 安排一个家庭
             */
            if (!isOccupied[0] && !isOccupied[2]) {
                result += 2;
            } else if (!isOccupied[0] || !isOccupied[1] || !isOccupied[2]) {
                result += 1;
            }
        }
        return result;
    }
}
