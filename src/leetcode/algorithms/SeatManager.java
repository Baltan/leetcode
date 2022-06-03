package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1845. Seat Reservation Manager
 *
 * @author Baltan
 * @date 2022/6/1 17:11
 */
public class SeatManager {
    /**
     * 从小到大保存所有的空着的座位
     */
    private Queue<Integer> pq;

    public SeatManager(int n) {
        pq = new PriorityQueue<>(n);

        for (int seatNumber = 1; seatNumber <= n; seatNumber++) {
            pq.offer(seatNumber);
        }
    }

    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }

    public static void main(String[] args) {
        SeatManager seatManager1 = new SeatManager(5);
        System.out.println(seatManager1.reserve());
        System.out.println(seatManager1.reserve());
        seatManager1.unreserve(2);
        System.out.println(seatManager1.reserve());
        System.out.println(seatManager1.reserve());
        System.out.println(seatManager1.reserve());
        System.out.println(seatManager1.reserve());
        seatManager1.unreserve(5);
    }
}
