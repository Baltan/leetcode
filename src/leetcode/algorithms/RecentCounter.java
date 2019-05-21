package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 933. Number of Recent Calls
 *
 * @author Baltan
 * @date 2019-04-13 19:47
 */
public class RecentCounter {
    private Queue<Integer> pings;

    public RecentCounter() {
        pings = new LinkedList<>();
    }

    public int ping(int t) {
        if (pings.isEmpty()) {
            pings.offer(t);
            return 1;
        } else {
            int start = t - 3000;
            while (!pings.isEmpty()) {
                int time = pings.peek();
                if (time < start) {
                    pings.poll();
                } else {
                    break;
                }
            }
            pings.offer(t);
            return pings.size();
        }
    }

    public static void main(String[] args) {
        RecentCounter obj1 = new RecentCounter();
        System.out.println(obj1.ping(1));
        System.out.println(obj1.ping(100));
        System.out.println(obj1.ping(3001));
        System.out.println(obj1.ping(3002));
        System.out.println(obj1.ping(4002));
        System.out.println(obj1.ping(7002));
        System.out.println(obj1.ping(15000));

        System.out.println("--------------");

        RecentCounter obj2 = new RecentCounter();
        System.out.println(obj2.ping(642));
        System.out.println(obj2.ping(1849));
        System.out.println(obj2.ping(4921));
        System.out.println(obj2.ping(5936));
        System.out.println(obj2.ping(5957));
    }
}
