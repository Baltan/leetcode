package leetcode.algorithms;

/**
 * Description: Number of Recent Calls
 *
 * @author Baltan
 * @date 2019-04-13 19:47
 */
public class RecentCounter {
    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    private Node pings;

    public RecentCounter() {
        pings = null;
    }

    public int ping(int t) {
        if (pings == null) {
            pings = new Node(t);
            return 1;
        }

        int start = t - 3000;
        Node temp = pings;

        while (temp != null) {
            if (temp.val < start) {
                temp = temp.next;
            } else {
                break;
            }
        }

        if (temp == null) {
            pings = new Node(t);
            return 1;
        }

        Node node = new Node(-1);
        node.next = temp;
        pings = temp;

        int num = 0;

        while (node.next != null) {
            num++;
            node = node.next;
        }

        node.next = new Node(t);

        num++;
        return num;
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
