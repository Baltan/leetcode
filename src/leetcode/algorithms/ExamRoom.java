package leetcode.algorithms;

import java.util.TreeSet;

/**
 * Description: Exam Room
 *
 * @author Baltan
 * @date 2019-04-30 21:38
 */
public class ExamRoom {
    private int seatNum;
    private TreeSet<Integer> occupiedSeats;

    public ExamRoom(int N) {
        seatNum = N;
        occupiedSeats = new TreeSet<>();
    }

    public int seat() {
        int position = 0;
        if (occupiedSeats.size() > 0) {
            int minDistance = occupiedSeats.first();
            Integer prevOccupied = null;
            for (int seatOrder : occupiedSeats) {
                if (prevOccupied != null) {
                    int currentMinDistance = (seatOrder - prevOccupied) / 2;
                    if (currentMinDistance > minDistance) {
                        minDistance = currentMinDistance;
                        position = prevOccupied + currentMinDistance;
                    }
                }
                prevOccupied = seatOrder;
            }

            if (seatNum - 1 - occupiedSeats.last() > minDistance) {
                position = seatNum - 1;
            }
        }
        occupiedSeats.add(position);
        return position;
    }

    public void leave(int p) {
        occupiedSeats.remove(p);
    }

    public static void main(String[] args) {
        ExamRoom room1 = new ExamRoom(10);
        System.out.println(room1.seat());
        System.out.println(room1.seat());
        System.out.println(room1.seat());
        System.out.println(room1.seat());
        room1.leave(4);
        System.out.println(room1.seat());

        System.out.println("----------");

        ExamRoom room2 = new ExamRoom(10);
        System.out.println(room2.seat());
        System.out.println(room2.seat());
        System.out.println(room2.seat());
        room2.leave(0);
        room2.leave(4);
        System.out.println(room2.seat());
        System.out.println(room2.seat());
        System.out.println(room2.seat());
        System.out.println(room2.seat());
        System.out.println(room2.seat());
        System.out.println(room2.seat());
        System.out.println(room2.seat());
        System.out.println(room2.seat());
        System.out.println(room2.seat());
        room2.leave(0);

        System.out.println("----------");

        ExamRoom room3 = new ExamRoom(10);
        System.out.println(room3.seat());
        System.out.println(room3.seat());
        System.out.println(room3.seat());
        room3.leave(0);
        room3.leave(4);
        System.out.println(room3.seat());
        System.out.println(room3.seat());
        System.out.println(room3.seat());
        System.out.println(room3.seat());
        System.out.println(room3.seat());
        System.out.println(room3.seat());
        System.out.println(room3.seat());
        System.out.println(room3.seat());
        System.out.println(room3.seat());
        room3.leave(0);
        room3.leave(4);
        System.out.println(room3.seat());
        System.out.println(room3.seat());
        room3.leave(7);
        System.out.println(room3.seat());
        room3.leave(3);
        System.out.println(room3.seat());
        room3.leave(3);
        System.out.println(room3.seat());
        room3.leave(9);
        System.out.println(room3.seat());
        room3.leave(0);
        room3.leave(8);
        System.out.println(room3.seat());
        System.out.println(room3.seat());
        room3.leave(0);
        room3.leave(8);
        System.out.println(room3.seat());
        System.out.println(room3.seat());
        room3.leave(2);
    }
}